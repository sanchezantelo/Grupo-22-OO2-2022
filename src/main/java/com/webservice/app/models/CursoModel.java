package com.webservice.app.models;

import com.webservice.app.helpers.StringHelper;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data @NoArgsConstructor @EqualsAndHashCode(callSuper=false)
public class CursoModel extends NotaPedidoModel {
	protected int codigo;
	protected int diaSemana;
	protected int presencialidad;

	public String getNombre() {
		String turnoPalabra = StringHelper.getTurnoPalabra(this.turno);
		return String.format("%s %s Turno %s", this.codigo, this.materia.getMateria(), turnoPalabra);
	}
}