package com.spring.start.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.spring.start.dto.recaudacion.RecaudacionRequestDto;
import com.spring.start.dto.recaudacion.RecaudacionResponseDto;
import com.spring.start.service.RecaudacionService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

@Tag(name = "Recaudaciones", description = "API de la entidad recaudacion")
@RestController
@RequestMapping("/recaudacion")
public class RecaudacionController {

	@Autowired
	RecaudacionService recaudacionService;

	@Operation(summary = "Buscar individualmente", description = "Buscar una recaudacion por id.", tags = { "recaudacion", "get" })
	@GetMapping
	public List<RecaudacionResponseDto> findAll() {
		return recaudacionService.findAll();
	}

	@Operation(summary = "Buscar todo", description = "Buscar todas las recaudacions de la base de datos.", tags = { "recaudacion", "get" })
	@GetMapping("/{id}")
	public RecaudacionResponseDto findById(@PathVariable Long id) {
		return recaudacionService.findById(id);
	}

	@Operation(summary = "Crear", description = "Crear una recaudacion e introducirla en la base de datos.", tags = { "recaudacion", "post" })
	@PostMapping
	public RecaudacionResponseDto add(@RequestBody RecaudacionRequestDto dto) {
		return recaudacionService.add(dto);
	}

	@Operation(summary = "Modificar", description = "Buscar una recaudacion por id y añadirle nuevos campos.", tags = { "recaudacion", "put" })
	@PutMapping("/{id}")
	public RecaudacionResponseDto update(@PathVariable Long id, @RequestBody RecaudacionRequestDto dto) {
		return recaudacionService.update(id, dto);
	}

	@Operation(summary = "Borrar", description = "Borrar una recaudacion de la base ded datos por su id.", tags = { "recaudacion", "delete" })
	@DeleteMapping("/{id}")
	public void delete(@PathVariable Long id) {
		recaudacionService.delete(id);
	}
}
