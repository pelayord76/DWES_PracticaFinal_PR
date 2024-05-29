package com.spring.start.dto.maquina;

import java.time.LocalDate;

import com.spring.start.enums.TipoMaquina;

import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class MaquinaRequestDto {

	@NotNull
	@Size(min = 3, max = 100, message = "El nombre de la maquina no puede superar los 100 caracteres")
	private String nombre;

	@Future(message = "La fecha de vencimiento de la licencia debe ser una fecha futura")
	private LocalDate fechaVencimientoLicencia;

	@NotNull(message = "Se debe indicar si la maquina está almacenada")
	private Boolean almacenada;

	@NotNull
	private TipoMaquina tipoMaquina;

	private Long idCliente;
}
