package com.spring.start.usuarios;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;


@RestController
public class UsuarioController {

	@Autowired
	UsuarioDAO usuarioDAO;
	
	
	
	@GetMapping("/usuario")
	public List<Usuario> getUsuarios(){
		return (List<Usuario>) usuarioDAO.findAll();
	}
	
	@GetMapping("/usuario/{id}")
	public Optional<Usuario> getUsuario(@PathVariable Long id){
		return usuarioDAO.findById(id);
	}
	
	/*@GetMapping("/usuario/add")
	public Optional<Usuario> addUsuario(){
		
	}*/
	
	@GetMapping("/usuario/edit/{id}")
	public Optional<Usuario> editUsuario(@PathVariable long id){
		Optional<Usuario> user = usuarioDAO.findById(id);
		if(user.isPresent()) {
			
		}
		else {
			
		}
		return null;
	}
	
	@GetMapping("/usuario/del/{id}")
	public Optional<Usuario> deleteUsuario(@PathVariable long id){
		usuarioDAO.deleteById(id);
		
		return null;
	}

	@PostMapping("/usuario/save")
	public ModelAndView formUsuario(@ModelAttribute @Validated Usuario usuario, BindingResult bindingResult) {
		return null;
	}
}
