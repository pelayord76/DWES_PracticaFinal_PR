/*package com.spring.start.servicios;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.spring.start.usuarios.Usuario;
import com.spring.start.usuarios.UsuarioDAO;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {
	
	
	@Autowired
	private UsuarioDAO usuarioDao;
	
	@Override
	public UserDetails loadUserByUsername(String nombre) throws UsernameNotFoundException {

		Optional<Usuario> usuario = usuarioDao.getUsuarioByNombre(nombre);
		if(usuario.isPresent()) {
			
			return (UserDetails)usuario.get();
		}
		
		throw new UsernameNotFoundException(nombre);
	}
}*/