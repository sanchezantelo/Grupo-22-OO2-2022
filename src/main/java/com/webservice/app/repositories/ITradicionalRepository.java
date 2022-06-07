package com.webservice.app.repositories;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.webservice.app.entities.Tradicional;


@Repository("tradicionalRepository")
public interface ITradicionalRepository extends JpaRepository<Tradicional, Serializable>{
	
	public abstract Tradicional findByIdAula(int idAula);
	
	@Query("SELECT t FROM Tradicional t WHERE t.cantBancos>=cantBancos")
	public abstract List<Tradicional> traerAulasPorAlumnos(int cantBancos);
}
