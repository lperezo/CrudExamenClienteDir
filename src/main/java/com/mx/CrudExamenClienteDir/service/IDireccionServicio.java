package com.mx.CrudExamenClienteDir.service;

import java.util.List;

import com.mx.CrudExamenClienteDir.model.Direcciones;

public interface IDireccionServicio {
	public void guardar(Direcciones direccion);
	public void editar(Direcciones direccion);
	public void eliminar(Direcciones direccion);
	public Direcciones buscar(Direcciones direccion);
	public List<Direcciones> listar();
}
