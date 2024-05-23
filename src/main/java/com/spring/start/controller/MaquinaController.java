package com.spring.start.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.spring.start.dto.MaquinaDataIngresosDTO;
import com.spring.start.entity.Maquina;
import com.spring.start.entity.Recaudacion;
import com.spring.start.repository.MaquinaRepository;

@RestController
@RequestMapping("/maquina")
public class MaquinaController {

	@Autowired
	MaquinaRepository maquinaDAO;

	@GetMapping
	public List<Maquina> getMaquinas() {
		return (List<Maquina>) maquinaDAO.findAll();
	}

	@GetMapping("/{id}")
	public Maquina getMaquina(@PathVariable Long id) {
		Optional<Maquina> maquina = maquinaDAO.findById(id);
		if (maquina.isPresent()) {
			return maquina.get();
		}
		return null;
	}

	@PostMapping
	public void addMaquina(@RequestBody Maquina maquina) {
		maquinaDAO.save(maquina);
	}

	@PutMapping("/{id}")
	public void editMaquina(@PathVariable long id, @RequestBody Maquina newMaquina) {
		Optional<Maquina> oldMaquina = maquinaDAO.findById(id);
		if (oldMaquina.isPresent()) {
			Maquina maquina = oldMaquina.get();
			maquina.setNombre(newMaquina.getNombre());
			maquina.setFechaVencimientoLicencia(newMaquina.getFechaVencimientoLicencia());
			maquina.setAlmacenada(newMaquina.getAlmacenada());
			maquina.setCliente(newMaquina.getCliente());
			maquinaDAO.save(maquina);
		}
	}

	@DeleteMapping("/{id}")
	public void deleteMaquina(@PathVariable long id) {
		maquinaDAO.deleteById(id);
	}

	@GetMapping("/data/ingresos")
	public List<MaquinaDataIngresosDTO> getDatosDeIngresosPorMaquina() {
		List<MaquinaDataIngresosDTO> data = new ArrayList<>();
		List<Maquina> maquinas = (List<Maquina>) maquinaDAO.findAll();

		for (int i = 0; i < maquinas.size(); i++) {
			List<Maquina> maquinasDevolver = maquinaDAO.findByNombre(maquinas.get(i).getNombre());
			MaquinaDataIngresosDTO dto = new MaquinaDataIngresosDTO();
			dto.setNombre(maquinas.get(i).getNombre());
			double cantidadRecaudada = 0;
			for (int j = 0; j < maquinasDevolver.size(); j++) {
				List<Recaudacion> recaudaciones = maquinasDevolver.get(j).getRecaudaciones();
				for (int k = 0; k < recaudaciones.size(); k++) {
					cantidadRecaudada += recaudaciones.get(k).getCantidadRecaudada();
				}
			}
			dto.setCantidadRecaudada(cantidadRecaudada);
		}

		return data;
	}
}
