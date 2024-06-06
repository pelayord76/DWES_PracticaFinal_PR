package com.spring.start.service;

import java.util.List;

import com.spring.start.dto.recaudacion.RecaudacionRequestDto;
import com.spring.start.dto.recaudacion.RecaudacionResponseDto;

/**
 * @author pelayord76
 */
public interface RecaudacionService {

	/**
	 * 
	 * @param id de la recaudacion que se quiere obtener
	 * @return dto con parametros
	 */
	RecaudacionResponseDto findById(Long id);

	/**
	 * 
	 * @return lista de dtos con todas las recaudacions del sistema
	 */
	List<RecaudacionResponseDto> findAll();

	/**
	 * 
	 * @param dto: datos del recaudacion que se quiere introducir
	 * @return dto de la recaudacion creado
	 */
	RecaudacionResponseDto add(RecaudacionRequestDto dto);

	/**
	 * 
	 * @param id   de la recaudacion que se quiere modificar
	 * @param dto: campos nuevos que se le quieren dar a la Recaudacion
	 * @return dto de la recaudacion modificado
	 */
	RecaudacionResponseDto update(Long id, RecaudacionRequestDto dto);

	/**
	 * 
	 * @param id de la recaudacion que se quiere eliminar de la base de datos
	 */
	void delete(Long id);

	/**
	 * metodo para desvincular las relaciones de la entidad antes de borrar para
	 * evitar la cascada
	 * 
	 * @param id
	 */
	void desvincularMaquina(long id);
}
