package com.webservice.app.services.implementation;

import java.util.List;

import com.webservice.app.entities.Curso;
import com.webservice.app.entities.Final;
import com.webservice.app.entities.NotaPedido;
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
    @Transactional(readOnly = true)
    public List<NotaPedido> findNotasPendientes() {
        return repository.findNotasPendientes();
    }

    @Override
    @Transactional(readOnly = true)
    public List<NotaPedido> findNotasAsignadas() {
        return repository.findNotasAsignadas();
    }

    @Override
    public boolean insertOrUpdate(NotaPedido notaPedido) {
        try {
            if(notaPedido instanceof Curso) {
                modelMapper.map(notaPedido, Curso.class);
                repository.save(notaPedido);
            } else if(notaPedido instanceof Final) {
                modelMapper.map(notaPedido, Final.class);
                repository.save(notaPedido);
            }
            return true;
        } catch(Exception e) {
            return false;
        }
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
