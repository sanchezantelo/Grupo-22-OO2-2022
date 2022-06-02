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

import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "materia")
@Data @NoArgsConstructor
public class Materia {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idMateria;

	@Column(name = "codigo", nullable = false, length = 45)
	private String codigo;

	@Column(name = "materia", nullable = false, length = 45)
	private String materia;

	@ManyToOne(cascade = CascadeType.PERSIST)
	@JoinColumn(name = "id_carrera")
	private Carrera carrera;

	public Materia(int idMateria, String codigo, String materia, Carrera carrera) {
		super();
		this.idMateria = idMateria;
		this.codigo = codigo;
		this.materia = materia;
		this.carrera = carrera;
	}

	public Materia(String codigo, String materia, Carrera carrera) {
		super();
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
