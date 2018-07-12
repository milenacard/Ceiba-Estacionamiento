package co.com.ceiba.persistencia.repositoryimpl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import co.com.ceiba.dominio.Vehiculo;
import co.com.ceiba.dominio.repository.VehiculoRepository;
import co.com.ceiba.persistencia.builder.VehiculoBuilder;
import co.com.ceiba.persistencia.entity.VehiculoEntity;
import co.com.ceiba.persistencia.jpa.VehiculoJpa;

@Repository
public class VehiculoRepositoryImpl implements VehiculoRepository {

	@Autowired
	VehiculoJpa vehiculoJpa;
	
	@Override
	public void crear(Vehiculo vehiculo) {
		vehiculoJpa.save(VehiculoBuilder.convertirAEntidad(vehiculo));
	}

	@Override
	public List<Vehiculo> listar() {
		List<Vehiculo> vehiculos = new ArrayList<>();
		for (VehiculoEntity vehiculoEntity : vehiculoJpa.findAll()) {
			vehiculos.add(VehiculoBuilder.convertirADominio(vehiculoEntity));
		}
		return vehiculos;

	}

//	@Override
//	public Boolean existeVehiculo (Vehiculo vehiculo) {
//		return (vehiculoJpa.buscarPorId(vehiculo.getPlaca()) != null);
//	}
	
	@Override
	public Boolean existeVehiculo (Vehiculo vehiculo) {
		return (true);
	}

}
