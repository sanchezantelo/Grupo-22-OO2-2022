package com.webservice.app.entities;

import java.io.Serializable;
import java.time.LocalDate;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.Getter;
import lombok.Setter;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

@Entity
@Getter @Setter @NoArgsConstructor @AllArgsConstructor
@Inheritance(strategy= InheritanceType.JOINED)
@Table(name="nota_pedido")
public abstract class NotaPedido implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name="id_nota_pedido")
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	private int idNotaPedido;
	
	@NotNull
	@NotEmpty
	@DateTimeFormat(pattern= "yyyy-MM-dd")
	@Column(name= "fecha")
	private LocalDate fecha;
	
	@Column(name= "cantidad_estudiantes")
	@NotEmpty()
	private int cantEstudiantes;
	
	@ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinColumn(name = "usuario_id", nullable = true)
	private Usuario docentes;
	
	@ManyToOne(fetch = FetchType.LAZY, cascade= CascadeType.PERSIST)
	@JoinColumn(name= "id_materia")
	private Materia materia;
	
	@Column(name= "observaciones")
	private String observaciones;
	
	@Column(name= "tipo_aula")
	private String tipoAula;
	
	@Column(name= "asignada", nullable = false)
	private boolean asignada;
	
	@OneToOne(cascade = CascadeType.PERSIST)
	@JoinColumn(name="id_aula")
	private Aula aulaAsignada;
	
	@OneToOne(cascade= CascadeType.PERSIST)
	@JoinColumn(name= "idUsuario")
	private Usuario solicitante;

	// Constructor sin id
	public NotaPedido(LocalDate fecha, int cantEstudiantes, Usuario docentes, Materia materia, String observaciones, String tipoAula, boolean asignada, Aula aulaAsignada, Usuario solicitante) {
		super();
		this.fecha = fecha;
		this.cantEstudiantes = cantEstudiantes;
		this.docentes = docentes;
		this.materia = materia;
		this.observaciones = observaciones;
		this.tipoAula = tipoAula;
		this.asignada = asignada;
		this.aulaAsignada = aulaAsignada;
		this.solicitante = solicitante;
	}
}
