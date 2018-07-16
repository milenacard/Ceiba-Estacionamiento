package co.com.ceiba.persistencia.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotNull;

@Entity(name="Vehiculo")
public class VehiculoEntity {
	
	@Id
	private String placa;
	
	@OneToOne
	@NotNull
	@JoinColumn(name = "id_tipoVehiculo", referencedColumnName = "id")
	private TipoVehiculoEntity tipoVehiculo;
		
	@Column
	@NotNull
	private int cilindraje;
	
	public String getPlaca() {
		return placa;
	}
	
	public void setPlaca(String placa) {
		this.placa = placa;
	}
	
	public TipoVehiculoEntity getTipoVehiculo() {
		return tipoVehiculo;
	}
	
	public void setTipoVehiculo(TipoVehiculoEntity tipoVehiculo) {
		this.tipoVehiculo = tipoVehiculo;
	}
	
	public int getCilindraje() {
		return cilindraje;
	}
	
	public void setCilindraje(int cilindraje) {
		this.cilindraje = cilindraje;
	}
}
