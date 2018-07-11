package co.com.ceiba.dominio.repository;

import java.util.List;

import co.com.ceiba.dominio.Vehiculo;

public interface VehiculoRepository {
	
	void crear (Vehiculo vehiculo);
	
	List<Vehiculo> listar();

}
