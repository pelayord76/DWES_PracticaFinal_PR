package com.spring.start.dto.usuario;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class UsuarioRequestDto {

	private String nombre;
	private String email;
	private String contrasenia;
}
