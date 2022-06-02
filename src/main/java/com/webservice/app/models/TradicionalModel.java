package com.webservice.app.models;

import com.webservice.app.entities.Edificio;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class TradicionalModel extends AulaModel {

	private int cantBancos;
	private String pizarron;
	private boolean tieneProyector;

	public TradicionalModel(int numero, Edificio edificio, int cantBancos, String pizarron, boolean tieneProyector) {
		super(numero, edificio);
		this.cantBancos = cantBancos;
		this.pizarron = pizarron;
		this.tieneProyector = tieneProyector;
	}

	public TradicionalModel(int idAula, int numero, Edificio edificio, int cantBancos, String pizarron,
			boolean tieneProyector) {
		super(idAula, numero, edificio);
		this.cantBancos = cantBancos;
		this.pizarron = pizarron;
		this.tieneProyector = tieneProyector;
	}

	@Override
	public String toString() {
		return "TradicionalModel [cantBancos=" + cantBancos + ", pizarron=" + pizarron + ", tieneProyector="
				+ tieneProyector + "]";
	}

}
