package com.spring.start.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.LogoutConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.spring.start.filter.JwtAuthenticationFilter;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

	@Autowired
	JwtAuthenticationFilter jwtAuthenticationFilter;

	@Autowired
	AuthenticationProvider authProvider;

	@Bean
	protected SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
		http.csrf(csrf -> csrf.disable())
				.authorizeHttpRequests(authRequest -> authRequest
						
						.requestMatchers("/", 
										 "/sign/**").permitAll()

						.requestMatchers("/cliente", "/cliente/data/ingresos",
										 "/factura",
										 "/maquina", "/maquina/data/ingresos",
										 "/recaudacion",
										 "/tiene").authenticated()

						.requestMatchers("/cliente/**",
										 "/factura/**",
										 "/maquina/**",
										 "/recaudacion/**",
										 "/tiene/**",
										 "/usuario/**").hasAnyRole("USER", "ADMIN")
						
						.requestMatchers("/usuario").hasRole("ADMIN")
						)

				.sessionManagement(sessionManager -> sessionManager.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
				.authenticationProvider(authProvider)
				.addFilterBefore(jwtAuthenticationFilter, UsernamePasswordAuthenticationFilter.class)
				.logout(LogoutConfigurer::permitAll);

		return http.build();
	}
}