package com.webservice.app.entities;

import java.io.Serializable;
import java.time.LocalDate;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.springframework.format.annotation.DateTimeFormat;

import com.webservice.app.helpers.Funciones;

import lombok.NoArgsConstructor;
import lombok.Data;

@Entity
@Data @NoArgsConstructor
@Inheritance(strategy= InheritanceType.JOINED)
@Table(name="nota_pedido")
public abstract class NotaPedido implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	private int idNotaPedido;
	
	@NotNull
	@DateTimeFormat(pattern= "yyyy-MM-dd")
	@Column(name= "fecha")
	private LocalDate fecha;

	@Column(name= "turno")
	@Enumerated(value = EnumType.STRING)
	private TipoTurnos turno;
	
	@Column(name= "cantidad_estudiantes")
	private int cantEstudiantes;
	
	@ManyToOne(fetch = FetchType.LAZY, cascade= CascadeType.PERSIST)
	@JoinColumn(name= "idMateria")
	private Materia materia;
	
	@Column(name= "observaciones")
	private String observaciones;
	
	@Column(name= "tipo_aula")
	@Enumerated(value = EnumType.STRING)
	private TipoAula tipoAula;
	
	@ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.PERSIST)
	@JoinColumn(name="idAula")
	private Aula aulaAsignada;
	
	@ManyToOne(fetch = FetchType.LAZY, cascade= CascadeType.PERSIST)
	@JoinColumn(name= "idUsuario")
	private Usuario solicitante;

	// Constructor sin id
	public NotaPedido(LocalDate fecha, TipoTurnos turno, int cantEstudiantes, Materia materia, String observaciones, TipoAula tipoAula, Aula aulaAsignada, Usuario solicitante) {
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
