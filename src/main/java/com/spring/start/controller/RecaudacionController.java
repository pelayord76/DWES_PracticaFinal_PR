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
import com.spring.start.dto.recaudacion.RecaudacionRequestDto;
import com.spring.start.dto.recaudacion.RecaudacionResponseDto;
import com.spring.start.service.RecaudacionService;
import com.spring.start.util.ResponseUtil;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.extern.slf4j.Slf4j;

@Tag(name = "Recaudaciones", description = "API de la entidad recaudacion")
@RestController
@RequestMapping("/recaudacion")
@Slf4j
public class RecaudacionController {

	@Autowired
	RecaudacionService recaudacionService;

	@Operation(summary = "Buscar individualmente", description = "Buscar una recaudacion por id.", tags = {
			"recaudacion", "get" })
	@GetMapping
	public ResponseEntity<ApiResponse<List<RecaudacionResponseDto>>> findAll() {
		log.info("Peticion para mostrar todas las recaudaciones");
		return ResponseUtil.response(recaudacionService.findAll(), HttpStatus.FOUND,
				"Mostrando todas las recaudaciones");
	}

	@Operation(summary = "Buscar todo", description = "Buscar todas las recaudacions de la base de datos.", tags = {
			"recaudacion", "get" })
	@GetMapping("/{id}")
	public ResponseEntity<ApiResponse<RecaudacionResponseDto>> findById(@PathVariable Long id) {
		log.info("Peticion para mostrar la recaudacion con id " + id);
		return ResponseUtil.response(recaudacionService.findById(id), HttpStatus.FOUND, "Mostrando la recaudación");
	}

	@Operation(summary = "Crear", description = "Crear una recaudacion e introducirla en la base de datos.", tags = {
			"recaudacion", "post" })
	@PostMapping
	public ResponseEntity<ApiResponse<RecaudacionResponseDto>> add(@RequestBody RecaudacionRequestDto dto) {
		log.info("Peticion para añadir una recaudacion");
		return ResponseUtil.response(recaudacionService.add(dto), HttpStatus.ACCEPTED, "Recaudación añadida con éxito");
	}

	@Operation(summary = "Modificar", description = "Buscar una recaudacion por id y añadirle nuevos campos.", tags = {
			"recaudacion", "put" })
	@PutMapping("/{id}")
	public ResponseEntity<ApiResponse<RecaudacionResponseDto>> update(@PathVariable Long id,
			@RequestBody RecaudacionRequestDto dto) {
		log.info("Peticion para actualizar la recaudacion con id " + id);
		return ResponseUtil.response(recaudacionService.update(id, dto), HttpStatus.ACCEPTED,
				"Recaudacion editada con éxito");
	}

	@Operation(summary = "Borrar", description = "Borrar una recaudacion de la base ded datos por su id.", tags = {
			"recaudacion", "delete" })
	@DeleteMapping("/{id}")
	public ResponseEntity<ApiResponse<Object>> delete(@PathVariable Long id) {
		log.info("Peticion para borrar la recaudacion con id " + id);
		recaudacionService.delete(id);
		return ResponseUtil.response(null, HttpStatus.NO_CONTENT, "Recaudacion eliminada con éxito");
	}
}
