package com.spring.start.dto.recaudacion;

import java.time.LocalDate;

import com.spring.start.dto.maquina.MaquinaFacturaResponseDto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class RecaudacionResponseDto {

	private Long id;
	private Double cantidadRecaudada;
	private Integer pasosEntrada;
	private Integer pasosSalida;
	private Double porcentajeJuego;
	private Double tasaRecaudacion;
	private LocalDate fecha;
	private MaquinaFacturaResponseDto maquina;
}
