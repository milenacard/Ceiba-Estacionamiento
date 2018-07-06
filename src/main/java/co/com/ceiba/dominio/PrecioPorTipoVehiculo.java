package co.com.ceiba.dominio;

public class PrecioPorTipoVehiculo {
	
	private TipoVehiculo tipoVehiculo;
	private int ValorHora;
	private int ValorDia;
	
	public PrecioPorTipoVehiculo(TipoVehiculo tipoVehiculo, int valorHora, int valorDia) {
		this.tipoVehiculo = tipoVehiculo;
		ValorHora = valorHora;
		ValorDia = valorDia;
	}

}
