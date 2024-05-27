package com.spring.start.mapper;

import java.util.List;

import org.mapstruct.Mapper;

import com.spring.start.dto.cliente.ClienteResponseDto;
import com.spring.start.dto.factura.FacturaRequestDto;
import com.spring.start.dto.factura.FacturaResponseDto;
import com.spring.start.entity.Cliente;
import com.spring.start.entity.Factura;

@Mapper(componentModel = "spring")
public interface FacturaMapper {

	public FacturaResponseDto mapToFacturaResponseDto(Factura factura);

	public List<FacturaResponseDto> mapToFacturaResponseDto(List<Factura> facturas);

	public Factura mapFacturaRequestToFactura(FacturaRequestDto dto);

	public Factura mapFacturaRequestToFactura(Long id, FacturaRequestDto dto);

	public FacturaResponseDto mapFacturaRequestToFacturaResponse(FacturaRequestDto dto);
	
	
	public ClienteResponseDto mapToClienteResponseDto(Cliente cliente);
}
