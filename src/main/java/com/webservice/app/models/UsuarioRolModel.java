package com.webservice.app.models;

public class UsuarioRolModel {
	private int id;
	private String rol;
	private boolean enabled;

	public UsuarioRolModel() {
		super();
	}

	public UsuarioRolModel(int id, String rol, boolean enabled) {
		super();
		this.id = id;
		this.rol = rol;
		this.enabled = enabled;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getRol() {
		return rol;
	}

	public void setRol(String rol) {
		this.rol = rol;
	}

	public boolean isEnabled() {
		return enabled;
	}

	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}

	@Override
	public String toString() {
		return "UsuarioRolModel [id=" + id + ", rol=" + rol + ", enabled=" + enabled + "]";
	}

}
