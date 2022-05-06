package com.webservice.app.converters;

import org.springframework.stereotype.Component;

import com.webservice.app.entities.UsuarioRol;
import com.webservice.app.models.UsuarioRolModel;

@Component("usuarioRolModel")

public class UsuarioRolConverter {
	
	public UsuarioRolModel entityToModel(UsuarioRol usuarioRol){
        return new UsuarioRolModel(usuarioRol.getId(),usuarioRol.getRol(),true);
    }

    public UsuarioRol modelToEntity(UsuarioRolModel usuarioRolModel){
        return new UsuarioRol(usuarioRolModel.getId(),usuarioRolModel.getRol(),true);
    }

}
