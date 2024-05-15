package com.spring.start.tiene;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.spring.start.maquinas.Maquina;
import com.spring.start.usuarios.Usuario;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.MapsId;
import lombok.Data;

@Entity
@Data
public class Tiene {

	@EmbeddedId
	private TieneKey id;

	@ManyToOne
	@JsonBackReference("tiene_usuario")
	@MapsId("usuario_id")
	@JoinColumn(name = "usuario_id")
	private Usuario usuario;

	@ManyToOne
	@JsonBackReference("tiene_maquina")
	@MapsId("maquina_id")
	@JoinColumn(name = "maquina_id")
	private Maquina maquina;
}
