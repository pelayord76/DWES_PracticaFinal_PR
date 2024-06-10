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
	 * @param key clave compuesta por el id del usuario y el de la maquina que
	 *            forman la relacion
	 * @return la realcion creada
	 */
	Tiene add(TieneKey key);

	/**
	 * 
	 * @param idUsuario usuario de la relacion
	 * @param idMaquina maquina de la relacion
	 */
	void delete(long idUsuario, long idMaquina);

	/**
	 * devuelve todas las relaciones con maquinas de un usuario especificado
	 * 
	 * @param idUsuario del que se quiere saber las relaciones
	 * @return lista de relaciones del usuario
	 */
	List<Tiene> findByUsuarioId(long idUsuario);

	/**
	 * devuelve todas las relaciones con usuarios de una maquina especificada
	 * 
	 * @param idMaquina de la que se quiere saber las relaciones
	 * @return lista de relaciones de la maquina
	 */
	List<Tiene> findByMaquinaId(long idMaquina);

}