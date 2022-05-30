
package com.webservice.app.controller;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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
import com.webservice.app.services.IUsuarioService;

@Controller
@RequestMapping("/")
public class LoginController {

	@Autowired
	@Qualifier("usuarioService")
	private IUsuarioService usuarioService;

	Logger logger = LoggerFactory.getLogger(LoginController.class);
	

	@GetMapping("/login")
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
		logger.info("/autenticar" + usuarioModel);
		try {
			sesion.setAttribute("user", usuarioService.validarCredenciales(usuarioModel));
			redirectAttrs.addFlashAttribute("user", usuarioService.validarCredenciales(usuarioModel));
		} catch (Exception e) {
			redirectAttrs.addFlashAttribute("error", e.getMessage()).addFlashAttribute("clase", "alert alert-danger");
			return "redirect:/login";
		}

		return "redirect:/index";
	}
	
	@GetMapping({"/index",""})
	public String index(Model model, HttpSession sesion) {
		model.addAttribute("user",sesion.getAttribute("user"));
		return "index";
	}
}
