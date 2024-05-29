package com.spring.start.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.start.dto.cliente.ClienteDataIngresosDTO;
import com.spring.start.dto.cliente.ClienteRequestDto;
import com.spring.start.dto.cliente.ClienteResponseDto;
import com.spring.start.entity.Cliente;
import com.spring.start.mapper.ClienteMapper;
import com.spring.start.repository.ClienteRepository;
import com.spring.start.service.ClienteService;

@Service
public class ClienteServiceImpl implements ClienteService {

	@Autowired
	ClienteRepository clienteRepository;

	@Autowired
	ClienteMapper clienteMapper;

	@Override
	public ClienteResponseDto findById(Long id) {
		Optional<Cliente> clienteOptional = clienteRepository.findById(id);

		if (clienteOptional.isEmpty()) {
			throw new IllegalArgumentException("No existe ese cliente");
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
			throw new IllegalArgumentException("No existe ese cliente");
		}
		Cliente cliente = clienteMapper.mapClienteRequestToCliente(id, dto);
		clienteRepository.save(cliente);
		return clienteMapper.mapToClienteResponseDto(cliente);
	}

	@Override
	public void delete(Long id) {
		if (!clienteRepository.existsById(id)) {
			throw new IllegalArgumentException("No existe ese cliente");
		}
		clienteRepository.deleteById(id);
	}

	@Override
	public List<ClienteDataIngresosDTO> findByIngresos() {
		return clienteRepository.findAllByIngresos();
	}
}
