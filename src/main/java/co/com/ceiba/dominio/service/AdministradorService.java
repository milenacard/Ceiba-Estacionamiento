package co.com.ceiba.dominio.service;

import java.util.Calendar;
import java.util.Locale;
import org.springframework.beans.factory.annotation.Autowired;
import co.com.ceiba.dominio.Registro;
import co.com.ceiba.dominio.excepcion.ParqueaderoException;
import co.com.ceiba.dominio.repository.RegistroRepository;
import co.com.ceiba.persistencia.jpa.RegistroJpa;

public class AdministradorService {
	
	@Autowired
	VehiculoService vehiculoService;
	
	@Autowired
	RegistroJpa registroJpa;
	
	private RegistroRepository registroRepository;
	
	public AdministradorService(RegistroRepository registroRepository) {
		this.registroRepository = registroRepository;
	}

	public static final String VEHICLE_WITH_NULL_FIELDS = "Verifique que toda la informacion del Registro ha sido ingresada, no se permiten campos vacios";
	public static final String LISENCE_PLATE_START_WITH_A = "El vehiculo solo puede ingresar los dias Lunes y Domingos";
	public static final String NOT_EXIST_VEHICLE = "Este vehiculo no se encuentra en el parqueadero";
	public static final String THERE_IS_NOT_SPACE = "No hay cupo para este tipo de vehiculo en el parqueadero";
	
	
	public void registrarIngresoVehiculo (Registro registro) {
		int cantVehiculosEnParqueadero = contarVehiculos(registro.getVehiculo().getTipoVehiculo().getCodigo());
		int tipoVehiculo  = registro.getVehiculo().getTipoVehiculo().getCodigo();
		
		if(tipoVehiculo == 1 && cantVehiculosEnParqueadero <= 10) {
			validarPlaca(registro.getVehiculo().getPlaca());
			vehiculoService.crearVehiculo(registro.getVehiculo());
		}else {
			throw new ParqueaderoException(THERE_IS_NOT_SPACE);
		}
		
		if (tipoVehiculo == 2 && cantVehiculosEnParqueadero <= 20) {
			vehiculoService.crearVehiculo(registro.getVehiculo());
		}else {
			throw new ParqueaderoException(THERE_IS_NOT_SPACE);
		}
	}
	
	public void registrarSalidaVehiculo (Registro registro) {
		if(registroRepository.obtenterRegistro(registro.getVehiculo().getPlaca()) != null) {
			//TODO Recuperar el registo para dar salida
		}else {
			throw new ParqueaderoException(NOT_EXIST_VEHICLE);
		}	
	}
	
	public int contarVehiculos (int idTipoVehiculo) {
		return registroRepository.numeroVehiculosEnParqueadero(idTipoVehiculo);
	}
	
	public void validarPlaca (String placaVehiculo) {
		Calendar calendar= Calendar.getInstance();
		if (calendar.getDisplayName(Calendar.DAY_OF_WEEK, Calendar.LONG, Locale.US).toUpperCase() != "MONDAY" && calendar.getDisplayName(Calendar.DAY_OF_WEEK, Calendar.LONG, Locale.US).toUpperCase() != "SUNDAY" && placaVehiculo.startsWith("A")) {
			throw new ParqueaderoException(LISENCE_PLATE_START_WITH_A);
		}	
	}
	
	
}
