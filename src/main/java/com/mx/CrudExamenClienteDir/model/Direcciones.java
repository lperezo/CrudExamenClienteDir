package com.mx.CrudExamenClienteDir.model;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Table(name="DIRECCIONES")
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Data // encapsulamiento
public class Direcciones {
	// Mapeo 
	@Id
	private int id;
	private String calle;
	private Integer num_ext;
	private Integer num_int;
	
	// Cardinalidad
	@OneToMany(mappedBy = "direccion", cascade = CascadeType.ALL)
	@JsonIgnore // se ignora la propiedad del json del objeto completo
	List<Clientes> lista = new ArrayList<>();
}
