package com.webservice.app.controller;

import com.webservice.app.services.IAulaService;
import com.webservice.app.services.INotaPedidoService;
import com.webservice.app.services.IUsuarioService;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import lombok.var;
import lombok.extern.slf4j.Slf4j;

@Controller
// @RequestMapping("/notaPedido")
@Slf4j
public class NotaPedidoController {
    
    @Autowired
    @Qualifier("notaPedidoService")
    private INotaPedidoService service;

    @Autowired
    @Qualifier("usuarioService")
    private IUsuarioService usuarioService;

    // @Autowired
    // @Qualifier("materiaService")
    // private IMateriaService materiaService;

    @Autowired
    @Qualifier("aulaService")
    private IAulaService aulaService;

    @Autowired
    @Qualifier("modelMapper")
    private ModelMapper modelMapper = new ModelMapper();

    @GetMapping("/notasPedido")
    public String NotasPedido(Model model) {
        log.info("CONTROLLER [NotasPedido]");
        log.debug("METHOD [NotasPedido]");

        var notasPedido = service.findAll();

        model.addAttribute("notasPedido", notasPedido);

        return "notasPedido";
    }

}
