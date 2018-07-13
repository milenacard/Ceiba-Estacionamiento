package co.com.ceiba.persistencia.jpa;

import org.springframework.data.jpa.repository.JpaRepository;
import co.com.ceiba.persistencia.entity.VehiculoEntity;

public interface VehiculoJpa extends JpaRepository<VehiculoEntity, String> {
	
}



