package com.webservice.app.services.implementation;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.webservice.app.entities.Carrera;
import com.webservice.app.repositories.ICarreraRepository;
import com.webservice.app.services.ICarreraService;

@Service("carreraService")
public class CarreraService implements ICarreraService {

	@Autowired
	@Qualifier("carreraRepository")
	private ICarreraRepository carreraRepository;

	private ModelMapper modelMapper = new ModelMapper();

	public Carrera traerCarrera(int idCarrera) {

		Carrera carrera = carreraRepository.findByIdCarrera(idCarrera);
		// Hibernate.initialize(aula.getEdificio());
		return carrera;
	}

}
