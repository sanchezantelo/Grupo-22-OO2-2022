package com.webservice.app.services.implementation;

import java.util.List;

import com.webservice.app.entities.NotaPedido;
import com.webservice.app.models.NotaPedidoModel;
import com.webservice.app.repositories.INotaPedidoRepository;
import com.webservice.app.services.INotaPedidoService;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("notaPedidoService")
public class NotaPedidoService implements INotaPedidoService {

    private ModelMapper modelMapper = new ModelMapper();

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
    public NotaPedidoModel insertOrUpdate(NotaPedido notaPedido) {
        NotaPedido newNotaPedido = repository.save(notaPedido);
        return modelMapper.map(newNotaPedido, NotaPedidoModel.class);
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
