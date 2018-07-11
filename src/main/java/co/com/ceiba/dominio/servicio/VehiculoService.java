package co.com.ceiba.dominio.servicio;

import java.util.List;

import co.com.ceiba.dominio.Vehiculo;
import co.com.ceiba.dominio.excepcion.VehiculoException;
import co.com.ceiba.dominio.repositorio.VehiculoRepository;

public class VehiculoService {
	
	public static final String VEHICLE_WITH_NULL_FIELDS = "Verifique que toda la información del Vehiculo ha sido ingresada, no se permiten campos vacios";

	private VehiculoRepository vehiculoRepository;
	
	public VehiculoService(VehiculoRepository vehiculoRepository) {
		this.vehiculoRepository = vehiculoRepository;
	}
	
	public List<Vehiculo> listarVehiculos(){
		return vehiculoRepository.listar();
	}
	
	public void crearVehiculo(Vehiculo vehiculo) {
		if(!vehiculo.esValidoVehiculo()){
			throw new VehiculoException(VEHICLE_WITH_NULL_FIELDS);
		}else {
		vehiculoRepository.registar(vehiculo);
		}
	}	
}
