package com.webservice.app.models;

import com.webservice.app.entities.Departamento;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data @NoArgsConstructor
public class CarreraModel {
	private int idCarrera;
	private String carrera;
	private Departamento departamento;

	public CarreraModel(String carrera, Departamento departamento) {
		super();
		this.carrera = carrera;
		this.departamento = departamento;
	}
}
