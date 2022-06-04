package com.webservice.app.models;

import java.time.LocalDate;
import java.util.Set;

import org.springframework.format.annotation.DateTimeFormat;

import com.webservice.app.entities.Aula;
import com.webservice.app.entities.Materia;
import com.webservice.app.entities.Usuario;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data @NoArgsConstructor @EqualsAndHashCode(callSuper=true)
public class FinalModel extends NotaPedidoModel {
	protected int mesa;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	protected LocalDate fechaExamen;

	public FinalModel(int id, LocalDate fecha, char turno, int cantEstudiantes, Set<Usuario> docentes, Materia materia, String observaciones,
			String tipoAula, Aula aulaAsignada, Usuario solicitante, int mesa,
			LocalDate fechaExamen) {
		super(id, fecha, turno, cantEstudiantes, docentes, materia, observaciones, tipoAula, aulaAsignada, solicitante);
		this.mesa = mesa;
		this.fechaExamen = fechaExamen;
	}
}
