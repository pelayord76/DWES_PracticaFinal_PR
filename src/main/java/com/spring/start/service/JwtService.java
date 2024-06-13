package com.spring.start.service;

import java.util.Date;
import java.util.Map;
import java.util.function.Function;

import javax.crypto.SecretKey;

import org.springframework.security.core.userdetails.UserDetails;

import io.jsonwebtoken.Claims;

/**
 * @author pelayord
 */

public interface JwtService {

	String getToken(UserDetails user);

	String getToken(Map<String, Object> extraClaims, UserDetails user);

	SecretKey getKey();

	String getUsernameFromToken(String token);

	boolean isTokenValid(String token, UserDetails userDetails);

	Claims getAllClaims(String token);

	<T> T getClaim(String token, Function<Claims, T> claimsResolver);

	Date getExpirationDate(String token);

	boolean isTokenExpired(String token);
}
