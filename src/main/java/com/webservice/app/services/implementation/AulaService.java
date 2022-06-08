package com.webservice.app.services.implementation;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Hibernate;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.webservice.app.entities.Laboratorio;
import com.webservice.app.entities.TipoAula;
import com.webservice.app.entities.Tradicional;
import com.webservice.app.entities.Aula;
import com.webservice.app.repositories.IAulaRepository;
import com.webservice.app.repositories.ILaboratorioRepository;
import com.webservice.app.repositories.ITradicionalRepository;
import com.webservice.app.services.IAulaService;

@Service("aulaService")
public class AulaService implements IAulaService {

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

	public List<Aula> traerAulas() {
		return  aulaRepository.findAll();
	}

	public Aula traerAula(int idAula) {
		Aula aula = aulaRepository.findByIdAula(idAula);
		Hibernate.initialize(aula.getEdificio());
		return aula;
	}
	
	public List<Aula> traerAulas(int cantEstudiantes,TipoAula tipo){
		
		List<Aula> aulas = new ArrayList<Aula>();
		
		if (tipo.equals("Tradicional")) {			
			List<Tradicional> tradicionales = tradicionalRepository.traerAulasPorAlumnos(cantEstudiantes);
			aulas.addAll(tradicionales);
		}else {
			List<Laboratorio> laboratorios =  laboratorioRepository.traerAulasPorAlumnos(cantEstudiantes);
			aulas.addAll(laboratorios);
		}
		for(Aula aula:aulas) {
			Hibernate.initialize(aula.getEdificio());
		}
		return aulas;
		
	}
	
}
