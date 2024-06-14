package com.spring.start.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.spring.start.dto.sign.SignUpDto;
import com.spring.start.service.AuthenticationService;
import com.spring.start.service.SignUpService;

@Service
public class SignUpServiceImpl implements SignUpService {

	@Autowired
	AuthenticationService authenticationService;

	@Override
	public ResponseEntity<?> manejarRegistro(SignUpDto dto) {
		authenticationService.signUp(dto);
		return ResponseEntity.status(HttpStatus.OK).body("Usuario registrado");
	}
}
