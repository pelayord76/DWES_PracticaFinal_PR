package com.spring.start.maquinas;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.spring.start.clientes.Cliente;
import com.spring.start.recaudaciones.Recaudacion;
import com.spring.start.tiene.Tiene;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;

@Entity
public class Maquina {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column
	private String nombre;

	@Column
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy")
	private LocalDate fechaVencimientoLicencia;

	@Column
	private Boolean almacenada;

	// relacion N:N con maquinas con clave embebida a traves de clase 'Tiene'
	@OneToMany(targetEntity = Tiene.class, mappedBy = "maquina")
	@JsonManagedReference("tiene_maquina")
	@Cascade(CascadeType.ALL)
	private List<Tiene> tiene;

	// relacion N:1 con cliente, cada maquina esta en un solo local.
	@JoinColumn(name = "FK_CLIENTE")
	@ManyToOne(fetch = FetchType.EAGER)
	@JsonBackReference("maquina_cliente")
	@Cascade(CascadeType.ALL)
	private Cliente cliente;

	// relacion 1:N con recaudaciones, una maquina tiene varias recaudaciones
	@OneToMany(mappedBy = "maquina", fetch = FetchType.EAGER)
	@Fetch(value = FetchMode.SUBSELECT)
	@JsonManagedReference("recaudacion_maquina")
	@Cascade(CascadeType.ALL)
	private List<Recaudacion> recaudaciones = new ArrayList<Recaudacion>();

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public LocalDate getFechaVencimientoLicencia() {
		return fechaVencimientoLicencia;
	}

	public void setFechaVencimientoLicencia(LocalDate fechaVencimientoLicencia) {
		this.fechaVencimientoLicencia = fechaVencimientoLicencia;
	}

	public Boolean isAlmacenada() {
		return almacenada;
	}

	public void setAlmacenada(Boolean almacenada) {
		this.almacenada = almacenada;
	}

	public List<Tiene> getTiene() {
		return tiene;
	}

	public void setTiene(List<Tiene> tiene) {
		this.tiene = tiene;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public List<Recaudacion> getRecaudaciones() {
		return recaudaciones;
	}

	public void setRecaudaciones(List<Recaudacion> recaudaciones) {
		this.recaudaciones = recaudaciones;
	}

	@Override
	public String toString() {
		return "Maquina [id=" + id + ", nombre=" + nombre + ", fechaVencimientoLicencia=" + fechaVencimientoLicencia
				+ ", almacenada=" + almacenada + ", usuarios=" + tiene + ", cliente=" + cliente + ", recaudaciones="
				+ recaudaciones + "]";
	}
}