package com.spring.start.dto.cliente;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@AllArgsConstructor
public class ClienteDataIngresosDTO {

	private String local;
	private Double cantidadRecaudada;
}
