package com.webservice.app.controller;

import com.webservice.app.services.IAulaService;
import com.webservice.app.services.IMateriaService;
import com.webservice.app.services.INotaPedidoService;
import com.webservice.app.services.IUsuarioService;

// import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/notaPedido")
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

	// private ModelMapper modelMapper = new ModelMapper();

    
}
