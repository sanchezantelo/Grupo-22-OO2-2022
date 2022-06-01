package com.webservice.app.controller;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;

import com.webservice.app.services.IDepartamentoService;

@Controller("departamento")
public class DepartamentoController {

	@Autowired
	@Qualifier("departamentoService")
	private IDepartamentoService departamentoService;

	private ModelMapper modelMapper = new ModelMapper();
}
