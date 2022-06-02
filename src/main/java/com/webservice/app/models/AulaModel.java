package com.webservice.app.models;

import com.webservice.app.entities.Edificio;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class AulaModel {

	private int idAula;
	private int numero;
	private Edificio edificio;

	public AulaModel(int idAula, int numero, Edificio edificio) {
		this.idAula = idAula;
		this.numero = numero;
		this.edificio = edificio;
	}

	public AulaModel(int numero, Edificio edificio) {
		this.numero = numero;
		this.edificio = edificio;
	}

	@Override
	public String toString() {
		return "AulaModel [idAula=" + idAula + ", numero=" + numero + ", edificio=" + edificio + "]";
	}

}
