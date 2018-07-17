package co.com.ceiba.testdatabuilder;

import java.util.Calendar;

import co.com.ceiba.dominio.Registro;
import co.com.ceiba.dominio.Vehiculo;

public class RegisterTestDataBuilder {
		
	private VehiculoTestDataBuilder vehiculoTestDataBuilder = new VehiculoTestDataBuilder();
	private static final Calendar FECHA_LLEGADA = Calendar.getInstance();

	private Vehiculo vehiculo;
	private Calendar fechaLlegada;
	
	public RegisterTestDataBuilder() {
		this.vehiculo = vehiculoTestDataBuilder.build();
		this.fechaLlegada = FECHA_LLEGADA;
	}
	
	public Registro build () {
		return new Registro(this.vehiculo, this.fechaLlegada);
	}
	
	public RegisterTestDataBuilder setFechaLlegada(Calendar fecha) {
		this.fechaLlegada  = fecha;
		return this;
	}
	
	public RegisterTestDataBuilder setVehiculo(Vehiculo vehiculo) {
		this.vehiculo = vehiculo;
		return this;
	}
	
	

}
