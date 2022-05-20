package com.webservice.app.models;

import java.time.LocalDate;
import java.util.Set;

import org.springframework.format.annotation.DateTimeFormat;

import com.webservice.app.entities.Usuario;

import lombok.NoArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter @NoArgsConstructor
public abstract class NotaPedidoModel {
	protected int id;
	@DateTimeFormat(pattern="yyyy-MM-dd")
	protected LocalDate fecha;
	protected int cantEstudiantes;
	protected Set<Usuario> docentes;
	//protected Materia materia;
	protected String observaciones;
	protected String tipoAula;
	protected boolean asignada;
	//protected Aula aulaAsignada;
	protected Usuario solicitante;
	
	public NotaPedidoModel(int id, LocalDate fecha, int cantEstudiantes, 
							Set<Usuario> docentes, String observaciones, String tipoAula,
							boolean asignada, Usuario solicitante) {
		this.setId(id);
		this.fecha = fecha;
		this.cantEstudiantes = cantEstudiantes;
		this.docentes = docentes;
		this.observaciones = observaciones;
		this.tipoAula = tipoAula;
		this.asignada = asignada;
		this.solicitante = solicitante;
	}
}
