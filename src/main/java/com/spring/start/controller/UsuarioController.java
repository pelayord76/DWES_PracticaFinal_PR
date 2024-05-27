package com.spring.start.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.spring.start.dto.usuario.UsuarioRequestDto;
import com.spring.start.dto.usuario.UsuarioResponseDto;
import com.spring.start.service.UsuarioService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;

@Tag(name = "Usuarios", description = "API de la entidad usuario")
@RestController
@Validated
@RequestMapping("/usuario")
public class UsuarioController {

	@Autowired
	UsuarioService usuarioService;

	@Operation(summary = "Buscar individualmente", description = "Buscar un usuario por id.", tags = { "usuario", "get" })
	@GetMapping("/{id}")
	public UsuarioResponseDto findById(@PathVariable Long id) {
		return usuarioService.findById(id);
	}

	@Operation(summary = "Buscar todo", description = "Buscar todos los usuarios de la base de datos.", tags = { "usuario", "get" })
	@GetMapping
	public List<UsuarioResponseDto> findAll() {
		return usuarioService.findAll();
	}

	@Operation(summary = "Crear", description = "Crear un usuario e introducirlo en la base de datos.", tags = { "usuario", "post" })
	@PostMapping
	public UsuarioResponseDto add(@Valid @RequestBody UsuarioRequestDto dto) {
		return usuarioService.add(dto);
	}

	@Operation(summary = "Modificar", description = "Buscar un usuario por id y añadirle nuevos campos.", tags = { "usuario", "put" })
	@PutMapping("/{id}")
	public UsuarioResponseDto update(@PathVariable Long id, @Valid @RequestBody UsuarioRequestDto dto) {
		return usuarioService.update(id, dto);
	}

	@Operation(summary = "Borrar", description = "Borrar un usuario de la base de datos por su id.", tags = { "usuario", "delete" })
	@DeleteMapping("/{id}")
	public void delete(@PathVariable Long id) {
		usuarioService.delete(id);
	}
}
