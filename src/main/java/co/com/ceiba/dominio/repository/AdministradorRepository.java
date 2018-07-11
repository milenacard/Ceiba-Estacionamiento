package co.com.ceiba.dominio.repository;

import java.util.List;

import co.com.ceiba.dominio.Vehiculo;

public interface AdministradorRepository {

	int contarVehiculos (List<Vehiculo> vehiculos);
	
	void registrarIngresoVehiculo (Vehiculo vehiculo);
	
	void registrarSalidaVehiculo (Vehiculo vehiculo);

}
