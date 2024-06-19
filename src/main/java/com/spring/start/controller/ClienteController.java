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

import com.spring.start.dto.cliente.ClienteContratoResponseDto;
import com.spring.start.dto.cliente.ClienteDataIngresosDTO;
import com.spring.start.dto.cliente.ClienteDto;
import com.spring.start.dto.cliente.ClienteRequestDto;
import com.spring.start.dto.cliente.ClienteResponseDto;
import com.spring.start.dto.factura.FacturaResponseDto;
import com.spring.start.dto.maquina.MaquinaDto;
import com.spring.start.service.ClienteService;

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
	public ClienteResponseDto findById(@PathVariable Long id) {
		log.info("Peticion para mostrar el cliente con id " + id);
		return clienteService.findById(id);
	}

	@Operation(summary = "Buscar todo", description = "Buscar todos los clientes de la base de datos.", tags = {
			"cliente", "get" })
	@GetMapping
	public List<ClienteResponseDto> findAll() {
		log.info("Peticion para mostrar todos los clientes");
		return clienteService.findAll();
	}

	@Operation(summary = "Buscar todo", description = "Buscar todos los clientes de la base de datos.", tags = {
			"cliente", "get" })
	@GetMapping("/clientes")
	public List<ClienteDto> getClientesEIds() {
		log.info("Peticion para encontrar todos los clientes con sus ides");
		return clienteService.getClientesEIds();
	}

	@Operation(summary = "Sacar clientes con sus ides", description = "Buscar todos los clientes de la base de datos con id y nombre del local para settearselos a una maquina desde el front.", tags = {
			"cliente", "get" })
	@GetMapping("/locales")
	public List<ClienteDto> getLocalesEIds() {
		log.info("Peticion para encontrar todos los nombres de los locales con los ides de los clientes");
		return clienteService.getLocalesEIds();
	}

	@Operation(summary = "Crear", description = "Crear un cliente e introducirlo en la base de datos.", tags = {
			"cliente", "post" })
	@PostMapping
	public ClienteResponseDto add(@RequestBody ClienteRequestDto dto) {
		log.info("Peticion para añadir un cliente");
		return clienteService.add(dto);
	}

	@Operation(summary = "Modificar", description = "Buscar un cliente por id y añadirle nuevos campos.", tags = {
			"cliente", "put" })
	@PutMapping("/{id}")
	public ClienteResponseDto update(@PathVariable Long id, @RequestBody ClienteRequestDto dto) {
		log.info("Peticion para actualizar el cliente con id " + id);
		return clienteService.update(id, dto);
	}

	@Operation(summary = "Borrar", description = "Borrar un cliente de la base de datos por su id.", tags = { "cliente",
			"delete" })
	@DeleteMapping("/{id}")
	public void delete(@PathVariable Long id) {
		log.info("Peticion para borrar el cliente con id " + id);
		clienteService.delete(id);
	}

	@Operation(summary = "Buscar por ingresos", description = "Buscar todos los clientes de la base de datos con sus ingresos históricos correspondientes.", tags = {
			"cliente", "get" })
	@GetMapping("/data/ingresos")
	public List<ClienteDataIngresosDTO> findByIngresos() {
		log.info("Peticion para encontrar todos los clientes con sus ingresos totales");
		return clienteService.findByIngresos();
	}

	@Operation(summary = "Buscar por ingresos", description = "Buscar los clientes de la base de datos con los menores ingresos históricos.", tags = {
			"cliente", "get" })
	@GetMapping("/data/ingresos/min")
	public List<ClienteDataIngresosDTO> findByIngresosAsc() {
		log.info("Peticion para encontrar los clientes con los menores ingresos totales");
		return clienteService.findByIngresosAsc();
	}

	@Operation(summary = "Buscar por ingresos", description = "Buscar los clientes de la base de datos con los mayores ingresos históricos.", tags = {
			"cliente", "get" })
	@GetMapping("/data/ingresos/max")
	public List<ClienteDataIngresosDTO> findByIngresosDesc() {
		log.info("Peticion para encontrar los clientes con los mayores ingresos totales");
		return clienteService.findByIngresosDesc();
	}

	@Operation(summary = "Buscar maquinas", description = "Buscar todas las maquinas relacionadas con el cliente especificado.", tags = {
			"usuario", "get" })
	@GetMapping("/{id}/maquina")
	public List<MaquinaDto> findMaquinasByCliente(@PathVariable long id) {
		log.info("Peticion para mostrar todas las maquinas del cliente con id " + id);
		return clienteService.findMaquinasByCliente(id);
	}

	@Operation(summary = "Buscar facturas", description = "Buscar todas las facturas relacionadas con el cliente especificado.", tags = {
			"usuario", "get" })
	@GetMapping("/{id}/factura")
	public List<FacturaResponseDto> findFacturasByCliente(@PathVariable long id) {
		log.info("Peticion para mostrar todas las facturas del cliente con id " + id);
		return clienteService.findFacturasByCliente(id);
	}

	@Operation(summary = "Buscar clientes", description = "Buscar todos los clientes cuyo contrato venza el mismo año que el especificado por parametro.", tags = {
			"cliente", "get" })
	@GetMapping("/contrato/{anio}")
	public List<ClienteContratoResponseDto> findByFechaVencimientoContrato(@PathVariable int anio) {
		log.info("Peticion para mostrar todos los clientes cuya fecha de vencimiento de contrato sea del año " + anio);
		return clienteService.findByFechaVencimientoContrato(anio);
	}
}