package com.spring.start.tiene;

import com.fasterxml.jackson.annotation.JsonBackReference;
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
	private TieneKey id;

	@ManyToOne
	@JsonBackReference("tiene-usuario")
	@MapsId("usuario_id")
	@JoinColumn(name = "usuario_id")
	private Usuario usuario;

	@ManyToOne
	@JsonBackReference("tiene-maquina")
	@MapsId("maquina_id")
	@JoinColumn(name = "maquina_id")
	private Maquina maquina;

	public TieneKey getId() {
		return id;
	}

	public void setId(TieneKey id) {
		this.id = id;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public Maquina getMaquina() {
		return maquina;
	}

	public void setMaquina(Maquina maquina) {
		this.maquina = maquina;
	}

	@Override
	public String toString() {
		return "Tiene [id=" + id + ", usuario=" + usuario + ", maquina=" + maquina + "]";
	}
}
