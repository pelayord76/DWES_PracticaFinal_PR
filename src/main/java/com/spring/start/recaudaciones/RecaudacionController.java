package com.spring.start.recaudaciones;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RecaudacionController {

	@Autowired
	RecaudacionDAO recaudacionDAO;
	
	
	
	@GetMapping("/recaudacion")
	public List<Recaudacion> getRecaudaciones(){
		return (List<Recaudacion>) recaudacionDAO.findAll();
	}
}
