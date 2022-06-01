package com.webservice.app.services.implementation;

import org.hibernate.Hibernate;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.webservice.app.entities.Aula;
import com.webservice.app.repositories.IAulaRepository;
import com.webservice.app.repositories.ILaboratorioRepository;
import com.webservice.app.repositories.ITradicionalRepository;
import com.webservice.app.services.IAulaService;


@Service("aulaService")
public class AulaService implements IAulaService{
	
	@Autowired
	@Qualifier("aulaRepository")
	private IAulaRepository aulaRepository;
	
	@Autowired
	@Qualifier("tradicionalRepository")
	private ITradicionalRepository tradicionalRepository;
	
	@Autowired
	@Qualifier("laboratorioRepository")
	private ILaboratorioRepository laboratorioRepository;
	
	
	private ModelMapper modelMapper = new ModelMapper();
	
	public Aula traerAula(int idAula) {
		Aula aula = aulaRepository.findByIdAula(idAula);
		//Hibernate.initialize(aula.getEdificio());
		return aula;
	}
}
