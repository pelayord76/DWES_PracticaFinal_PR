package com.spring.start.clientes;

import org.springframework.data.repository.CrudRepository;

public interface ClienteDAO extends CrudRepository<Cliente, Long>  {
}
