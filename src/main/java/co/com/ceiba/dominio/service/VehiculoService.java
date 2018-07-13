package co.com.ceiba.dominio.service;

import java.util.List;

import co.com.ceiba.dominio.Vehiculo;
import co.com.ceiba.dominio.excepcion.ParqueaderoException;
import co.com.ceiba.dominio.repository.VehiculoRepository;

public class VehiculoService {
	
	public static final String 	VEHICLE_INVALID = "Vehiculo invalido";

	private VehiculoRepository vehiculoRepository;
	
	public VehiculoService(VehiculoRepository vehiculoRepository) {
		this.vehiculoRepository = vehiculoRepository;
	}
	
	public List<Vehiculo> listarVehiculos(){
		return vehiculoRepository.listar();
	}
	
	public void crearVehiculo(Vehiculo vehiculo) {
		if(!vehiculo.esValido()){
			throw new ParqueaderoException(VEHICLE_INVALID);
		}
		
		if (!vehiculoRepository.existeVehiculo(vehiculo)) {
			vehiculoRepository.crear(vehiculo);
		}
	}
}
