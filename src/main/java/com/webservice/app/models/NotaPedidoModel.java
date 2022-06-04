package com.webservice.app.models;

import java.time.LocalDate;
import java.util.Set;

import org.springframework.format.annotation.DateTimeFormat;

import com.webservice.app.entities.Aula;
import com.webservice.app.entities.Materia;
import com.webservice.app.entities.Usuario;

import lombok.NoArgsConstructor;
import lombok.Data;

@Data @NoArgsConstructor
public abstract class NotaPedidoModel {
	protected int id;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	protected LocalDate fecha;
	protected char turno;
	protected int cantEstudiantes;
	protected Set<Usuario> docentes;
	protected Materia materia;
	protected String observaciones;
	protected String tipoAula;
	protected Aula aulaAsignada;
	protected Usuario solicitante;

	public NotaPedidoModel(int id, LocalDate fecha, char turno, int cantEstudiantes, Set<Usuario> docentes, Materia materia, String observaciones,
			String tipoAula, Aula aulaAsignada, Usuario solicitante) {
		super();
		this.id = id;
		this.fecha = fecha;
		this.turno = turno;
		this.cantEstudiantes = cantEstudiantes;
		this.docentes = docentes;
		this.materia = materia;
		this.observaciones = observaciones;
		this.tipoAula = tipoAula;
		this.aulaAsignada = aulaAsignada;
		this.solicitante = solicitante;
	}

	public NotaPedidoModel(LocalDate fecha, char turno, int cantEstudiantes, Set<Usuario> docentes, Materia materia, String observaciones,
			String tipoAula, Aula aulaAsignada, Usuario solicitante) {
		super();
		this.fecha = fecha;
		this.turno = turno;
		this.cantEstudiantes = cantEstudiantes;
		this.docentes = docentes;
		this.materia = materia;
		this.observaciones = observaciones;
		this.tipoAula = tipoAula;
		this.aulaAsignada = aulaAsignada;
		this.solicitante = solicitante;
	}

}
