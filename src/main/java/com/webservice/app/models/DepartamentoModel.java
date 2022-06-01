package com.webservice.app.models;

public class DepartamentoModel {
	private int idDepartamento;
	private String departamento;

	public DepartamentoModel(int idDepartamento, String departamento) {
		super();
		this.idDepartamento = idDepartamento;
		this.departamento = departamento;
	}

	public DepartamentoModel(String departamento) {
		super();
		this.departamento = departamento;
	}

}
