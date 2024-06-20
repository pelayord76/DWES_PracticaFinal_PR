package com.spring.start.dto.factura;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@AllArgsConstructor
public class PdfDto {
	private Long id;
	private Double iva;
	private LocalDate fechaEmision;
	private String local;
	private String duenio;
	private String cif;
	private Double totalRecaudaciones;
}