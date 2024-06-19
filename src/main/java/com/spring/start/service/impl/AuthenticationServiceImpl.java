package com.spring.start.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.spring.start.dto.sign.SignInDto;
import com.spring.start.dto.sign.SignUpDto;
import com.spring.start.entity.Usuario;
import com.spring.start.mapper.UsuarioMapper;
import com.spring.start.repository.UsuarioRepository;
import com.spring.start.service.AuthenticationService;
import com.spring.start.service.JwtService;
import com.spring.start.service.SignInService;

@Service
public class AuthenticationServiceImpl implements AuthenticationService {

	@Autowired
	UsuarioRepository usuarioRepository;
	
	@Autowired
	UsuarioMapper usuarioMapper;

	@Autowired
	JwtService jwtService;

	@Autowired
	AuthenticationManager authenticationManager;

	@Autowired
	PasswordEncoder passwordEncoder;

	@Autowired
	SignInService signInService;

	@Override
	public ResponseEntity<?> signIn(SignInDto dto) {
		return ResponseEntity.status(HttpStatus.OK).body(signInService.autenticar(dto));
	}

	@Override
	public void signUp(SignUpDto dto) {
		
		if(usuarioRepository.findByUsername(dto.getUsername()).isPresent()) {
			throw new IllegalArgumentException("Ya existe un usuario con ese nombre de usuario");
		}
		
		else if(usuarioRepository.findByEmail(dto.getEmail()).isPresent()) {
			throw new IllegalArgumentException("Ese correo ya ha sido utilizado por otro usuario");
		}
		
		Usuario usuario = usuarioMapper.mapSignUpDtoToUsuario(dto);
		usuarioRepository.save(usuario);
	}

}
