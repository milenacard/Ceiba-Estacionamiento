package co.com.ceiba.dominio;

public class PrecioPorTipoVehiculo {
	
	private TipoVehiculo tipoVehiculo;
	private int valorHora;
	private int valorDia;
	
	public PrecioPorTipoVehiculo(TipoVehiculo tipoVehiculo, int valorHora, int valorDia) {
		this.tipoVehiculo = tipoVehiculo;
		this.valorHora = valorHora;
		this.valorDia = valorDia;
	}

	public TipoVehiculo getTipoVehiculo() {
		return tipoVehiculo;
	}

	public void setTipoVehiculo(TipoVehiculo tipoVehiculo) {
		this.tipoVehiculo = tipoVehiculo;
	}

	public int getValorHora() {
		return valorHora;
	}

	public void setValorHora(int valorHora) {
		this.valorHora = valorHora;
	}

	public int getValorDia() {
		return valorDia;
	}

	public void setValorDia(int valorDia) {
		this.valorDia = valorDia;
	}
}
