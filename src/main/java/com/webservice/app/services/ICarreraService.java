package com.webservice.app.services;

import org.springframework.stereotype.Service;

import com.webservice.app.entities.Carrera;

@Service
public interface ICarreraService {
	public Carrera traerCarrera(int idCarrera);

}
