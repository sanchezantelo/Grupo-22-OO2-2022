package com.webservice.app.repositories;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import com.webservice.app.entities.UsuarioRol;

@Repository("usuarioRolRepository")
public interface IUsuarioRolRepository extends JpaRepository<UsuarioRol, Serializable> {

	public abstract UsuarioRol findByRol(@Param("rol") String rol);

	public abstract UsuarioRol findById(@Param("id") int id);
	
	public abstract List<UsuarioRol> findAll();
	

	@Query("SELECT r FROM UsuarioRol r WHERE r.enabled=true")
	public abstract List<UsuarioRol> findByEnabled();


}
