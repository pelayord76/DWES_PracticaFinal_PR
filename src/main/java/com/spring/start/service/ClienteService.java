package com.spring.start.service;

import java.util.List;

import com.spring.start.dto.cliente.ClienteContratoResponseDto;
import com.spring.start.dto.cliente.ClienteDataIngresosDTO;
import com.spring.start.dto.cliente.ClienteDto;
import com.spring.start.dto.cliente.ClienteRequestDto;
import com.spring.start.dto.cliente.ClienteResponseDto;
import com.spring.start.dto.factura.FacturaResponseDto;
import com.spring.start.dto.maquina.MaquinaDto;

/**
 * @author pelayord76
 */
public interface ClienteService {

	/**
	 * 
	 * @param id del cliente que se quiere obtener
	 * @return dto con parametros
	 */
	ClienteResponseDto findById(Long id);

	/**
	 * 
	 * @return lista de dtos con todos los clientes del sistema
	 */
	List<ClienteResponseDto> findAll();

	/**
	 * 
	 * @param dto: datos del cliente que se quiere introducir
	 * @return dto del cliente creado
	 */
	ClienteResponseDto add(ClienteRequestDto dto);

	/**
	 * 
	 * @param id   del cliente que se quiere modificar
	 * @param dto: campos nuevos que se le quieren dar al Cliente
	 * @return dto del Cliente modificado
	 */
	ClienteResponseDto update(Long id, ClienteRequestDto dto);

	/**
	 * 
	 * @param id del cliente que se quiere eliminar de la base de datos
	 */
	void delete(Long id);

	/**
	 * metodo usado en un componente de estadisticas en el front
	 * 
	 * @return lista de los clientes de la base de datos con sus ingresos historicos
	 *         totales
	 */
	List<ClienteDataIngresosDTO> findByIngresos();

	/**
	 * 
	 * @return lista de locales con sus ids para settearlos en el front
	 */
	List<ClienteDto> getLocalesEIds();

	/**
	 * 
	 * @return lista de todos los clientes con sus ides
	 */
	List<ClienteDto> getClientesEIds();

	/**
	 * 
	 * @param id
	 * @return lista de las maquinas asociadas al cliente
	 */
	List<MaquinaDto> findMaquinasByCliente(long id);

	/**
	 * 
	 * @param id
	 * @return lista de facturas asociadas al cliente
	 */
	List<FacturaResponseDto> findFacturasByCliente(long id);
	
	/**
	 * 
	 * @return
	 */
	List<ClienteDataIngresosDTO> findByIngresosAsc();
	
	/**
	 * 
	 * @return
	 */
	List<ClienteDataIngresosDTO> findByIngresosDesc();

	/**
	 * 
	 * @param anio 
	 * @return
	 */
	List<ClienteContratoResponseDto> findByFechaVencimientoContrato(int anio);
}