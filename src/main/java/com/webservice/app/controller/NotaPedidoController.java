package com.webservice.app.controller;

import com.webservice.app.entities.Curso;
import com.webservice.app.entities.Final;
import com.webservice.app.entities.Usuario;
import com.webservice.app.models.CursoModel;
import com.webservice.app.models.FinalModel;
import com.webservice.app.services.IAulaService;
import com.webservice.app.services.IMateriaService;
import com.webservice.app.services.INotaPedidoService;
import com.webservice.app.services.IUsuarioService;

import lombok.var;
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

@Controller("notaPedido")
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

    @PostMapping("/crearFinal")
    public String crearFinal(@Valid @ModelAttribute("final") FinalModel finalModel, HttpSession sesion) {
        Usuario user = (Usuario) sesion.getAttribute("user");
        Final final_ = modelMapper.map(finalModel, Final.class);
        final_.setSolicitante(user);
        final_.setFecha(LocalDate.now());
        final_.setMesa("MESIST-"+final_.getMateria().getCodigo()+"-T"+final_.getTurno());
        notaPedidoService.insertOrUpdate(final_);
        return "redirect:/index";
    }
    
    @PostMapping("/crearCursada")
    public String crearCursada(@Valid @ModelAttribute("curso") CursoModel curso, HttpSession sesion, RedirectAttributes redirAttr) {
        log.info("/crearCursada" + curso);
        Usuario user = (Usuario) sesion.getAttribute("user");
        try {
            curso.setSolicitante(user);
            curso.setFecha(LocalDate.now());
            curso.setCodigo(curso.getMateria().getCodigo()+"-"+String.valueOf(curso.getIdNotaPedido()));
            Curso cursada = modelMapper.map(curso, Curso.class);
            notaPedidoService.insertOrUpdate(cursada);
            redirAttr.addFlashAttribute("success", "Cursada creada correctamente");
        } catch (Exception e) {
            log.error("Error al crear cursada: " + e.getMessage());
            redirAttr.addFlashAttribute("modalCursada", true);
            redirAttr.addFlashAttribute("error", "Error al crear cursada");
        }
        return "redirect:/index";
    }

    @GetMapping("/{id}")
    public String get(Model model, @PathVariable("id") int id) {
        var notaPedido = notaPedidoService.findById(id);
        if(notaPedido instanceof Final) {
            model.addAttribute("final", notaPedido);
            return "redirect:/index";
        } else {
            model.addAttribute("curso", notaPedido);
            return "redirect:/index";
        }
    }

    @PostMapping("/updateFinal")
    public String updateFinal(@Valid @ModelAttribute("final") FinalModel finalModel) {
        Final final_ = modelMapper.map(finalModel, Final.class);
        if(final_.getIdNotaPedido() > 0) {
            Final finalViejo = (Final) notaPedidoService.findById(final_.getIdNotaPedido());
            final_.setSolicitante(finalViejo.getSolicitante());
            final_.setFecha(finalViejo.getFecha());
            final_.setMesa(finalViejo.getMesa());
        }
        notaPedidoService.insertOrUpdate(final_);
        return "redirect:/index";
    }

    @PostMapping("/updateCurso")
    public String updateCurso(@Valid @ModelAttribute("curso") CursoModel cursoModel) {
        Curso curso = modelMapper.map(cursoModel, Curso.class);
        if(curso.getIdNotaPedido() > 0) {
            Curso cursoViejo = (Curso) notaPedidoService.findById(curso.getIdNotaPedido());
            curso.setSolicitante(cursoViejo.getSolicitante());
            curso.setFecha(cursoViejo.getFecha());
            curso.setCodigo(cursoViejo.getCodigo());
        }
        notaPedidoService.insertOrUpdate(curso);
        return "redirect:/index";
    }

    @PostMapping("/eliminarFinal/{id}")
    public String eliminarFinal(@PathVariable("id") int id) {
        notaPedidoService.remove(id);
        return "redirect:/index";
    }

    @PostMapping("/eliminarCurso/{id}")
    public String eliminarCurso(@PathVariable("id") int id) {
        notaPedidoService.remove(id);
        return "redirect:/index";
    }

}
