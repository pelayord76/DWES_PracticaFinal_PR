package com.spring.start.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
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

@Service
@Slf4j
public class FacturaServiceImpl implements FacturaService {

	@Autowired
	FacturaRepository facturaRepository;

	@Autowired
	FacturaMapper facturaMapper;

	@Autowired
	ClienteRepository clienteRepository;

	private String errorMsg = "No se encuentra la factura solicitada, id: ";

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
			log.error("No se encuentra el cliente solicitado, id: " + dto.getIdCliente());
			throw new IllegalArgumentException("No se encuentra el cliente solicitado, id: " + dto.getIdCliente());
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
}
