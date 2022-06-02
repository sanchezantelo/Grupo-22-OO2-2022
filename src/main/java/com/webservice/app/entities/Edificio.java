package com.webservice.app.entities;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;


@Entity
@Table(name = "edificio")
@Data @NoArgsConstructor
public class Edificio {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idEdificio;
	
	@Column(name="edificio")
	@NotNull
	private String edificio;
	
	@OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private Set<Aula> aulas = new HashSet<Aula>();
	
	public Edificio(int idEdificio,String edificio) {
		this.idEdificio=idEdificio;
		this.edificio = edificio;
	}
	
	public Edificio(String edificio) {
		this.edificio = edificio;
	}
	
}
