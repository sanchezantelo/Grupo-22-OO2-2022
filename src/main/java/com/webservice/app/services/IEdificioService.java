package com.webservice.app.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.webservice.app.entities.Edificio;
import com.webservice.app.models.EdificioModel;

@Service
public interface IEdificioService {

	public Edificio findByIdEdificio(int idEdificio);

	public EdificioModel traerEdificioConAulas(int idEdificio);

	public List<Edificio> findAll();

}
