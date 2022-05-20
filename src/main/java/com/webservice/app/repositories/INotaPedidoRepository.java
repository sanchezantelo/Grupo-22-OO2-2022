package com.webservice.app.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.webservice.app.entities.NotaPedido;

public interface INotaPedidoRepository extends JpaRepository<NotaPedido, Integer>{
	
	@Query("FROM nota_pedido np WHERE np.idNotaPedido = (:idNotaPedido)")
	public NotaPedido findById(int idNotaPedido);
	
}
