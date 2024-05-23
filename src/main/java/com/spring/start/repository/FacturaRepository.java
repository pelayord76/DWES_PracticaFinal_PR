package com.spring.start.repository;

import org.springframework.data.repository.CrudRepository;

import com.spring.start.entity.Factura;

public interface FacturaRepository extends CrudRepository<Factura, Long> {

}
