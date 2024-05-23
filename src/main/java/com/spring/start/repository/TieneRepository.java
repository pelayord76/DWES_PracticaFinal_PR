package com.spring.start.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.spring.start.entity.Tiene;
import com.spring.start.entity.TieneKey;

public interface TieneRepository extends JpaRepository<Tiene, TieneKey> {

	List<Tiene> findByUsuarioId(Long id);

	List<Tiene> findByMaquinaId(Long id);

	Optional<Tiene> findByUsuario_IdAndMaquina_Id(Long idUsuario, Long idMaquina);
}
