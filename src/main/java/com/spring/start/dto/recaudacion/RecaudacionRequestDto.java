package com.spring.start.dto.recaudacion;

import jakarta.validation.constraints.Digits;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class RecaudacionRequestDto {

	@NotNull
	@Digits(integer = 4, fraction = 2)
	private Double cantidadRecaudada;

	@NotNull
	private Integer pasosEntrada;

	@NotNull
	private Integer pasosSalida;

	@NotNull
	private Long idMaquina;
}
