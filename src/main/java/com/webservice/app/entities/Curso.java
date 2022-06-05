package com.webservice.app.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;

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
	
	@Min(1) @Max(6)
	@Column(name= "dia_semana")
	private int diaSemana;

	@Column(name= "presencialidad")
	private int presencialidad;
}
