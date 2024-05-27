package com.spring.start.entity;

import java.io.Serializable;

import jakarta.persistence.Embeddable;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

/**
 * @author pelayord76
 */
@Embeddable
@Getter
@Setter
@EqualsAndHashCode
public class TieneKey implements Serializable {

	private static final long serialVersionUID = -5387434216767856483L;

	private Long idUsuario;
	private Long idMaquina;
}
