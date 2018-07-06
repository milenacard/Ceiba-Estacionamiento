package co.com.ceiba.persistencia.entidad;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity(name="FacturaParqueadero")
public class FacturaEntidad {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;

}
