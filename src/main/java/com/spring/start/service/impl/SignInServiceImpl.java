package com.spring.start.service.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.stereotype.Service;

import com.spring.start.dto.auth.AuthResponseDto;
import com.spring.start.dto.sign.SignInDto;
import com.spring.start.entity.Usuario;
import com.spring.start.repository.UsuarioRepository;
import com.spring.start.service.JwtService;
import com.spring.start.service.SignInService;

@Service
public class SignInServiceImpl implements SignInService {

	@Autowired
	AuthenticationManager authManager;

	@Autowired
	UsuarioRepository usuarioRepository;

	@Autowired
	JwtService jwtService;

	@Override
	public AuthResponseDto autenticar(SignInDto request) {
		authManager.authenticate(new UsernamePasswordAuthenticationToken(request.getUsername(), request.getPassword()));
		Optional<Usuario> user = usuarioRepository.findByUsername(request.getUsername());
		
		if(user.isEmpty()) {
			throw new IllegalArgumentException("No se encuentra el usuario solicitado, Usuario: " + request.getUsername());
		}
		
		String token = jwtService.getToken(user.get());
		return AuthResponseDto.builder().token(token).build();
	}
}
