package com.spring.start.tiene;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

public interface TieneDAO extends CrudRepository<Tiene, TieneKey> {
	
    List<Tiene> findByUsuarioId(Long id);
    List<Tiene> findByMaquinaId(Long id);
	Optional<Tiene> findByUsuario_IdAndMaquina_Id(Long idUsuario, Long idMaquina);
}
