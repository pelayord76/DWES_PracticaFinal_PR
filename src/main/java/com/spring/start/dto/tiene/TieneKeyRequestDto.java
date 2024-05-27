package com.spring.start.dto.tiene;

import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class TieneKeyRequestDto {

	@NotNull
	private Long usuarioId;

	@NotNull
	private Long maquinaId;
}
