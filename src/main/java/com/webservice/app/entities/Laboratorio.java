package com.webservice.app.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="laboratorio")
@PrimaryKeyJoinColumn(referencedColumnName = "id_aula")
@Getter @Setter @NoArgsConstructor
public class Laboratorio extends Aula{
				
		@Column(name="cant_sillas")
		@NotNull
		private int cantSillas;
		
		@Column(name="cant_pc")
		@NotNull
		private int cantPC;
		
		
		public Laboratorio(int idAula,int numero, Edificio edificio, int cantSillas, int cantPC) {
			super(idAula,numero, edificio);
			this.cantSillas = cantSillas;
			this.cantPC = cantPC;
		}

		public Laboratorio(int numero, Edificio edificio, int cantSillas, int cantPC) {
			super(numero, edificio);
			this.cantSillas = cantSillas;
			this.cantPC = cantPC;
		}
}