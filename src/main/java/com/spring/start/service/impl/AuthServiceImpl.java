package com.spring.start.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.spring.start.dto.sign.SignInDto;
import com.spring.start.dto.sign.SignUpDto;
import com.spring.start.repository.UsuarioRepository;
import com.spring.start.service.AuthService;
import com.spring.start.service.JwtService;
import com.spring.start.service.SignInService;

@Service
public class AuthServiceImpl implements AuthService {

	@Autowired
	UsuarioRepository usuarioRepository;

	@Autowired
	JwtService jwtService;

	@Autowired
	AuthenticationManager authManager;

	@Autowired
	PasswordEncoder bcryptPasswordEncoder;
	
	@Autowired
    SignInService loginService;

	@Override
	public void register(SignUpDto request) {
		// TODO Auto-generated method stub

	}

	@Override
	public void login(SignInDto request) {
		// TODO Auto-generated method stub

	}

}
