package com.webservice.app.entities;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

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

import org.springframework.format.annotation.DateTimeFormat;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter @Setter @NoArgsConstructor @AllArgsConstructor
@Inheritance(strategy= InheritanceType.JOINED)
@Table(name="nota_pedido")
public abstract class NotaPedido implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	private int idNotaPedido;
	
	@DateTimeFormat(pattern= "yyyy-MM-dd")
	@Column(name= "fecha")
	private LocalDate fecha;
	
	@Column(name= "cantidad_estudiantes")
	@NotEmpty()
	private int cantEstudiantes;
	
	@ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinColumn(name = "usuario_id", nullable = true)
	private Usuario docentes;
	
	/*
	@ManyToOne(cascade= CascadeType.PERSIST)
	@JoinColumn(name= "idMateria")
	private Materia materia;
	*/
	
	@Column(name= "observaciones")
	private String observaciones;
	
	@Column(name= "tipo_aula")
	private String tipoAula;
	
	@Column(name= "asignada", nullable = false)
	private boolean asignada;
	
	@ManyToOne
	@JoinColumn(name="id_aula")
	private Aula aulaAsignada;
	
	@OneToOne(cascade= CascadeType.PERSIST)
	@JoinColumn(name= "idUsuario")
	private Usuario solicitante;
}
