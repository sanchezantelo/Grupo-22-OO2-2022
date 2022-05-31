package com.webservice.app.models;

import com.webservice.app.entities.Edificio;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter @NoArgsConstructor
public class LaboratorioModel extends AulaModel{

	private int cantSillas;
	private int cantPC;
	
	
	public LaboratorioModel(int numero, Edificio edificio,int cantSillas, int cantPC) {
		super(numero, edificio);
		this.cantSillas = cantSillas;
		this.cantPC = cantPC;
	}
	
	

	public LaboratorioModel(int idAula, int numero, Edificio edificio,int cantSillas, int cantPC) {
		super(idAula, numero, edificio);
		this.cantSillas = cantSillas;
		this.cantPC = cantPC;	
	}
	
}
