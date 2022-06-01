package com.webservice.app.repositories;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.webservice.app.entities.Carrera;


@Repository("carreraRepository")
public interface ICarreraRepository extends JpaRepository<Carrera, Serializable>{
	
	public abstract Carrera findByIdCarrera(int idCarrera);

}
