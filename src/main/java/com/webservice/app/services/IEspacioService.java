package com.webservice.app.services;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.stereotype.Service;

import com.webservice.app.entities.NotaPedido;
import com.webservice.app.entities.Aula;
import com.webservice.app.entities.Curso;
import com.webservice.app.entities.Espacio;
import com.webservice.app.entities.TipoTurnos;



@Service
public interface IEspacioService {
	public List<Espacio> traerEspacios(Aula aula);
	public List<Espacio> traerEspacios(Curso curso,Aula aula) throws Exception;
	public List<Espacio> traerCuatrimestreActivo();
	public List<Aula> traerAulasDisponiblesPorFecha(LocalDate fecha, List<Aula> aulas,TipoTurnos turno) throws Exception;
	public List<Aula> traerAulasDisponiblesPorFecha(List<Aula> aulas,Curso curso) throws Exception;
	public boolean insertarOActualizar(Espacio espacio);
	public boolean insertarOActualizar(List<Espacio> espacios);
	public void agregarEspacios(LocalDate desde,LocalDate hasta) throws Exception;
	public void AsignarEspacios(int idNotaPedido, int idAula) throws Exception;
	public void ModificarEspacio(Espacio espacio,NotaPedido notaPedido,Aula aula);
	public void DesactivarCuatrimestreAnterior(List<Espacio> espaciosActivos);
}