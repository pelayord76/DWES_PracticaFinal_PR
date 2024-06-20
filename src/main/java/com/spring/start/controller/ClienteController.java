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
import com.spring.start.dto.cliente.ClienteContratoResponseDto;
import com.spring.start.dto.cliente.ClienteDataIngresosDTO;
import com.spring.start.dto.cliente.ClienteDto;
import com.spring.start.dto.cliente.ClienteRequestDto;
import com.spring.start.dto.cliente.ClienteResponseDto;
import com.spring.start.dto.factura.FacturaResponseDto;
import com.spring.start.dto.maquina.MaquinaDto;
import com.spring.start.service.ClienteService;
import com.spring.start.util.ResponseUtil;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.extern.slf4j.Slf4j;

@Tag(name = "Clientes", description = "API de la entidad cliente")
@RestController
@RequestMapping("/cliente")
@Slf4j
public class ClienteController {

	@Autowired
	ClienteService clienteService;

	@Operation(summary = "Buscar individualmente", description = "Buscar un cliente por id.", tags = { "cliente",
			"get" })
	@GetMapping("/{id}")
	public ResponseEntity<ApiResponse<ClienteResponseDto>> findById(@PathVariable Long id) {
		log.info("Peticion para mostrar el cliente con id " + id);
		return ResponseUtil.response(clienteService.findById(id), HttpStatus.FOUND, "Mostrando el cliente");
	}

	@Operation(summary = "Buscar todo", description = "Buscar todos los clientes de la base de datos.", tags = {
			"cliente", "get" })
	@GetMapping
	public ResponseEntity<ApiResponse<List<ClienteResponseDto>>> findAll() {
		log.info("Peticion para mostrar todos los clientes");
		return ResponseUtil.response(clienteService.findAll(), HttpStatus.FOUND, "Mostrando todos los clientes");
	}

	@Operation(summary = "Buscar todo", description = "Buscar todos los clientes de la base de datos.", tags = {
			"cliente", "get" })
	@GetMapping("/clientes")
	public ResponseEntity<ApiResponse<List<ClienteDto>>> getClientesEIds() {
		log.info("Peticion para encontrar todos los clientes con sus ides");
		return ResponseUtil.response(clienteService.getClientesEIds(), HttpStatus.FOUND,
				"Mostrando los clientes con sus ides");
	}

	@Operation(summary = "Sacar clientes con sus ides", description = "Buscar todos los clientes de la base de datos con id y nombre del local para settearselos a una maquina desde el front.", tags = {
			"cliente", "get" })
	@GetMapping("/locales")
	public ResponseEntity<ApiResponse<List<ClienteDto>>> getLocalesEIds() {
		log.info("Peticion para encontrar todos los nombres de los locales con los ides de los clientes");
		return ResponseUtil.response(clienteService.getLocalesEIds(), HttpStatus.FOUND,
				"Mostrando los locales con sus ides");
	}

	@Operation(summary = "Crear", description = "Crear un cliente e introducirlo en la base de datos.", tags = {
			"cliente", "post" })
	@PostMapping
	public ResponseEntity<ApiResponse<ClienteResponseDto>> add(@RequestBody ClienteRequestDto dto) {
		log.info("Peticion para añadir un cliente");
		return ResponseUtil.response(clienteService.add(dto), HttpStatus.CREATED, "Cliente creado con éxito");
	}

	@Operation(summary = "Modificar", description = "Buscar un cliente por id y añadirle nuevos campos.", tags = {
			"cliente", "put" })
	@PutMapping("/{id}")
	public ResponseEntity<ApiResponse<ClienteResponseDto>> update(@PathVariable Long id,
			@RequestBody ClienteRequestDto dto) {
		log.info("Peticion para actualizar el cliente con id " + id);
		return ResponseUtil.response(clienteService.update(id, dto), HttpStatus.ACCEPTED,
				"Cliente actualizado con éxito");
	}

