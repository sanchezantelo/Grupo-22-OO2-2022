package com.webservice.app.models;

import java.time.LocalDate;

import com.webservice.app.entities.Aula;
import com.webservice.app.entities.NotaPedido;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data @NoArgsConstructor
public class EspacioModel {
	
	private int idEspacio;
	private LocalDate fecha;
	private char turno;
	private Aula aula;
	private boolean libre;
	private NotaPedido notaPedido;
	private boolean activo;

	
	public EspacioModel(int idEspacio, LocalDate fecha, char turno, Aula aula, boolean libre, boolean activo) {
		this.idEspacio = idEspacio;
		this.fecha = fecha;
		this.turno = turno;
		this.aula = aula;
		this.libre = libre;
		this.activo=activo;
	}
	
	public EspacioModel(LocalDate fecha, char turno, Aula aula, boolean libre, boolean activo) {
		this.fecha = fecha;
		this.turno = turno;
		this.aula = aula;
		this.libre = libre;
		this.activo=activo;
	}
	
	

	
}