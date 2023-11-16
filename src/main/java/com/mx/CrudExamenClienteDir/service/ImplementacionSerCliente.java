package com.mx.CrudExamenClienteDir.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mx.CrudExamenClienteDir.dao.IClienteDao;
import com.mx.CrudExamenClienteDir.dao.IDireccionesDao;
import com.mx.CrudExamenClienteDir.model.Clientes;
import com.mx.CrudExamenClienteDir.model.Direcciones;

@Service
public class ImplementacionSerCliente implements IClienteServicio {

	@Autowired
	IClienteDao clienteDao;
	@Autowired
	IDireccionesDao direccionDao;
	
	@Transactional
	@Override
	public List<String> guardar(Clientes cliente) {
		List<String> lValidaciones = validar(cliente);
		if (lValidaciones.size() == 0) {
			clienteDao.save(cliente);
			lValidaciones.add("Registro guardado exitosamente.");
		}
		
		return lValidaciones;
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
	
	private List<String> validar(Clientes cliente) {
		List<String> lMensajes = new ArrayList<>();
		
		Direcciones dir = direccionDao.findById(cliente.getDireccion().getId()).orElse(null);
		
		int idDir = dir != null ? dir.getId() : 0;
				
		for (Clientes c : clienteDao.findAll()) {
			if (cliente.getId() == c.getId()) {
				lMensajes.add("El registro con identificador "+cliente.getId()+" ya existe en el sistema.");
			}
			if (cliente.getNum_cliente() == c.getNum_cliente()) {
				lMensajes.add("El registro con núm. de cliente "+cliente.getNum_cliente()+" ya existe en el sistema.");
			}
		}
		if (idDir == 0) {
			lMensajes.add("La dirección que intenta asignar al cliente no existe en el sistema.");
		}
		
		return lMensajes;
	}
}
