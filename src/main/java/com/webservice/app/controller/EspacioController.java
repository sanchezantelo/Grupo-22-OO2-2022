package com.webservice.app.controller;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Map;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;

import com.webservice.app.entities.Aula;
import com.webservice.app.services.IAulaService;
import com.webservice.app.services.IEspacioService;

@Controller("espacio")
@RequestMapping("/espacio" )
public class EspacioController {
	
	@Autowired
	@Qualifier("espacioService")
	private IEspacioService espacioService;
	
	
	@Autowired
	@Qualifier("aulaService")
	private IAulaService aulaService;
	
	private ModelMapper modelMapper = new ModelMapper();
	
	@GetMapping("/{idAula}")
	public String traerEspaciosPorAula(@PathVariable("idAula") int idAula, Model model,RedirectAttributes redirectAttrs) {
		 
		Aula aula = aulaService.traerAula(idAula);
		redirectAttrs.addFlashAttribute("aula", aula);
		redirectAttrs.addFlashAttribute("espacios", espacioService.traerEspacios(aula))
				.addFlashAttribute("clase", "alert alert-success");
		return "redirect:/index";
	}
	
	@RequestMapping(value="/add",method = RequestMethod.POST)
	public String generarEspacios(@RequestParam Map<String, String> parameters,Model model,RedirectAttributes redirectAttrs) 
	{   
		
		LocalDate desde= LocalDate.parse(parameters.get("desde"), DateTimeFormatter.ofPattern("yyyy-MM-dd"));
		LocalDate hasta= LocalDate.parse(parameters.get("hasta"), DateTimeFormatter.ofPattern("yyyy-MM-dd"));
		try {
			espacioService.agregarEspacios(desde,hasta);
			redirectAttrs.addFlashAttribute("success", "Se generaron los espacios").addFlashAttribute("clase", "alert alert-danger");
		}catch(Exception e) {
			redirectAttrs.addFlashAttribute("modalGeneradorEspacios", true);
			redirectAttrs.addFlashAttribute("error", e.getMessage()).addFlashAttribute("clase", "alert alert-danger");
		}

		return "redirect:/index";
	}

}
