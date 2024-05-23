package com.spring.start.entity;

import java.io.Serializable;
import java.util.Objects;

import jakarta.persistence.Embeddable;

@Embeddable
public class TieneKey implements Serializable {

	private static final long serialVersionUID = 1L;

	private Long usuario_id;
	private Long maquina_id;

	public Long getUsuario_id() {
		return usuario_id;
	}

	public void setUsuario_id(Long usuario_id) {
		this.usuario_id = usuario_id;
	}
	
	public Long getMaquina_id() {
		return maquina_id;
	}

	public void setMaquina_id(Long maquina_id) {
		this.maquina_id = maquina_id;
	}

	@Override
	public int hashCode() {
		return Objects.hash(maquina_id, usuario_id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) return true;
		if (obj == null) return false;
		if (getClass() != obj.getClass()) return false;
		TieneKey other = (TieneKey) obj;
		return Objects.equals(maquina_id, other.maquina_id) && Objects.equals(usuario_id, other.usuario_id);
	}
}
