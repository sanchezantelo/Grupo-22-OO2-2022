package com.webservice.app.repositories;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.webservice.app.entities.Aula;
import com.webservice.app.entities.Espacio;


@Repository("espacioRepository")
public interface IEspacioRepository extends JpaRepository<Espacio, Serializable>{

	public abstract Espacio findByIdEspacio(int idEspacio);
	public abstract List<Espacio> findByAulaAndActivo(Aula aula,boolean activo);
	@Query("SELECT e FROM Espacio e WHERE e.activo=1")
	public abstract List<Espacio> traerEspaciosActivos();
	public abstract Espacio findByFechaAndTurnoAndAula(LocalDate fecha, char turno, Aula aula);
}
