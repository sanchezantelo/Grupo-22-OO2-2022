package com.webservice.app.services;

import org.springframework.stereotype.Service;

import com.webservice.app.entities.Departamento;

@Service
public interface IDepartamentoService {
	public Departamento traerDepartamento(int idDepartamento);

}
