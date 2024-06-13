package com.spring.start.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.spring.start.dto.sign.SignUpDto;
import com.spring.start.service.AuthService;
import com.spring.start.service.SignUpService;

@Service
public class SignUpServiceImpl implements SignUpService {

	@Autowired
	AuthService authService;

	@Override
	public ResponseEntity<?> manejarErrores(SignUpDto request) {

		try {
			authService.register(request);
			return ResponseEntity.status(HttpStatus.OK).body("Usuario registrado");
		}
		
//		catch (ExistingUserException | ExistingMailException e) {
//			return ResponseEntity.status(HttpStatus.CONFLICT).body(e.getMessage());
//		}
//		
//		catch (DatosInvalidosException e) {
//			return ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE).body(e.getMessage());
//		}
		
		catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error al registrar el usuario");
		}
	}
}
