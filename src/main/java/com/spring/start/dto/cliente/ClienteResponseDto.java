package com.spring.start.dto.cliente;

import java.time.LocalDate;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.spring.start.dto.factura.FacturaResponseDto;
import com.spring.start.dto.maquina.MaquinaResponseDto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class ClienteResponseDto {

	private String local;
	private String duenio;
	private Integer telefono;
	private String direccion;
	private String cif;

	@DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
	@JsonFormat(pattern = "dd/MM/yyyy HH:mm", timezone = "Europe/Madrid")
	private LocalDate fechaVencimientoContrato;
	private List<MaquinaResponseDto> maquinas;
	private List<FacturaResponseDto> facturas;
}
