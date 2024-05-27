package com.spring.start.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import com.spring.start.dto.usuario.UsuarioRequestDto;
import com.spring.start.dto.usuario.UsuarioResponseDto;
import com.spring.start.entity.Usuario;
import com.spring.start.mapper.UsuarioMapper;
import com.spring.start.repository.UsuarioRepository;
import com.spring.start.service.UsuarioService;

import jakarta.validation.Valid;

@Service
@Validated
public class UsuarioServiceImpl implements UsuarioService {

	@Autowired
	UsuarioRepository usuarioRepository;

	@Autowired
	UsuarioMapper usuarioMapper;

	@Override
	public UsuarioResponseDto findById(Long id) {
		Optional<Usuario> usuarioOptional = usuarioRepository.findById(id);
		if (usuarioOptional.isEmpty()) {
			throw new IllegalArgumentException("No existe ese usuario");
		}
		return usuarioMapper.mapToUsuarioResponseDto(usuarioOptional.get());
	}

	@Override
	public List<UsuarioResponseDto> findAll() {
		List<Usuario> usuarios = usuarioRepository.findAll();
		return usuarioMapper.mapToUsuarioResponseDto(usuarios);
	}

	@Override
	public UsuarioResponseDto add(@Valid UsuarioRequestDto dto) {
		usuarioRepository.save(usuarioMapper.mapUsuarioRequestToUsuario(dto));
		return usuarioMapper.mapUsuarioRequestToUsuarioResponse(dto);
	}

	@Override
	public UsuarioResponseDto update(Long id, UsuarioRequestDto dto) {
		Optional<Usuario> usuarioOptional = usuarioRepository.findById(id);
		if (usuarioOptional.isEmpty()) {
			throw new IllegalArgumentException("No existe ese usuario");
		}
		Usuario usuario = usuarioMapper.mapUsuarioRequestToUsuario(id, dto);
		usuarioRepository.save(usuario);
		return usuarioMapper.mapUsuarioRequestToUsuarioResponse(dto);
	}

	@Override
	public void delete(Long id) {
		if (!usuarioRepository.findById(id).isPresent()) {
			throw new IllegalArgumentException("No existe ese usuario");
		}
		usuarioRepository.deleteById(id);
	}

}
