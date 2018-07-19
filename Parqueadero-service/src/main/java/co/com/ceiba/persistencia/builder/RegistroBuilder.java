package co.com.ceiba.persistencia.builder;

import co.com.ceiba.dominio.Registro;
import co.com.ceiba.dominio.Vehiculo;
import co.com.ceiba.persistencia.entity.RegistroEntity;
import co.com.ceiba.persistencia.entity.VehiculoEntity;

public final class RegistroBuilder {
	
	private RegistroBuilder() {}
	
	public static Registro convertirADominio(RegistroEntity registroEntity) {
		Vehiculo vehiculo = VehiculoBuilder.convertirADominio(registroEntity.getVehiculo());
		return new Registro(vehiculo, registroEntity.getFechaLlegada(), registroEntity.getFechaSalida(), registroEntity.getTotalPagar());
	}
	
	public static RegistroEntity convertirAEntidad(Registro registro) {
		VehiculoEntity vehiculoEntity = VehiculoBuilder.convertirAEntidad(registro.getVehiculo());
		RegistroEntity registroEntity = new RegistroEntity();
		registroEntity.setVehiculo(vehiculoEntity);
		registroEntity.setFechaLlegada(registro.getFechaLlegada());
		registroEntity.setFechaSalida(registro.getFechaSalida());
		registroEntity.setTotalPagar(registro.getTotalPagar());
		
		return registroEntity;
	}
	
	
}
