package com.webservice.app.services;

import com.webservice.app.entities.Persona;
import com.webservice.app.entities.Usuario;

public interface IPersonaService {

	Usuario findByUsuario(String usuarioModel);

	Usuario findById(int id);
	
	Persona findByDni(long dni);

}
