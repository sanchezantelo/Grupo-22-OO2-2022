package com.webservice.app.repositories;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.webservice.app.entities.Edificio;

@Repository("edificioRepository")
public interface IEdificioRepository extends JpaRepository<Edificio, Serializable> {

	public abstract Edificio findByIdEdificio(@Param("idEdificio") int idEdificio);
	
	public abstract List<Edificio> findAll();

}
