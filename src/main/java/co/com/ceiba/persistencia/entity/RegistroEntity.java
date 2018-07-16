package co.com.ceiba.persistencia.entity;

import java.util.Calendar;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity(name="RegistroParqueadero")
public class RegistroEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_vehiculo",referencedColumnName="placa", nullable=false)
	private VehiculoEntity vehiculo;
	
	@Column(nullable = false)
	private Calendar fechaLlegada;
	@Column
	private Calendar fechaSalida;
	@Column 
	private double totalPagar;
	
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public VehiculoEntity getVehiculo() {
		return vehiculo;
	}
	
	public void setVehiculo(VehiculoEntity vehiculo) {
		this.vehiculo = vehiculo;
	}
	
	public Calendar getFechaLlegada() {
		return fechaLlegada;
	}
	
	public void setFechaLlegada(Calendar fechaLlegada) {
		this.fechaLlegada = fechaLlegada;
	}
	
	public Calendar getFechaSalida() {
		return fechaSalida;
	}
	
	public void setFechaSalida(Calendar fechaSalida) {
		this.fechaSalida = fechaSalida;
	}
	
	public double getTotalPagar() {
		return totalPagar;
	}
	
	public void setTotalPagar(double totalPagar) {
		this.totalPagar = totalPagar;
	}
}
