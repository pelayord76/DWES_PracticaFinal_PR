package com.spring.start.dto.cliente;

import java.time.LocalDate;
import java.util.List;

import com.spring.start.entity.Factura;
import com.spring.start.entity.Maquina;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class ClienteResponseDto {

	private Long id;

	private String local;

	private String duenio;

	private Integer telefono;

	private String direccion;

	private String cif;

	private LocalDate fechaVencimientoContrato;

	private List<Maquina> maquinas;

	private List<Factura> facturas;
}
