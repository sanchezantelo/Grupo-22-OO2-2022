package com.webservice.app.models;

import java.time.LocalDate;
import java.util.Set;

import org.springframework.format.annotation.DateTimeFormat;

import com.webservice.app.entities.Aula;
import com.webservice.app.entities.Usuario;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CursoModel extends NotaPedidoModel {
	protected int codigo;
	protected char turno;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	protected LocalDate fechaInicio;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	protected LocalDate fechaFin;
	protected String cuatrimestre;
	protected String presencialidad;

	public CursoModel(int id, LocalDate fecha, int cantEstudiantes, Set<Usuario> docentes, String observaciones,
			String tipoAula, boolean asignada, Aula aulaAsignada, Usuario solicitante, int codigo, char turno,
			LocalDate fechaInicio, LocalDate fechaFin, String cuatrimestre, String presencialidad) {
		super(id, fecha, cantEstudiantes, docentes, observaciones, tipoAula, asignada, aulaAsignada, solicitante);
		this.codigo = codigo;
		this.turno = turno;
		this.fechaInicio = fechaInicio;
		this.fechaFin = fechaFin;
		this.cuatrimestre = cuatrimestre;
		this.presencialidad = presencialidad;
	}

}