package com.webservice.app.models;

import com.webservice.app.entities.Carrera;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter @NoArgsConstructor
public class MateriaModel {
	private int idMateria;
	private int codigo;
	private String materia;
	private Carrera carrera;
	
	public MateriaModel(int idMateria, int codigo, String materia, Carrera carrera) {
		super();
		this.idMateria = idMateria;
		this.codigo = codigo;
		this.materia = materia;
		this.carrera = carrera;
	}

	public MateriaModel(int codigo, String materia, Carrera carrera) {
		super();
		this.codigo = codigo;
		this.materia = materia;
		this.carrera = carrera;
	}
	
	
	
	

}
