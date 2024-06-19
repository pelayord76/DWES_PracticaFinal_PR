package com.spring.start.dto.usuario;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class UsuarioUpdateRequestDto {

	@NotBlank(message = "El nombre no puede estar vacío")
	@Size(min = 3, max = 100, message = "El nombre debe tener entre 3 y 100 caracteres")
	private String nombre;

	@NotBlank(message = "El nombre de ususario no puede estar vacío")
	@Size(min = 3, max = 20, message = "El nombre de usuario debe tener entre 3 y 20 caracteres")
	private String username;

	@NotBlank(message = "El correo no puede estar vacío")
	@Email(message = "El email debe tener un formato válido")
	private String email;
}
