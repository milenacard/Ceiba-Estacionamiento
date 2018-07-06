package co.com.ceiba.persistencia.entidad;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class VehiculoEntidad {
	
	@Id
	private String placa;
	@Column
	private String tipoVehiculo;
	@Column
	private int cilindraje;
	
	public String getPlaca() {
		return placa;
	}
	
	public void setPlaca(String placa) {
		this.placa = placa;
	}
	
	public String getTipoVehiculo() {
		return tipoVehiculo;
	}
	
	public void setTipoVehiculo(String tipoVehiculo) {
		this.tipoVehiculo = tipoVehiculo;
	}
	
	public int getCilindraje() {
		return cilindraje;
	}
	
	public void setCilindraje(int cilindraje) {
		this.cilindraje = cilindraje;
	}
	
	
	

}
