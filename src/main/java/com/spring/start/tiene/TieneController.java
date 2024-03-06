package com.spring.start.tiene;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.spring.start.maquinas.Maquina;
import com.spring.start.usuarios.Usuario;

@RestController
public class TieneController {

	@Autowired
	TieneDAO tieneDAO;

	@GetMapping("/usuario/{id}/tiene")
	public List<Maquina> getMaquinas(@PathVariable Long id) {

		List<Tiene> relaciones = tieneDAO.findByUsuarioId(id);
		List<Maquina> maquinas = new ArrayList<>();

		for (Tiene r : relaciones) {
			maquinas.add(r.maquina);
		}

		return maquinas;
	}

	@GetMapping("/maquina/{id}/tiene")
	public List<Usuario> getUsuarios(@PathVariable Long id) {

		List<Tiene> relaciones = tieneDAO.findByMaquinaId(id);
		List<Usuario> usuarios = new ArrayList<>();

		for (Tiene r : relaciones) {
			usuarios.add(r.usuario);
		}

		return usuarios;
	}

	@DeleteMapping("/usuario/{idUsuario}/maquina/{idMaquina}")
	public ResponseEntity<Tiene> deleteMaquina(@PathVariable Long idUsuario, @PathVariable Long idMaquina) {
		List<Tiene> relaciones = (List<Tiene>) tieneDAO.findAll();
		for (Tiene r : relaciones) {
			if (r.maquina.getId() == idMaquina && r.usuario.getId() == idUsuario) {
				tieneDAO.delete(r);
				return ResponseEntity.status(HttpStatus.FOUND).body(r);
			}
		}
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
	}
}
