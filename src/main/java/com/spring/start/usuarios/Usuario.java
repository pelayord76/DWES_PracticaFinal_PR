package com.spring.start.usuarios;

import java.util.List;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.spring.start.tiene.Tiene;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class Usuario {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column
	private String nombre;

	@Column
	private String email;

	@Column
	private String contrasenia;

	// relacion N:N con maquinas con clave embebida a traves de clase 'Tiene'
	@OneToMany(targetEntity = Tiene.class, mappedBy = "usuario")
	@JsonManagedReference("tiene_usuario")
	@Cascade(CascadeType.ALL)
	private List<Tiene> tiene;

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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getContrasenia() {
		return contrasenia;
	}

	public void setContrasenia(String contrasenia) {
		this.contrasenia = contrasenia;
	}

	public List<Tiene> getTiene() {
		return tiene;
	}

	public void setTiene(List<Tiene> tiene) {
		this.tiene = tiene;
	}

	@Override
	public String toString() {
		return "Usuario [id=" + id + ", nombre=" + nombre + ", email=" + email + "]";
	}
}
