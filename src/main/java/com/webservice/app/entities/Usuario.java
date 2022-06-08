package com.webservice.app.entities;

import java.io.Serializable;
import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.util.DigestUtils;

import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "usuario")
@Data @NoArgsConstructor
public class Usuario implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idUsuario;

	@Column(name = "usuario", unique = true, nullable = false, length = 45)
	private String usuario;

	@Column(name = "clave", nullable = false, length = 60)
	private String clave;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "rol_id", nullable = false)
	private UsuarioRol rol;

	@Column(name = "nombre", nullable = false, length = 45)
	private String nombre;

	@Column(name = "apellido", nullable = false, length = 45)
	private String apellido;

	@Column(name = "tipoDocumento", nullable = false)
	@Enumerated(value = EnumType.STRING)
	private TipoDocumento tipoDocumento;

	@Column(name = "dni", unique = true, nullable = false, length = 8)
	private Long dni;

	@Column(name = "email", unique = true, nullable = false, length = 45)
	private String email;

	@Column(name = "enabled", columnDefinition = "boolean default true")
	private boolean enabled;

	@Column(name = "createdat", updatable = false)
	@CreationTimestamp
	private LocalDateTime createdAt;

	@Column(name = "updatedat", nullable = false)
	@UpdateTimestamp
	private LocalDateTime updatedAt;

	public Usuario(int idUsuario, String usuario, String clave, UsuarioRol rol, String nombre, String apellido,
			TipoDocumento tipoDocumento, Long dni, String email, boolean enabled) {
		super();
		this.idUsuario = idUsuario;
		this.usuario = usuario;
		this.clave = DigestUtils.md5DigestAsHex(clave.getBytes());
		this.rol = rol;
		this.nombre = nombre;
		this.apellido = apellido;
		this.tipoDocumento = tipoDocumento;
		this.dni = dni;
		this.email = email;
		this.enabled = enabled;
	}
	
	public void setClave(String clave) {
		this.clave = DigestUtils.md5DigestAsHex(clave.getBytes());
	}
}
