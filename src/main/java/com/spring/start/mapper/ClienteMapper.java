package com.spring.start.mapper;

import java.util.List;

import org.mapstruct.Mapper;

import com.spring.start.dto.cliente.ClienteRequestDto;
import com.spring.start.dto.cliente.ClienteResponseDto;
import com.spring.start.entity.Cliente;

@Mapper(componentModel = "spring")
public interface ClienteMapper {

	public ClienteResponseDto mapToClienteResponseDto(Cliente cliente);

	public List<ClienteResponseDto> mapToClienteResponseDto(List<Cliente> clientes);

	public Cliente mapClienteRequestToCliente(ClienteRequestDto dto);

	public Cliente mapClienteRequestToCliente(Long id, ClienteRequestDto dto);

	public ClienteResponseDto mapClienteRequestToClienteResponse(ClienteRequestDto dto);
}
