package com.webservice.app.converters;

import org.springframework.stereotype.Component;

import com.webservice.app.entities.Usuario;
import com.webservice.app.models.UsuarioModel;

@Component("usuarioModel")

public class UsuarioConverter {

	public UsuarioModel entityToModel(Usuario usuario) {
		return new UsuarioModel(usuario.getIdUsuario(), usuario.getUsuario(), usuario.getClave(), true, usuario.getRol(),
				usuario.getNombre(), usuario.getApellido(), usuario.getTipoDocumento(),
				String.valueOf(usuario.getDni()), usuario.getEmail());
	}

	public Usuario modelToEntity(UsuarioModel usuarioModel) {
		return new Usuario(usuarioModel.getIdUsuario(), usuarioModel.getUsuario(), usuarioModel.getClave(),
				usuarioModel.getRol(), usuarioModel.getNombre(), usuarioModel.getApellido(),
				usuarioModel.getTipoDocumento(), Long.valueOf(usuarioModel.getDni()), usuarioModel.getEmail(), true);
	}
}
