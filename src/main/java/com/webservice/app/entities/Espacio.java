package com.webservice.app.entities;

import java.time.LocalDate;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "espacio")
@Getter @Setter @NoArgsConstructor
public class Espacio {
	
	@Id
	@Column(name="idEspacio")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idEspacio;
	
	@Column(name="fecha")
	@NotNull
	private LocalDate fecha;
	
	@Column(name="turno")
	@NotNull
	private char turno;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "idAula")
	private Aula aula;
	
	@Column(name="libre")
	@NotNull
	private boolean libre;
	
	/*@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "idNotaPedido")
	private NotaPedido notaPedido;*/
	
	public Espacio(int idEspacio,LocalDate fecha, char turno, Aula aula, boolean libre /*, NotaPedido notaPedido*/) {
		this.idEspacio=idEspacio;
		this.fecha = fecha;
		this.turno = turno;
		this.aula = aula;
		this.libre = libre;
		//this.notaPedido = notaPedido;
	}
	
	public Espacio(LocalDate fecha, char turno, Aula aula, boolean libre /*, NotaPedido notaPedido*/) {
		this.fecha = fecha;
		this.turno = turno;
		this.aula = aula;
		this.libre = libre;
		//this.notaPedido = notaPedido;
	}
	

	
	
	
	
	
	
	
}
