package co.com.ceiba.dominio.repository;

import java.util.List;
import co.com.ceiba.dominio.Registro;
import co.com.ceiba.dominio.Vehiculo;


public interface AdministradorRepository {

	int contarVehiculos (List<Vehiculo> vehiculos);
	
	void registrarIngresoVehiculo (Registro registro);
	
	void registrarSalidaVehiculo (Registro registro);
	
	Boolean existeRegistroDeVehiculo (Vehiculo vehiculo);
}
