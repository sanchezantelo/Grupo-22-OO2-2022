package com.webservice.app.repositories;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.webservice.app.entities.Materia;


@Repository("materiaRepository")
public interface IMateriaRepository extends JpaRepository<Materia, Serializable>{
	
	public abstract Materia findByIdMateria(int idMateria);

}
