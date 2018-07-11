package co.com.ceiba.persistencia.builder;

import co.com.ceiba.dominio.TipoVehiculo;
import co.com.ceiba.persistencia.entity.TipoVehiculoEntity;

public final class TipoVehiculoBuilder {
	
	private TipoVehiculoBuilder () {}

	public static TipoVehiculo convertirADominio(TipoVehiculoEntity tipoVehiculoEntity) {
		return new TipoVehiculo(tipoVehiculoEntity.getId(), tipoVehiculoEntity.getNombre());
	}
	
	public static TipoVehiculoEntity convertirAEntidad(TipoVehiculo tipoVehiculo) {
		TipoVehiculoEntity tipoVehiculoEntity = new TipoVehiculoEntity();
		tipoVehiculoEntity.setId(tipoVehiculo.getCodigo());
		tipoVehiculoEntity.setNombre(tipoVehiculo.getNombre());
		
		return tipoVehiculoEntity;
	}
}
