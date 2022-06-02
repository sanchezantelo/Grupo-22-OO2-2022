package com.webservice.app.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import lombok.Getter;
import lombok.Setter;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

@Entity
@Table(name = "tradicional")
@PrimaryKeyJoinColumn(referencedColumnName = "id_aula")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
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
}
