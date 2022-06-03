package com.webservice.app.entities;

import java.io.Serializable;
import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "usuario_rol")
@Data @NoArgsConstructor
public class UsuarioRol implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@Column(name = "rol", unique = true, nullable = false, length = 100)
	private String rol;

	@Column(name = "enabled", columnDefinition = "boolean default true")
	private boolean enabled;

	@Column(name = "createdat", updatable = false)
	@CreationTimestamp
	private LocalDateTime createdAt;
	
	@Column(name = "updatedat", nullable = false)
	@UpdateTimestamp
	private LocalDateTime updatedAt;
	
	public UsuarioRol(int id, String rol, boolean enabled) {
		super();
		this.id = id;
		this.rol = rol;
		this.enabled = enabled;
    }

}
