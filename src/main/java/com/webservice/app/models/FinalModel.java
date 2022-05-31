package com.webservice.app.models;

import java.time.LocalDate;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter @NoArgsConstructor @AllArgsConstructor
public class FinalModel extends NotaPedidoModel {
	protected int mesa;
	@DateTimeFormat(pattern= "yyyy-MM-dd")
	protected LocalDate fechaExamen;
}
