package co.com.ceiba.dominio.repository;

import java.util.List;

import co.com.ceiba.dominio.Registro;

public interface RegistroRepository {
	
	void registar (Registro factura);
	
	List<Registro> listar();

}
