package com.webservice.app.models;

import java.time.LocalDate;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data @NoArgsConstructor @EqualsAndHashCode(callSuper=false)
public class CursoModel extends NotaPedidoModel {
	protected int codigo;
	protected char turno;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	protected LocalDate fechaInicio;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	protected LocalDate fechaFin;
	protected String cuatrimestre;
	protected int presencialidad;
}