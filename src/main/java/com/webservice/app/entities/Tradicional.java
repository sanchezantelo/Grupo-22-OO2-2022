package com.webservice.app.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import lombok.NoArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Entity
@Table(name = "tradicional")
@PrimaryKeyJoinColumn(name = "id_tradicional", referencedColumnName = "idAula")
@Data @NoArgsConstructor @EqualsAndHashCode(callSuper = false)
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

	public Tradicional(int idAula, int numero, Edificio edificio, @NotNull int cantBancos, @NotNull String pizarron,
			@NotNull boolean tieneProyector) {
		super(idAula, numero, edificio);
		this.cantBancos = cantBancos;
		this.pizarron = pizarron;
		this.tieneProyector = tieneProyector;
	}
}
