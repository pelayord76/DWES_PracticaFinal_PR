package com.spring.start.dto.factura;

import java.time.LocalDate;

import com.spring.start.entity.Cliente;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class FacturaResponseDto {

	private Long id;
	private Double iva;
	private LocalDate fechaEmision;
	private Cliente cliente;
}
