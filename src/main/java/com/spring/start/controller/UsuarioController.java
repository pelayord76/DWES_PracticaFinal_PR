package com.spring.start.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.spring.start.dto.ApiResponse;
import com.spring.start.dto.maquina.MaquinaUsuarioResponseDto;
import com.spring.start.dto.usuario.UsuarioResponseDto;
import com.spring.start.dto.usuario.UsuarioUpdateRequestDto;
import com.spring.start.service.UsuarioService;
import com.spring.start.util.ResponseUtil;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;

@Tag(name = "Usuarios", description = "API de la entidad usuario")
@RestController
@RequestMapping("/usuario")
@Slf4j
public class UsuarioController {

	@Autowired
	UsuarioService usuarioService;

	@Operation(summary = "Buscar individualmente", description = "Buscar un usuario por id.", tags = { "usuario",
			"get" })
	@GetMapping("/{id}")
	public ResponseEntity<ApiResponse<UsuarioResponseDto>> findById(@PathVariable Long id) {
		log.info("Peticion para mostrar el usuario con id " + id);
		return ResponseUtil.response(usuarioService.findById(id), HttpStatus.FOUND, "Mostrando el usuario");
	}

	@Operation(summary = "Buscar todo", description = "Buscar todos los usuarios de la base de datos.", tags = {
			"usuario", "get" })
	@GetMapping
	public ResponseEntity<ApiResponse<List<UsuarioResponseDto>>> findAll() {
		log.info("Peticion para mostrar todos los usuarios");
		return ResponseUtil.response(usuarioService.findAll(), HttpStatus.FOUND, "Mostrando todos los usuarios");
	}

	// MÉTODO ADD MEDIANTE REGISTRO EN LOGCONTROLLER

	@Operation(summary = "Modificar", description = "Buscar un usuario por id y añadirle nuevos campos.", tags = {
			"usuario", "put" })
	@PutMapping("/{id}")
	public ResponseEntity<ApiResponse<UsuarioResponseDto>> update(@PathVariable Long id,
			@Valid @RequestBody UsuarioUpdateRequestDto dto) {
		log.info("Peticion para actualizar el usuario con id " + id);
		return ResponseUtil.response(usuarioService.update(id, dto), HttpStatus.ACCEPTED, "Usuario actualizado con éxito");
	}

	@Operation(summary = "Borrar", description = "Borrar un usuario de la base de datos por su id.", tags = { "usuario",
			"delete" })
	@DeleteMapping("/{id}")
	public ResponseEntity<ApiResponse<Object>> delete(@PathVariable Long id) {
		log.info("Peticion para borrar el usuario con id " + id);
		usuarioService.delete(id);
		return ResponseUtil.response(null, HttpStatus.NO_CONTENT, "Usuario eliminado con éxito");
	}

	@Operation(summary = "Buscar maquinas", description = "Buscar todas las maquinas relacionadas con el usuario especificado.", tags = {
			"usuario", "get" })
	@GetMapping("/{id}/maquina")
	public ResponseEntity<ApiResponse<List<MaquinaUsuarioResponseDto>>> findMaquinasByUsuario(@PathVariable long id) {
		log.info("Peticion para mostrar todas las maquinas del usuario con id " + id);
		return ResponseUtil.response(usuarioService.findMaquinasByUsuario(id), HttpStatus.FOUND,
				"Mostrando todas las maquinas del usuario");
	}
}