package com.webservice.app.repositories;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.webservice.app.entities.Laboratorio;


@Repository("laboratorioRepository")
public interface ILaboratorioRepository extends JpaRepository<Laboratorio, Serializable>{

	@Query("SELECT l FROM Laboratorio l WHERE l.cantSillas>=cantSillas")
	public abstract List<Laboratorio> traerAulasPorAlumnos(int cantSillas);

}
