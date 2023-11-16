package com.mx.CrudExamenClienteDir.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mx.CrudExamenClienteDir.dao.IDireccionesDao;
import com.mx.CrudExamenClienteDir.model.Direcciones;

@Service
public class ImplementacionSerDireccion implements IDireccionServicio {
	
	@Autowired
	IDireccionesDao dirDao;

	@Override
	public void guardar(Direcciones direccion) {
		dirDao.save(direccion);
	}

	@Override
	public void editar(Direcciones direccion) {
		dirDao.save(direccion);
	}

	@Override
	public void eliminar(Direcciones direccion) {
		dirDao.delete(direccion);
	}

	@Override
	public Direcciones buscar(Direcciones direccion) {
		return dirDao.findById(direccion.getId()).orElse(null);
	}

	@Override
	public List<Direcciones> listar() {
		return (List<Direcciones>) dirDao.findAll();
	}

}
