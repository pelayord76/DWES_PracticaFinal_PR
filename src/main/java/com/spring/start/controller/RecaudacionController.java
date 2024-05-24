package com.spring.start.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.spring.start.dto.recaudacion.RecaudacionRequestDto;
import com.spring.start.dto.recaudacion.RecaudacionResponseDto;
import com.spring.start.service.RecaudacionService;

@RestController
@RequestMapping("/recaudacion")
public class RecaudacionController {

	@Autowired
	RecaudacionService recaudacionService;

	@GetMapping
	public List<RecaudacionResponseDto> findAll() {
		return recaudacionService.findAll();
	}

	@GetMapping("/{id}")
	public RecaudacionResponseDto findById(@PathVariable Long id) {
		return recaudacionService.findById(id);
	}

	@PostMapping
	public RecaudacionResponseDto add(@RequestBody RecaudacionRequestDto dto) {
		return recaudacionService.add(dto);
	}

	@PutMapping("/{id}")
	public RecaudacionResponseDto update(@PathVariable Long id, @RequestBody RecaudacionRequestDto dto) {
		return recaudacionService.update(id, dto);
	}

	@DeleteMapping("/{id}")
	public void delete(@PathVariable Long id) {
		recaudacionService.delete(id);
	}
}
