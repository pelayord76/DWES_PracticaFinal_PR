package com.spring.start.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.MapsId;
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
@Table(name = "tiene")
public class Tiene {

	@EmbeddedId
	private TieneKey id;

	@ManyToOne
	@JsonBackReference("tiene_usuario")
	@MapsId("usuarioId")
	@JoinColumn(name = "usuario_id")
	private Usuario usuario;

	@ManyToOne
	@JsonBackReference("tiene_maquina")
	@MapsId("maquinaId")
	@JoinColumn(name = "maquina_id")
	private Maquina maquina;
}
