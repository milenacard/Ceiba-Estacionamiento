package co.com.ceiba.persistencia.jpa;

import org.springframework.data.jpa.repository.JpaRepository;

import co.com.ceiba.persistencia.entity.TipoVehiculoEntity;

public interface TipoVehiculoJpa extends JpaRepository<TipoVehiculoEntity, Integer> {

}
