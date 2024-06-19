package com.spring.start.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.spring.start.dto.sign.SignInDto;
import com.spring.start.dto.sign.SignUpDto;
import com.spring.start.service.AuthenticationService;
import com.spring.start.service.SignUpService;

import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/sign")
@Slf4j
public class SignController {

	@Autowired
	AuthenticationService authenticationService;

	@Autowired
	SignUpService signUpService;

	@PostMapping("/in")
	public ResponseEntity<?> signIn(@RequestBody SignInDto dto) {
		log.info("Peticion para iniciar sesion del usuario " + dto.getUsername());
		return authenticationService.signIn(dto);
	}

	@PostMapping("/up")
	public ResponseEntity<?> signUp(@RequestBody SignUpDto dto) {
		return signUpService.manejarRegistro(dto);
	}
}
