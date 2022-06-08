
package com.webservice.app.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.webservice.app.helpers.ViewRouteHelper;
import com.webservice.app.models.UsuarioModel;
import com.webservice.app.services.IAulaService;
import com.webservice.app.services.IEdificioService;
import com.webservice.app.services.IMateriaService;
import com.webservice.app.services.IUsuarioService;
import com.webservice.app.services.INotaPedidoService;

import lombok.var;
import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j // Logger
@RequestMapping("/")
public class LoginController {

	@Autowired
	@Qualifier("usuarioService")
	private IUsuarioService usuarioService;
	
	@Autowired
	@Qualifier("edificioService")
	private IEdificioService edificioService;

	@Autowired
	@Qualifier("materiaService")
	private IMateriaService materiaService;
	
	@Autowired
	@Qualifier("aulaService")
	private IAulaService aulaService;

	@Autowired
	@Qualifier("notaPedidoService")
	private INotaPedidoService notaPedidoService;

	@GetMapping({"login",""})
	public String login(Model model, @RequestParam(name = "error", required = false) String error,
			@RequestParam(name = "logout", required = false) String logout) {
		model.addAttribute("logout", logout);
		model.addAttribute("usuarioModel", new UsuarioModel());
		return ViewRouteHelper.USER_LOGIN;
	}

	@GetMapping("/logout")
	public String logout(Model model, HttpSession sesion) {
		model.addAttribute("usuarioModel", new UsuarioModel());
		sesion.removeAttribute("user");
		return ViewRouteHelper.USER_LOGOUT;
	}

	@PostMapping("/autenticar")
	public String loginCheck(@ModelAttribute("usuarioModel") UsuarioModel usuarioModel,RedirectAttributes redirectAttrs, HttpSession sesion) {
		log.info("/autenticar" + usuarioModel);
		try {
			sesion.setAttribute("user", usuarioService.validarCredenciales(usuarioModel));
			redirectAttrs.addFlashAttribute("user", usuarioService.validarCredenciales(usuarioModel));
		} catch (Exception e) {
			redirectAttrs.addFlashAttribute("error", e.getMessage()).addFlashAttribute("clase", "alert alert-danger");
			return "redirect:/login";
		}
		
		return "redirect:/index";
	}
	
	@GetMapping("/index")
	public String index(Model model, HttpSession sesion) {	
		log.info("/edificio" + edificioService.findAll());
		log.info("/notaPedido" + notaPedidoService.findAll());
		var notasPedido = notaPedidoService.findNotasPendientes();
		var notasPedidoAsignadas = notaPedidoService.findNotasAsignadas();
		model.addAttribute("user",sesion.getAttribute("user"));
		model.addAttribute("lstEdificios", edificioService.findAll());
		model.addAttribute("lstMaterias", materiaService.findAll());
		model.addAttribute("notasPedido", notasPedido);
		model.addAttribute("notasPedidoAsignadas", notasPedidoAsignadas);
		return "index";
	}
}
