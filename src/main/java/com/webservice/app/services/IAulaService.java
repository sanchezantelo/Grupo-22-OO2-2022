package com.webservice.app.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.webservice.app.entities.Aula;

@Service
public interface IAulaService {

	public Aula traerAula(int idAula);
	public List<Aula> traerAulas();


}
