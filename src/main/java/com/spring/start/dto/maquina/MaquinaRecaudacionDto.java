package com.spring.start.dto.maquina;

import com.spring.start.dto.cliente.ClienteDto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class MaquinaRecaudacionDto {

	private Long id;
	private String nombre;
	private ClienteDto cliente;
}
