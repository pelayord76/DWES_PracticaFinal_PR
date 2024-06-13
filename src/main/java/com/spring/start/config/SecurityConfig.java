package com.spring.start.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.spring.start.filter.JwtAuthenticationFilter;

@Configuration
@EnableWebSecurity
@EnableMethodSecurity
public class SecurityConfig {

	@Autowired
	JwtAuthenticationFilter jwtAuthenticationFilter;

	@Autowired
	AuthenticationProvider authProvider;

	private String rolAdmin = "ADMIN";

	@Bean
	SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
		http.csrf(csrf -> csrf.disable())
				.authorizeHttpRequests(authRequest -> authRequest.requestMatchers("/auth/**", "/").permitAll()
						.requestMatchers("/estadisticas/**").hasAuthority(rolAdmin).requestMatchers("/alerta/**")
						.hasAuthority("ADMIN").requestMatchers("/usuario/del/**").hasAnyAuthority("USER", rolAdmin)
						.requestMatchers("/usuario/propiedades/**").hasAuthority("USER"))
				.sessionManagement(
						sessionManager -> sessionManager.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
				.authenticationProvider(authProvider)
				.addFilterBefore(jwtAuthenticationFilter, UsernamePasswordAuthenticationFilter.class)
				.logout(logout -> logout.permitAll());
		return http.build();
	}
}
