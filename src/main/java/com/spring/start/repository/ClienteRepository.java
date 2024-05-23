package com.spring.start.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.spring.start.entity.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {
}
