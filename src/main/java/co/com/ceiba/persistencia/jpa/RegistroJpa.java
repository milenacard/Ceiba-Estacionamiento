package co.com.ceiba.persistencia.jpa;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import co.com.ceiba.dominio.Registro;
import co.com.ceiba.dominio.Vehiculo;
import co.com.ceiba.persistencia.entity.RegistroEntity;

public interface RegistroJpa extends JpaRepository<RegistroEntity, Integer> {
	
	Registro findByVehiculo(String placa);
	
	List<Registro> findByfechaSalidaIsNull();
}
