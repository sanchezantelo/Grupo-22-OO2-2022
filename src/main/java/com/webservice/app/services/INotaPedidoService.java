package com.webservice.app.services;

import java.util.List;

import com.webservice.app.entities.NotaPedido;

public interface INotaPedidoService {
    
    public NotaPedido findById(int id);
    
    public List<NotaPedido> findAll();

    public List<NotaPedido> findNotasPendientes();

    public List<NotaPedido> findNotasAsignadas();

    public boolean insertOrUpdate(NotaPedido notaPedido);

    public boolean remove(int id);
}
