package com.webservice.app.entities;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter @Setter @NoArgsConstructor @AllArgsConstructor
@PrimaryKeyJoinColumn(referencedColumnName= "idNotaPedido", name= "idCurso")
@Table(name= "curso")
public class Curso extends NotaPedido {
	private static final long serialVersionUID = 1L;
	
	@Column(name= "codigo")
	private String codigo;
	
	@Column(name= "turno")
	@NotEmpty()
	private char turno;
	
	@DateTimeFormat(pattern= "yyyy-MM-dd")
	@Column(name= "fecha_inicio")
	private LocalDate fechaInicio;
	
	@DateTimeFormat(pattern= "yyyy-MM-dd")
	@Column(name= "fecha_fin")
	private LocalDate fechaFin;
	
	@Column(name= "cuatrimestre")
	private String cuatrimestre;
	
	@Column(name= "presencialidad")
	private String presencialidad;
}
