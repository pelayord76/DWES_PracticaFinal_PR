package com.spring.start.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.spring.start.dto.cliente.ClienteContratoResponseDto;
import com.spring.start.dto.cliente.ClienteDataIngresosDTO;
import com.spring.start.dto.cliente.ClienteDto;
import com.spring.start.dto.cliente.ClienteRequestDto;
import com.spring.start.dto.cliente.ClienteResponseDto;
import com.spring.start.dto.factura.FacturaResponseDto;
import com.spring.start.dto.maquina.MaquinaDto;
import com.spring.start.entity.Cliente;
import com.spring.start.entity.Factura;
import com.spring.start.entity.Maquina;
import com.spring.start.mapper.ClienteMapper;
import com.spring.start.repository.ClienteRepository;
import com.spring.start.repository.FacturaRepository;
import com.spring.start.repository.MaquinaRepository;
import com.spring.start.service.ClienteService;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class ClienteServiceImpl implements ClienteService {

	@Autowired
	ClienteRepository clienteRepository;

	@Autowired
	FacturaRepository facturaRepository;

	@Autowired
	MaquinaRepository maquinaRepository;

	@Autowired
	ClienteMapper clienteMapper;

	private String errorMsg = "No se encuentra el cliente solicitado, id: ";

	@Override
	public ClienteResponseDto findById(Long id) {
		Optional<Cliente> clienteOptional = clienteRepository.findById(id);

		if (clienteOptional.isEmpty()) {
			log.error(errorMsg + id);
			throw new IllegalArgumentException(errorMsg + id);
		}

		return clienteMapper.mapToClienteResponseDto(clienteOptional.get());
	}

	@Override
	public List<ClienteResponseDto> findAll() {
		List<Cliente> clientes = clienteRepository.findAll();
		return clienteMapper.mapToClienteResponseDto(clientes);
	}

	@Override
	public ClienteResponseDto add(ClienteRequestDto dto) {
		clienteRepository.save(clienteMapper.mapClienteRequestToCliente(dto));
		return clienteMapper.mapClienteRequestToClienteResponse(dto);
	}

	@Override
	public ClienteResponseDto update(Long id, ClienteRequestDto dto) {
		Optional<Cliente> clienteOptional = clienteRepository.findById(id);
		if (clienteOptional.isEmpty()) {
			log.error(errorMsg + id);
			throw new IllegalArgumentException(errorMsg + id);
		}
		Cliente cliente = clienteMapper.mapClienteRequestToCliente(id, dto);
		clienteRepository.save(cliente);
		return clienteMapper.mapToClienteResponseDto(cliente);
	}

	@Override
	public void delete(Long id) {
		if (!clienteRepository.existsById(id)) {
			log.error(errorMsg + id);
			throw new IllegalArgumentException(errorMsg + id);
		}
		desvincularMaquinas(id);
		desvincularFacturas(id);
		clienteRepository.deleteById(id);
	}

	private void desvincularFacturas(long id) {
		Cliente cliente = clienteRepository.findById(id).get();
		if (cliente.getFacturas().isEmpty()) {
		} else {
			for (Factura f : cliente.getFacturas()) {
				f.setCliente(null);
				facturaRepository.save(f);
			}
			cliente.setFacturas(null);
			clienteRepository.save(cliente);
		}
	}

	private void desvincularMaquinas(long id) {
		Cliente cliente = clienteRepository.findById(id).get();
		if (cliente.getMaquinas().isEmpty()) {
		} else {
			for (Maquina m : cliente.getMaquinas()) {
				m.setCliente(null);
				maquinaRepository.save(m);
			}
			cliente.setMaquinas(null);
			clienteRepository.save(cliente);
		}
	}

	@Override
	public List<ClienteDataIngresosDTO> findByIngresos() {
		return clienteRepository.findAllByIngresos();
	}

	@Override
	public List<ClienteDto> getLocalesEIds() {
		return clienteMapper.mapToClienteDto(clienteRepository.findAll());
	}

	@Override
	public List<ClienteDto> getClientesEIds() {
		return clienteMapper.mapToClienteDto(clienteRepository.findAll());
	}

	@Override
	public List<MaquinaDto> findMaquinasByCliente(long id) {
		return clienteRepository.findMaquinasByCliente(id);
	}

	@Override
	public List<FacturaResponseDto> findFacturasByCliente(long id) {
		return clienteRepository.findFacturasByCliente(id);
	}

	@Override
	public List<ClienteDataIngresosDTO> findByIngresosAsc() {
		Pageable top5 = PageRequest.of(0, 5);
		return clienteRepository.findByIngresosAsc(top5);
	}

	@Override
	public List<ClienteDataIngresosDTO> findByIngresosDesc() {
		Pageable top5 = PageRequest.of(0, 5);
		return clienteRepository.findByIngresosDesc(top5);
	}

	@Override
	public List<ClienteContratoResponseDto> findByFechaVencimientoContrato(int anio) {
		return clienteRepository.findByFechaVencimientoContrato(anio);
	}
}
