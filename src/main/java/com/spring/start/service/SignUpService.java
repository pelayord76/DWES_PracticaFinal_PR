package com.spring.start.service;

import org.springframework.http.ResponseEntity;

import com.spring.start.dto.sign.SignUpDto;

/**
 * @author pelayord
 */
public interface SignUpService {

	ResponseEntity<?> manejarErrores(SignUpDto request);
}
