package com.webservice.app.models;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.webservice.app.entities.TipoDocumento;
import com.webservice.app.entities.UsuarioRol;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import com.webservice.app.helpers.StringHelper;

@Data @NoArgsConstructor @AllArgsConstructor
public class UsuarioModel {
	private int idUsuario;
	private String usuario;
	private String clave;
	private boolean enabled;
	private UsuarioRol rol;
	@NotNull
	@Valid
	private String nombre;
	private String apellido;
	private TipoDocumento tipoDocumento;
	@Size(max = 8, message = "No se puede ingresar mas de 8 digitos")
	private String dni;
	private String email;

	public String nombreApellido() {
		String caseNombre = StringHelper.capitalize(this.nombre);
		String caseApellido = StringHelper.capitalize(this.apellido);
		return String.format("%s %s", caseNombre, caseApellido);
	}

	public boolean hasRole(String rol) {
		boolean hasRole = false;
		if (this.rol.getRol().compareTo(rol) == 0) {
			hasRole = true;
		}
		return hasRole;
	}
}
