package com.spring.start.dto.maquina;

import com.spring.start.dto.cliente.ClienteDto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@AllArgsConstructor
public class MaquinaUsuarioResponseDto {

	private Long id;

	private String nombre;

	private ClienteDto cliente;
}
