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

import com.spring.start.dto.factura.FacturaRequestDto;
import com.spring.start.dto.factura.FacturaResponseDto;
import com.spring.start.service.FacturaService;

@RestController
@RequestMapping("/factura")
public class FacturaController {

	@Autowired
	FacturaService facturaService;

	@GetMapping("/{id}")
	public FacturaResponseDto getFactura(@PathVariable Long id) {
		return facturaService.findById(id);
	}

	@GetMapping
	public List<FacturaResponseDto> findAll() {
		return facturaService.findAll();
	}

	@PostMapping
	public FacturaResponseDto addFactura(@RequestBody FacturaRequestDto dto) {
		return facturaService.add(dto);
	}

	@PutMapping("/{id}")
	public FacturaResponseDto editFactura(@PathVariable Long id, @RequestBody FacturaRequestDto dto) {
		return facturaService.update(id, dto);
	}

	@DeleteMapping("/{id}")
	public void deleteFactura(@PathVariable Long id) {
		facturaService.delete(id);
	}
}