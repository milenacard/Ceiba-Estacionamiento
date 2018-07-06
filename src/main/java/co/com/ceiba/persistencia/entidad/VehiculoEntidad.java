package co.com.ceiba.persistencia.entidad;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity
public class VehiculoEntidad {
	
	@Id
	private String placa;
	
	@OneToOne
	@JoinColumn(name = "id_tipoVehiculo", referencedColumnName = "id")
	private TipoVehiculoEntidad tipoVehiculo;
	
	@Column
	private int cilindraje;
	
	public String getPlaca() {
		return placa;
	}
	
	public void setPlaca(String placa) {
		this.placa = placa;
	}
	
	public TipoVehiculoEntidad getTipoVehiculo() {
		return tipoVehiculo;
	}
	
	public void setTipoVehiculo(TipoVehiculoEntidad tipoVehiculo) {
		this.tipoVehiculo = tipoVehiculo;
	}
	
	public int getCilindraje() {
		return cilindraje;
	}
	
	public void setCilindraje(int cilindraje) {
		this.cilindraje = cilindraje;
	}
	
	
	

}
