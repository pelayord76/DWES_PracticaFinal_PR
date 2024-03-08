package com.spring.start.maquinas;

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

import com.spring.start.clientes.ClienteDAO;
import com.spring.start.recaudaciones.RecaudacionDAO;
import com.spring.start.tiene.TieneDAO;
import com.spring.start.usuarios.UsuarioDAO;

@RestController
public class MaquinaController {

	@Autowired
	MaquinaDAO maquinaDAO;

	@Autowired
	UsuarioDAO usuarioDAO;

	@Autowired
	ClienteDAO clienteDAO;

	@Autowired
	RecaudacionDAO recaudacionDAO;

	@Autowired
	TieneDAO tieneDAO;

	@GetMapping("/maquina")
	public ModelAndView getMaquinas() {
		ModelAndView model = new ModelAndView();
		model.setViewName("maquinas");
		model.addObject("maquinas", maquinaDAO.findAll());
		return model;
	}

	@GetMapping("/maquina/{id}")
	public ModelAndView getMaquina(@PathVariable Long id) {
		ModelAndView model = new ModelAndView();
		model.setViewName("maquina");

		Maquina maquina = maquinaDAO.findById(id).get();
		model.addObject("maquina", maquina);
		return model;

	}

	@GetMapping("/maquina/add")
	public ModelAndView addMaquina() {
		ModelAndView model = new ModelAndView();
		model.setViewName("formMaquina");
		model.addObject("maquina", new Maquina());
		model.addObject("clientes", clienteDAO.findAll());
		return model;
	}

	@GetMapping("/maquina/edit/{id}")
	public ModelAndView editMaquina(@PathVariable long id) {

		ModelAndView model = new ModelAndView();
		Optional<Maquina> maquina = maquinaDAO.findById(id);

		if (maquina.isPresent()) {

			model.addObject("maquina", maquina.get());
			model.addObject("clientes", clienteDAO.findAll());
			model.setViewName("formMaquina");
		} else
			model.setViewName("redirect:/maquina");

		return model;
	}

	@GetMapping("/maquina/del/{id}")
	public ModelAndView deleteMaquina(@PathVariable long id) {

		maquinaDAO.deleteById(id);
		ModelAndView model = new ModelAndView();
		model.setViewName("redirect:/maquina");
		return model;
	}

	@PostMapping("/maquina/save")
	public ModelAndView formMaquina(@ModelAttribute @Validated Maquina maquina, BindingResult bindingResult) {

		ModelAndView model = new ModelAndView();
		if (bindingResult.hasErrors()) {

			model.setViewName("formMaquina");
			model.addObject("maquina", maquina);

			maquina.setCliente(null);

			model.addObject("clientes", clienteDAO.findAll());

			return model;
		}
		
		maquinaDAO.save(maquina);
		model.setViewName("redirect:/maquina");

		return model;
	}
}
