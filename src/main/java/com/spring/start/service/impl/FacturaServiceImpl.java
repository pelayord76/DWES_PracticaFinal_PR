package com.spring.start.service.impl;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.spring.start.dto.factura.FacturaRequestDto;
import com.spring.start.dto.factura.FacturaResponseDto;
import com.spring.start.entity.Cliente;
import com.spring.start.entity.Factura;
import com.spring.start.mapper.FacturaMapper;
import com.spring.start.repository.ClienteRepository;
import com.spring.start.repository.FacturaRepository;
import com.spring.start.service.FacturaService;

import lombok.extern.slf4j.Slf4j;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;

@Service
@Slf4j
public class FacturaServiceImpl implements FacturaService {

	@Autowired
	FacturaRepository facturaRepository;

	@Autowired
	FacturaMapper facturaMapper;

	@Autowired
	ClienteRepository clienteRepository;

	@Autowired
	ResourceLoader resourceLoader;

	private String errorMsg = "No se encuentra la factura solicitada, id: ";

	private String errorMsgCliente = "No se encuentra el cliente solicitado, id: ";

	@Override
	public FacturaResponseDto findById(Long id) {
		Optional<Factura> facturaOptional = facturaRepository.findById(id);
		if (facturaOptional.isEmpty()) {
			log.error(errorMsg + id);
			throw new IllegalArgumentException(errorMsg + id);
		}
		return facturaMapper.mapToFacturaResponseDto(facturaOptional.get());
	}

	@Override
	public List<FacturaResponseDto> findAll() {
		List<Factura> facturas = facturaRepository.findAll();
		return facturaMapper.mapToFacturaResponseDto(facturas);
	}

	@Override
	public FacturaResponseDto add(FacturaRequestDto dto) {
		Factura factura = facturaMapper.mapFacturaRequestToFactura(dto);
		Optional<Cliente> clienteOptional = clienteRepository.findById(dto.getIdCliente());

		if (clienteOptional.isEmpty()) {
			log.error(errorMsgCliente + dto.getIdCliente());
			throw new IllegalArgumentException(errorMsgCliente + dto.getIdCliente());
		}

		factura.setCliente(clienteOptional.get());
		facturaRepository.save(factura);
		return facturaMapper.mapToFacturaResponseDto(factura);
	}

	@Override
	public FacturaResponseDto update(Long id, FacturaRequestDto dto) {
		Optional<Factura> facturaOptional = facturaRepository.findById(id);
		if (facturaOptional.isEmpty()) {
			log.error(errorMsg + id);
			throw new IllegalArgumentException(errorMsg + id);
		}
		Factura factura = facturaMapper.mapFacturaRequestToFactura(id, dto);

		Optional<Cliente> clienteOptional = clienteRepository.findById(dto.getIdCliente());

		if (clienteOptional.isEmpty()) {
			log.error(errorMsgCliente + dto.getIdCliente());
			throw new IllegalArgumentException(errorMsgCliente + dto.getIdCliente());
		}

		factura.setCliente(clienteOptional.get());

		facturaRepository.save(factura);
		return facturaMapper.mapToFacturaResponseDto(factura);
	}

	@Override
	public void delete(Long id) {
		if (!facturaRepository.existsById(id)) {
			log.error(errorMsg + id);
			throw new IllegalArgumentException(errorMsg + id);
		}
		desvincularCliente(id);
		facturaRepository.deleteById(id);
	}

	private void desvincularCliente(long id) {
		Optional<Factura> facturaOptional = facturaRepository.findById(id);
		if (facturaOptional.isEmpty()) {
			log.error(errorMsg + id);
			throw new IllegalArgumentException(errorMsg + id);
		}
		Factura factura = facturaOptional.get();
		if (factura.getCliente() != null) {
			List<Factura> facturas = factura.getCliente().getFacturas();

			facturas.remove(factura);
			factura.setCliente(null);

			facturaRepository.save(factura);
		}
	}

	@Override
	public ResponseEntity<byte[]> generarPdf(Long id) throws JRException, IOException {

		Optional<Factura> facturaOptional = facturaRepository.findById(id);

		if (facturaOptional.isEmpty()) {
			log.error(errorMsg + id);
			throw new IllegalArgumentException(errorMsg + id);
		}

		// Cargar la plantilla JRXML desde los recursos
		Resource resource = resourceLoader.getResource("classpath:resources/factura.jrxml");
		InputStream inputStream = resource.getInputStream();

		// Compilar el reporte JRXML
		JasperReport jasperReport = JasperCompileManager.compileReport(inputStream);

		// Fuente de datos y parámetros
		JRBeanCollectionDataSource dataSource = new JRBeanCollectionDataSource(Collections.singletonList(facturaOptional.get()));
		Map<String, Object> parameters = new HashMap<>();

		// Llenar el reporte
		JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, parameters, dataSource);

		// Exportar a PDF
		ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
		JasperExportManager.exportReportToPdfStream(jasperPrint, outputStream);
		byte[] devolver = outputStream.toByteArray();

		// Configurar los encabezados HTTP para la respuesta
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_PDF);
		headers.setContentDispositionFormData("attachment", "factura_" + id + ".pdf");
		headers.setContentLength(devolver.length);

		return new ResponseEntity<>(devolver, headers, HttpStatus.OK);
	}
}