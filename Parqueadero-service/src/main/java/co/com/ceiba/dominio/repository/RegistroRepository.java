package co.com.ceiba.dominio.repository;

import java.util.List;

import co.com.ceiba.dominio.Registro;

public interface RegistroRepository {
	
	void registar (Registro registro);
	
	List<Registro> listar();
	
	Registro obtenerRegistro(String placa);
	
	int numeroVehiculosEnParqueadero(int idTipoVehiculo);
	
	void registrarSalida(Registro registro);
}
