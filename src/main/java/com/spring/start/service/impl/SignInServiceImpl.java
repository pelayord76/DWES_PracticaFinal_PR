package com.spring.start.service.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.stereotype.Service;

import com.spring.start.dto.authentication.AuthenticationResponseDto;
import com.spring.start.dto.sign.SignInDto;
import com.spring.start.entity.Usuario;
import com.spring.start.repository.UsuarioRepository;
import com.spring.start.service.JwtService;
import com.spring.start.service.SignInService;

@Service
public class SignInServiceImpl implements SignInService {

	@Autowired
	AuthenticationManager authenticationManager;

	@Autowired
	UsuarioRepository usuarioRepository;

	@Autowired
	JwtService jwtService;

	@Override
	public AuthenticationResponseDto autenticar(SignInDto dto) {
		authenticationManager
				.authenticate(new UsernamePasswordAuthenticationToken(dto.getUsername(), dto.getPassword()));

		Optional<Usuario> user = usuarioRepository.findByUsername(dto.getUsername());

		if (user.isEmpty())
			throw new IllegalArgumentException("No se encuentra el usuario");

		String token = jwtService.getToken(user.get());

		return AuthenticationResponseDto.builder().token(token).build();
	}
}