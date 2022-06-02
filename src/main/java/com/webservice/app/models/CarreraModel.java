package com.webservice.app.models;

import com.webservice.app.entities.Departamento;

import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
public class CarreraModel {
	private int idCarrera;
	private String carrera;
	private Departamento departamento;

	public CarreraModel(int idCarrera, String carrera, Departamento departamento) {
		super();
		this.idCarrera = idCarrera;
		this.carrera = carrera;
		this.departamento = departamento;
	}

	public CarreraModel(String carrera, Departamento departamento) {
		super();
		this.carrera = carrera;
		this.departamento = departamento;
	}
}
