package com.webservice.app.models;

import com.webservice.app.entities.Carrera;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@Data
public class MateriaModel {
	private int idMateria;
	private String codigo;
	private String materia;
	private Carrera carrera;

	public MateriaModel(int idMateria, String codigo, String materia, Carrera carrera) {
		super();
		this.idMateria = idMateria;
		this.codigo = codigo;
		this.materia = materia;
		this.carrera = carrera;
	}

	public MateriaModel(String codigo, String materia, Carrera carrera) {
		super();
		this.codigo = codigo;
		this.materia = materia;
		this.carrera = carrera;
	}
}
