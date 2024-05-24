package com.spring.start.dto.recaudacion;

import com.spring.start.dto.maquina.MaquinaRecaudacionDto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class RecaudacionRequestDto {

	private Double cantidadRecaudada;
	private Integer pasosEntrada;
	private Integer pasosSalida;
	private MaquinaRecaudacionDto maquina;
}
