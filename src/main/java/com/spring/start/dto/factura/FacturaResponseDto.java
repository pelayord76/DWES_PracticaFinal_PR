package com.spring.start.dto.factura;

import java.time.LocalDate;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.spring.start.dto.cliente.ClienteResponseDto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class FacturaResponseDto {

	private Double iva;
	
	@DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
	@JsonFormat(pattern = "dd/MM/yyyy HH:mm", timezone = "Europe/Madrid")
	private LocalDate fechaEmision;
	private ClienteResponseDto cliente;
}
