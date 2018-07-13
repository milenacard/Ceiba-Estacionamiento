package co.com.ceiba.persistencia.repositoryimpl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import co.com.ceiba.dominio.Registro;
import co.com.ceiba.dominio.repository.RegistroRepository;
import co.com.ceiba.persistencia.builder.RegistroBuilder;
import co.com.ceiba.persistencia.entity.RegistroEntity;
import co.com.ceiba.persistencia.jpa.RegistroJpa;

public class RegistroRepositoryImpl implements RegistroRepository{

	@Autowired
	RegistroJpa registroJpa;
	
	@Override
	public void registar(Registro registro) {
		registroJpa.save(RegistroBuilder.convertirAEntidad(registro));
	}

	@Override
	public List<Registro> listar() {
		List<Registro> registros = new ArrayList<>();
		for (RegistroEntity registroEntity : registroJpa.findAll()) {
			registros.add(RegistroBuilder.convertirADominio(registroEntity));
		}
		return registros;
	}
}
