package com.webservice.app.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="tradicional")
@PrimaryKeyJoinColumn(referencedColumnName = "id_aula")
@Getter @Setter @NoArgsConstructor @AllArgsConstructor
public class Tradicional extends Aula {
	
	public Tradicional(int numero, Edificio edificio) {
		super(numero, edificio);
		// TODO Auto-generated constructor stub
	}

	@Column(name="cant_bancos")
	@NotNull
	private int cantBancos;
	
	@Column(name="pizarron")
	@NotNull
	private String pizarron;
	
	@Column(name="tiene_proyector")
	@NotNull
	private boolean tieneProyector;
}
