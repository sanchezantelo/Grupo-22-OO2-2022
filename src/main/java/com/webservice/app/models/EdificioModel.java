package com.webservice.app.models;

import java.util.Set;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
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

	@Override
	public String toString() {
		return "EdificioModel [idEdificio=" + idEdificio + ", edificio=" + edificio + ", aulas=" + aulas + "]";
	}

}
