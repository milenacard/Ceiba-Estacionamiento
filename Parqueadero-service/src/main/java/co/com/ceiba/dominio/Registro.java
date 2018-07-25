package co.com.ceiba.dominio;

import java.util.Calendar;

public class Registro {

	private Vehiculo vehiculo;
	private Calendar fechaLlegada;
	private Calendar fechaSalida;
	private double totalPagar;
	
	public Registro(Vehiculo vehiculo, Calendar fechaLlegada) {
		this.vehiculo = vehiculo;
		this.fechaLlegada = fechaLlegada;
	}
	
	public Registro(Calendar fechaSalida, double totalPagar) {
		this.fechaSalida = fechaSalida;
		this.totalPagar = totalPagar;
	}
	
	public Registro(Vehiculo vehiculo, Calendar fechaLlegada, Calendar fechaSalida, double totalPagar) {
		this.vehiculo = vehiculo;
		this.fechaLlegada = fechaLlegada;
		this.fechaSalida = fechaSalida;
		this.totalPagar = totalPagar;
	}
	
	public Registro() {}

	public Vehiculo getVehiculo() {
		return vehiculo;
	}

	public void setVehiculo(Vehiculo vehiculo) {
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
	
	public boolean esValido() {
		return !(getVehiculo() == null);
	}

}
