package co.com.ceiba.persistencia.repositoryimpl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import co.com.ceiba.dominio.Registro;
import co.com.ceiba.dominio.repository.RegistroRepository;
import co.com.ceiba.persistencia.builder.RegistroBuilder;
import co.com.ceiba.persistencia.entity.RegistroEntity;
import co.com.ceiba.persistencia.jpa.RegistroJpa;

@Repository
public class RegistroRepositoryImpl implements RegistroRepository{

	@Autowired
	RegistroJpa registroJpa;
	
	@Override
	public void registar(Registro registro) {
		registroJpa.saveAndFlush(RegistroBuilder.convertirAEntidad(registro));
	}

	@Override
	public List<Registro> listar() {
		List<Registro> registros = new ArrayList<>();
		List<RegistroEntity> reg = registroJpa.findAll();
		for (RegistroEntity registroEntity : reg) {
			registros.add(RegistroBuilder.convertirADominio(registroEntity));
		}
		return registros;
	}

	@Override
	public Registro obtenerRegistro(String placa) {
		Optional<RegistroEntity> registroTmp  = registroJpa.buscarVehiculoEnParqueadero(placa);
		if(registroTmp.isPresent()) {
			return RegistroBuilder.convertirADominio(registroTmp.get());
		}
			return null;
	}

	@Override
	public int numeroVehiculosEnParqueadero(int idTipoVehiculo) {
		return registroJpa.contarVehiculos(idTipoVehiculo);	
	}
	
	public RegistroEntity obtenerRegistroRef(String placa) {
		Optional<RegistroEntity> registroTmp  = registroJpa.buscarVehiculoEnParqueadero(placa);
		if(registroTmp.isPresent()) {
			return registroTmp.get();
		}
		return null;
	}

	@Override
	public void registrarSalida(Registro registro) {
		RegistroEntity registroEntity = obtenerRegistroRef(registro.getVehiculo().getPlaca());
		registroEntity.setFechaSalida(registro.getFechaSalida());
		registroEntity.setTotalPagar(registro.getTotalPagar());
		registroJpa.save(registroEntity);
		
	}
	
	
}
