package co.com.ceiba.dominio.service;

import java.util.Calendar;
import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;

import co.com.ceiba.dominio.Registro;
import co.com.ceiba.dominio.excepcion.ParqueaderoException;
import co.com.ceiba.persistencia.jpa.RegistroJpa;

public class AdministradorService {
	
	@Autowired
	VehiculoService vehiculoService;
	
	@Autowired
	RegistroJpa registroJpa;

	public static final String VEHICLE_WITH_NULL_FIELDS = "Verifique que toda la informacion del Registro ha sido ingresada, no se permiten campos vacios";
	public static final String LISENCE_PLATE_START_WITH_A = "El vehiculo solo puede ingresar los dias Lunes y Domingos";
	
	
	public int contarVehiculos (int idTipoVehiculo) {
		return registroJpa.contarVehiculos(idTipoVehiculo);	
	}
	
	public void registrarIngresoVehiculo (Registro registro) {
		vehiculoService.crearVehiculo(registro.getVehiculo());
	}
	
	public void registrarSalidaVehiculo (Registro registro) {
//		if(administradorRepository.existeRegistroDeVehiculo(registro.getVehiculo())) {		
//			//TODO Recuperar el registo para dar salida
//		}else {
//			administradorRepository.registrar(registro);
//		}		
	}
	
	public void validarPlaca (String placaVehiculo) {
		Calendar calendar= Calendar.getInstance();
		if (calendar.getDisplayName(Calendar.DAY_OF_WEEK, Calendar.LONG, Locale.US).toUpperCase() != "MONDAY" && calendar.getDisplayName(Calendar.DAY_OF_WEEK, Calendar.LONG, Locale.US).toUpperCase() != "SUNDAY" && placaVehiculo.startsWith("A")) {
			throw new ParqueaderoException(LISENCE_PLATE_START_WITH_A);
		}	
	}
}
