package co.com.ceiba.persistencia.repositoryimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import co.com.ceiba.dominio.Registro;
import co.com.ceiba.dominio.Vehiculo;
import co.com.ceiba.dominio.repository.AdministradorRepository;
import co.com.ceiba.persistencia.jpa.RegistroJpa;

@Repository
public class AdministradorRepositoryImpl implements AdministradorRepository {
	
	@Autowired
	RegistroJpa registroJpa;
	
	@Autowired
	RegistroRepositoryImpl registroRepositoyImp;

	//TODO Contar por tipo de Vehiculo
	@Override
	public int contarVehiculos(List<Vehiculo> vehiculos) {
		List<Registro> vehiculosEnParqueadero = registroJpa.findByfechaSalidaIsNull();
		return vehiculosEnParqueadero.size();
	}

	@Override
	public void registrarIngresoVehiculo(Registro registro) {
		registroRepositoyImp.registar(registro);
	}

	//TODO Como guardo en el mismo registro del vehiculo?
	@Override
	public void registrarSalidaVehiculo(Registro registro) {
		if(existeRegistroDeVehiculo(registro.getVehiculo())) {		
			registroRepositoyImp.registar(registro);
		}
	}

	@Override
	public Boolean existeRegistroDeVehiculo(Vehiculo vehiculo) {
		return (registroJpa.findByVehiculo(vehiculo.getPlaca())!= null);
	}
}
