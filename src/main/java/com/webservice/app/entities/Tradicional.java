package com.webservice.app.entities;

import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="tradicional")
@PrimaryKeyJoinColumn(referencedColumnName = "id_aula")
@Getter @Setter @NoArgsConstructor
public class Tradicional extends Aula {
	
	@Column(name="cant_bancos")
	@NotNull
	private int cantBancos;
	
	@Column(name="pizarron")
	@NotNull
	private String pizarron;
	
	@Column(name="tiene_proyector")
	@NotNull
	private boolean tieneProyector;
	
	public Tradicional(int idAula,int numero, Edificio edificio,int cantBancos, String pizarron, boolean tieneProyector) {
		super(idAula,numero, edificio);
		this.cantBancos = cantBancos;
		this.pizarron = pizarron;
		this.tieneProyector = tieneProyector;
	}
	
	public Tradicional(int numero, Edificio edificio,int cantBancos, String pizarron, boolean tieneProyector) {
		super(numero, edificio);
		this.cantBancos = cantBancos;
		this.pizarron = pizarron;
		this.tieneProyector = tieneProyector;
	}

	
	


	
	
}
