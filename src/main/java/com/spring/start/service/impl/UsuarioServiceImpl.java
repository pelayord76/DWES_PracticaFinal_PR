package com.spring.start.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.start.dto.maquina.MaquinaUsuarioResponseDto;
import com.spring.start.dto.usuario.UsuarioRequestDto;
import com.spring.start.dto.usuario.UsuarioResponseDto;
import com.spring.start.entity.Usuario;
import com.spring.start.mapper.UsuarioMapper;
import com.spring.start.repository.UsuarioRepository;
import com.spring.start.service.UsuarioService;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class UsuarioServiceImpl implements UsuarioService {

	@Autowired
	UsuarioRepository usuarioRepository;

	@Autowired
	UsuarioMapper usuarioMapper;

	private String errorMsg = "No se encuentra el usuario solicitado, id: ";

	@Override
	public UsuarioResponseDto findById(Long id) {
		Optional<Usuario> usuarioOptional = usuarioRepository.findById(id);
		if (usuarioOptional.isEmpty()) {
			log.error(errorMsg + id);
			throw new IllegalArgumentException(errorMsg + id);
		}
		return usuarioMapper.mapToUsuarioResponseDto(usuarioOptional.get());
	}

	@Override
	public List<UsuarioResponseDto> findAll() {
		List<Usuario> usuarios = usuarioRepository.findAll();
		return usuarioMapper.mapToUsuarioResponseDto(usuarios);
	}

	@Override
	public UsuarioResponseDto add(UsuarioRequestDto dto) {
		usuarioRepository.save(usuarioMapper.mapUsuarioRequestToUsuario(dto));
		return usuarioMapper.mapUsuarioRequestToUsuarioResponse(dto);
	}

	@Override
	public UsuarioResponseDto update(Long id, UsuarioRequestDto dto) {
		Optional<Usuario> usuarioOptional = usuarioRepository.findById(id);
		if (usuarioOptional.isEmpty()) {
			log.error(errorMsg + id);
			throw new IllegalArgumentException(errorMsg + id);
		}
		Usuario usuario = usuarioMapper.mapUsuarioRequestToUsuario(id, dto);
		usuarioRepository.save(usuario);
		return usuarioMapper.mapUsuarioRequestToUsuarioResponse(dto);
	}

	@Override
	public void delete(Long id) {
		if (!usuarioRepository.existsById(id)) {
			log.error(errorMsg + id);
			throw new IllegalArgumentException(errorMsg + id);
		}
		usuarioRepository.deleteById(id);
	}

	@Override
	public List<MaquinaUsuarioResponseDto> findMaquinasByUsuario(Long id) {
		return usuarioRepository.findMaquinasByUsuario(id);
	}

}
