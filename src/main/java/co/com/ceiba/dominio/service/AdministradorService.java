package co.com.ceiba.dominio.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.com.ceiba.dominio.Vehiculo;
import co.com.ceiba.dominio.excepcion.VehiculoException;
import co.com.ceiba.dominio.repository.AdministradorRepository;

@Service
public class AdministradorService {
	
	@Autowired
	AdministradorRepository administradorRepository;
	
	public static final String VEHICLE_WITH_NULL_FIELDS = "Verifique que toda la informacion del Vehiculo ha sido ingresada, no se permiten campos vacios";
	
	public int contarVehiculos (List<Vehiculo> vehiculos) {
		return administradorRepository.contarVehiculos(vehiculos);	
	}
	
	public void registrarIngresoVehiculo (Vehiculo vehiculo) {
		if(!vehiculo.esValido()){
			throw new VehiculoException(VEHICLE_WITH_NULL_FIELDS);
		}else {
			administradorRepository.registrarIngresoVehiculo(vehiculo);
		}
	}
	
	public void registrarSalidaVehiculo (Vehiculo vehiculo) {
		administradorRepository.registrarSalidaVehiculo(vehiculo);
	}
}
