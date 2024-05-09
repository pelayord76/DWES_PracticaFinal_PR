package com.spring.start.tiene;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.spring.start.maquinas.Maquina;
import com.spring.start.maquinas.MaquinaDAO;
import com.spring.start.usuarios.Usuario;
import com.spring.start.usuarios.UsuarioDAO;

@RestController
@RequestMapping("/tiene")
public class TieneController {

	@Autowired
	TieneDAO tieneDAO;

	@Autowired
	UsuarioDAO usuarioDAO;

	@Autowired
	MaquinaDAO maquinaDAO;

	@GetMapping
	public List<Tiene> getTiene() {
		return (List<Tiene>) tieneDAO.findAll();
	}

	@PostMapping
	public void tieneAdd(@RequestBody TieneKey key) {

		Optional<Usuario> usuario = usuarioDAO.findById(key.getUsuario_id());
		Optional<Maquina> maquina = maquinaDAO.findById(key.getMaquina_id());

		if (usuario.isPresent() && maquina.isPresent()) {
			Tiene tieneAdd = new Tiene();
			tieneAdd.setId(key);
			tieneAdd.setUsuario(usuario.get());
			tieneAdd.setMaquina(maquina.get());
			tieneDAO.save(tieneAdd);
		}
	}

	@DeleteMapping("/{idUsuario}/{idMaquina}")
	public void delTiene(@PathVariable long idUsuario, @PathVariable long idMaquina) {
		TieneKey key = new TieneKey();
		key.setUsuario_id(idUsuario);
		key.setMaquina_id(idMaquina);
		tieneDAO.deleteById(key);
	}
}
