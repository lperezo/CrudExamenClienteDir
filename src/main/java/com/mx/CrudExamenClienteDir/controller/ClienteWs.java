package com.mx.CrudExamenClienteDir.controller;

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

@RestController
@RequestMapping("ClienteWs")
@CrossOrigin
public class ClienteWs {
	@Autowired
	ImplementacionSerCliente impCliente;
	
	@GetMapping("listar")
	public List<Clientes> listar(){
		return impCliente.listar();
	}
	
	@PostMapping("guardar")
	public ResponseEntity<List<String>> guardar(@RequestBody Clientes cliente){
		List<String> lRespuesta = impCliente.guardar(cliente);

		return new ResponseEntity<List<String>>(lRespuesta,HttpStatus.OK);
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
	
	
}
