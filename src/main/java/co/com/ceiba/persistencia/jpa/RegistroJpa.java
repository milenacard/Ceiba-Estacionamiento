package co.com.ceiba.persistencia.jpa;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import co.com.ceiba.persistencia.entity.RegistroEntity;

public interface RegistroJpa extends JpaRepository<RegistroEntity, Integer> {
	
	 @Query("SELECT count(1) FROM RegistroParqueadero registroParking WHERE "
		  		+ "registroParking.vehiculo.tipoVehiculo.id =:idTipoVehiculo and  registroParking.fechaSalida IS NULL and registroParking.totalPagar = 0 ")
		int contarVehiculos(@Param("idTipoVehiculo") int idTipoVehiculo); 	 
	 
	 @Query("SELECT registroParking FROM RegistroParqueadero registroParking WHERE registroParking.vehiculo.placa =:idVehicle and "
		  		+ "registroParking.fechaSalida IS NULL and registroParking.totalPagar = 0 ")
	 Optional<RegistroEntity> buscarVehiculoEnParqueadero(@Param("idVehicle") String idVehicle);
}
