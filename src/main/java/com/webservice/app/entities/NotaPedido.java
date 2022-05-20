package com.webservice.app.entities;

import java.io.Serializable;
import java.time.LocalDate;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Inheritance(strategy= InheritanceType.JOINED)
@Data @NoArgsConstructor // Getter, Setter, toString, equals, hash, constructor
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
	
	/* TODO: Tabla Intermedia 
	@
	private Set<Usuario> docentes;
	*/
	
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
	
	/* TODO: JoinColumn idEspacio o idAula
	@
	private Aula aulaAsignada;
	*/
	
	@OneToOne(cascade= CascadeType.PERSIST)
	@JoinColumn(name= "idUsuario")
	private Usuario solicitante;
}
