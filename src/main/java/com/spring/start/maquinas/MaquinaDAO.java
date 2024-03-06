package com.spring.start.maquinas;

import org.springframework.data.repository.CrudRepository;

public interface MaquinaDAO extends CrudRepository<Maquina, Long> {

	/*
	// query between fechas (no funciona)
	@Query(value = "SELECT * FROM Maquina WHERE fecha_vencimiento_licencia BETWEEN :fecha1 AND :fecha2", nativeQuery = true)
	List<Maquina> findByFechaVencimientoLicenciaBetween(Date fecha1, Date fecha2);

	// query between ids
	@Query(value = "SELECT * FROM Maquina WHERE id BETWEEN :id1 AND :id2", nativeQuery = true)
	List<Maquina> findByIdBetween(Long id1, Long id2);

	// query ending with
	List<Maquina> findByNombreEndingWith(String cadena);

	// query between + orderBy
	List<Maquina> findByIdBetweenOrderByNombreAsc(Long id1, Long id2);

	// query notIN
	List<Maquina> findByIdNotIn(List<Long> idsExcluidos);

	// query ignoreCase
	List<Maquina> findByNombreIgnoreCase(String nombre);
	*/
}