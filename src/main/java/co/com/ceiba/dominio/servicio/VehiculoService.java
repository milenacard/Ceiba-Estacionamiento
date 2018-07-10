package co.com.ceiba.dominio.servicio;

import java.util.List;

import co.com.ceiba.dominio.Vehiculo;
import co.com.ceiba.dominio.excepcion.VehiculoException;
import co.com.ceiba.dominio.repositorio.VehiculoRepository;

public class VehiculoService {
	
	public static final String VEHICULO_NO_VALIDO = "Vehiculo no valido";

	private VehiculoRepository vehiculoRepository;
	
	public VehiculoService(VehiculoRepository vehiculoRepository) {
		this.vehiculoRepository = vehiculoRepository;
	}
	
	public List<Vehiculo> listarVehiculos(){
		return vehiculoRepository.listar();
	}
	
	public void crear(Vehiculo vehiculo) {
		if(!vehiculo.esValidoVehiculo()){
			throw new VehiculoException(VEHICULO_NO_VALIDO);
		}else {
		vehiculoRepository.registar(vehiculo);
		}
	}	
}
