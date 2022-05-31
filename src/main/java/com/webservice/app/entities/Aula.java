package com.webservice.app.entities;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;


@Entity
@Table(name = "aula")
@Inheritance(strategy = InheritanceType.JOINED)
@Getter @Setter @NoArgsConstructor
public abstract class Aula {
	
	@Id
	@Column(name="id_aula")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idAula;
	
	@Column(name="numero")
	@NotNull
	private int numero;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "idEdificio")
	private Edificio edificio;
	
	
	public Aula(int idAula,int numero, Edificio edificio) {
		this.idAula=idAula;
		this.numero = numero;
		this.edificio = edificio;
	}
	
	public Aula(int numero, Edificio edificio) {
		this.numero = numero;
		this.edificio = edificio;
	}
	
}