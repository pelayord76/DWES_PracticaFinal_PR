package com.spring.start.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.spring.start.dto.tiene.TieneKeyRequestDto;
import com.spring.start.dto.tiene.TieneResponseDto;
import com.spring.start.service.TieneService;

@RestController
@RequestMapping("/tiene")
public class TieneController {

	@Autowired
	private TieneService tieneService;

	@GetMapping
	public List<TieneResponseDto> findAll() {
		return tieneService.findAll();
	}

	@PostMapping
	public TieneResponseDto add(@RequestBody TieneKeyRequestDto dto) {
		return tieneService.add(dto);
	}

	@DeleteMapping("/{idUsuario}/{idMaquina}")
	public void delTiene(@PathVariable TieneKeyRequestDto dto) {
		tieneService.delete(dto);
	}
}
