package com.webservice.app.services.implementation;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;


import com.webservice.app.entities.Aula;
import com.webservice.app.entities.Espacio;
import com.webservice.app.entities.TipoTurnos;
import com.webservice.app.helpers.Funciones;
import com.webservice.app.repositories.IEspacioRepository;
import com.webservice.app.services.IAulaService;
import com.webservice.app.services.IEspacioService;
import com.webservice.app.services.INotaPedidoService;


@Service("espacioService")
public class EspacioService implements IEspacioService{

	@Autowired
	@Qualifier("espacioRepository")
	private IEspacioRepository espacioRepository;
	
	@Autowired
	@Qualifier("aulaService")
	private IAulaService aulaService;
	
	@Autowired
	@Qualifier("notaPedidoService")
	private INotaPedidoService notaPedidoService;
	
	private ModelMapper modelMapper = new ModelMapper();

	public List<Espacio> traerEspacios(Aula aula) {
		return espacioRepository.findByAulaAndActivo(aula,true);
	}
	
	public void agregarEspacios(LocalDate desde,LocalDate hasta) throws Exception{
		
			
		List<Aula> aulas = aulaService.traerAulas();
		
		List<Espacio> espacios = new ArrayList<>();
		
		if(aulas.isEmpty()) throw new Exception("No hay aulas cargadas en el sistema");
		
		
		List<Espacio> espaciosActivos = espacioRepository.traerEspaciosActivos();

		
		while(desde.isBefore(hasta) || desde.isEqual(hasta) ) {
		
			for(Aula aula:aulas) {
				for(TipoTurnos turno:TipoTurnos.values()) {
					if(Funciones.esDiaHabil(desde) || Funciones.esSabado(desde)) {
						
						if(espacioRepository.findByFechaAndTurnoAndAula(desde, turno,aula)!=null) throw new Exception("Ya existe el espacio con fecha "+desde+", turno "+turno+" para el aula "+aula.getNumero()+" del edificio "+aula.getEdificio().getEdificio());
						Espacio espacio = new Espacio(desde, turno, aula, true,true);
						espacios.add(espacio);

					}
				}

			}
			
			desde = desde.plusDays(1);
		}
		
		if(this.insertarOActualizar(espacios) ) {
			if(!espaciosActivos.isEmpty()) this.DesactivarCalendarioAnterior(espaciosActivos);
		}else {
			throw new Exception("No se pudo completar la transaccion");
		}

	}


	public boolean insertarOActualizar(Espacio espacio) {
	    return espacioRepository.save(espacio) != null ? true : false;
	}
	
	public boolean insertarOActualizar(List<Espacio> espacios) {
	    return espacioRepository.saveAll(espacios) != null ? true : false;
	}
	
	public void DesactivarCalendarioAnterior(List<Espacio> espaciosActivos){
		espaciosActivos.stream().forEach(espacio -> espacio.setActivo(false));
		this.insertarOActualizar(espaciosActivos);
	}
}
