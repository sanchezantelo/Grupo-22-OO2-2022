package com.webservice.app.models;

import javax.validation.constraints.Size;

import com.webservice.app.entities.TipoDocumento;

public class PersonaModel {
	private int id;
	private String nombre;
	private String apellido;
	private TipoDocumento tipoDocumento;
	@Size(max = 8 ,message="No se puede ingresar mas de 8 digitos")
	private String dni;
	private String email;

	public PersonaModel() {}
	
	public PersonaModel(int id, String nombre, String apellido, TipoDocumento tipoDocumento, String dni, String email) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.apellido = apellido;
		this.tipoDocumento = tipoDocumento;
		this.dni = dni;
		this.email = email;
	}

	public PersonaModel(String nombre, String apellido, TipoDocumento tipoDocumento, String dni, String email) {
		super();
		this.nombre = nombre;
		this.apellido = apellido;
		this.tipoDocumento = tipoDocumento;
		this.dni = dni;
		this.email = email;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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
		return "PersonaModel [id=" + id + ", nombre=" + nombre + ", apellido=" + apellido + ", tipoDocumento="
				+ tipoDocumento + ", dni=" + dni + ", email=" + email + "]";
	}

	public String nombreApellido() {
		return nombre + " "+ apellido ;
	}
	
}
