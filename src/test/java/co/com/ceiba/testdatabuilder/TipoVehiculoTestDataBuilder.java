package co.com.ceiba.testdatabuilder;

import co.com.ceiba.dominio.TipoVehiculo;

public class TipoVehiculoTestDataBuilder {

	private static final int CODIGO = 1;
	private static final String NOMBRE = "Moto";
	
	private int codigo;
	private String nombre;
	
	public TipoVehiculoTestDataBuilder() {
		this.codigo = CODIGO;
		this.nombre = NOMBRE;
	}
	
	public TipoVehiculo build() {
		return new TipoVehiculo(this.codigo, this.nombre);
	}
}
