package com.webservice.app.entities;

import java.time.LocalDate;

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



import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "espacio")
@Data @NoArgsConstructor
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
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "idNotaPedido")
	private NotaPedido notaPedido;
	
	@Column(name="activo")
	@NotNull
	private boolean activo;

	
	public Espacio(int idEspacio,LocalDate fecha, char turno, Aula aula, boolean libre,boolean activo ) {
		this.idEspacio=idEspacio;
		this.fecha = fecha;
		this.turno = turno;
		this.aula = aula;
		this.libre = libre;
		this.activo=activo;
	}
	
	public Espacio(LocalDate fecha, char turno, Aula aula, boolean libre,boolean activo ) {
		this.fecha = fecha;
		this.turno = turno;
		this.aula = aula;
		this.libre = libre;
		this.activo=activo;
	}
	

	
	
	
	
	
	
	
}