	@Operation(summary = "Borrar", description = "Borrar un cliente de la base de datos por su id.", tags = { "cliente",
			"delete" })
	@DeleteMapping("/{id}")
	public ResponseEntity<ApiResponse<Object>> delete(@PathVariable Long id) {
		log.info("Peticion para borrar el cliente con id " + id);
		clienteService.delete(id);
		return ResponseUtil.response(null, HttpStatus.NO_CONTENT, "Cliente eliminado con éxito");
	}

	@Operation(summary = "Buscar por ingresos", description = "Buscar todos los clientes de la base de datos con sus ingresos históricos correspondientes.", tags = {
			"cliente", "get" })
	@GetMapping("/data/ingresos")
	public ResponseEntity<ApiResponse<List<ClienteDataIngresosDTO>>> findByIngresos() {
		log.info("Peticion para encontrar todos los clientes con sus ingresos totales");
		return ResponseUtil.response(clienteService.findByIngresos(), HttpStatus.FOUND,
				"Mostrando todos los clientes con sus ingresos históricos");
	}

	@Operation(summary = "Buscar por ingresos", description = "Buscar los clientes de la base de datos con los menores ingresos históricos.", tags = {
			"cliente", "get" })
	@GetMapping("/data/ingresos/min")
	public ResponseEntity<ApiResponse<List<ClienteDataIngresosDTO>>> findByIngresosAsc() {
		log.info("Peticion para encontrar los clientes con los menores ingresos totales");
		return ResponseUtil.response(clienteService.findByIngresosAsc(), HttpStatus.FOUND,
				"Mostrando todos los clientes con sus ingresos históricos ordenados de forma ascendente");
	}

	@Operation(summary = "Buscar por ingresos", description = "Buscar los clientes de la base de datos con los mayores ingresos históricos.", tags = {
			"cliente", "get" })
	@GetMapping("/data/ingresos/max")
	public ResponseEntity<ApiResponse<List<ClienteDataIngresosDTO>>> findByIngresosDesc() {
		log.info("Peticion para encontrar los clientes con los mayores ingresos totales");
		return ResponseUtil.response(clienteService.findByIngresosDesc(), HttpStatus.FOUND,
				"Mostrando todos los clientes con sus ingresos históricos ordenados de forma descendente");
	}

	@Operation(summary = "Buscar maquinas", description = "Buscar todas las maquinas relacionadas con el cliente especificado.", tags = {
			"usuario", "get" })
	@GetMapping("/{id}/maquina")
	public ResponseEntity<ApiResponse<List<MaquinaDto>>> findMaquinasByCliente(@PathVariable long id) {
		log.info("Peticion para mostrar todas las maquinas del cliente con id " + id);
		return ResponseUtil.response(clienteService.findMaquinasByCliente(id), HttpStatus.FOUND,
				"Mostrando todas las máquinas del cliente especificado");
	}

	@Operation(summary = "Buscar facturas", description = "Buscar todas las facturas relacionadas con el cliente especificado.", tags = {
			"usuario", "get" })
	@GetMapping("/{id}/factura")
	public ResponseEntity<ApiResponse<List<FacturaResponseDto>>> findFacturasByCliente(@PathVariable long id) {
		log.info("Peticion para mostrar todas las facturas del cliente con id " + id);
		return ResponseUtil.response(clienteService.findFacturasByCliente(id), HttpStatus.FOUND,
				"Mostrando todas las facturas del cliente especificado");
	}

	@Operation(summary = "Buscar clientes", description = "Buscar todos los clientes cuyo contrato venza el mismo año que el especificado por parametro.", tags = {
			"cliente", "get" })
	@GetMapping("/contrato/{anio}")
	public ResponseEntity<ApiResponse<List<ClienteContratoResponseDto>>> findByFechaVencimientoContrato(
			@PathVariable int anio) {
		log.info("Peticion para mostrar todos los clientes cuya fecha de vencimiento de contrato sea del año " + anio);
		return ResponseUtil.response(clienteService.findByFechaVencimientoContrato(anio), HttpStatus.FOUND,
				"Mostrando los clientes que vencen contrato en el año especificado");
	}
}