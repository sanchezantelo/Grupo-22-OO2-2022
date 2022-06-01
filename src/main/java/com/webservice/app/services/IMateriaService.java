package com.webservice.app.services;

import org.springframework.stereotype.Service;

import com.webservice.app.entities.Materia;

@Service
public interface IMateriaService {
	public Materia traerMateria(int idMateria);

}
