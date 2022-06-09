package com.webservice.app.controller;

import com.webservice.app.entities.Curso;
import com.webservice.app.entities.Final;
import com.webservice.app.entities.NotaPedido;
import com.webservice.app.models.CursoModel;
import com.webservice.app.models.FinalModel;
import com.webservice.app.models.UsuarioModel;
import com.webservice.app.services.IAulaService;
import com.webservice.app.services.IMateriaService;
import com.webservice.app.services.INotaPedidoService;
import com.webservice.app.services.IUsuarioService;

import lombok.extern.slf4j.Slf4j;

import java.time.LocalDate;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@Slf4j // Logger
@RequestMapping("/notaPedido")
@Validated
public class NotaPedidoController {
    @Autowired
    @Qualifier("notaPedidoService")
    private INotaPedidoService notaPedidoService;

    @Autowired
    @Qualifier("usuarioService")
    private IUsuarioService usuarioService;

    @Autowired
    @Qualifier("materiaService")
    private IMateriaService materiaService;

    @Autowired
    @Qualifier("aulaService")
    private IAulaService aulaService;

	private ModelMapper modelMapper = new ModelMapper();

    @GetMapping("/nuevoCurso")
    public String nuevoCurso(Model model, RedirectAttributes redirAttr) {
        redirAttr.addFlashAttribute("curso", new CursoModel());
        return "redirect:/index";
    }

    @GetMapping("/nuevoFinal")
    public String nuevoFinal(Model model, RedirectAttributes redirAttr) {
        redirAttr.addFlashAttribute("final", new FinalModel());
        return "redirect:/index";
    }

    @PostMapping("/crearFinal")
    public String crearFinal(@Valid @ModelAttribute("final") FinalModel finalModel,RedirectAttributes redirAttr, HttpSession sesion) {
        log.info("/crearFinal" + finalModel);
    	try {
            UsuarioModel user = (UsuarioModel) sesion.getAttribute("user");
	    	Final final_ = modelMapper.map(finalModel, Final.class);
	        final_.setSolicitante(usuarioService.findById(user.getIdUsuario()));
	        final_.setFecha(LocalDate.now());
	        final_.setMesa("MESIST-"+String.valueOf(materiaService.traerMateria(final_.getMateria().getIdMateria()).getCodigo()));
	        final_.setMateria(materiaService.traerMateria(final_.getMateria().getIdMateria()));
	        notaPedidoService.insertOrUpdate(final_);
            redirAttr.addFlashAttribute("mensaje", "Pedido de final creado correctamente")
                .addFlashAttribute("clase", "task-success");
        } catch (Exception e) {
            log.error("Error al crear final: " + e.getMessage());
            redirAttr.addFlashAttribute("modalCursada", true);
            redirAttr.addFlashAttribute("mensaje", "Error al crear su pedido de final")
                .addFlashAttribute("clase", "task-error");
        }
        return "redirect:/index";
    }
    
    @PostMapping("/crearCursada")
    public String crearCursada(@Valid @ModelAttribute("curso") CursoModel curso, HttpSession sesion, RedirectAttributes redirAttr) {
        log.info("/crearCursada" + curso);
        try {
            UsuarioModel user = (UsuarioModel) sesion.getAttribute("user");
            curso.setSolicitante(usuarioService.findById(user.getIdUsuario()));
            curso.setFecha(LocalDate.now());
            curso.setCodigo(curso.getMateria().getCodigo()+"-"+String.valueOf(curso.getIdNotaPedido()));
            Curso cursada = modelMapper.map(curso, Curso.class);
            cursada.setMateria(materiaService.traerMateria(curso.getMateria().getIdMateria()));
            cursada.setFecha(LocalDate.now());
            notaPedidoService.insertOrUpdate(cursada);
            cursada.setCodigo(cursada.getMateria().getCodigo()+"-"+String.valueOf(cursada.getIdNotaPedido()));
            notaPedidoService.insertOrUpdate(cursada);
            redirAttr.addFlashAttribute("mensaje", "Pedido de cursada creada correctamente")
                .addFlashAttribute("clase", "task-success");
        } catch (Exception e) {
            log.error("Error al crear cursada: " + e.getMessage());
            redirAttr.addFlashAttribute("modalCursada", true);
            redirAttr.addFlashAttribute("mensaje", "Error al crear su pedido de cursada")
                .addFlashAttribute("clase", "task-error");
        }
        return "redirect:/index";
    }

