package com.webservice.app.services.implementation;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.webservice.app.entities.Curso;
import com.webservice.app.entities.Final;
import com.webservice.app.entities.NotaPedido;
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
	
	
	//Trae espacios por aula
	public List<Espacio> traerEspacios(Aula aula) {
		return espacioRepository.findByAulaAndActivo(aula,true);
	}
	
	//Trae espacios para las notas de pedido de tipo Curso
	public List<Espacio> traerEspacios(Curso curso,Aula aula) throws Exception{
	
		List<Espacio> inicioFin = traerCuatrimestreActivo();		
		if (inicioFin.isEmpty())  throw new Exception("No existen espacios activos disponibles");
		
		LocalDate inicioCuatrimestre = inicioFin.get(0).getFecha();
		LocalDate finCuatrimestre = inicioFin.get(1).getFecha();
		
		List<LocalDate> diasClases = Funciones.generarListadoDias(curso.getPresencialidad(), curso.getDiaSemana(),inicioCuatrimestre,finCuatrimestre);
		return	espacioRepository.traerEspaciosPorFechaTurnoYAula(diasClases, aula, curso.getTurno());
	}
	
	//Trae el cuatrimestre activo
	public List<Espacio> traerCuatrimestreActivo(){
		List<Espacio> inicioFin = new ArrayList<>();
		Espacio inicio = espacioRepository.inicioCuatrimestre();
		Espacio fin = espacioRepository.finCuatrimestre();
		if(inicio!=null) inicioFin.add(inicio);
		if(fin!=null) inicioFin.add(fin);
		return inicioFin;
	
	}
	
	//Trae las aulas para finales
	public List<Aula> traerAulasDisponiblesPorFecha(LocalDate fecha, List<Aula> aulas,TipoTurnos turno) throws Exception{
		
		Iterator <Aula> aulasIterador = aulas.iterator();
		while (aulasIterador.hasNext()) {
			Aula aula = aulasIterador.next();
			if(espacioRepository.buscarAulasLibresPorFechaYTurno(fecha,aula, turno) == null) {
				aulasIterador.remove();
			}
		}
		
		if ( aulas.isEmpty() ) throw new Exception("No se encontraron aulas para la fecha y el turno indicado");
		return  aulas;
	 
	}
	
	//Trae las aulas para curso
	public List<Aula> traerAulasDisponiblesPorFecha(List<Aula> aulas,Curso curso) throws Exception{
		
		List<Espacio> inicioFin = traerCuatrimestreActivo();
		
		if (inicioFin.isEmpty())  throw new Exception("No existen espacios activos disponibles");
		
		LocalDate inicioCuatrimestre = inicioFin.get(0).getFecha();
		LocalDate finCuatrimestre = inicioFin.get(1).getFecha();
		
		List<LocalDate> diasClases = Funciones.generarListadoDias(curso.getPresencialidad(), curso.getDiaSemana(),inicioCuatrimestre,finCuatrimestre);
		
		Iterator <Aula> aulasIterador = aulas.iterator();
		while (aulasIterador.hasNext()) {
			Aula aula = aulasIterador.next();
			if(espacioRepository.traerEspaciosPorFechaTurnoYAula(diasClases, aula, curso.getTurno()).size() < diasClases.size()) {
				aulasIterador.remove();
			}			
		}
		if ( aulas.isEmpty() ) throw new Exception("No se encontraron aulas para la fecha y el turno indicado");
		return  aulas;
		
	}
	

	public boolean insertarOActualizar(Espacio espacio) {
	    return espacioRepository.save(espacio) != null ? true : false;
	}
	
	public boolean insertarOActualizar(List<Espacio> espacios) {
	    return espacioRepository.saveAll(espacios) != null ? true : false;
	}
	
	//Genera los espacios para el cuatrimestre
	public void agregarEspacios(LocalDate desde,LocalDate hasta) throws Exception {
	
		List<Aula> aulas = aulaService.traerAulas();
		
		List<Espacio> espacios = new ArrayList<>();
		
		if(aulas.isEmpty()) throw new Exception("No hay aulas cargadas en el sistema");
		
		
		List<Espacio> espaciosActivos = espacioRepository.traerEspaciosActivos();

		
		while(desde.isBefore(hasta) || desde.isEqual(hasta) ) {
		
			for(Aula aula:aulas) {
				for(TipoTurnos turno:TipoTurnos.values()) {
					if(Funciones.esDiaHabil(desde) || Funciones.esSabado(desde)) {
						
						if(espacioRepository.findByFechaAndTurnoAndAulaAndActivo(desde, turno,aula,true)!=null) throw new Exception("Ya existe el espacio con fecha "+desde+", turno "+turno+" para el aula "+aula.getNumero()+" del edificio "+aula.getEdificio().getEdificio());
						Espacio espacio = new Espacio(desde, turno, aula, true,true);
						espacios.add(espacio);

					}
				}

			}	
			desde = desde.plusDays(1);
		}
		
		if(this.insertarOActualizar(espacios) ) {
			if(!espaciosActivos.isEmpty()) this.DesactivarCuatrimestreAnterior(espaciosActivos);
		}else {
			throw new Exception("No se pudo completar la transaccion");
		}

	}
	//Asigna el espacio a una nota Pedido
	public void AsignarEspacios(int idNotaPedido, int idAula) throws Exception{
	
		NotaPedido notaPedido = notaPedidoService.findById(idNotaPedido);
		Aula aula = aulaService.traerAula(idAula);
		
		if(notaPedido instanceof Final) {
			Final notaFinal= (Final) notaPedido;
			Espacio espacio = espacioRepository.findByFechaAndTurnoAndAulaAndActivo(notaFinal.getFechaExamen(),notaFinal.getTurno(),aula,true);
			ModificarEspacio(espacio,notaPedido,aula);
		
		}else {
			Curso curso = (Curso) notaPedido;
			List<Espacio> espacios = this.traerEspacios(curso, aula);
			for(Espacio espacio:espacios) {
				ModificarEspacio(espacio,notaPedido,aula);
			}
		}
	}
	//Modifica el espacio y la nota peiddo. Al espacio le setea nota pedido y lo pone en ocupado, y a la nota le pone el aula asignada
	public void ModificarEspacio(Espacio espacio,NotaPedido notaPedido,Aula aula){
		
		espacio.setLibre(false);
		espacio.setNotaPedido(notaPedido);
	
		if(this.insertarOActualizar(espacio)) 
		{
			notaPedido.setAulaAsignada(aula);
			if(notaPedido instanceof Curso) {
				
				Curso curso = (Curso) notaPedido;
				
				notaPedidoService.insertOrUpdate(curso);
				
			}else {
				Final notaFinal = (Final) notaPedido;
				notaPedidoService.insertOrUpdate(notaFinal);
			}
			
		}
	}
	
	//Desactiva los espacios del cuatrimestre anterior. Cuando se crea un nuevo listado de espacios, se desactivan los anteriores
	public void DesactivarCuatrimestreAnterior(List<Espacio> espaciosActivos){
		espaciosActivos.stream().forEach(espacio -> espacio.setActivo(false));
		this.insertarOActualizar(espaciosActivos);
	}
		
	
}
