package com.webservice.app.controller;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
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
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.webservice.app.entities.NotaPedido;
import com.webservice.app.services.INotaPedidoService;
import com.webservice.app.entities.Aula;
import com.webservice.app.entities.Curso;
import com.webservice.app.entities.Final;
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
	
	@Autowired
	@Qualifier("notaPedidoService")
	private INotaPedidoService notaPedidoService;
	
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
			redirectAttrs.addFlashAttribute("mensaje", "Se generaron los espacios").addFlashAttribute("clase", "task-success");
		}catch(Exception e) {
			redirectAttrs.addFlashAttribute("mensaje", e.getMessage()).addFlashAttribute("clase", "task-error");
		}

		return "redirect:/index";
	}
	
	@GetMapping("/buscarAula/notapedido={idNotaPedido}")
	public String buscarAula(@PathVariable("idNotaPedido") int idNotaPedido,
			RedirectAttributes redirectAttrs) throws Exception
	{  
		
		NotaPedido notaPedido = notaPedidoService.findById(idNotaPedido);
		List<Aula> aulas = aulaService.traerAulas(notaPedido.getCantEstudiantes(),notaPedido.getTipoAula());
 		if (notaPedido instanceof Final) { 
			Final notafinal = (Final) notaPedido;	
			try {
				redirectAttrs.addFlashAttribute("aulasNota",espacioService.traerAulasDisponiblesPorFecha(notafinal.getFechaExamen(),aulas,notafinal.getTurno()));
			
			}catch(Exception e) {
				redirectAttrs.addFlashAttribute("mensaje", e.getMessage()).addFlashAttribute("clase", "task-error");
			}
		}else {
			
			Curso curso=(Curso) notaPedido;
			try {
		 		redirectAttrs.addFlashAttribute("aulasNota",espacioService.traerAulasDisponiblesPorFecha(aulas,curso));
			
			}catch(Exception e) {
				redirectAttrs.addFlashAttribute("mensaje", e.getMessage()).addFlashAttribute("clase", "task-error");
		
			}
		}
 		redirectAttrs.addFlashAttribute("notapedido",notaPedido);
		return "redirect:/index";
	}
	
	@GetMapping("/asignar/notapedido={idNotaPedido}/aula={idAula}")
	public String asignarAula(@PathVariable("idNotaPedido") int idNotaPedido,@PathVariable("idAula") int idAula, RedirectAttributes redirectAttrs) {
		
		NotaPedido notaPedido = notaPedidoService.findById(idNotaPedido);
		
		Aula aula = aulaService.traerAula(idAula);
		
		espacioService.AsignarEspacios(notaPedido, aula);
		
		redirectAttrs.addFlashAttribute("mensaje", "Se asigno el aula para la nota pedido").addFlashAttribute("clase", "task-success");
		return "redirect:/index";
		
	}

}
