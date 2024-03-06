package com.spring.start.tiene;

import com.spring.start.maquinas.Maquina;
import com.spring.start.usuarios.Usuario;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.MapsId;

@Entity
public class Tiene {

	@EmbeddedId
	TieneKey id;

	@ManyToOne
	@MapsId("usuario_id")
	@JoinColumn(name = "usuario_id")
	Usuario usuario;

	@ManyToOne
	@MapsId("maquina_id")
	@JoinColumn(name = "maquina_id")
	Maquina maquina;
}
