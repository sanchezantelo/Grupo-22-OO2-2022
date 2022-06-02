package com.webservice.app.entities;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

@Entity
@Getter @Setter @NoArgsConstructor @AllArgsConstructor
@PrimaryKeyJoinColumn(referencedColumnName= "id_nota_pedido", name= "id_final")
@Table(name= "final")
public class Final extends NotaPedido {
	private static final long serialVersionUID = 1L;
	
	@Column(name= "mesa")
	private int mesa;
	
	@Column(name= "fecha_examen")
	private LocalDate fechaExamen;
}
