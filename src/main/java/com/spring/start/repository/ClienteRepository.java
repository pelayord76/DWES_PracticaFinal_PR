package com.spring.start.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.spring.start.dto.cliente.ClienteDataIngresosDTO;
import com.spring.start.entity.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {

	@Query("SELECT new com.spring.start.dto.cliente.ClienteDataIngresosDTO(c.local, SUM(r.cantidadRecaudada)) "
			+ "FROM Cliente c "
			+ "JOIN c.maquinas m "
			+ "JOIN m.recaudaciones r "
			+ "GROUP BY c.local")
	List<ClienteDataIngresosDTO> findAllByIngresos();
}
