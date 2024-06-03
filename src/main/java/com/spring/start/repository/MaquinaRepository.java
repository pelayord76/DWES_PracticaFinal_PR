package com.spring.start.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.spring.start.dto.maquina.MaquinaDataIngresosDTO;
import com.spring.start.dto.recaudacion.MaquinaRecaudacionResponseDto;
import com.spring.start.entity.Maquina;

public interface MaquinaRepository extends JpaRepository<Maquina, Long> {

	@Query("SELECT new com.spring.start.dto.maquina.MaquinaDataIngresosDTO(m.nombre, SUM(r.cantidadRecaudada))"
			+ "FROM Maquina m " + "JOIN m.recaudaciones r " + "GROUP BY m.nombre")
	List<MaquinaDataIngresosDTO> findByNombreGroupByIngresos();

	@Query("SELECT new com.spring.start.dto.recaudacion.MaquinaRecaudacionResponseDto(r.id, r.cantidadRecaudada, r.porcentajeJuego, r.fecha) "
			+ "FROM Recaudacion r " + "WHERE r.maquina.id = :idMaquina")
	List<MaquinaRecaudacionResponseDto> getRecaudacionesByMaquina(@Param("idMaquina") long idMaquina);
}