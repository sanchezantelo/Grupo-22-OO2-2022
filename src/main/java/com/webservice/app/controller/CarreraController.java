package com.webservice.app.controller;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;

import com.webservice.app.services.ICarreraService;

@Controller("carrera")

public class CarreraController {

	@Autowired
	@Qualifier("carreraService")
	private ICarreraService carreraService;

	private ModelMapper modelMapper = new ModelMapper();
}
