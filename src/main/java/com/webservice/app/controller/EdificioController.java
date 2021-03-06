package com.webservice.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import com.webservice.app.services.IAulaService;
import com.webservice.app.services.IEdificioService;

@Controller("/edificio")
public class EdificioController {

	@Autowired
	@Qualifier("edificioService")
	private IEdificioService edificioService;

	@Autowired
	@Qualifier("aulaService")
	private IAulaService aulaService;

}
