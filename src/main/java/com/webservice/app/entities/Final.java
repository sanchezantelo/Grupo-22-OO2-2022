package com.webservice.app.entities;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter @Setter @NoArgsConstructor
@PrimaryKeyJoinColumn(referencedColumnName= "idNotaPedido", name= "idFinal")
@Table(name= "final")
public class Final extends NotaPedido {
	private static final long serialVersionUID = 1L;
	
	@Column(name= "mesa")
	private int mesa;
	
	@Column(name= "fecha_examen")
	private LocalDate fechaExamen;
}
