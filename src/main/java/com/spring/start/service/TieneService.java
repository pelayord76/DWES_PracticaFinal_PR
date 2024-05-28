package com.spring.start.service;

import java.util.List;

import com.spring.start.entity.Tiene;
import com.spring.start.entity.TieneKey;

/**
 * @author pelayord76
 */
public interface TieneService {

	/**
	 * 
	 * @return lista de todas las relaciones del sistema
	 */
	List<Tiene> findAll();

	/**
	 * 
	 * @param dto: datos de la relacion que se quiere introducir, serán el id de una
	 *             maquina y el de un usuario
	 * @return la relacion creada
	 */
	Tiene add(TieneKey key);

	/**
	 * 
	 * @param id de las entidades que forman la relacion que se quiere eliminar de
	 *           la base de datos
	 */
	void delete(long idUsuario, long idMaquina);
}