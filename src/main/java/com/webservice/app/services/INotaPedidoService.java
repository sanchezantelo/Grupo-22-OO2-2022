package com.webservice.app.services;

import java.util.List;

import com.webservice.app.entities.NotaPedido;
import com.webservice.app.models.NotaPedidoModel;

public interface INotaPedidoService {
    
    public NotaPedido findById(int id);
    
    public List<NotaPedido> findAll();

    public NotaPedidoModel insertOrUpdate(NotaPedido notaPedido);

    public boolean remove(int id);
}