    @GetMapping("{id}")
    public String get(Model model, @PathVariable("id") int idNotaPedido, RedirectAttributes redirAttr) {
        log.info("/{id}" + idNotaPedido);
        NotaPedido notaPedido = notaPedidoService.findById(idNotaPedido);
        model.addAttribute("editar", true);
        redirAttr.addFlashAttribute("notaPedidoReq", notaPedido).addFlashAttribute("clase", "task-success");
        return "redirect:/index";
    }

    @GetMapping("/verAula/{id}")
    public String getAula(Model model, @PathVariable("id") int idNotaPedido, RedirectAttributes redirAttr) {
        log.info("/verAula/{id}" + idNotaPedido);
        NotaPedido notaPedido = notaPedidoService.findById(idNotaPedido);
        model.addAttribute("verAula", true);
        redirAttr.addFlashAttribute("notaPedidoAula", notaPedido).addFlashAttribute("clase", "task-success");
        return "redirect:/index";
    }

    @PostMapping("/updateFinal")
    public String updateFinal(@Valid @ModelAttribute("notaPedidoReq") FinalModel finalModel, RedirectAttributes redirAttr) {
        log.info("/updateFinal" + finalModel);
        try {
            Final final_ = modelMapper.map(finalModel, Final.class);
            if(final_.getIdNotaPedido() > 0) {
                Final finalViejo = (Final) notaPedidoService.findById(final_.getIdNotaPedido());
                final_.setSolicitante(finalViejo.getSolicitante());
                final_.setFecha(finalViejo.getFecha());
                final_.setMesa("MESIST-"+String.valueOf(materiaService.traerMateria(final_.getMateria().getIdMateria()).getCodigo()));
                notaPedidoService.insertOrUpdate(final_);
                redirAttr.addFlashAttribute("mensaje", "Pedido de final modificado correctamente")
                    .addFlashAttribute("clase", "task-success");
            }
        } catch (Exception e) {
            log.error("Error al modificar final: " + e.getMessage());
            redirAttr.addFlashAttribute("mensaje", "Error al modificar su pedido de final")
                .addFlashAttribute("error", e.getMessage()).addAttribute("clase", "task-error");
        }
        return "redirect:/index";
    }

    @PostMapping("/updateCurso")
    public String updateCurso(@Valid @ModelAttribute("notaPedidoReq") CursoModel cursoModel, RedirectAttributes redirAttr) {
        log.info("/updateCurso" + cursoModel);
        try {
            Curso curso = modelMapper.map(cursoModel, Curso.class);
            if(curso.getIdNotaPedido() > 0) {
                Curso cursoViejo = (Curso) notaPedidoService.findById(curso.getIdNotaPedido());
                curso.setSolicitante(cursoViejo.getSolicitante());
                curso.setFecha(cursoViejo.getFecha());
                curso.setCodigo(cursoViejo.getCodigo());
            }
            notaPedidoService.insertOrUpdate(curso);
            redirAttr.addFlashAttribute("mensaje", "Pedido de curso modificado correctamente")
                .addFlashAttribute("clase", "task-success");
        } catch (Exception e) {
            log.error("Error al modificar curso: " + e.getMessage());
            redirAttr.addFlashAttribute("mensaje", "Error al modificar su pedido de curso")
                .addFlashAttribute("error", e.getMessage()).addAttribute("clase", "task-error");
        }
        return "redirect:/index";
    }

    @GetMapping("/eliminarNotaPedido/{id}")
    public String eliminarNotaPedido(@PathVariable("id") int id, RedirectAttributes redirAttr) {
        log.info("/eliminarNotaPedido" + id);
        try {            
            notaPedidoService.remove(id);
            redirAttr.addFlashAttribute("mensaje", "Pedido eliminado correctamente")
                .addFlashAttribute("clase", "task-success");
        } catch(Exception e) {
            log.error("Error al eliminar pedido: " + e.getMessage());
            redirAttr.addFlashAttribute("mensaje", "Error al eliminar el pedido")
                .addFlashAttribute("error", e.getMessage()).addAttribute("clase", "task-error");
        }
        return "redirect:/index";
    }

}