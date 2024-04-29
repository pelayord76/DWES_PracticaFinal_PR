package com.spring.start.recaudaciones;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
public class RecaudacionController {

	@Autowired
	RecaudacionDAO recaudacionDAO;

	@GetMapping("/usuario")
	public ModelAndView getRcecaudaciones() {

		ModelAndView model = new ModelAndView();
		model.setViewName("recaudaciones");

		List<Recaudacion> recaudaciones = (List<Recaudacion>) recaudacionDAO.findAll();
		model.addObject("recaudaciones", recaudaciones);

		return model;
	}

	@GetMapping("/usuario/{id}")
	public ModelAndView getRecaudacion(@PathVariable long id) {
		ModelAndView model = new ModelAndView();
		model.setViewName("recaudacion");

		Recaudacion recaudacion = recaudacionDAO.findById(id).get();
		model.addObject("recaudacion", recaudacion);

		return model;
	}

	@GetMapping("/recaudacion/add")
	public ModelAndView addRecaudacion() {
		ModelAndView model = new ModelAndView();
		model.setViewName("formRecaudacion");
		model.addObject("recaudacion", new Recaudacion());

		return model;
	}

	@GetMapping("/recaudacion/edit/{id}")
	public ModelAndView editRecaudacion(@PathVariable long id) {
		ModelAndView model = new ModelAndView();
		Optional<Recaudacion> recaudacion = recaudacionDAO.findById(id);

		if (recaudacion.isPresent()) {
			model.addObject("recaudacion", recaudacion.get());
			model.setViewName("formRecaudacion");
		}

		else model.setViewName("redirect:/recaudacion");

		return model;
	}

	@GetMapping("/recaudacion/del/{id}")
	public ModelAndView deleteRecaudacion(@PathVariable long id) {

		ModelAndView model = new ModelAndView();
		Optional<Recaudacion> recaudacionDelete = recaudacionDAO.findById(id);

		if (recaudacionDelete.isPresent()) {
			recaudacionDAO.delete(recaudacionDelete.get());
			model.setViewName("recaudaciones");
		}
		else model.setViewName("redirect:/recaudacion");

		return model;
	}

	@PostMapping("/recaudacion/save")
	public ModelAndView formRecaudacion(@ModelAttribute @Validated Recaudacion recaudacion, BindingResult bindingResult) {
		ModelAndView model = new ModelAndView();
		if (bindingResult.hasErrors()) {

			model.setViewName("formRecaudacion");
			model.addObject("recaudacion", recaudacion);
			
			return model;
		}
		
		recaudacionDAO.save(recaudacion);
		model.setViewName("redirect:/recaudacion");

		return model;
	}
}