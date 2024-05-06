package com.spring.start.tiene;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.spring.start.maquinas.MaquinaDAO;
import com.spring.start.usuarios.UsuarioDAO;

@RestController
public class TieneController {

	@Autowired
	TieneDAO tieneDAO;

	@Autowired
	UsuarioDAO usuarioDAO;

	@Autowired
	MaquinaDAO maquinaDAO;

	@GetMapping("/tiene")
	public List<Tiene> getTiene() {
		return (List<Tiene>) tieneDAO.findAll();
	}

	@PostMapping("/tiene/add")
	public void tieneAdd(@RequestBody Tiene tiene) {

		TieneKey key = new TieneKey();
		key.setUsuario_id(tiene.getUsuario().getId());
		key.setMaquina_id(tiene.getMaquina().getId());
		tiene.setId(key);
		tieneDAO.save(tiene);
	}

	@DeleteMapping("/tiene/del/{idUsuario}/{idMaquina}")
	public void delTiene(@PathVariable long idUsuario, @PathVariable long idMaquina) {
		TieneKey key = new TieneKey();
		key.setUsuario_id(idUsuario);
		key.setMaquina_id(idMaquina);
		tieneDAO.deleteById(key);
	}
}
