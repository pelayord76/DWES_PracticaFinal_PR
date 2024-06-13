package com.spring.start.entity;

import java.util.Collection;
import java.util.List;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.spring.start.enums.Rol;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
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
@Table(name = "usuario")
public class Usuario implements UserDetails {

	private static final long serialVersionUID = 6163333875297925103L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "nombre")
	private String nombre;

	@Column(name = "username")
	private String username;

	@Column(name = "email")
	private String email;

	@Column(name = "password")
	private String password;

	@Column(name = "rol")
	@Enumerated(EnumType.STRING)
	private Rol rol;

	// relacion N:N con maquinas con clave embebida a traves de clase 'Tiene'
	@OneToMany(targetEntity = Tiene.class, mappedBy = "usuario")
	@JsonManagedReference("tiene_usuario")
	@Cascade(CascadeType.ALL)
	private List<Tiene> tiene;

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return List.of(new SimpleGrantedAuthority((rol.name())));
	}

	@Override
	public boolean isAccountNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isEnabled() {
		// TODO Auto-generated method stub
		return true;
	}
}
