package com.spring.start.dto.maquina;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@AllArgsConstructor
public class MaquinaDataIngresosDTO {

	private String nombre;
	private Double cantidadRecaudada;
}
