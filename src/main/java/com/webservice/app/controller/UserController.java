
package com.webservice.app.controller;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.lowagie.text.pdf.PdfWriter;
import com.lowagie.text.Document;
import com.webservice.app.entities.Usuario;
import com.webservice.app.models.UsuarioModel;
import com.webservice.app.services.IUsuarioRolService;
import com.webservice.app.services.IUsuarioService;
import com.webservice.app.util.UsuarioPDF;

@Controller
@RequestMapping("/admin/usuario")
@Validated
public class UserController {

	@Autowired
	@Qualifier("usuarioService")
	private IUsuarioService usuarioService;

	@Autowired
	@Qualifier("usuarioRolService")
	private IUsuarioRolService usuarioRolService;

	Logger logger = LoggerFactory.getLogger(UserController.class);

	@GetMapping("/abm-usuario")
	public String abmUsuario(Model model, @RequestParam("page") Optional<Integer> page,
			@RequestParam("size") Optional<Integer> size, HttpSession sesion) {
		model.addAttribute("user", sesion.getAttribute("user"));

		model.addAttribute("usuarioModel", new UsuarioModel());
		// model.addAttribute("lstUsuarios", usuarioService.findAll());
		model.addAttribute("lstRoles", usuarioRolService.findAll());
		model.addAttribute("pageNumbers", IntStream.rangeClosed(1, 5).boxed().collect(Collectors.toList()));

		int currentPage = page.orElse(1);
		int pageSize = size.orElse(5);
		logger.info("page " + page + "size " + size);

		Page<Usuario> lstUsuarios = usuarioService.findPaginated(PageRequest.of(currentPage - 1, pageSize));

		model.addAttribute("lstUsuarios", lstUsuarios);

		int totalPages = lstUsuarios.getTotalPages();
		if (totalPages > 0) {
			List<Integer> pageNumbers = IntStream.rangeClosed(1, totalPages).boxed().collect(Collectors.toList());
			model.addAttribute("pageNumbers", pageNumbers);
		}
		return "abm-usuario";
	}

//ABM

	@PostMapping("/altaUsuario")
	public String altaUsuario(@Valid @ModelAttribute("usuarioModel") UsuarioModel usuarioModel,
			RedirectAttributes redirectAttrs) {
		logger.info("/altaUsuario" + usuarioModel);
		try {
			usuarioService.altaUsuario(usuarioModel);
			redirectAttrs.addFlashAttribute("mensaje", "Usuario agregado exitosamente!").addFlashAttribute("clase",
					"alert alert-success");
		} catch (Exception e) {
			redirectAttrs.addFlashAttribute("error", e.getMessage()).addFlashAttribute("clase", "alert alert-danger");
		}

		return "redirect:/admin/usuario/abm-usuario";
	}

	@GetMapping("/bajaUsuario")
	public String bajaUsuario(@RequestParam("id_usuario") int idUsuario, RedirectAttributes redirectAttrs) {
		logger.info("/bajaUsuario" + idUsuario);
		try {
			usuarioService.bajaUsuario(idUsuario);
			redirectAttrs.addFlashAttribute("mensaje", "Usuario dado de baja exitosamente!").addFlashAttribute("clase",
					"alert alert-success");
		} catch (Exception e) {
			redirectAttrs.addFlashAttribute("error", e.getMessage()).addFlashAttribute("clase", "alert alert-danger");
		}

		return "redirect:/admin/usuario/abm-usuario";
	}

	@PostMapping("/modificacionUsuario")
	public String modificacionUsuario(@Valid @ModelAttribute("usuarioModelUpdate") UsuarioModel usuarioModelUpdate,
			RedirectAttributes redirectAttrs) {
		logger.info("/modificacionUsuario" + usuarioModelUpdate);
		try {
			usuarioService.modificacionUsuario(usuarioModelUpdate);
			redirectAttrs.addFlashAttribute("mensaje", "Usuario modificado exitosamente!").addFlashAttribute("clase",
					"alert alert-success");
		} catch (Exception e) {
			redirectAttrs.addFlashAttribute("error", e.getMessage()).addFlashAttribute("clase", "alert alert-danger");
		}

		return "redirect:/admin/usuario/abm-usuario";
	}

	@GetMapping("/traerUsuario")
	public String traerUsuario(@RequestParam("id_usuario") int idUsuario, Model model, RedirectAttributes redirectAttrs) {
		logger.info("/traerUsuario" + idUsuario);
		model.addAttribute("editar", true);
		redirectAttrs.addFlashAttribute("usuarioModelUpdate", usuarioService.traerUsuario(idUsuario))
				.addFlashAttribute("clase", "alert alert-success");
		return "redirect:/admin/usuario/abm-usuario";
	}

	@GetMapping("/listUsuarios")
	public String listUsuarios(RedirectAttributes redirectAttrs, @RequestParam("page") Optional<Integer> page,
			@RequestParam("size") Optional<Integer> size) {
		int currentPage = page.orElse(1);
		int pageSize = size.orElse(5);
		logger.info("page " + page + "size " + size);

		Page<Usuario> lstUsuarios = usuarioService.findPaginated(PageRequest.of(currentPage - 1, pageSize));

		redirectAttrs.addFlashAttribute("lstUsuarios", lstUsuarios);

		int totalPages = lstUsuarios.getTotalPages();
		if (totalPages > 0) {
			List<Integer> pageNumbers = IntStream.rangeClosed(1, totalPages).boxed().collect(Collectors.toList());
			redirectAttrs.addFlashAttribute("pageNumbers", pageNumbers);
		}

		return "redirect:/admin/usuario/abm-usuario";
	}

	@GetMapping("/usuario/export/pdf")
	public void exportToPDF(Map<String, Object> model, Document document, PdfWriter writer, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		response.setContentType("application/pdf");

		String headerKey = "Content-Disposition";
		String headerValue = "attachment; filename=Usuarios.pdf";
		response.setHeader(headerKey, headerValue);

		List<Usuario> lstusuarios = usuarioService.findAll();

		UsuarioPDF exporter = new UsuarioPDF(lstusuarios);
		exporter.export(model, document, writer, request, response);

	}
}
