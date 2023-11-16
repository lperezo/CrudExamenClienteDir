package com.mx.CrudExamenClienteDir.dao;

import org.springframework.data.repository.CrudRepository;

import com.mx.CrudExamenClienteDir.model.Clientes;

public interface IClienteDao extends CrudRepository<Clientes, Integer> {

}
