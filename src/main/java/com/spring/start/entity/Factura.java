package com.spring.start.entity;

import java.time.LocalDate;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonFormat;

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
public class Factura {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "IVA")
	private Double iva;
	
	@Column(name = "fecha_emision")
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy")
	private LocalDate fechaEmision;

	// relacion N:1 con cliente, cada maquina esta en un solo local.
	@ManyToOne(fetch = FetchType.EAGER)
	@JsonBackReference("factura_cliente")
	@JoinColumn(name = "FK_CLIENTE")
	@Cascade(CascadeType.ALL)
	private Cliente cliente;
}