package co.com.ceiba.persistencia.jpa;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import co.com.ceiba.persistencia.entity.VehiculoEntity;

public interface VehiculoJpa extends JpaRepository<VehiculoEntity, String> {
	
	Optional<VehiculoEntity> findById(String placa);
}
