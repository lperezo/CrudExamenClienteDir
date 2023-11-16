package com.mx.CrudExamenClienteDir.model;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Table(name="CLIENTE")
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Data
public class Clientes {
	@Id
	private int id;
	private int num_cliente;
	private String nombre;
	private String app;
	private String apm;
	private long celular;
	private String correo;
	private int estatus;
	
	//Cardinalidad
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "ID_DIRECCION")
	Direcciones direccion;
}
