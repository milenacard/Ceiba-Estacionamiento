package co.com.ceiba.dominio;


public class Vehiculo {
	
	private String placa;
	private int cilindraje;
	private TipoVehiculo tipoVehiculo;
	
	public Vehiculo() {
	}
	
	public Vehiculo(String placa, int cilindraje, TipoVehiculo tipoVehiculo) {
		this.placa = placa;
		this.cilindraje = cilindraje;
		this.tipoVehiculo = tipoVehiculo;
	}

	public String getPlaca() {
		return placa;
	}

	public void setPlaca(String placa) {
		this.placa = placa;
	}

	public int getCilindraje() {
		return cilindraje;
	}

	public void setCilindraje(int cilindraje) {
		this.cilindraje = cilindraje;
	}

	public TipoVehiculo getTipoVehiculo() {
		return tipoVehiculo;
	}

	public void setTipoVehiculo(TipoVehiculo tipoVehiculo) {
		this.tipoVehiculo = tipoVehiculo;
	}

	public boolean esValido() {
		return !(getPlaca() == null || getTipoVehiculo() == null);
	}
}
