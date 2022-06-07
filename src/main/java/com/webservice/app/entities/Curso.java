package com.webservice.app.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.EqualsAndHashCode;

@Entity
@Data @NoArgsConstructor @EqualsAndHashCode(callSuper = false)
@PrimaryKeyJoinColumn(referencedColumnName= "idNotaPedido", name= "idCurso")
@Table(name= "curso")
public class Curso extends NotaPedido {
	private static final long serialVersionUID = 1L;
	
	@NotNull
	@Column(name= "codigo")
	private String codigo;
	
	@Min(1) @Max(6)@NotNull
	@Column(name= "dia_semana")
	private int diaSemana;

	@NotNull
	@Column(name= "presencialidad")
	private int presencialidad;
}
