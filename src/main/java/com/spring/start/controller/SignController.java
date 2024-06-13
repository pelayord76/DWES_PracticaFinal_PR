package com.spring.start.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.spring.start.dto.sign.SignInDto;
import com.spring.start.dto.sign.SignUpDto;
import com.spring.start.service.AuthService;
import com.spring.start.service.SignUpService;

@RestController
@RequestMapping("/sign")
public class SignController {

	@Autowired
	AuthService authService;

	@Autowired
	SignUpService registerService;

	@PostMapping("/in")
	public void login(@RequestBody SignInDto request) {
		authService.login(request);

	}

	@PostMapping("/up")
	public void register(@RequestBody SignUpDto request) {
		registerService.manejarErrores(request);

	}
}
