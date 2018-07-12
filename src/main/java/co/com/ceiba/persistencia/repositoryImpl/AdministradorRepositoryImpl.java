package co.com.ceiba.persistencia.repositoryimpl;

import java.util.List;

import org.springframework.stereotype.Repository;
import co.com.ceiba.dominio.Vehiculo;
import co.com.ceiba.dominio.repository.AdministradorRepository;

@Repository
public class AdministradorRepositoryImpl implements AdministradorRepository {

	@Override
	public int contarVehiculos(List<Vehiculo> vehiculos) {
		// TODO Realizar una consulta SQL a la BD para ver quienes tienen fecha de salida  y total a pagar en Null
		return 0;
	}

	@Override
	public void registrarIngresoVehiculo(Vehiculo vehiculo) {
		
		// TODO llamar constructor con atributos para ingresar vehiculo
		// Vehiculo y fecha de ingreso
		
	}

	@Override
	public void registrarSalidaVehiculo(Vehiculo vehiculo) {
		// TODO Llamar constructur para ingresar atributos de salida
		// Fecha salida y total a pagar
		
	}
}
