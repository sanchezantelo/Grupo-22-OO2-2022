package com.webservice.app.services;

import org.springframework.stereotype.Service;

import com.webservice.app.entities.Aula;


@Service
public interface IAulaService {
	public Aula traerAula(int idAula);
	
}
