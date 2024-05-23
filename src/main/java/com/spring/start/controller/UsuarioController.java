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

import com.spring.start.dto.usuario.UsuarioRequestDto;
import com.spring.start.dto.usuario.UsuarioResponseDto;
import com.spring.start.service.UsuarioService;

@RestController
@RequestMapping("/usuario")
public class UsuarioController {

	@Autowired
	UsuarioService usuarioService;

	@GetMapping("/{id}")
	public UsuarioResponseDto findById(@PathVariable Long id) {
		return usuarioService.findById(id);
	}

	@GetMapping
	public List<UsuarioResponseDto> findAll() {
		return usuarioService.findAll();
	}

	@PostMapping
	public UsuarioResponseDto add(@RequestBody UsuarioRequestDto dto) {
		return usuarioService.add(dto);
	}

	@PutMapping("/{id}")
	public UsuarioResponseDto update(@PathVariable Long id, @RequestBody UsuarioRequestDto dto) {
		return usuarioService.update(id, dto);
	}

	@DeleteMapping("/{id}")
	public void delete(@PathVariable Long id) {
		usuarioService.delete(id);
	}
}
