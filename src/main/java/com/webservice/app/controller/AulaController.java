package com.webservice.app.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.webservice.app.services.IAulaService;
import com.webservice.app.services.IEdificioService;



@Controller
@RequestMapping("/aula")
public class AulaController {

	@Autowired
	@Qualifier("aulaService")
	private IAulaService aulaService;
	
	@Autowired
	@Qualifier("edificioService")
	private IEdificioService edificioService;
	
	Logger logger = LoggerFactory.getLogger(AulaController.class);

	
	
	@GetMapping("/buscarPorId")
	public String buscarPorId(@RequestParam("idAula") int idAula, Model model,
			RedirectAttributes redirectAttrs) {
		logger.info("/buscarPorId" + idAula);
		model.addAttribute("editar", true);
		redirectAttrs.addFlashAttribute("aulaModel", aulaService.traerAula(idAula))
				.addFlashAttribute("clase", "alert alert-success");
		return "redirect:/index";
	}
	
	
}
