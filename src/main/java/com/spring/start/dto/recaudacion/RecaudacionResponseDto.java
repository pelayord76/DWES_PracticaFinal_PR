package com.spring.start.dto.recaudacion;

import java.time.LocalDate;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.spring.start.dto.maquina.MaquinaFacturaResponseDto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class RecaudacionResponseDto {

	private Double cantidadRecaudada;
	private Integer pasosEntrada;
	private Integer pasosSalida;
	private Double porcentajeJuego;
	private Double tasaRecaudacion;
	
	@DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
	@JsonFormat(pattern = "dd/MM/yyyy HH:mm", timezone = "Europe/Madrid")
	private LocalDate fecha;
	private MaquinaFacturaResponseDto maquina;
}
