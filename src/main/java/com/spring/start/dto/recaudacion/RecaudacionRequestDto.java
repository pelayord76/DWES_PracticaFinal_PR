package com.spring.start.dto.recaudacion;

import java.time.LocalDate;

import jakarta.validation.constraints.Digits;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class RecaudacionRequestDto {

	@NotNull(message = "La fecha de la recaudacion no puede ser nula")
	private LocalDate fecha;

	@NotNull(message = "La referencia de la maquina no puede ser nula")
	private Long idMaquina;

	@NotNull(message = "La cantidad recaudada no puede ser nula")
	@Digits(integer = 4, fraction = 2)
	private Double cantidadRecaudada;

	@NotNull(message = "La cantidad de pasos no puede ser nula")
	private Integer pasosEntrada;

	@NotNull(message = "La cantidad de pasos no puede ser nula")
	private Integer pasosSalida;
}
