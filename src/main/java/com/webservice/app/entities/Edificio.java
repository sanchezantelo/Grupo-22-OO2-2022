package com.webservice.app.entities;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


@Entity
@Table(name = "edificio")
@Getter @Setter @NoArgsConstructor
public class Edificio {
	
	@Id
	@Column(name="idEdificio")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idEdificio;
	
	@Column(name="edificio")
	@NotNull
	private String edificio;
	
	public Edificio(int idEdificio,String edificio) {
		this.idEdificio=idEdificio;
		this.edificio = edificio;
	}
	
	public Edificio(String edificio) {
		this.edificio = edificio;
	}
	
}
