package com.spring.start.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.spring.start.entity.Maquina;

public interface MaquinaRepository extends JpaRepository<Maquina, Long> {

	List<Maquina> findByNombre(String nombre);
}