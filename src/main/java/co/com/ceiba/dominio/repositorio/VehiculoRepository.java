package co.com.ceiba.dominio.repositorio;

import java.util.List;

import co.com.ceiba.dominio.Vehiculo;

public interface VehiculoRepository {
	
	void registar (Vehiculo vehiculo);
	
	List<Vehiculo> listar();

}
