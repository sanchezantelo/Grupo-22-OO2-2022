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
}