package com.spring.start.recaudaciones;

import java.time.LocalDate;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.spring.start.maquinas.Maquina;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Data;

@Entity
@Data
public class Recaudacion {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column
	private Double cantidadRecaudada;
	
	@Column
	private Integer pasosEntrada;
	
	@Column
	private Integer pasosSalida;
	
	@Column
	private Double porcentajeJuego;
	
	@Column
	private Double tasaRecaudacion;

	@Column
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy")
	private LocalDate fecha;

	// relacion N:1 con maquina, una recaudacion pertenece unicamente a una maquina
	@JoinColumn(name = "FK_MAQUINA")
	@ManyToOne(fetch = FetchType.EAGER)
	@JsonBackReference("recaudacion_maquina")
	@Cascade(CascadeType.ALL)
	private Maquina maquina;
}
