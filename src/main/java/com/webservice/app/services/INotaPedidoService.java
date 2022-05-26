package com.webservice.app.services;

import java.util.List;

import com.webservice.app.entities.NotaPedido;

public interface INotaPedidoService {
    
    public NotaPedido findById(int id);
    
    public List<NotaPedido> findAll();

    public boolean insertOrUpdate(NotaPedido notaPedido);

    public boolean remove(int id);
}
