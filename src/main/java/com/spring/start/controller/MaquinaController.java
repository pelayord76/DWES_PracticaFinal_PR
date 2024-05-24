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

@RestController
@RequestMapping("/maquina")
public class MaquinaController {

	@Autowired
	MaquinaService maquinaService;

	@GetMapping
	public List<MaquinaResponseDto> findAll() {
		return maquinaService.findAll();
	}

	@GetMapping("/{id}")
	public MaquinaResponseDto findById(@PathVariable Long id) {
		return maquinaService.findById(id);
	}

	@PostMapping
	public MaquinaResponseDto add(@RequestBody MaquinaRequestDto dto) {
		return maquinaService.add(dto);
	}

	@PutMapping("/{id}")
	public MaquinaResponseDto update(@PathVariable Long id, @RequestBody MaquinaRequestDto dto) {
		return maquinaService.update(id, dto);
	}

	@DeleteMapping("/{id}")
	public void delete(@PathVariable Long id) {
		maquinaService.delete(id);
	}

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
