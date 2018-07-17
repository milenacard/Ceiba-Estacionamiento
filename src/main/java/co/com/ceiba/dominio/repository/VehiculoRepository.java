package co.com.ceiba.dominio.repository;

import java.util.List;
import java.util.Optional;

import co.com.ceiba.dominio.Vehiculo;
import co.com.ceiba.persistencia.entity.VehiculoEntity;

public interface VehiculoRepository {
	
	void crear (Vehiculo vehiculo);
	
	List<Vehiculo> listar();
	
	Optional<VehiculoEntity>  obtenerPorId (String placa);

}
