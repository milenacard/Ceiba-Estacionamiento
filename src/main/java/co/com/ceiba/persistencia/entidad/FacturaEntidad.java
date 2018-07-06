package co.com.ceiba.persistencia.entidad;

import java.util.Calendar;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity(name="FacturaParqueadero")
public class FacturaEntidad {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	
	@OneToOne
	@JoinColumn(name = "id_vehiculo", referencedColumnName = "placa")
	private VehiculoEntidad vehiculo;
	
	@Column(nullable = false)
	private Calendar fechaLlegada;
	@Column
	private Calendar fechaSalida;
	@Column 
	private double totalPagar;

}
