package com.webservice.app.models;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data @NoArgsConstructor @EqualsAndHashCode(callSuper=false)
public class CursoModel extends NotaPedidoModel {
	protected int codigo;
	protected int diaSemana;
	protected String cuatrimestre;
	protected int presencialidad;

	public String getNombre() {
		String turnoPalabra = "";
		switch(this.turno) {
		case 'M':
			turnoPalabra = "Mañana";
		case 'T':
			turnoPalabra = "Tarde";
		case 'N':
			turnoPalabra = "Noche";
		default:
			turnoPalabra = "";
		}
		return String.format("%s %s Turno %s", this.codigo, this.materia.getMateria(), turnoPalabra);
	}
}