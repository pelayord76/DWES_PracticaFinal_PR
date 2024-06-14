package com.spring.start.service;

import java.util.Date;
import java.util.function.Function;

import org.springframework.security.core.userdetails.UserDetails;

import io.jsonwebtoken.Claims;

public interface JwtService {

	String getToken(UserDetails user);

	String getUsernameFromToken(String token);

	boolean isTokenValid(String token, UserDetails userDetails);

	<T> T getClaim(String token, Function<Claims, T> claimsResolver);

	Date getExpirationDate(String token);

	boolean isTokenExpired(String token);
}
