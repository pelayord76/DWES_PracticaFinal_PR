package com.spring.start.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.spring.start.entity.Factura;

public interface FacturaRepository extends JpaRepository<Factura, Long> {

}
