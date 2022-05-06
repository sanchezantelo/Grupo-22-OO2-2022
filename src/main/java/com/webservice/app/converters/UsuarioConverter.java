package com.webservice.app.converters;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import com.webservice.app.entities.Usuario;
import com.webservice.app.models.UsuarioModel;

@Component("usuarioModel")

public class UsuarioConverter {

	@Autowired
	@Qualifier("personaModel")
	private PersonaConverter personaModel;

	public UsuarioModel entityToModel(Usuario usuario){
        return new UsuarioModel(usuario.getId(),usuario.getUsuario(),usuario.getClave(),true,usuario.getRol(),personaModel.entityToModel(usuario.getPersona()));
    }

    public Usuario modelToEntity(UsuarioModel usuarioModel){
        return new Usuario(usuarioModel.getId(),usuarioModel.getUsuario(),usuarioModel.getClave(),usuarioModel.getRol(),personaModel.modelToEntity(usuarioModel.getPersona()),true);
    }
}


