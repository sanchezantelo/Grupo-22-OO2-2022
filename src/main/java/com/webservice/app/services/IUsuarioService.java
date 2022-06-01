package com.webservice.app.services;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.webservice.app.entities.Usuario;
import com.webservice.app.models.UsuarioModel;

public interface IUsuarioService {

	Usuario findByUsuario(String usuarioModel);

	Usuario findById(int idUsuario);

	Usuario findByDni(long dni);

	UsuarioModel traerUsuario(int idUsuario);

	List<Usuario> findAll();

	void altaUsuario(UsuarioModel usuarioModel) throws Exception;

	void bajaUsuario(int idUsuario) throws Exception;

	void modificacionUsuario(UsuarioModel usuarioModel) throws Exception;

	Page<Usuario> findPaginated(Pageable pageable);

	UsuarioModel validarCredenciales(UsuarioModel usuarioModel) throws Exception;

}
