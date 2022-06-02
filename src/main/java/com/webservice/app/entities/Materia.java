package com.webservice.app.entities;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
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
@Table(name = "materia")
@Getter
@Setter
@NoArgsConstructor

public class Materia {

	@Id
	@Column(name="id_materia")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idMateria;

	@Column(name = "codigo", nullable = false, length = 45)
	@NotNull
	private int codigo;

	@Column(name = "materia", nullable = false, length = 45)
	private String materia;

	@ManyToOne(cascade = CascadeType.PERSIST)
	@JoinColumn(name = "id_carrera")
	private Carrera carrera;

	public Materia(int idMateria, @NotNull int codigo, String materia, Carrera carrera) {
		super();
		this.idMateria = idMateria;
		this.codigo = codigo;
		this.materia = materia;
		this.carrera = carrera;
	}

	public Materia(String materia, Carrera carrera) {
		super();
		this.materia = materia;
		this.carrera = carrera;
	}

}
