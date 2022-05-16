package com.webservice.app.controller.error;

import org.springframework.http.HttpStatus;
import org.springframework.validation.BindException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.thymeleaf.exceptions.TemplateInputException;

@ControllerAdvice
public class ExceptionController {

	@ExceptionHandler
	public String validarFormulriosException(BindException exception, RedirectAttributes redirectAttrs) {

		if (exception.getObjectName().startsWith("usuarioModel")) {
			if (exception.hasFieldErrors("dni")) {
				redirectAttrs.addFlashAttribute("errorDNI", exception.getFieldError().getDefaultMessage())
						.addFlashAttribute("clase", "alert alert-danger");
				return "redirect:/admin/usuario/abm-usuario";
			}
		}
		return "redirect:/index";
	}

	@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
	@ExceptionHandler(TemplateInputException.class)
	public String internalError(TemplateInputException ex) {

		return "redirect:/index";
	}
}