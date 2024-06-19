package com.spring.start.dto.sign;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class SignInDto {

	@NotBlank(message = "El nombre de ususario no puede estar vacío")
	private String username;

	@NotBlank(message = "La contraseña no puede estar vacía")
	private String password;
}
