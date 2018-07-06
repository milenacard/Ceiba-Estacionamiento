package co.com.ceiba.persistencia.entidad;

import javax.persistence.Column;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

public class PrecioPorTipoVehiculoEntity {
	
	@OneToOne
	@JoinColumn(name = "id_tipoVehiculo", referencedColumnName = "id")
	private TipoVehiculoEntity tipoVehiculo;
	
	@Column
	private int valorhora;
	@Column
	private int valordia;
	
	public TipoVehiculoEntity getTipoVehiculo() {
		return tipoVehiculo;
	}
	
	public void setTipoVehiculo(TipoVehiculoEntity tipoVehiculo) {
		this.tipoVehiculo = tipoVehiculo;
	}
	
	public int getValorhora() {
		return valorhora;
	}
	
	public void setValorhora(int valorhora) {
		this.valorhora = valorhora;
	}
	
	public int getValordia() {
		return valordia;
	}
	
	public void setValordia(int valordia) {
		this.valordia = valordia;
	}
}
