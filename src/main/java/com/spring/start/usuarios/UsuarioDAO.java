package com.spring.start.usuarios;

import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface UsuarioDAO extends CrudRepository<Usuario, Long>{

	@Query(value="SELECT * FROM usuario u WHERE u.nombre = :nombre", nativeQuery = true)
	Optional<Usuario> getUsuarioByNombre(@Param("nombre") String nombre);
}
