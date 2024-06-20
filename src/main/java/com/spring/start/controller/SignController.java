package com.spring.start.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.spring.start.dto.ApiResponse;
import com.spring.start.dto.sign.SignInDto;
import com.spring.start.dto.sign.SignUpDto;
import com.spring.start.service.AuthenticationService;
import com.spring.start.service.SignUpService;
import com.spring.start.util.ResponseUtil;

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
	public ResponseEntity<ApiResponse<Object>> signIn(@RequestBody SignInDto dto) {
		log.info("Peticion para iniciar sesion del usuario " + dto.getUsername());
		return ResponseUtil.response(authenticationService.signIn(dto), HttpStatus.ACCEPTED,
				"Sesion iniciada correctamente");
	}

	@PostMapping("/up")
	public ResponseEntity<ApiResponse<Object>> signUp(@RequestBody SignUpDto dto) {
		return ResponseUtil.response(signUpService.manejarRegistro(dto), HttpStatus.ACCEPTED,
				"Registro realizado correctamente");
	}
}
