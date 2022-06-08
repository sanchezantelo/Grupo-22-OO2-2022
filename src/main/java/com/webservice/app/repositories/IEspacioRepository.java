package com.webservice.app.repositories;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.webservice.app.entities.Aula;
import com.webservice.app.entities.Espacio;
import com.webservice.app.entities.TipoTurnos;


@Repository("espacioRepository")
public interface IEspacioRepository extends JpaRepository<Espacio, Serializable>{

	public abstract Espacio findByIdEspacio(int idEspacio);
	
	public abstract List<Espacio> findByAulaAndActivo(Aula aula,boolean activo);

	@Query("SELECT e FROM Espacio e WHERE e.activo=1")
	public abstract List<Espacio> traerEspaciosActivos();
	
	public abstract Espacio findByFechaAndTurnoAndAulaAndActivo(LocalDate fecha, TipoTurnos turno, Aula aula,boolean activo);
	
	@Query("SELECT e FROM Espacio e WHERE e.libre=1 and aula=(:aula) and turno=(:turno) and fecha in (:fechas)")
	public abstract List<Espacio> traerEspaciosPorFechaTurnoYAula(List<LocalDate> fechas,Aula aula,TipoTurnos turno);
	
	@Query(nativeQuery = true,value="SELECT * FROM Espacio e where activo = 1 order by id_espacio ASC LIMIT 1")
	public abstract Espacio inicioCuatrimestre();
	
	@Query(nativeQuery = true,value="SELECT * FROM Espacio e where activo = 1 order by id_espacio DESC LIMIT 1")
	public abstract Espacio finCuatrimestre();
	
	@Query("SELECT e FROM Espacio e WHERE e.libre=1 and e.fecha=(:fecha) and e.turno=(:turno) and e.aula = (:aula)")
	public abstract Espacio buscarAulasLibresPorFechaYTurno(LocalDate fecha,Aula aula,TipoTurnos turno);
}
