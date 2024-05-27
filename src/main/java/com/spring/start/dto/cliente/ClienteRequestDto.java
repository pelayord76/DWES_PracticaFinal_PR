package com.spring.start.dto.cliente;

import java.time.LocalDate;

import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class ClienteRequestDto {

	@NotBlank(message = "El nombre del local no puede estar vacío")
	@Size(min = 3, max = 50, message = "El nombre del local no puede superar los 50 caracteres")
	private String local;

	@NotBlank(message = "El nombre del dueño del local no puede estar vacío")
	@Size(max = 100, message = "El nombre del dueño no puede superar los 100 caracteres")
	private String duenio;

	@NotBlank(message = "El número de teléfono no puede estar vacío")
	@Size(max = 9, message = "El número de teléfono no puede tener más de 9 dígitos")
	private Integer telefono;

	@NotBlank(message = "La dirección del local no puede estar vacía")
	@Size(min = 5, max = 100, message = "La direccion del local debe tener entre 5 y 100 caracteres")
	private String direccion;

	@NotBlank(message = "El CIF del local no puede estar vacío")
	@Size(max = 9, message = "El CIF debe tener un maximo de 9 caracteres, 1 letra (mayúscula) y 8 dígitos")
	@Pattern(regexp = "^[A-Z]\\d{8}$", message = "El formato debe ser una letra mayúscula seguida de 8 dígitos")
	private String cif;

	@NotNull(message = "La fecha de vencimiento del contrato no puede ser nula")
	@Future(message = "La fecha de vencimiento del contrato debe ser una fecha futura")
	private LocalDate fechaVencimientoContrato;
}
