package com.webservice.app.models;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.webservice.app.entities.TipoDocumento;
import com.webservice.app.entities.UsuarioRol;

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

	public UsuarioModel() {
		super();
	}

	public UsuarioModel(int idUsuario, String usuario, String clave, boolean enabled, UsuarioRol rol, String nombre,
			String apellido, TipoDocumento tipoDocumento, String dni, String email) {
		super();
		this.idUsuario = idUsuario;
		this.usuario = usuario;
		this.clave = clave;
		this.enabled = enabled;
		this.rol = rol;
		this.nombre = nombre;
		this.apellido = apellido;
		this.tipoDocumento = tipoDocumento;
		this.dni = dni;
		this.email = email;
	}

	public int getIdUsuario() {
		return idUsuario;
	}

	public void setIdUsuario(int idUsuario) {
		this.idUsuario = idUsuario;
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

	public boolean isEnabled() {
		return enabled;
	}

	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public TipoDocumento getTipoDocumento() {
		return tipoDocumento;
	}

	public void setTipoDocumento(TipoDocumento tipoDocumento) {
		this.tipoDocumento = tipoDocumento;
	}

	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public String toString() {
		return "UsuarioModel [idUsuario=" + idUsuario + ", usuario=" + usuario + ", clave=" + clave + ", enabled="
				+ enabled + ", rol=" + rol + ", nombre=" + nombre + ", apellido=" + apellido + ", tipoDocumento="
				+ tipoDocumento + ", dni=" + dni + ", email=" + email + "]";
	}

	public String nombreApellido() {
		return nombre + " " + apellido;
	}

	public boolean hasRole(String rol) {
		boolean hasRole = false;
		if (this.rol.getRol().compareTo(rol) == 0) {
			hasRole = true;
		}
		return hasRole;
	}
}
