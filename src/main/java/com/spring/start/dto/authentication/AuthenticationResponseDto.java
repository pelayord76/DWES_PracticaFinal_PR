package com.spring.start.dto.authentication;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@Builder
public class AuthenticationResponseDto {

	private String token;
}
