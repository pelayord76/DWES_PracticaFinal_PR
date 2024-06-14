package com.spring.start.service;

import org.springframework.http.ResponseEntity;

import com.spring.start.dto.sign.SignUpDto;

public interface SignUpService {

	ResponseEntity<?> manejarRegistro(SignUpDto dto);
}
