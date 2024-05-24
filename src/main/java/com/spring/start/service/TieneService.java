package com.spring.start.service;

import java.util.List;

import com.spring.start.dto.tiene.TieneKeyRequestDto;
import com.spring.start.dto.tiene.TieneResponseDto;

/**
 * @author pelayord76
 */
public interface TieneService {

	/**
	 * 
	 * @return lista de dtos con todas las relaciones del sistema
	 */
	List<TieneResponseDto> findAll();

	/**
	 * 
	 * @param dto: datos de la relacion que se quiere introducir, serán el id de una
	 *             maquina y el de un usuario
	 * @return dto de la relacion tiene creada
	 */
	TieneResponseDto add(TieneKeyRequestDto dto);

	/**
	 * 
	 * @param id de la relacion que se quiere eliminar de la base de datos
	 */
	void delete(TieneKeyRequestDto dto);
}