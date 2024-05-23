package com.spring.start.repository;

import org.springframework.data.repository.CrudRepository;

import com.spring.start.entity.Cliente;

public interface ClienteRepository extends CrudRepository<Cliente, Long>  {
}
