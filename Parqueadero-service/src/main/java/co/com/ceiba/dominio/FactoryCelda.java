package co.com.ceiba.dominio;

import co.com.ceiba.dominio.excepcion.ParqueaderoException;

public class FactoryCelda {
	
	public static Celda obtenerCelda(int tipoVehiculo) {
		Celda celda = null;
		switch(tipoVehiculo) {
		case 1:
			celda = new CeldaMotos();
			break;
		case 2:
			celda = new CeldaCarros();
			break;
		default:
			throw new ParqueaderoException("Tipo de vehiculo no implementado");
		}
		
		return celda;
	}

}
