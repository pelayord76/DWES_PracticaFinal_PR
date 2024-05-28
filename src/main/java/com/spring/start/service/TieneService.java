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