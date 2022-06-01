package com.webservice.app.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "departamento")
@Getter
@Setter
@NoArgsConstructor
public class Departamento {
	@Id
	@Column(name="id_departamento")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idDepartamento;

	@Column(name = "departamento", nullable = false, length = 45)
	private String departamento;

	public Departamento(int idDepartamento, String departamento) {
		super();
		this.idDepartamento = idDepartamento;
		this.departamento = departamento;
	}

	public Departamento(String departamento) {
		super();
		this.departamento = departamento;
	}

}
