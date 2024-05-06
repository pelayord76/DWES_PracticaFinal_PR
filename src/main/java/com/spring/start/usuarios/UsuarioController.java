package com.spring.start.usuarios;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UsuarioController {

	@Autowired
	UsuarioDAO usuarioDAO;

	@GetMapping("/usuario")
	public List<Usuario> getUsuarios() {
		return (List<Usuario>) usuarioDAO.findAll();
	}

	@GetMapping("/usuario/{id}")
	public Usuario getUsuario(@PathVariable Long id) {
		Optional<Usuario> usuario = usuarioDAO.findById(id);
		if (usuario.isPresent()) {
			return usuario.get();
		}
		return null;
	}

	@PostMapping("/usuario/add")
	public void addUsuario(@RequestBody Usuario usuario) {
		usuarioDAO.save(usuario);
	}

	@PutMapping("/usuario/edit/{id}")
	public void editUsuario(@PathVariable long id, @RequestBody Usuario usuario) {
		Optional<Usuario> usuarioUpdate = usuarioDAO.findById(id);
		if (usuarioUpdate.isPresent()) {
			Usuario usuarioNew = usuarioUpdate.get();
			usuarioNew.setNombre(usuario.getNombre());
			usuarioNew.setEmail(usuario.getEmail());
			usuarioNew.setContrasenia(usuario.getContrasenia());
			usuarioNew.setTiene(usuario.getTiene());
			usuarioDAO.save(usuarioNew);
		}
	}

	@DeleteMapping("/usuario/del/{id}")
	public void deleteUsuario(@PathVariable long id) {
		usuarioDAO.deleteById(id);
	}
}
