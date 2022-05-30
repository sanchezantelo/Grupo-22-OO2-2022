package com.webservice.app.controller;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;

import com.webservice.app.services.IAulaService;
import com.webservice.app.services.IEspacioService;

@Controller("espacio")
public class EspacioController {
	
	@Autowired
	@Qualifier("espacioService")
	private IEspacioService espacioService;
	
	
	@Autowired
	@Qualifier("aulaService")
	private IAulaService aulaService;
	
	private ModelMapper modelMapper = new ModelMapper();

}
