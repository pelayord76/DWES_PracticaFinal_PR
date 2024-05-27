package com.spring.start.dto.maquina;

import java.time.LocalDate;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.spring.start.dto.cliente.ClienteResponseDto;
import com.spring.start.enums.TipoMaquina;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class MaquinaResponseDto {

	private String nombre;

	@DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
	@JsonFormat(pattern = "dd/MM/yyyy", timezone = "Europe/Madrid")
	private LocalDate fechaVencimientoLicencia;
	private Boolean almacenada;
	private TipoMaquina tipoMaquina;
	private ClienteResponseDto cliente;
}
