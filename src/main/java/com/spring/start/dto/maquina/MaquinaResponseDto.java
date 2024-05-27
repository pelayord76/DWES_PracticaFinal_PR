package com.spring.start.dto.maquina;

import java.time.LocalDate;
import java.util.List;

import com.spring.start.dto.cliente.ClienteResponseDto;
import com.spring.start.dto.recaudacion.RecaudacionResponseDto;
import com.spring.start.dto.tiene.TieneResponseDto;
import com.spring.start.enums.TipoMaquina;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class MaquinaResponseDto {

	private String nombre;
	private LocalDate fechaVencimientoLicencia;
	private Boolean almacenada;
	private TipoMaquina tipoMaquina;
	private List<TieneResponseDto> tiene;
	private ClienteResponseDto cliente;
	private List<RecaudacionResponseDto> recaudaciones;
}
