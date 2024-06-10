package com.spring.start.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.spring.start.dto.factura.FacturaRequestDto;
import com.spring.start.dto.factura.FacturaResponseDto;
import com.spring.start.service.FacturaService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.extern.slf4j.Slf4j;

@Tag(name = "Facturas", description = "API de la entidad factura")
@RestController
@CrossOrigin(origins = "http://localhost:5173")
@RequestMapping("/factura")
@Slf4j
public class FacturaController {

	@Autowired
	FacturaService facturaService;

	@Operation(summary = "Buscar individualmente", description = "Buscar una factura por id.", tags = { "factura",
			"get" })
	@GetMapping("/{id}")
	public FacturaResponseDto getFactura(@PathVariable Long id) {
		log.info("Peticion para mostrar la factura con id " + id);
		return facturaService.findById(id);
	}

	@Operation(summary = "Buscar todo", description = "Buscar todas las facturas de la base de datos.", tags = {
			"factura", "get" })
	@GetMapping
	public List<FacturaResponseDto> findAll() {
		log.info("Peticion para mostrar todas las facturas");
		return facturaService.findAll();
	}

	@Operation(summary = "Crear", description = "Crear una factura e introducirla en la base de datos.", tags = {
			"factura", "post" })
	@PostMapping
	public FacturaResponseDto addFactura(@RequestBody FacturaRequestDto dto) {
		log.info("Peticion para añadir una factura");
		return facturaService.add(dto);
	}

	@Operation(summary = "Modificar", description = "Buscar una factura por id y añadirle nuevos campos.", tags = {
			"factura", "put" })
	@PutMapping("/{id}")
	public FacturaResponseDto editFactura(@PathVariable Long id, @RequestBody FacturaRequestDto dto) {
		log.info("Peticion para actualizar la factura con id " + id);
		return facturaService.update(id, dto);
	}

	@Operation(summary = "Borrar", description = "Borrar una factura de la base ded datos por su id.", tags = {
			"factura", "delete" })
	@DeleteMapping("/{id}")
	public void deleteFactura(@PathVariable Long id) {
		log.info("Peticion para borrar la factura con id " + id);
		facturaService.delete(id);
	}
}