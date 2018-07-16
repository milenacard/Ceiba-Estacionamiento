package co.com.ceiba.persistencia.jpa;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import co.com.ceiba.dominio.Registro;
import co.com.ceiba.persistencia.entity.RegistroEntity;

public interface RegistroJpa extends JpaRepository<RegistroEntity, Integer> {
	
	Registro findByVehiculo(String placa);

	 @Query("SELECT count(1) FROM RegistroParqueadero registroParking WHERE "
		  		+ "registroParking.vehiculo.tipoVehiculo.id =: idTipoVehiculo and  registroParking.fechaSalida IS NULL and registroParking.totalPagar = 0 ")
		int contarVehiculos(@Param("idTipoVehiculo") int idTipoVehiculo); 	 
	 
	 @Query("SELECT registerParking FROM RegistroParqueadero registroParking WHERE registroParking.vehiculo.placa = :idVehicle and "
		  		+ "registroParking.fechaSalida IS NULL and registroParking.totalPagar = 0 ")
		  RegistroEntity buscarVehiculoEnParqueadero(@Param("idVehicle") String idVehicle);
}
