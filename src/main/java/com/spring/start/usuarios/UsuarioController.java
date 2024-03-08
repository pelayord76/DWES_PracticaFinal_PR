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

import com.spring.start.maquinas.MaquinaDAO;

@RestController
public class UsuarioController {

	@Autowired
	UsuarioDAO usuarioDAO;

	@Autowired
	MaquinaDAO maquinaDAO;

	@GetMapping("/usuario")
	public ModelAndView getUsuarios() {

		ModelAndView model = new ModelAndView();
		model.setViewName("usuarios");

		List<Usuario> usuarios = (List<Usuario>) usuarioDAO.findAll();

		model.addObject("usuarios", usuarios);

		return model;

	}

	@GetMapping("/usuario/{id}")
	public ModelAndView getUsuario(@PathVariable Long id) {

		ModelAndView model = new ModelAndView();
		model.setViewName("usuario");

		Usuario usuario = usuarioDAO.findById(id).get();
		model.addObject("usuario", usuario);

		return model;
	}

	@GetMapping("/usuario/add")
	public ModelAndView addUsuario() {

		ModelAndView model = new ModelAndView();
		model.setViewName("formUsuario");

		model.addObject("usuario", new Usuario());
		model.addObject("maquinas", maquinaDAO.findAll());

		return model;
	}

	@GetMapping("/usuario/edit/{id}")
	public ModelAndView editUsuario(@PathVariable long id) {

		ModelAndView model = new ModelAndView();
		Optional<Usuario> user = usuarioDAO.findById(id);

		if (user.isPresent()) {

			model.addObject("usuario", user.get());
			model.setViewName("formUsuario");
		}
		else model.setViewName("redirect:/usuario");
		
		return model;
	}

	@GetMapping("/usuario/del/{id}")
	public ModelAndView deleteUsuario(@PathVariable long id) {

		usuarioDAO.deleteById(id);
		ModelAndView model = new ModelAndView();
		model.setViewName("redirect:/usuario");
		return model;
	}

	@PostMapping("/usuario/save")
	public ModelAndView formUsuario(@ModelAttribute @Validated Usuario usuario, BindingResult bindingResult) {

		ModelAndView model = new ModelAndView();
		if (bindingResult.hasErrors()) {

			model.setViewName("formUsuario");
			model.addObject("usuario", usuario);
		}

		usuarioDAO.save(usuario);

		model.setViewName("redirect:/usuario");

		return model;
	}
}
