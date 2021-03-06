package com.webservice.app.models;

import java.time.LocalDate;

import org.springframework.format.annotation.DateTimeFormat;

import com.webservice.app.entities.Aula;
import com.webservice.app.entities.Materia;
import com.webservice.app.entities.TipoAula;
import com.webservice.app.entities.TipoTurnos;
import com.webservice.app.entities.Usuario;

import lombok.NoArgsConstructor;
import lombok.Data;

@Data @NoArgsConstructor
public abstract class NotaPedidoModel {
	protected int idNotaPedido;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	protected LocalDate fecha;
	protected TipoTurnos turno;
	protected int cantEstudiantes;
	protected Materia materia;
	protected String observaciones;
	protected TipoAula tipoAula;
	protected Aula aulaAsignada;
	protected Usuario solicitante;

	public NotaPedidoModel(int id, LocalDate fecha, TipoTurnos turno, int cantEstudiantes, Materia materia, String observaciones,
			TipoAula tipoAula, Aula aulaAsignada, Usuario solicitante) {
		super();
		this.idNotaPedido = id;
		this.fecha = fecha;
		this.turno = turno;
		this.cantEstudiantes = cantEstudiantes;
		this.materia = materia;
		this.observaciones = observaciones;
		this.tipoAula = tipoAula;
		this.aulaAsignada = aulaAsignada;
		this.solicitante = solicitante;
	}

	public NotaPedidoModel(LocalDate fecha, TipoTurnos turno, int cantEstudiantes, Materia materia, String observaciones,
			TipoAula tipoAula, Aula aulaAsignada, Usuario solicitante) {
		super();
		this.fecha = fecha;
		this.turno = turno;
		this.cantEstudiantes = cantEstudiantes;
		this.materia = materia;
		this.observaciones = observaciones;
		this.tipoAula = tipoAula;
		this.aulaAsignada = aulaAsignada;
		this.solicitante = solicitante;
	}

}
