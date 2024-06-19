package com.spring.start.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.spring.start.dto.cliente.ClienteLocalResponseDto;
import com.spring.start.entity.Recaudacion;

public interface RecaudacionRepository extends JpaRepository<Recaudacion, Long> {

	@Query("SELECT new com.spring.start.dto.cliente.ClienteLocalResponseDto(r.maquina.cliente.local) "
			+ "FROM Recaudacion r "
			+ "WHERE r.id = ?1")
	ClienteLocalResponseDto getLocal(long id);
}
