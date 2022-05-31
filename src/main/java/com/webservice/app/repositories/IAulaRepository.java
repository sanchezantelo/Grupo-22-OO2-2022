package com.webservice.app.repositories;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.webservice.app.entities.Aula;


@Repository("aulaRepository")
public interface IAulaRepository extends JpaRepository<Aula, Serializable>{
	
	public abstract Aula findByIdAula(int idAula);

}
