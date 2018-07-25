package co.com.ceiba.dominio;

import java.util.ArrayList;
import java.util.List;

import co.com.ceiba.dominio.excepcion.ParqueaderoException;

public class Parqueadero {
	
	private static List<CeldaCarros> lstCeldasCarros = new ArrayList<>(20);
	private static List<CeldaMotos> lstCeldasMotos = new ArrayList<>(10);

	
	
	public static int cantMaximaCelda(int tipoVehiculo) {
			int cantidadMaxima = 0;
			switch(tipoVehiculo) {
			case 1:
				cantidadMaxima = lstCeldasMotos.size();
				break;
			case 2:
				cantidadMaxima = lstCeldasCarros.size();
				break;
			default:
				throw new ParqueaderoException("Tipo de vehiculo no implementado");
			}
			
			return cantidadMaxima;
		}
	
	
}
