package com.webservice.app.services.implementation;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.webservice.app.entities.Departamento;
import com.webservice.app.repositories.IDepartamentoRepository;
import com.webservice.app.services.IDepartamentoService;

@Service("departamentoService")
public class DepartamentoService implements IDepartamentoService {

	@Autowired
	@Qualifier("departamentoRepository")
	private IDepartamentoRepository departamentoRepository;

	private ModelMapper modelMapper = new ModelMapper();

	public Departamento traerDepartamento(int idDepartamento) {

		Departamento departamento = departamentoRepository.findByIdDepartamento(idDepartamento);
		// Hibernate.initialize(aula.getEdificio());
		return departamento;
	}

}
