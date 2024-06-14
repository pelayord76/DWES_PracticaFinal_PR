package com.spring.start.service;

import org.springframework.http.ResponseEntity;

import com.spring.start.dto.sign.SignInDto;
import com.spring.start.dto.sign.SignUpDto;

public interface AuthenticationService {

	ResponseEntity<?> signIn(SignInDto dto);

	void signUp(SignUpDto dto);
}
