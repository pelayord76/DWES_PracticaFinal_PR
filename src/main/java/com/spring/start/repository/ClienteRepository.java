package com.spring.start.repository;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.spring.start.dto.cliente.ClienteContratoResponseDto;
import com.spring.start.dto.cliente.ClienteDataIngresosDTO;
import com.spring.start.dto.factura.FacturaResponseDto;
import com.spring.start.dto.maquina.MaquinaDto;
import com.spring.start.entity.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {

	@Query("SELECT new com.spring.start.dto.cliente.ClienteDataIngresosDTO(c.local, SUM(r.cantidadRecaudada)) "
			+ "FROM Cliente c "
			+ "JOIN c.maquinas m "
			+ "JOIN m.recaudaciones r "
			+ "GROUP BY c.local")
	List<ClienteDataIngresosDTO> findAllByIngresos();

	@Query("SELECT new com.spring.start.dto.maquina.MaquinaDto(m.id, m.nombre) "
			+ "FROM Maquina m "
			+ "JOIN m.cliente c "
			+ "WHERE c.id = :idCliente")
	List<MaquinaDto> findMaquinasByCliente(@Param("idCliente") long id);

	@Query("SELECT new com.spring.start.dto.factura.FacturaResponseDto(f.id, f.iva, f.fechaEmision, new com.spring.start.dto.cliente.ClienteDto(f.cliente.id, f.cliente.local)) "
			+ "FROM Factura f "
			+ "WHERE f.cliente.id = :idCliente")
	List<FacturaResponseDto> findFacturasByCliente(@Param("idCliente") long id);

	@Query("SELECT new com.spring.start.dto.cliente.ClienteDataIngresosDTO(c.local, SUM(r.cantidadRecaudada)) "
			+ "FROM Cliente c "
			+ "JOIN c.maquinas m "
			+ "JOIN m.recaudaciones r "
			+ "GROUP BY c.local "
			+ "ORDER BY SUM(r.cantidadRecaudada) "
			+ "ASC")
	List<ClienteDataIngresosDTO> findByIngresosAsc(Pageable pageable);

	@Query("SELECT new com.spring.start.dto.cliente.ClienteDataIngresosDTO(c.local, SUM(r.cantidadRecaudada)) "
			+ "FROM Cliente c "
			+ "JOIN c.maquinas m "
			+ "JOIN m.recaudaciones r "
			+ "GROUP BY c.local "
			+ "ORDER BY SUM(r.cantidadRecaudada) "
			+ "DESC")
	List<ClienteDataIngresosDTO> findByIngresosDesc(Pageable pageable);

	@Query("SELECT new com.spring.start.dto.cliente.ClienteContratoResponseDto(c.local, c.fechaVencimientoContrato) "
			+ "FROM Cliente c "
			+ "WHERE YEAR(c.fechaVencimientoContrato) = :anio "
			+ "ORDER BY c.fechaVencimientoContrato "
			+ "ASC")
	List<ClienteContratoResponseDto> findByFechaVencimientoContrato(@Param("anio") int anio);

}