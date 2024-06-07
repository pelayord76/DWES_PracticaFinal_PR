package com.spring.start.service;

import java.util.List;

import org.springframework.validation.annotation.Validated;

import com.spring.start.dto.maquina.MaquinaUsuarioResponseDto;
import com.spring.start.dto.usuario.UsuarioRequestDto;
import com.spring.start.dto.usuario.UsuarioResponseDto;

import jakarta.validation.Valid;

/**
 * @author pelayord76
 */
@Validated
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
	UsuarioResponseDto add(@Valid UsuarioRequestDto dto);

	/**
	 * 
	 * @param id   del usuario que se quiere modificar
	 * @param dto: campos nuevos que se le quieren dar al usuario
	 * @return dto del usuario modificado
	 */
	UsuarioResponseDto update(Long id, @Valid UsuarioRequestDto dto);

	/**
	 * 
	 * @param id del usuario que se quiere eliminar de la base de datos
	 */
	void delete(Long id);

	/**
	 * 
	 * @param id
	 * @return
	 */
	List<MaquinaUsuarioResponseDto> findMaquinasByUsuario(Long id);
}