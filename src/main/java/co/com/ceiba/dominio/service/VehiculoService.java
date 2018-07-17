package co.com.ceiba.dominio.service;

import java.util.List;
import java.util.Optional;

import co.com.ceiba.dominio.Vehiculo;
import co.com.ceiba.dominio.excepcion.ParqueaderoException;
import co.com.ceiba.dominio.repository.VehiculoRepository;
import co.com.ceiba.persistencia.entity.VehiculoEntity;

public class VehiculoService {
	
	public static final String 	VEHICLE_INVALID = "Vehiculo invalido";
	public static final String EXIST_VEHICLE = "El vehiculo ya existe en la Base de datos";

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

		Optional<VehiculoEntity> vehiculoTmp = vehiculoRepository.obtenerPorId(vehiculo.getPlaca());
		if(!vehiculoTmp.isPresent()) {
			vehiculoRepository.crear(vehiculo);			
		}else {
			throw new ParqueaderoException(EXIST_VEHICLE);
		}		
	}
}
