package co.com.ceiba.testdatabuilder;

import co.com.ceiba.dominio.TipoVehiculo;
import co.com.ceiba.dominio.Vehiculo;

public class VehiculoTestDataBuilder {
	
	private static final int CILINDRAJE = 200;
	private static final String PLACA = "DGC851";
	private TipoVehiculoTestDataBuilder tipoVehiculoTestDataBuilder = new TipoVehiculoTestDataBuilder();
	
	private String placa;
	private int cilindraje;
	private TipoVehiculo tipoVehiculo;
	
	public VehiculoTestDataBuilder() {
		this.placa = PLACA;
		this.cilindraje = CILINDRAJE;
		this.tipoVehiculo = tipoVehiculoTestDataBuilder.build();
	}
	
	public Vehiculo build () {
		return new Vehiculo(this.placa, this.cilindraje, this.tipoVehiculo);
	}
	
	public VehiculoTestDataBuilder setPlaca(String placa) {
		this.placa = placa;
		return this;
	}
	
	public VehiculoTestDataBuilder setCilindraje(int cilindraje) {
		this.cilindraje = cilindraje;
		return this;
	}

}
