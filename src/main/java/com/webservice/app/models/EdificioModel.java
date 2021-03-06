package com.webservice.app.models;

import java.util.Set;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data @NoArgsConstructor
public class EdificioModel {

	private int idEdificio;
	private String edificio;
	private Set<AulaModel> aulas;

	public EdificioModel(int idEdificio, String edificio) {
		this.idEdificio = idEdificio;
		this.edificio = edificio;
	}

	public EdificioModel(String edificio) {
		this.edificio = edificio;
	}

	public EdificioModel(int idEdificio, String edificio, Set<AulaModel> aulas) {
		super();
		this.idEdificio = idEdificio;
		this.edificio = edificio;
		this.aulas = aulas;
	}
}
