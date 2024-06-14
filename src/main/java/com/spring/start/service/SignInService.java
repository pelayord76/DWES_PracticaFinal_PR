package com.spring.start.service;

import com.spring.start.dto.authentication.AuthenticationResponseDto;
import com.spring.start.dto.sign.SignInDto;

public interface SignInService {

	AuthenticationResponseDto autenticar(SignInDto dto);
}
