package com.spring.start.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.spring.start.entity.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

	@Query(value = "SELECT * FROM usuario u WHERE u.nombre = :nombre", nativeQuery = true)
	Optional<Usuario> getUsuarioByNombre(@Param("nombre") String nombre);
}
