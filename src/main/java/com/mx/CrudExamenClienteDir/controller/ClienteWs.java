package com.mx.CrudExamenClienteDir.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mx.CrudExamenClienteDir.model.Clientes;
import com.mx.CrudExamenClienteDir.service.ImplementacionSerCliente;
import com.mx.CrudExamenClienteDir.service.ImplementacionSerDireccion;

@RestController
@RequestMapping("ClienteWs")
@CrossOrigin
public class ClienteWs {
	@Autowired
	ImplementacionSerCliente impCliente;
	@Autowired
	ImplementacionSerDireccion impDir;
	
	@GetMapping("listar")
	public List<Clientes> listar(){
		return impCliente.listar();
	}
	
	@PostMapping("guardar")
	public ResponseEntity<List<String>> guardar(@RequestBody Clientes cliente){
		ResponseEntity<List<String>> response = null;
		List<String> lista = validar(cliente);

		boolean validacion = true;
		validacion = lista.size()>0 ? false : true;

		if(validacion){
			impCliente.guardar(cliente);
			lista.add("Registro guardado exitosamente.");
		}
		
		response = new ResponseEntity<List<String>>(lista,HttpStatus.OK);
		return response;
	}
	
	@PostMapping("editar")
	public ResponseEntity<String> editar(@RequestBody Clientes cliente){
		impCliente.editar(cliente);
		return new ResponseEntity<String>("Se modificó un registro.",HttpStatus.OK);
	}
	
	@PostMapping("eliminar")
	public ResponseEntity<String> eliminar(@RequestBody Clientes cliente){
		impCliente.eliminar(cliente);
		return new ResponseEntity<String>("Se eliminó un registro.",HttpStatus.OK);
	}
	
	@PostMapping("buscar")
	public Clientes buscar(@RequestBody Clientes cliente){
		return impCliente.buscar(cliente);
	}
	
	private List<String> validar(Clientes cliente) {
		List<String> lMensajes = new ArrayList<>();
		
		int id = impCliente.buscar(cliente) != null ? impCliente.buscar(cliente).getId() : 0;
		int noCliente = impCliente.buscar(cliente) != null ? impCliente.buscar(cliente).getNum_cliente() : 0;
		int idDir = impDir.buscar(cliente.getDireccion()) != null ? impDir.buscar(cliente.getDireccion()).getId() : 0;
				
		if (cliente.getId() == id) {
			lMensajes.add("El registro con identificador "+cliente.getId()+" ya existe en el sistema.");
		}
		if (cliente.getNum_cliente() == noCliente) {
			lMensajes.add("El registro con núm. de cliente "+cliente.getNum_cliente()+" ya existe en el sistema.");
		}
		if (idDir == 0) {
			lMensajes.add("La dirección que intenta asignar al cliente no existe en el sistema.");
		}
		
		return lMensajes;
	}
}
