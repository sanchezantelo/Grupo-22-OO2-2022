package com.webservice.app.repositories;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.webservice.app.entities.Espacio;


@Repository("espacioRepository")
public interface IEspacioRepository extends JpaRepository<Espacio, Serializable>{

	public abstract Espacio findByIdEspacio(int idEspacio);
	
}
