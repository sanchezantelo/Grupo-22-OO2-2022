package com.webservice.app.services.implementation;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.webservice.app.entities.Materia;
import com.webservice.app.repositories.IMateriaRepository;
import com.webservice.app.services.IMateriaService;

@Service("materiaService")
public class MateriaService implements IMateriaService {

	@Autowired
	@Qualifier("materiaRepository")
	private IMateriaRepository materiaRepository;

	private ModelMapper modelMapper = new ModelMapper();

	public Materia traerMateria(int idMateria) {

		Materia materia = materiaRepository.findByIdMateria(idMateria);
		// Hibernate.initialize(aula.getEdificio());
		return materia;
	}

}
