package co.com.ceiba.persistencia.repositoryimpl;

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

	@Override
	public void registrar(Registro registro) {
		registroRepositoyImp.registar(registro);
	}

	@Override
	public Boolean existeRegistroDeVehiculo(Vehiculo vehiculo) {
		return (registroJpa.findByVehiculo(vehiculo.getPlaca())!= null);
	}

	@Override
	public int contarVehiculos(int idTipoVehiculo) {
		return registroJpa.contarVehiculos(idTipoVehiculo);
		
	}
}
