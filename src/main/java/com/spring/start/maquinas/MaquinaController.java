package com.spring.start.maquinas;

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

@RestController
@RequestMapping("/maquina")
public class MaquinaController {

	@Autowired
	MaquinaDAO maquinaDAO;

	@GetMapping
	public List<Maquina> getMaquinas() {
		return (List<Maquina>) maquinaDAO.findAll();
	}

	@GetMapping("/{id}")
	public Maquina getMaquina(@PathVariable Long id) {
		Optional<Maquina> maquina = maquinaDAO.findById(id);
		if(maquina.isPresent()) {
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
			maquina.setAlmacenada(newMaquina.isAlmacenada());
			maquina.setCliente(newMaquina.getCliente());
			maquinaDAO.save(maquina);
		}
	}

	@DeleteMapping("/{id}")
	public void deleteMaquina(@PathVariable long id) {
		maquinaDAO.deleteById(id);
	}
}
