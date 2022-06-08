package com.webservice.app.helpers;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;

import com.webservice.app.entities.Espacio;

public class Funciones {
public static boolean esBisiesto(int anio) {
		
		if((anio % 4 == 0 && anio % 100 != 0) || (anio % 100 == 0 && anio % 400 == 0)){
			return true;
		}
		
		return false;
		
		
		
	}
	
	public static boolean esFechaValida(LocalDate fecha) {
		
		return esBisiesto(fecha.getYear()) && (fecha.getDayOfMonth() == 29 && fecha.getMonth().getValue() == 2 );
		
	}

	
	//Devuelve la fecha en formato dd/mm/aa
	public static String traerFechaCorta (LocalDate fecha) {
		
		return  fecha.format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
   
	
	}
	// Retorna “hh:mm”
	public static String traerHoraCorta (LocalTime hora) {
	
		return hora.format(DateTimeFormatter.ofPattern("HH:mm"));
		
	}
	//retorna true si el dia es habil (entre lunes y viernes)
	public static boolean esDiaHabil(LocalDate fecha) {

			int d= fecha.getDayOfWeek().getValue();
			return ((d>=1) &&( d<=5));
	
	}
	
	public static boolean esSabado(LocalDate fecha) {

			return fecha.getDayOfWeek().getValue()==6;
	
	}
	
	public static String traerDiaDeLaSemana(LocalDate fecha) {
		
		String diaSemana="";
		
		switch (fecha.getDayOfWeek().getValue()) {
			  case 1:
			    diaSemana="Lunes";
			    break;
			  case 2:
				 diaSemana="Martes";
				 break;
			  case 3:
				 diaSemana="Miercoles";
				 break;
			  case 4:
				 diaSemana="Jueves";
				 break;
			  case 5:
				 diaSemana="Viernes";
				 break;
			  case 6:
				 diaSemana="Sabado";
				 break;
			  case 7:
				 diaSemana="Domingo";
				 break;
		}
		
		return diaSemana;
	}
	
	
	public static String traerMesEnLetras(LocalDate fecha) {
		
		String mes ="";
		
		switch (fecha.getMonthValue()) {

		  case 1:
		    mes="Enero";
		    break;
		  case 2:
			 mes="Febrero";
			 break;
		  case 3:
			 mes="Marzo";
			 break;
		  case 4:
			 mes="Abril";
			 break;
		  case 5:
			 mes="Mayo";
			 break;
		  case 6:
			 mes="Junio";
			 break;
		  case 7:
			 mes="Julio";
			 break;
		  case 8:
		    mes="Agosto";
		    break;
		  case 9:
			 mes="Septiembre";
			 break;
		  case 10:
			 mes="Octubre";
			 break;
		  case 11:
			 mes="Noviembre";
			 break;
		  case 12:
			 mes="Diciembre";
			 break;
		}
		return mes;
		
	}
	
	//Debe retornar la fecha en formato: Lunes 19 de Octubre de 2020
	public static String traerFechaLarga(LocalDate fecha) {
		
		return  traerDiaDeLaSemana(fecha) + " "+fecha.getDayOfMonth()+" de "+traerMesEnLetras(fecha)+" de "+fecha.getYear();
		
	}
	
	public static int traerCantDiasDeUnMes (int anio, int mes) throws Exception{
		
		int numeroDias=0;
		 
        switch(mes){
            case 1:
            case 3:
            case 5:
            case 7:
            case 8:
            case 10:
            case 12:
                numeroDias=31;
                break;
            case 4:
            case 6:
            case 9:
            case 11:
                numeroDias=30;
                break;
            case 2:
                if(Funciones.esBisiesto(anio)){
                    numeroDias=29;
                }else{
                    numeroDias=28;
                }
                break;
            default: throw new Exception("El mes no es valido");
 
        }
 
        return numeroDias;
	}
	
	public static double aproximar2Decimal(double valor) {
	       
		   double parteEntera, resultado;
	       resultado = valor;
	       parteEntera = Math.floor(resultado);
	       resultado=(resultado-parteEntera)*Math.pow(10, 2);
	       resultado=Math.round(resultado);
	       resultado=(resultado/Math.pow(10, 2))+parteEntera;
	        
	       return resultado;
		
	}
	
	public static boolean esNumero(char c) {
		
		return Character.isDigit(c);
		
	}

	public static boolean esLetra(char c) {
		
		return !Character.isDigit(c);
	}
	
	public static boolean esCadenaNros(String cadena) {
		

        boolean resultado;

        try {
            Integer.parseInt(cadena);
            resultado = true;
        } catch (NumberFormatException excepcion) {
            resultado = false;
        }

        return resultado;
		
	
	}
	
	public static boolean esCadenaLetras(String cadena) {
		
        return !esCadenaNros(cadena);
	
	}
	
	public static List<LocalDate> listadoDias(LocalDate inicioCuatrimestre,LocalDate finCuatrimestre,int diaSolicitado,int presencialidad){
		
		
		int diaSemanaComienzo = inicioCuatrimestre.getDayOfWeek().getValue();
		
		LocalDate inicioClase = inicioCuatrimestre;	
		
		List<LocalDate> diasCuatrimestre = new ArrayList<>();
		
		if(diaSolicitado>diaSemanaComienzo) {
		
			inicioClase = inicioClase.plusDays(diaSolicitado-diaSemanaComienzo);
		
		}else if( diaSemanaComienzo > diaSolicitado){
			
			inicioClase = inicioClase.plusDays( 7 - (diaSemanaComienzo - diaSolicitado) );
		}
		
		//calculo las clases
		long cantidadClases=ChronoUnit.DAYS.between(inicioCuatrimestre, finCuatrimestre)/7;
		
		int sumaDias = 7;	
		
		if(presencialidad==50) {
			cantidadClases = cantidadClases/2;
			sumaDias=14;
		}
		
		
		for(int i=0 ; i < cantidadClases ;i++) {
			
			diasCuatrimestre.add(inicioClase);
			
			inicioClase = inicioClase.plusDays(sumaDias);
		
		}
		
		return diasCuatrimestre;
	
	}
	
	public static List<LocalDate> generarListadoDias(int presencialidad, int diaSolicitado,LocalDate inicioCuatrimestre,LocalDate finCuatrimestre) {
		
			List<LocalDate> listadoDias = new ArrayList<>();
			int diaSemanaComienzo = inicioCuatrimestre.getDayOfWeek().getValue();
			LocalDate inicioClase = inicioCuatrimestre;	
			
			
			if(diaSolicitado>diaSemanaComienzo) {
			
				inicioClase = inicioClase.plusDays(diaSolicitado-diaSemanaComienzo);
			
			}else if( diaSemanaComienzo > diaSolicitado){
				
				inicioClase = inicioClase.plusDays( 7 - (diaSemanaComienzo - diaSolicitado) );
			}
			
			long cantidadClases=ChronoUnit.DAYS.between(inicioCuatrimestre, finCuatrimestre)/7;
			
			int sumaDias = 7;		
			
			switch(presencialidad) {
				case 50 :cantidadClases = cantidadClases/2;
					sumaDias=14;
				break;
				case 25 :cantidadClases = cantidadClases/4;
					sumaDias=28;
				break;
			}
	
			
			for(int i=0 ; i < cantidadClases ;i++) {
				
				listadoDias.add(inicioClase);
				
				inicioClase = inicioClase.plusDays(sumaDias);
			
			}
		
		
		return listadoDias;
	}

}
