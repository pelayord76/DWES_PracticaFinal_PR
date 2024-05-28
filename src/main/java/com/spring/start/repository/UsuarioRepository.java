package com.spring.start.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.spring.start.entity.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
}
