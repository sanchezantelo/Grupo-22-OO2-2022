package com.webservice.app.models;

import java.time.LocalDate;
import java.util.Set;

import org.springframework.format.annotation.DateTimeFormat;

import com.webservice.app.entities.Usuario;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter @NoArgsConstructor
public class FinalModel extends NotaPedidoModel {
	protected int mesa;
	@DateTimeFormat(pattern= "yyyy-MM-dd")
	protected LocalDate fechaExamen;
	
	public FinalModel(int id, LocalDate fecha, int cantEstudiantes, 
			Set<Usuario> docentes, String observaciones, String tipoAula,
			boolean asignada, Usuario solicitante, int mesa, LocalDate fechaExamen) {
		super(id, fecha, cantEstudiantes, docentes, observaciones, tipoAula, asignada, solicitante);
		this.mesa = mesa;
		this.fechaExamen = fechaExamen;
	}
}