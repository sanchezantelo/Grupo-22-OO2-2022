package com.webservice.app.models;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter @NoArgsConstructor
public class EdificioModel {
		
		private int idEdificio;
		private String edificio;
		
		
		public EdificioModel(int idEdificio, String edificio) {
			this.idEdificio = idEdificio;
			this.edificio = edificio;
		}
		
		public EdificioModel(String edificio) {
			this.edificio = edificio;
		}

		
		
		
	
}
