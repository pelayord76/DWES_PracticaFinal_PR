package com.spring.start.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.spring.start.dto.ApiResponse;
import com.spring.start.dto.maquina.MaquinaContratoResponseDto;
import com.spring.start.dto.maquina.MaquinaDataIngresosDTO;
import com.spring.start.dto.maquina.MaquinaDto;
import com.spring.start.dto.maquina.MaquinaRequestDto;
import com.spring.start.dto.maquina.MaquinaResponseDto;
import com.spring.start.dto.recaudacion.MaquinaRecaudacionResponseDto;
import com.spring.start.service.MaquinaService;
import com.spring.start.util.ResponseUtil;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.extern.slf4j.Slf4j;

@Tag(name = "Maquinas", description = "API de la entidad maquina")
@RestController
@RequestMapping("/maquina")
@Slf4j
public class MaquinaController {

	@Autowired
	MaquinaService maquinaService;

	@Operation(summary = "Buscar individualmente", description = "Buscar una maquina por id.", tags = { "maquina",
			"get" })
	@GetMapping("/{id}")
	public ResponseEntity<ApiResponse<MaquinaResponseDto>> findById(@PathVariable Long id) {
		log.info("Peticion para mostrar la maquina con id " + id);
		return ResponseUtil.response(maquinaService.findById(id), HttpStatus.FOUND, "Mostrando la máquina");
	}

	@Operation(summary = "Buscar todo", description = "Buscar todas las maquinas de la base de datos.", tags = {
			"maquina", "get" })
	@GetMapping
	public ResponseEntity<ApiResponse<List<MaquinaResponseDto>>> findAll() {
		log.info("Peticion para mostrar todas las maquinas");
		return ResponseUtil.response(maquinaService.findAll(), HttpStatus.FOUND, "Mostrando todas las máquinas");
	}

	@Operation(summary = "Crear", description = "Crear una maquina e introducirla en la base de datos.", tags = {
			"maquina", "post" })
	@PostMapping
	public ResponseEntity<ApiResponse<MaquinaResponseDto>> add(@RequestBody MaquinaRequestDto dto) {
		log.info("Peticion para añadir una maquina");
		return ResponseUtil.response(maquinaService.add(dto), HttpStatus.ACCEPTED, "Máquina creada con éxito");
	}

	@Operation(summary = "Modificar", description = "Buscar una maquina por id y añadirle nuevos campos.", tags = {
			"maquina", "put" })
	@PutMapping("/{id}")
	public ResponseEntity<ApiResponse<MaquinaResponseDto>> update(@PathVariable Long id,
			@RequestBody MaquinaRequestDto dto) {
		log.info("Peticion para actualizar la maquina con id " + id);
		return ResponseUtil.response(maquinaService.update(id, dto), HttpStatus.ACCEPTED, "Máquina editada con éxito");
	}

	@Operation(summary = "Desvincular entidades", description = "Buscar una maquina por id y la desvincula de su cliente.", tags = {
			"maquina", "put" })
	@PutMapping("/cliente/{id}")
	public ResponseEntity<ApiResponse<Object>> desvincularCliente(@PathVariable Long id) {
		log.info("Peticion para desvincular la maquina con id " + id + " de su cliente");
		maquinaService.desvincularCliente(id);
		return ResponseUtil.response(null, HttpStatus.ACCEPTED, "Máquina correctamente desvinculada de su cliente");
	}

	@Operation(summary = "Borrar", description = "Borrar una maquina de la base ded datos por su id.", tags = {
			"maquina", "delete" })
	@DeleteMapping("/{id}")
	public ResponseEntity<ApiResponse<Object>> delete(@PathVariable Long id) {
		log.info("Peticion para borrar la maquina con id " + id);
		maquinaService.delete(id);
		return ResponseUtil.response(null, HttpStatus.NO_CONTENT, "Máquina borrada correctamente");
	}

	@Operation(summary = "Buscar por ingresos", description = "Buscar todas las maquinas de la base de datos con sus ingresos históricos correspondientes agrupadas por el nombre de la maquina.", tags = {
			"maquina", "get" })
	@GetMapping("/data/ingresos")
	public ResponseEntity<ApiResponse<List<MaquinaDataIngresosDTO>>> getDatosDeIngresosPorMaquina() {
		log.info("Peticion para mostrar todas las maquinas con sus ingresos");
		return ResponseUtil.response(maquinaService.findByIngresos(), HttpStatus.FOUND,
				"Mostrando todas las máquinas con sus ingresos");
	}

	@Operation(summary = "Almacenar maquina", description = "Buscar una maquina por id y almacenarla.", tags = {
			"maquina", "put" })
	@PutMapping("/almacenada/{id}")
	public ResponseEntity<ApiResponse<Object>> almacenarMaquina(@PathVariable Long id) {
		log.info("Peticion para almacenar la maquina con id " + id);
		maquinaService.almacenarMaquina(id);
		return ResponseUtil.response(null, HttpStatus.ACCEPTED, "Máquina almacenada correctamente");
	}

	@Operation(summary = "Buscar reacaudaciones por maquina", description = "Buscar todas las recaudaciones de una máquina.", tags = {
			"maquina", "get" })
	@GetMapping("/{id}/recaudacion")
	public ResponseEntity<ApiResponse<List<MaquinaRecaudacionResponseDto>>> getRecaudacionesByMaquina(
			@PathVariable Long id) {
		log.info("Peticion para mostrar las recaudaciones de la maquina con id " + id);
		return ResponseUtil.response(maquinaService.getRecaudacionesByMaquina(id), HttpStatus.FOUND,
				"Mostrando todas las recaudaciones de la máquina");
	}

	@Operation(summary = "Buscar las maquinas de un solo local", description = "Recibe un local y devuelve todas las maquinas que estén en el mismo", tags = {
			"maquina", "get" })
	@GetMapping("/cliente/{id}")
	public ResponseEntity<ApiResponse<List<MaquinaDto>>> getMaquinasByLocal(@PathVariable Long id) {
		log.info("Peticion para mostrar las maquinas del cliente con id " + id);
		return ResponseUtil.response(maquinaService.getMaquinasByLocal(id), HttpStatus.FOUND,
				"Mostrando todas las máquinas del local");
	}

	@Operation(summary = "Buscar clientes", description = "Buscar todas las maquinas cuya licencia venza el mismo año que el especificado por parametro.", tags = {
			"cliente", "get" })
	@GetMapping("/licencia/{anio}")
	public ResponseEntity<ApiResponse<List<MaquinaContratoResponseDto>>> findByFechaVencimientoContrato(
			@PathVariable int anio) {
		log.info("Peticion para mostrar todas las maquinas cuya fecha de vencimiento de contrato sea del año " + anio);
		return ResponseUtil.response(maquinaService.findByFechaVencimientoLicencia(anio), HttpStatus.FOUND,
				"Mostrando todas las maquinas que vencen contrato");
	}
}
