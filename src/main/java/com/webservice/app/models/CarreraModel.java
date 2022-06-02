package com.webservice.app.models;

import com.webservice.app.entities.Departamento;

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

	@Override
	public String toString() {
		return "CarreraModel [idCarrera=" + idCarrera + ", carrera=" + carrera + ", departamento=" + departamento + "]";
	}

}
