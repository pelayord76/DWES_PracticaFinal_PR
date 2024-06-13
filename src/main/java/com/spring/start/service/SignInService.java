package com.spring.start.service;

import com.spring.start.dto.auth.AuthResponseDto;
import com.spring.start.dto.sign.SignInDto;

/**
 * @author pelayord
 */
public interface SignInService {

	AuthResponseDto autenticar(SignInDto request);
}
