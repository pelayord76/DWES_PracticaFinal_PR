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

	@Column(name = "cantidad_recaudada")
	private Double cantidadRecaudada;

	// los pasos de entrada y de salida son las jugadas que tiene la maquina, cada
	// paso vale 0,20€
	// sirven tanto como para validar la cantidad recaudada como
	// para calcular el porcentaje de juego que tuvo la maquina desde la ultima
	// recaudacion
	// los de entrada son los que el usuario fisico de la maquina paga
	@Column(name = "pasos_entrada")
	private Integer pasosEntrada;

	// los pasos de salida son los que la maquina devuelve en premios al usuario
	// fisico
	@Column(name = "pasos_salida")
	private Integer pasosSalida;

	@Column(name = "porcentaje_juego")
	private Double porcentajeJuego;

	// la tasa de recaudacion es la cantidad que el usuario quiere destinar de la
	// recaudacion al impuesto trimestral que la empresa debe pagar por cada maquina
	// la tasa trimestral debe ser de un total de 890€
	@Column(name = "tasa_recaudacion")
	private Double tasaRecaudacion;

	@Column(name = "fecha")
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy")
	private LocalDate fecha;

	// relacion N:1 con maquina, una recaudacion pertenece unicamente a una maquina
	@JoinColumn(name = "FK_MAQUINA")
	@ManyToOne(fetch = FetchType.EAGER)
	@JsonBackReference("recaudacion_maquina")
	@Cascade(CascadeType.ALL)
	private Maquina maquina;
}
