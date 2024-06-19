package com.spring.start.service.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.spring.start.entity.Usuario;
import com.spring.start.repository.UsuarioRepository;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

	@Autowired
	private UsuarioRepository usuarioRepository;

	@Override
	public UserDetails loadUserByUsername(String nombre) throws UsernameNotFoundException {
		Optional<Usuario> usuario = usuarioRepository.findByNombre(nombre);
		if (usuario.isPresent()) {
			return usuario.get();
		}
		throw new UsernameNotFoundException(nombre);
	}
}
