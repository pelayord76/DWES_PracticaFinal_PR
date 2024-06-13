package com.spring.start.service.impl;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

import javax.crypto.SecretKey;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import com.spring.start.service.JwtService;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;

@Service
public class JwtServiceImpl implements JwtService {

	private final static String SECRET_KEY = "2af73203581a1dd684c7c33b0a6000693276fa0a5819342b20cda963ebb119bd";

	@Value("${security.jwt.expiration-time}")
	private long jwtExpiration;

	@Override
	public String getToken(UserDetails user) {
		return getToken(new HashMap<>(), user);
	}

	@Override
	public String getToken(Map<String, Object> extraClaims, UserDetails user) {
		return Jwts.builder()
					.claims(extraClaims)
					.subject(user.getUsername())
					.issuedAt(new Date(System.currentTimeMillis()))
					.expiration(new Date(System.currentTimeMillis() + jwtExpiration))
					.signWith(getKey())
					.claim("role", user.getAuthorities())
					.compact();
	}

	@Override
	public SecretKey getKey() {
		byte[] keyBytes = Decoders.BASE64.decode(SECRET_KEY);
		return Keys.hmacShaKeyFor(keyBytes);
	}

	@Override
	public String getUsernameFromToken(String token) {
		return getClaim(token, Claims::getSubject);
	}

	@Override
	public boolean isTokenValid(String token, UserDetails userDetails) {
		String username = getUsernameFromToken(token);
		return (username.equals(userDetails.getUsername()) && !isTokenExpired(token));
	}

	@Override
	public Claims getAllClaims(String token) {
		return Jwts.parser()
						.verifyWith(getKey())
						.build()
						.parseSignedClaims(token)
						.getPayload();
	}

	@Override
	public <T> T getClaim(String token, Function<Claims, T> claimsResolver) {
		Claims claims = getAllClaims(token);
		return claimsResolver.apply(claims);
	}

	@Override
	public Date getExpirationDate(String token) {
		return getClaim(token, Claims::getExpiration);
	}

	@Override
	public boolean isTokenExpired(String token) {
		return getExpirationDate(token).before(new Date());
	}

}
