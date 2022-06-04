package com.webservice.app.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.EqualsAndHashCode;

@Entity
@Data @NoArgsConstructor @EqualsAndHashCode(callSuper = false)
@PrimaryKeyJoinColumn(referencedColumnName= "idNotaPedido", name= "idCurso")
@Table(name= "curso")
public class Curso extends NotaPedido {
	private static final long serialVersionUID = 1L;
	
	@Column(name= "codigo")
	private String codigo;
	
	@Column(name= "dia_semana")
	private int diaSemana;

	@Column(name= "cuatrimestre")
	private String cuatrimestre;
	
	@Column(name= "presencialidad")
	private int presencialidad;
}
