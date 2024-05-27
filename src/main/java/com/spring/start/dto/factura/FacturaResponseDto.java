package com.spring.start.dto.factura;

import java.time.LocalDate;

import com.spring.start.dto.cliente.ClienteResponseDto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class FacturaResponseDto {

	private Double iva;
	private LocalDate fechaEmision;
	private ClienteResponseDto cliente;
}
