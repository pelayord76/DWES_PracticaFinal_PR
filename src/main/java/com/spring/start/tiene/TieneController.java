package com.spring.start.tiene;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

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
	public ModelAndView tiene() {

		ModelAndView model = new ModelAndView();
		model.addObject("tiene", tieneDAO.findAll());
		model.setViewName("tiene");

		return model;
	}

	@GetMapping("/tiene/add")
	public ModelAndView enmarcaAdd() {

		ModelAndView model = new ModelAndView();
		model.addObject("tiene", new Tiene());
		model.addObject("usuarios", usuarioDAO.findAll());
		model.addObject("maquinas", maquinaDAO.findAll());

		model.setViewName("formTiene");

		return model;
	}

	@PostMapping("/tiene/save")
	public ModelAndView formTiene(@ModelAttribute Tiene tiene) {

		TieneKey key = new TieneKey();
		key.setUsuario_id(tiene.getUsuario().getId());
		key.setMaquina_id(tiene.getMaquina().getId());
		tiene.setId(key);

		tieneDAO.save(tiene);

		ModelAndView model = new ModelAndView();
		model.setViewName("redirect:/usuario/" + tiene.getUsuario().getId());

		return model;
	}

	@GetMapping("/tiene/del/{idUsuario}/{idMaquina}")
	public ModelAndView delPlan(@PathVariable long idUsuario, @PathVariable long idMaquina) {
				
		
		TieneKey key = new TieneKey();
		key.setUsuario_id(idUsuario);
		key.setMaquina_id(idMaquina);

		tieneDAO.deleteById(key);
		
		ModelAndView model = new ModelAndView();
		model.setViewName("redirect:/tiene");
		
		return model;
	}	
}
