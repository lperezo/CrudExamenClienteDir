package com.mx.CrudExamenClienteDir.service;

import java.util.List;

import com.mx.CrudExamenClienteDir.model.Clientes;


public interface IClienteServicio {
	public void guardar(Clientes cliente);
	public void editar(Clientes cliente);
	public void eliminar(Clientes cliente);
	public Clientes buscar(Clientes cliente);
	public List<Clientes> listar();
}
