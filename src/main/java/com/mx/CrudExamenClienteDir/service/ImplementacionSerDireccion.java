package com.mx.CrudExamenClienteDir.service;

import java.util.ArrayList;
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
	public List<String> guardar(Direcciones direccion) {
		List<String> lMensajes = validar(direccion);
		if (lMensajes.size() == 0) {
			dirDao.save(direccion);
			lMensajes.add("Registro guardado exitosamente.");
		}
		return lMensajes;
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

	private List<String> validar(Direcciones direccion){
		List<String> lMensajes = new ArrayList<>();
		Direcciones dir = dirDao.findById(direccion.getId()).orElse(null);

		int id = dir != null ? dir.getId() : 0;
		
		if (direccion.getId() == id) {
			lMensajes.add("El registro con identificador "+direccion.getId()+" ya existe en el sistema.");
		}
		return lMensajes;
	}
}
