package com.spring.start.dto.usuario;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class UsuarioResponseDto {

	private Long id;
	private String nombre;
	private String username;
	private String email;
	private String password;
}
