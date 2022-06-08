package com.webservice.app.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.webservice.app.entities.NotaPedido;

public interface INotaPedidoRepository extends JpaRepository<NotaPedido, Integer>{
	
	public NotaPedido findById(int idNotaPedido);

	@Query("SELECT n FROM NotaPedido n WHERE n.aulaAsignada IS NULL")
	public List<NotaPedido> findNotasPendientes();

	@Query("SELECT n FROM NotaPedido n WHERE n.aulaAsignada IS NOT NULL")
    public List<NotaPedido> findNotasAsignadas();

}
