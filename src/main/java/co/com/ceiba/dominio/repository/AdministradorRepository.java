package co.com.ceiba.dominio.repository;

import co.com.ceiba.dominio.Registro;
import co.com.ceiba.dominio.Vehiculo;


public interface AdministradorRepository {

	int contarVehiculos (int idTipoVehiculo);
	
	void registrar(Registro registro);
	
	Boolean existeRegistroDeVehiculo (Vehiculo vehiculo);
}
