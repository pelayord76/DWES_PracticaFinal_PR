package com.spring.start.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.spring.start.dto.tiene.TieneKeyRequestDto;
import com.spring.start.dto.tiene.TieneResponseDto;
import com.spring.start.service.TieneService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

@Tag(name = "Usuario_maquina", description = "API de la entidad intermedia entre usuario y maquina")
@RestController
@RequestMapping("/tiene")
public class TieneController {

	@Autowired
	private TieneService tieneService;

	@Operation(summary = "Buscar todo", description = "Buscar todas las relaciones de la base de datos.", tags = { "usuario_maquina", "get" })
	@GetMapping
	public List<TieneResponseDto> findAll() {
		return tieneService.findAll();
	}

	@Operation(summary = "Crear", description = "Crear una relacion e introducirla en la base de datos.", tags = { "usuario_maquina", "post" })
	@PostMapping
	public TieneResponseDto add(@RequestBody TieneKeyRequestDto dto) {
		return tieneService.add(dto);
	}

	@Operation(summary = "Borrar", description = "Borrar una relacion de la base de datos por el id de sus integrantes.", tags = { "cliente", "delete" })
	@DeleteMapping("/{idUsuario}/{idMaquina}")
	public void delete(@PathVariable TieneKeyRequestDto dto) {
		tieneService.delete(dto);
	}
}
