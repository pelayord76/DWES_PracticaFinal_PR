package com.spring.start.dto.cliente;

import java.time.LocalDate;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class ClienteRequestDto {

	private String local;
	private String duenio;
	private Integer telefono;
	private String direccion;
	private String cif;
	private LocalDate fechaVencimientoContrato;
}
