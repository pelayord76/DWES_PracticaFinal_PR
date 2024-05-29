package com.spring.start.entity;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.spring.start.enums.TipoMaquina;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * @author pelayord76
 */
@Entity
@Getter
@Setter
@ToString
@Table(name = "maquina")
public class Maquina {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "nombre")
	private String nombre;

	@Column(name = "fecha_vencimiento_licencia")
	private LocalDateTime fechaVencimientoLicencia;

	@Column(name = "almacenada")
	private Boolean almacenada;

	// fecha en la que la maquina paso a estar en estado de almacenada
	@Column(name = "fecha_almacenamiento")
	private LocalDate fechaAlmacenada;

	// para una funcionalidad de las recaudaciones se necesita añadir de qué tipo es
	// cada máquina, ya que se pueden diferenciar en dos tipos dependiendo del % de
	// juego legal, se usarán los términos 'monedas' y 'billetes' de forma
	// provisional
	@Column(name = "tipo_maquina")
	@Enumerated(EnumType.STRING)
	private TipoMaquina tipoMaquina;

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
	private List<Recaudacion> recaudaciones;

	// cuando la maquina pase a estar almacenada se empezará a tener en cuenta y
	// comprobar cuanto tiempo lleva en este estado
	public void setAlmacenada(Boolean almacenada) {
		this.almacenada = almacenada;
		if (almacenada) {
			this.fechaAlmacenada = LocalDate.now();
			this.cliente = null;
		} else {
			this.fechaAlmacenada = null;
		}
	}
}