package com.spring.start.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.spring.start.dto.ApiResponse;
import com.spring.start.entity.Tiene;
import com.spring.start.entity.TieneKey;
import com.spring.start.service.TieneService;
import com.spring.start.util.ResponseUtil;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.extern.slf4j.Slf4j;

@Tag(name = "Usuario_maquina", description = "API de la entidad intermedia entre usuario y maquina")
@RestController
@RequestMapping("/tiene")
@Slf4j
public class TieneController {

	@Autowired
	private TieneService tieneService;

	@Operation(summary = "Buscar todo", description = "Buscar todas las relaciones de la base de datos.", tags = {
			"usuario_maquina", "get" })
	@GetMapping
	public ResponseEntity<ApiResponse<List<Tiene>>> findAll() {
		log.info("Peticion para mostrar todas las relaciones usuario-maquina");
		return ResponseUtil.response(tieneService.findAll(), HttpStatus.FOUND, "Mostrando todas las relaciones");
	}

	@Operation(summary = "Crear", description = "Crear una relacion e introducirla en la base de datos.", tags = {
			"usuario_maquina", "post" })
	@PostMapping
	public ResponseEntity<ApiResponse<Tiene>> add(@RequestBody TieneKey key) {
		log.info("Peticion para añadir una relacion usuario-maquina");
		return ResponseUtil.response(tieneService.add(key), HttpStatus.ACCEPTED, "Relacion creada con éxito");
	}

	@Operation(summary = "Borrar", description = "Borrar una relacion de la base de datos por el id de sus integrantes.", tags = {
			"cliente", "delete" })
	@DeleteMapping("/{idUsuario}/{idMaquina}")
	public ResponseEntity<ApiResponse<Object>> delete(@PathVariable long idUsuario, @PathVariable long idMaquina) {
		log.info("Peticion para borrar la relacion usuario-maquina con los ides: usuario[" + idUsuario + "], maquina["
				+ idMaquina + "]");
		tieneService.delete(idUsuario, idMaquina);
		return ResponseUtil.response(null, HttpStatus.NO_CONTENT, "Relacion eliminada con éxito");
	}

	@Operation(summary = "Buscar por usuario", description = "Buscar todas las relaciones del usuario especificado que haya de la base de datos.", tags = {
			"usuario_maquina", "get" })
	@GetMapping("/usuario/{idUsuario}")
	public ResponseEntity<ApiResponse<List<Tiene>>> findByUsuarioId(@PathVariable long idUsuario) {
		log.info("Peticion para mostrar todas las relaciones usuario-maquina del usuario con id: " + idUsuario);
		return ResponseUtil.response(tieneService.findByUsuarioId(idUsuario), HttpStatus.FOUND,
				"Mostrando todas las relaciones del usuario");
	}

	@Operation(summary = "Buscar por maquna", description = "Buscar todas las relaciones de la maquina especificada que haya de la base de datos.", tags = {
			"usuario_maquina", "get" })
	@GetMapping("/maquina/{idMaquina}")
	public ResponseEntity<ApiResponse<List<Tiene>>> findByMaquinaId(@PathVariable long idMaquina) {
		log.info("Peticion para mostrar todas las relaciones usuario-maquina de la maquina con id: " + idMaquina);
		return ResponseUtil.response(tieneService.findByMaquinaId(idMaquina), HttpStatus.FOUND,
				"Mostrando todas relaciones de la máquina");
	}
}
