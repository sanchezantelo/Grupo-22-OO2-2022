package com.webservice.app.repositories;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.webservice.app.entities.Departamento;


@Repository("departamentoRepository")
public interface IDepartamentoRepository extends JpaRepository<Departamento, Serializable>{
	
	public abstract Departamento findByIdDepartamento(int idDepartamento);

}
