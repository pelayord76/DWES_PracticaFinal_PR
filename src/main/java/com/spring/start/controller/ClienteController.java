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

import com.spring.start.dto.cliente.ClienteDataIngresosDTO;
import com.spring.start.dto.cliente.ClienteRequestDto;
import com.spring.start.dto.cliente.ClienteResponseDto;
import com.spring.start.service.ClienteService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

@Tag(name = "Clientes", description = "API de la entidad cliente")
@RestController
@RequestMapping("/cliente")
public class ClienteController {

	@Autowired
	ClienteService clienteService;

	@Operation(summary = "Buscar individualmente", description = "Buscar un cliente por id.", tags = { "cliente", "get" })
	@GetMapping("/{id}")
	public ClienteResponseDto findById(@PathVariable Long id) {
		return clienteService.findById(id);
	}

	@Operation(summary = "Buscar todo", description = "Buscar todos los clientes de la base de datos.", tags = { "cliente", "get" })
	@GetMapping
	public List<ClienteResponseDto> findAll() {
		return clienteService.findAll();
	}

	@Operation(summary = "Crear", description = "Crear un cliente e introducirlo en la base de datos.", tags = { "cliente", "post" })
	@PostMapping
	public ClienteResponseDto add(@RequestBody ClienteRequestDto dto) {
		return clienteService.add(dto);
	}

	@Operation(summary = "Modificar", description = "Buscar un cliente por id y añadirle nuevos campos.", tags = { "cliente", "put" })
	@PutMapping("/{id}")
	public ClienteResponseDto update(@PathVariable Long id, @RequestBody ClienteRequestDto dto) {
		return clienteService.update(id, dto);
	}

	@Operation(summary = "Borrar", description = "Borrar un cliente de la base de datos por su id.", tags = { "cliente", "delete" })
	@DeleteMapping("/{id}")
	public void delete(@PathVariable Long id) {
		clienteService.delete(id);
	}

	@Operation(summary = "Buscar por ingresos", description = "Buscar todos los clientes de la base de datos con sus ingresos históricos correspondientes.", tags = { "cliente", "get" })
	@GetMapping("/data/ingresos")
	public List<ClienteDataIngresosDTO> findByIngresos() {
		return clienteService.findByIngresos();
		/*
		 * List<ClienteDataIngresosDTO> data = new ArrayList<>(); List<Cliente> clientes
		 * = (List<Cliente>) clienteDAO.findAll();
		 * 
		 * for (int i = 0; i < clientes.size(); i++) { ClienteDataIngresosDTO dto = new
		 * ClienteDataIngresosDTO(); dto.setLocal(clientes.get(i).getLocal());
		 * List<Maquina> maquinas = clientes.get(i).getMaquinas(); List<Recaudacion>
		 * recaudaciones = new ArrayList<>();
		 * 
		 * for (int j = 0; j < maquinas.size(); j++) {
		 * recaudaciones.addAll(maquinas.get(j).getRecaudaciones()); double total = 0;
		 * 
		 * for (int k = 0; k < recaudaciones.size(); k++) { total +=
		 * recaudaciones.get(k).getCantidadRecaudada(); }
		 * dto.setCantidadRecaudada(total); } data.add(dto); } return data;
		 */
	}
}
