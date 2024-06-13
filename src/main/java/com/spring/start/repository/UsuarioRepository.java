package com.spring.start.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.spring.start.dto.maquina.MaquinaUsuarioResponseDto;
import com.spring.start.entity.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

	@Query("SELECT new com.spring.start.dto.maquina.MaquinaUsuarioResponseDto(m.id, m.nombre, new com.spring.start.dto.cliente.ClienteDto(c.id, c.local)) "
			+ "FROM Maquina m " + "JOIN m.cliente c " + "JOIN m.tiene t " + "JOIN t.usuario u "
			+ "WHERE u.id = :idUsuario")
	List<MaquinaUsuarioResponseDto> findMaquinasByUsuario(@Param("idUsuario") long idUsuario);

	Optional<Usuario> findByNombre(String nombre);

	Optional<Usuario> findByUsername(String username);
}
