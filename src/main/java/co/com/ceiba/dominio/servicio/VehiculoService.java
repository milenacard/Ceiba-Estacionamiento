package co.com.ceiba.dominio.servicio;

import java.util.List;

import co.com.ceiba.dominio.Vehiculo;
import co.com.ceiba.dominio.repositorio.VehiculoRepository;

public class VehiculoService {

	
	private VehiculoRepository vehiculoRepository;
	
	public VehiculoService(VehiculoRepository vehiculoRepository) {
		this.vehiculoRepository = vehiculoRepository;
	}
	
	public List<Vehiculo> listarVehiculos(){
		return vehiculoRepository.listar();
	}
	
	public void crear(Vehiculo vehiculo) {
		//verificar que el vehiculo no tenga campos nullos
		//ej if(!esValidoVehiculo()){
		//return exception
		//}
		vehiculoRepository.registar(vehiculo);
	}
	
}
