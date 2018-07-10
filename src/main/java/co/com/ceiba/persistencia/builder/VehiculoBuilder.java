package co.com.ceiba.persistencia.builder;

import co.com.ceiba.dominio.TipoVehiculo;
import co.com.ceiba.dominio.Vehiculo;
import co.com.ceiba.persistencia.entidad.TipoVehiculoEntity;
import co.com.ceiba.persistencia.entidad.VehiculoEntity;

public final class VehiculoBuilder {
	
	private VehiculoBuilder() {}
	
	public static Vehiculo convertirADominio(VehiculoEntity vehiculoEntity) {
		TipoVehiculo tipoVehiculo = TipoVehiculoBuilder.convertirADominio(vehiculoEntity.getTipoVehiculo());
		return  new Vehiculo(vehiculoEntity.getPlaca(), vehiculoEntity.getCilindraje(), tipoVehiculo);
	}
	
	public static VehiculoEntity convertirAEntidad(Vehiculo vehiculo) {
		TipoVehiculoEntity tipoVehiculoEntity = TipoVehiculoBuilder.convertirAEntidad(vehiculo.getTipoVehiculo());
		VehiculoEntity vehiculoEntity = new VehiculoEntity();
		vehiculoEntity.setPlaca(vehiculo.getPlaca());
		vehiculoEntity.setCilindraje(vehiculo.getCilindraje());
		vehiculoEntity.setTipoVehiculo(tipoVehiculoEntity);
		
		return vehiculoEntity;
	}
}
