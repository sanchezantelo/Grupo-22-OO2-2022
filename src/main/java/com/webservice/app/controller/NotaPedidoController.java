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

import java.time.LocalDate;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller("notaPedido")
@RequestMapping("/")
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

    @PostMapping("/notaPedido/crearFinal")
    public String crearFinal(@Valid @ModelAttribute("final") FinalModel finalModel, HttpSession sesion) {
        Usuario user = (Usuario) sesion.getAttribute("user");
        Final final_ = modelMapper.map(finalModel, Final.class);
        final_.setSolicitante(user);
        final_.setFecha(LocalDate.now());
        final_.setMesa("MESIST-"+final_.getMateria().getCodigo()+"-T"+final_.getTurno());
        notaPedidoService.insertOrUpdate(final_);
        return "redirect:/index";
    }
    
    @PostMapping("/notaPedido/crearCursada")
    public String crearCursada(@Valid @ModelAttribute("cursada") CursoModel curso, HttpSession sesion) {
        Usuario user = (Usuario) sesion.getAttribute("user");
        Curso cursada = modelMapper.map(curso, Curso.class);
        cursada.setSolicitante(user);
        cursada.setFecha(LocalDate.now());
        cursada.setCodigo(cursada.getMateria().getCodigo()+"-"+cursada.getIdNotaPedido());
        notaPedidoService.insertOrUpdate(cursada);
        return "redirect:/index";
    }

    @GetMapping("/notaPedido/{id}")
    public String get(Model model, @PathVariable("id") int id) {
        var notaPedido = notaPedidoService.findById(id);
        if(notaPedido instanceof Final) {
            model.addAttribute("final", notaPedido);
            return "notaPedido/updateFinal";
        } else {
            model.addAttribute("curso", notaPedido);
            return "notaPedido/updateCurso";
        }
    }

    @PostMapping("/notaPedido/updateFinal")
    public String updateFinal(@Valid @ModelAttribute("final") Final finalModel) {
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

    @PostMapping("/notaPedido/updateCurso")
    public String updateCurso(@Valid @ModelAttribute("curso") Curso cursoModel) {
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

    @PostMapping("/notaPedido/eliminarFinal/{id}")
    public String eliminarFinal(@PathVariable("id") int id) {
        notaPedidoService.remove(id);
        return "redirect:/index";
    }

    @PostMapping("/notaPedido/eliminarCurso/{id}")
    public String eliminarCurso(@PathVariable("id") int id) {
        notaPedidoService.remove(id);
        return "redirect:/index";
    }

}
