package com.spring.start.service;

import java.io.IOException;
import java.util.List;

import org.springframework.http.ResponseEntity;

import com.spring.start.dto.factura.FacturaRequestDto;
import com.spring.start.dto.factura.FacturaResponseDto;

import net.sf.jasperreports.engine.JRException;

/**
 * @author pelayord76
 */
public interface FacturaService {

	/**
	 * 
	 * @param id de la factura que se quiere obtener
	 * @return dto con parametros
	 */
	FacturaResponseDto findById(Long id);

	/**
	 * 
	 * @return lista de dtos con todos las facturas del sistema
	 */
	List<FacturaResponseDto> findAll();

	/**
	 * 
	 * @param dto: datos del factura que se quiere introducir
	 * @return dto de la factura creado
	 */
	FacturaResponseDto add(FacturaRequestDto dto);

	/**
	 * 
	 * @param id   de la factura que se quiere modificar
	 * @param dto: campos nuevos que se le quieren dar a la Factura
	 * @return dto de la factura modificado
	 */
	FacturaResponseDto update(Long id, FacturaRequestDto dto);

	/**
	 * 
	 * @param id de la factura que se quiere eliminar de la base de datos
	 */
	void delete(Long id);

	/**
	 * 
	 * @return
	 */
	ResponseEntity<byte[]> generarPdf(Long id) throws JRException, IOException;
}
