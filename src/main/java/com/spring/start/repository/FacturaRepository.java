package com.spring.start.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.spring.start.dto.factura.PdfDto;
import com.spring.start.entity.Factura;

public interface FacturaRepository extends JpaRepository<Factura, Long> {

	@Query("SELECT new com.spring.start.dto.factura.PdfDto("
			+ "f.id, "
			+ "f.iva, "
			+ "f.fechaEmision, "
			+ "c.local, "
			+ "c.duenio, "
			+ "c.cif, "
			+ "SUM(r.cantidadRecaudada) "
			+ ") "
			+ "FROM Factura f "
			+ "JOIN f.cliente c "
			+ "JOIN c.maquinas m "
			+ "JOIN m.recaudaciones r "
			+ "WHERE f.id = :id "
			+ "AND FUNCTION('YEAR', r.fecha) = FUNCTION('YEAR', f.fechaEmision) "
			+ "AND FUNCTION('MONTH', r.fecha) = FUNCTION('MONTH', f.fechaEmision) "
			+ "GROUP BY "
			+ "f.id, "
			+ "c.local, "
			+ "c.duenio, "
			+ "c.telefono, "
			+ "c.cif")
	PdfDto generarPdf(Long id);
}