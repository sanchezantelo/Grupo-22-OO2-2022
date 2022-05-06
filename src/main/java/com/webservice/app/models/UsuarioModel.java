package com.webservice.app.models;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import com.webservice.app.entities.UsuarioRol;

public class UsuarioModel {
	private int id;
	private String usuario;
	private String clave;
	private boolean enabled;
	private UsuarioRol rol;
	@NotNull
    @Valid
	private PersonaModel persona;

	public UsuarioModel() {
		super();
	}

	public UsuarioModel(int id, String usuario, String clave, boolean enabled, UsuarioRol rol, PersonaModel persona) {
		super();
		this.id = id;
		this.usuario = usuario;
		this.clave = clave;
		this.enabled = enabled;
		this.rol = rol;
		this.persona = persona;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public String getClave() {
		return clave;
	}

	public void setClave(String clave) {
		this.clave = clave;
	}

	public UsuarioRol getRol() {
		return rol;
	}

	public void setRol(UsuarioRol rol) {
		this.rol = rol;
	}

	public PersonaModel getPersona() {
		return persona;
	}

	public void setPersona(PersonaModel persona) {
		this.persona = persona;
	}

	public boolean isEnabled() {
		return enabled;
	}

	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}

	@Override
	public String toString() {
		return "UsuarioModel [id=" + id + ", usuario=" + usuario + ", clave=" + clave + ", enabled=" + enabled
				+ ", rol=" + rol + ", persona=" + persona + "]";
	}

	public boolean hasRole(String rol) {
		boolean hasRole=false;
		if(this.rol.getRol().compareTo(rol)==0) {
		hasRole=true;
	}
		return hasRole;
	}
}
