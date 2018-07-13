package co.com.ceiba.dominio.service;

import java.util.List;

import co.com.ceiba.dominio.Registro;
import co.com.ceiba.dominio.Vehiculo;
import co.com.ceiba.dominio.repository.AdministradorRepository;

public class AdministradorService {
	
	AdministradorRepository administradorRepository;
	
	public AdministradorService(AdministradorRepository administradorRepository) {
		this.administradorRepository = administradorRepository;
	}
	
	public static final String VEHICLE_WITH_NULL_FIELDS = "Verifique que toda la informacion del Registro ha sido ingresada, no se permiten campos vacios";
	
	public int contarVehiculos (List<Vehiculo> vehiculos) {
		return administradorRepository.contarVehiculos(vehiculos);	
	}
	
	public void registrarIngresoVehiculo (Registro registro) {
		administradorRepository.registrarIngresoVehiculo(registro);
	}
	
	public void registrarSalidaVehiculo (Registro registro) {
		administradorRepository.registrarSalidaVehiculo(registro);
	}
}
