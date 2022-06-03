package com.webservice.app.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data @NoArgsConstructor @AllArgsConstructor
public class UsuarioRolModel {
	private int id;
	private String rol;
	private boolean enabled;
}
