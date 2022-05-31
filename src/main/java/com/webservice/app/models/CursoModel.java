package com.webservice.app.models;

import java.time.LocalDate;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter @NoArgsConstructor @AllArgsConstructor
public class CursoModel extends NotaPedidoModel {
	protected int codigo;
	protected char turno;
	@DateTimeFormat(pattern= "yyyy-MM-dd")
	protected LocalDate fechaInicio;
	@DateTimeFormat(pattern= "yyyy-MM-dd")
	protected LocalDate fechaFin;
	protected String cuatrimestre;
	protected String presencialidad;
}