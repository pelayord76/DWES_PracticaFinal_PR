package com.spring.start.dto.factura;

import java.time.LocalDate;

import jakarta.validation.constraints.Digits;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class FacturaRequestDto {

	@NotNull
	@Digits(integer = 2, fraction = 2)
	private Double iva;

	@NotNull(message = "La fecha de emision de la factura no puede ser nula")
	private LocalDate fechaEmision;

	@NotNull
	private Long idCliente;
}
