package com.webservice.app.services.implementation;

import java.util.List;

import com.webservice.app.entities.NotaPedido;
import com.webservice.app.repositories.INotaPedidoRepository;
import com.webservice.app.services.INotaPedidoService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

public class NotaPedidoService implements INotaPedidoService {

    @Autowired()
    private INotaPedidoRepository repository;

    @Override
    @Transactional(readOnly = true)
    public NotaPedido findById(int id) {
        return repository.findById(id);
    }

    @Override
    @Transactional(readOnly = true)
    public List<NotaPedido> findAll() {
        return repository.findAll();
    }

    @Override
    public boolean insertOrUpdate(NotaPedido notaPedido) {
        return repository.save(notaPedido) != null ? true : false;
    }

    @Override
    @Transactional
    public boolean remove(int id) {
        try {
            repository.deleteById(id);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
    
}
