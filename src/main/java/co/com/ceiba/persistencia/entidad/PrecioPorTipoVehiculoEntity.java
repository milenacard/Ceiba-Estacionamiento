package co.com.ceiba.persistencia.entidad;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotNull;

public class PrecioPorTipoVehiculoEntity {
	
	@Id
	private int id;
	
	@OneToOne
	@JoinColumn(name = "id_tipoVehiculo", referencedColumnName = "id", nullable=false)
	private TipoVehiculoEntity tipoVehiculo;
	
	@Column
	@NotNull
	private int valorhora;
	@Column
	@NotNull
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
