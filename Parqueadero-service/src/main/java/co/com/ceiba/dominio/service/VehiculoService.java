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
	public static final String NO_EXIST_VEHICLE = "El vehiculo no existe en la Base de datos. Por favor diligencie los datos y presione clic en Registrar";

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
	
	public Boolean existeVehiculo(String placa) {
		Optional<VehiculoEntity> vehiculoTmp = vehiculoRepository.obtenerPorId(placa);
		return vehiculoTmp.isPresent();
	}
	
	public Optional<VehiculoEntity> obtenerPorId(String placa) {
		Optional<VehiculoEntity> vehiculoTmp = vehiculoRepository.obtenerPorId(placa);
		
		if(!vehiculoTmp.isPresent()) {
			throw new ParqueaderoException(NO_EXIST_VEHICLE);
		}
		return vehiculoRepository.obtenerPorId(placa);
		
	}
}
