package com.spring.start.dto.maquina;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import com.spring.start.entity.Cliente;
import com.spring.start.entity.Recaudacion;
import com.spring.start.entity.Tiene;
import com.spring.start.enums.TipoMaquina;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class MaquinaResponseDto {

	private Long id;
	private String nombre;
	private LocalDate fechaVencimientoLicencia;
	private Boolean almacenada;
	private TipoMaquina tipoMaquina;
	private List<Tiene> tiene;
	private Cliente cliente;
	private List<Recaudacion> recaudaciones = new ArrayList<>();
}
