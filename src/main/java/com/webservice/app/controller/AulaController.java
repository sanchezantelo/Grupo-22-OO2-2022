package com.webservice.app.controller;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;

import com.webservice.app.services.IAulaService;
import com.webservice.app.services.IEdificioService;



@Controller("aula")
public class AulaController {

	@Autowired
	@Qualifier("aulaService")
	private IAulaService aulaService;
	
	@Autowired
	@Qualifier("edificioService")
	private IEdificioService edificioService;
	
	private ModelMapper modelMapper = new ModelMapper();
}
