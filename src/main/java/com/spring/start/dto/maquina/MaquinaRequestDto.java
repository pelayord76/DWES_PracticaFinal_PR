package com.spring.start.dto.maquina;

import java.time.LocalDate;

import com.spring.start.entity.Cliente;
import com.spring.start.enums.TipoMaquina;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class MaquinaRequestDto {

	private String nombre;
	private LocalDate fechaVencimientoLicencia;
	private Boolean almacenada;
	private TipoMaquina tipoMaquina;
	private Cliente cliente;
}
