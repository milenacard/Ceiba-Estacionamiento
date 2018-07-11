package co.com.ceiba.persistencia.jpa;

import org.springframework.data.jpa.repository.JpaRepository;

import co.com.ceiba.persistencia.entity.RegistroEntity;

public interface RegistroJpa extends JpaRepository<RegistroEntity, Integer> {

}
