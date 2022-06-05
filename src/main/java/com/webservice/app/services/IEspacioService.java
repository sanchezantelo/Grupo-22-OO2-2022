package com.webservice.app.services;

import java.time.LocalDate;
import java.util.List;

import org.springframework.stereotype.Service;

import com.webservice.app.entities.Aula;
import com.webservice.app.entities.Espacio;


@Service
public interface IEspacioService {
	public List<Espacio> traerEspacios(Aula aula);
	public void agregarEspacios(LocalDate desde,LocalDate hasta) throws Exception;
    public boolean insertarOActualizar(Espacio espacio);  
    public boolean insertarOActualizar(List<Espacio> espacios);
	public void DesactivarCalendarioAnterior(List<Espacio> espaciosActivos);
}