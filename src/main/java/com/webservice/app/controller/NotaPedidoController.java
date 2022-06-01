package com.webservice.app.controller;

import com.webservice.app.entities.NotaPedido;
import com.webservice.app.services.IAulaService;
import com.webservice.app.services.INotaPedidoService;
import com.webservice.app.services.IUsuarioService;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import lombok.var;
import lombok.extern.slf4j.Slf4j;

@Controller
@RequestMapping("/notaPedido")
@Slf4j
public class NotaPedidoController {
	Logger logger = LoggerFactory.getLogger(NotaPedidoController.class);

    @Autowired
    @Qualifier("notaPedidoService")
    private INotaPedidoService notaPedidoService;

    @Autowired
    @Qualifier("usuarioService")
    private IUsuarioService usuarioService;

    // @Autowired
    // @Qualifier("materiaService")
    // private IMateriaService materiaService;

    @Autowired
    @Qualifier("aulaService")
    private IAulaService aulaService;

    @GetMapping("/notasPedido")
    public String NotasPedido(Model model) {
    	logger.info("CONTROLLER [NotasPedido]");
    	logger.debug("METHOD [NotasPedido]");

        List<NotaPedido> notasPedido = notaPedidoService.findAll();

        model.addAttribute("notaPedidoService", notasPedido);

        return "notasPedido";
    }

}
