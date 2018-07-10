package co.com.ceiba.dominio.repositorio;

import java.util.List;

import co.com.ceiba.dominio.Factura;

public interface FacturaRepository {
	
	void registar (Factura factura);
	
	List<Factura> listar();

}
