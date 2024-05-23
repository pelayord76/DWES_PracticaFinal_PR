package com.spring.start.service;

import java.util.List;

import com.spring.start.dto.usuario.UsuarioRequestDto;
import com.spring.start.dto.usuario.UsuarioResponseDto;

/**
 * @author pelayord76
 */
public interface UsuarioService {

	/**
	 * 
	 * @param id del usuario que se quiere obtener
	 * @return dto con el id, nombre e email del usuario, si se encuentra
	 */
	UsuarioResponseDto findById(Long id);

	/**
	 * 
	 * @return lista de dtos con todos los usuarios del sistema
	 */
	List<UsuarioResponseDto> findAll();

	/**
	 * 
	 * @param dto: datos del usuario que se quiere introducir
	 * @return dto del usuario creado
	 */
	UsuarioResponseDto add(UsuarioRequestDto dto);

	/**
	 * 
	 * @param id del usuario que se quiere modificar
	 * @param dto: campos nuevos que se le quieren dar al usuario
	 * @return dto del usuario modificado
	 */
	UsuarioResponseDto update(Long id, UsuarioRequestDto dto);

	/**
	 * 
	 * @param id del usuario que se quiere eliminar de la base de datos
	 */
	void delete(Long id);
}