package com.webservice.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;

import com.webservice.app.services.IMateriaService;

@Controller("materia")
public class MateriaController {

	@Autowired
	@Qualifier("materiaService")
	private IMateriaService materiaService;
}
