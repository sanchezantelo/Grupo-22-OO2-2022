package com.webservice.app.models;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data @NoArgsConstructor @EqualsAndHashCode(callSuper=false)
public class CursoModel extends NotaPedidoModel {
	protected int codigo;
	protected int diaSemana;
	protected int presencialidad;

	public String getNombre() {
		return String.format("%s %s Turno %s", this.codigo, this.materia.getMateria(), this.turno);
	}
}