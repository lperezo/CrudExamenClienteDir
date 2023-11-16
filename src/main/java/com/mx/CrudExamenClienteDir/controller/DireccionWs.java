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

import com.mx.CrudExamenClienteDir.model.Direcciones;
import com.mx.CrudExamenClienteDir.service.ImplementacionSerDireccion;

@RestController
@RequestMapping("DireccionWs")
@CrossOrigin
public class DireccionWs {
	@Autowired
	ImplementacionSerDireccion impDireccion;
	
	@GetMapping("listar")
	public List<Direcciones> listar(){
		return impDireccion.listar();
	}
	
	@PostMapping("guardar")
	public ResponseEntity<List<String>> guardar(@RequestBody Direcciones direccion){
		ResponseEntity<List<String>> response = null;
		List<String> lista = validar(direccion);

		boolean validacion = true;
		validacion = lista.size()>0 ? false : true;

		if (validacion) {
			impDireccion.guardar(direccion);
			lista.add("Registro guardado exitosamente.");
		}
		
		response = new ResponseEntity<List<String>>(lista,HttpStatus.OK);
		return response;
	}
	
	@PostMapping("editar")
	public ResponseEntity<String> editar(@RequestBody Direcciones direccion){
		impDireccion.editar(direccion);
		return new ResponseEntity<String>("Se modificó un registro.",HttpStatus.OK);
	}
	
	@PostMapping("eliminar")
	public ResponseEntity<String> eliminar(@RequestBody Direcciones direccion){
		impDireccion.eliminar(direccion);
		return new ResponseEntity<String>("Se eliminó un registro.",HttpStatus.OK);
	}
	
	@PostMapping("buscar")
	public Direcciones buscar(@RequestBody Direcciones direccion){
		return impDireccion.buscar(direccion);
	}
	
	private List<String> validar(Direcciones direccion){
		List<String> lMensajes = new ArrayList<>();
		
		int id = impDireccion.buscar(direccion) != null ? impDireccion.buscar(direccion).getId() : 0;
		
		if (direccion.getId() == id) {
			lMensajes.add("El registro con identificador "+direccion.getId()+" ya existe en el sistema.");
		}
		return lMensajes;
	}
}
