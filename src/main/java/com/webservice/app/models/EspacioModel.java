package com.webservice.app.models;

import java.time.LocalDate;
import java.util.Objects;

import com.webservice.app.entities.Aula;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter @NoArgsConstructor
public class EspacioModel {
	
	private int idEspacio;
	private LocalDate fecha;
	private char turno;
	private Aula aula;
	private boolean libre;

	
	public EspacioModel(int idEspacio, LocalDate fecha, char turno, Aula aula, boolean libre) {
		this.idEspacio = idEspacio;
		this.fecha = fecha;
		this.turno = turno;
		this.aula = aula;
		this.libre = libre;
	}
	
	public EspacioModel(LocalDate fecha, char turno, Aula aula, boolean libre) {
		this.fecha = fecha;
		this.turno = turno;
		this.aula = aula;
		this.libre = libre;
	}
	
	
	

	
}
