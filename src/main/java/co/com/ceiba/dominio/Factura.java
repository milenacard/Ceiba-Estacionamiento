package co.com.ceiba.dominio;

import java.util.Calendar;

public class Factura {
	
	private Vehiculo vehiculo;
	private Calendar fechaLlegada;
	private Calendar fechaSalida;
	private double totalPagar;
	
	public Factura(Vehiculo vehiculo, Calendar fechaLlegada, Calendar fechaSalida, double totalPagar) {
		this.vehiculo = vehiculo;
		this.fechaLlegada = fechaLlegada;
		this.fechaSalida = fechaSalida;
		this.totalPagar = totalPagar;
	}

	public Factura() {}

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
	
	
	
	
	
	

}
