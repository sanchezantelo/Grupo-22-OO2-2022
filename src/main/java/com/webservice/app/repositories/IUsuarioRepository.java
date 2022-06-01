package com.webservice.app.repositories;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import com.webservice.app.entities.Usuario;

@Repository("usuarioRepository")
public interface IUsuarioRepository extends JpaRepository<Usuario, Serializable> {

	public abstract Usuario findByUsuario(@Param("usuario") String usuario);

	public abstract Usuario findByDni(long dni);

	public abstract Usuario findByIdUsuario(@Param("idUsuario") int idUsuario);

	@Query("SELECT u FROM Usuario u JOIN FETCH u.rol WHERE u.idUsuario=:idUsuario")
	public abstract Usuario findByIdRol(@Param("idUsuario") int idUsuario);

	public abstract List<Usuario> findAll();

	@Query("SELECT u FROM Usuario u JOIN FETCH u.rol WHERE u.enabled=true")
	public abstract List<Usuario> findByEnabled();

	@Query("SELECT u FROM Usuario u  JOIN FETCH u.rol WHERE (u.usuario LIKE :usuario AND u.clave LIKE :clave) OR (u.email LIKE :email AND u.clave LIKE :clave)")
	public abstract Usuario validarCredenciales(@Param("usuario") String usuario, @Param("email") String email,
			@Param("clave") String clave);

}
