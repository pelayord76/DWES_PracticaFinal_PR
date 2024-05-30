package com.spring.start.service;

import java.util.List;

import com.spring.start.dto.maquina.MaquinaDataIngresosDTO;
import com.spring.start.dto.maquina.MaquinaRequestDto;
import com.spring.start.dto.maquina.MaquinaResponseDto;

/**
 * @author pelayord76
 */
public interface MaquinaService {

	/**
	 * 
	 * @param id de la maquina que se quiere obtener
	 * @return dto con parametros
	 */
	MaquinaResponseDto findById(Long id);

	/**
	 * 
	 * @return lista de dtos con todos las maquinas del sistema
	 */
	List<MaquinaResponseDto> findAll();

	/**
	 * 
	 * @param dto: datos del maquina que se quiere introducir
	 * @return dto de la maquina creado
	 */
	MaquinaResponseDto add(MaquinaRequestDto dto);

	/**
	 * 
	 * @param id   de la maquina que se quiere modificar
	 * @param dto: campos nuevos que se le quieren dar a la Maquina
	 * @return dto de la maquina modificado
	 */
	MaquinaResponseDto update(Long id, MaquinaRequestDto dto);

	/**
	 * 
	 * @param id de la maquina que se quiere eliminar de la base de datos
	 */
	void delete(Long id);
	
	/**
	 * 
	 * @return lista de cada maquina, agrupadas por nombre con los ingresos totales de cada una.
	 */
	List<MaquinaDataIngresosDTO> findByIngresos();
	
	/**
	 * settea el cliente de una máquina a null
	 * 
	 * @param id
	 */
	void desvincularCliente(long id);
}
