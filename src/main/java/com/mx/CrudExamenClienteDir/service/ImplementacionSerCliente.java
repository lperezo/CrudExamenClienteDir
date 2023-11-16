package com.mx.CrudExamenClienteDir.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mx.CrudExamenClienteDir.dao.IClienteDao;
import com.mx.CrudExamenClienteDir.model.Clientes;

@Service
public class ImplementacionSerCliente implements IClienteServicio {

	@Autowired
	IClienteDao clienteDao;
	
	@Transactional
	@Override
	public void guardar(Clientes cliente) {
		clienteDao.save(cliente);
	}

	@Transactional
	@Override
	public void editar(Clientes cliente) {
		clienteDao.save(cliente);
	}

	@Transactional
	@Override
	public void eliminar(Clientes cliente) {
		clienteDao.delete(cliente);
	}

	@Transactional(readOnly = true)
	@Override
	public Clientes buscar(Clientes cliente) {
		return clienteDao.findById(cliente.getId()).orElse(null);
	}

	@Transactional(readOnly = true)
	@Override
	public List<Clientes> listar() {
		return (List<Clientes>) clienteDao.findAll();
	}

}
