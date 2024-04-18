package com.spring.start.recaudaciones;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.spring.start.maquinas.Maquina;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Recaudacion {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column
	private float cantidadRecaudada;
	@Column
	private float porcentajeJuego;
	@Column
	private String fecha;

	// relacion N:1 con maquina, una recaudacion pertenece unicamente a una maquina
	@JoinColumn(name = "FK_MAQUINA")
	@ManyToOne(fetch = FetchType.EAGER)
	@JsonBackReference
	@Cascade(CascadeType.ALL)
	private Maquina maquina;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public float getCantidadRecaudada() {
		return cantidadRecaudada;
	}

	public void setCantidadRecaudada(float cantidadRecaudada) {
		this.cantidadRecaudada = cantidadRecaudada;
	}

	public float getPorcentajeJuego() {
		return porcentajeJuego;
	}

	public void setPorcentajeJuego(float porcentajeJuego) {
		this.porcentajeJuego = porcentajeJuego;
	}

	public String getFecha() {
		return fecha;
	}

	public void setFecha(String fecha) {
		this.fecha = fecha;
	}

	public Maquina getMaquina() {
		return maquina;
	}

	public void setMaquina(Maquina maquina) {
		this.maquina = maquina;
	}

	@Override
	public String toString() {
		return "Recaudacion [id=" + id + ", cantidadRecaudada=" + cantidadRecaudada + ", porcentajeJuego="
				+ porcentajeJuego + ", fecha=" + fecha + ", maquina=" + maquina + "]";
	}
}
