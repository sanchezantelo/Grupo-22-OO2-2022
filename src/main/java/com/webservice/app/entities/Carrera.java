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
@Data @NoArgsConstructor
@Table(name = "carrera")
public class Carrera {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idCarrera;

	@Column(name = "carrera", nullable = false, length = 45)
	private String carrera;

	@ManyToOne(cascade = CascadeType.PERSIST)
	@JoinColumn(name = "idDepartamento")
	private Departamento departamento;

	public Carrera(int idCarrera, String carrera, Departamento departamento) {
		super();
		this.idCarrera = idCarrera;
		this.carrera = carrera;
		this.departamento = departamento;
	}

	public Carrera(String carrera, Departamento departamento) {
		super();
		this.carrera = carrera;
		this.departamento = departamento;
	}

}
