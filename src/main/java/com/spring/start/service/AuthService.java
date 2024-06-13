package com.spring.start.service;

import com.spring.start.dto.sign.SignInDto;
import com.spring.start.dto.sign.SignUpDto;

/**
 * @author pelayord
 */
public interface AuthService {

	void register(SignUpDto request);
	
	void login(SignInDto request);
}
