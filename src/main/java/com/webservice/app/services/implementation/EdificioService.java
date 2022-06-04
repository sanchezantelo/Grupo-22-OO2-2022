package com.webservice.app.services.implementation;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.webservice.app.entities.Edificio;
import com.webservice.app.models.EdificioModel;
import com.webservice.app.repositories.IEdificioRepository;
import com.webservice.app.services.IEdificioService;

@Service("edificioService")
public class EdificioService implements IEdificioService {

	@Autowired
	@Qualifier("edificioRepository")
	private IEdificioRepository edificioRepository;

	private ModelMapper modelMapper = new ModelMapper();

	@Override
	public Edificio findByIdEdificio(int idEdificio) {
		return edificioRepository.findByIdEdificio(idEdificio);
	}
	
	public List<Edificio> findAll() {
		return edificioRepository.findAll();
	}

	@Override
	public EdificioModel traerEdificioConAulas(int idEdificio) {

		return modelMapper.map(edificioRepository.findByIdEdificio(idEdificio), EdificioModel.class);
	}

}
