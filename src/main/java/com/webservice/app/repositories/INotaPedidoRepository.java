package com.webservice.app.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.webservice.app.entities.NotaPedido;

public interface INotaPedidoRepository extends JpaRepository<NotaPedido, Integer>{
	
	public NotaPedido findById(int idNotaPedido);
	
}
