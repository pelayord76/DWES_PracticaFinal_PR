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

import com.spring.start.dto.maquina.MaquinaDataIngresosDTO;
import com.spring.start.dto.maquina.MaquinaRequestDto;
import com.spring.start.dto.maquina.MaquinaResponseDto;
import com.spring.start.service.MaquinaService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

@Tag(name = "Maquinas", description = "API de la entidad maquina")
@RestController
@RequestMapping("/maquina")
public class MaquinaController {

	@Autowired
	MaquinaService maquinaService;

	@Operation(summary = "Buscar individualmente", description = "Buscar una maquina por id.", tags = { "maquina", "get" })
	@GetMapping("/{id}")
	public MaquinaResponseDto findById(@PathVariable Long id) {
		return maquinaService.findById(id);
	}

	@Operation(summary = "Buscar todo", description = "Buscar todas las maquinas de la base de datos.", tags = { "maquina", "get" })
	@GetMapping
	public List<MaquinaResponseDto> findAll() {
		return maquinaService.findAll();
	}

	@Operation(summary = "Crear", description = "Crear una maquina e introducirla en la base de datos.", tags = { "maquina", "post" })
	@PostMapping
	public MaquinaResponseDto add(@RequestBody MaquinaRequestDto dto) {
		return maquinaService.add(dto);
	}

	@Operation(summary = "Modificar", description = "Buscar una maquina por id y añadirle nuevos campos.", tags = { "maquina", "put" })
	@PutMapping("/{id}")
	public MaquinaResponseDto update(@PathVariable Long id, @RequestBody MaquinaRequestDto dto) {
		return maquinaService.update(id, dto);
	}

	@Operation(summary = "Borrar", description = "Borrar una maquina de la base ded datos por su id.", tags = { "maquina", "delete" })
	@DeleteMapping("/{id}")
	public void delete(@PathVariable Long id) {
		maquinaService.delete(id);
	}

	@Operation(summary = "Buscar por ingresos", description = "Buscar todas las maquinas de la base de datos con sus ingresos históricos correspondientes agrupadas por el nombre de la maquina.", tags = { "maquina", "get" })
	@GetMapping("/data/ingresos")
	public List<MaquinaDataIngresosDTO> getDatosDeIngresosPorMaquina() {
		return maquinaService.findByIngresos();
//		List<MaquinaDataIngresosDTO> data = new ArrayList<>();
//		List<Maquina> maquinas = (List<Maquina>) maquinaDAO.findAll();
//
//		for (int i = 0; i < maquinas.size(); i++) {
//			List<Maquina> maquinasDevolver = maquinaDAO.findByNombre(maquinas.get(i).getNombre());
//			MaquinaDataIngresosDTO dto = new MaquinaDataIngresosDTO();
//			dto.setNombre(maquinas.get(i).getNombre());
//			double cantidadRecaudada = 0;
//			for (int j = 0; j < maquinasDevolver.size(); j++) {
//				List<Recaudacion> recaudaciones = maquinasDevolver.get(j).getRecaudaciones();
//				for (int k = 0; k < recaudaciones.size(); k++) {
//					cantidadRecaudada += recaudaciones.get(k).getCantidadRecaudada();
//				}
//			}
//			dto.setCantidadRecaudada(cantidadRecaudada);
//		}
//
//		return data;
	}
}
