package co.com.ceiba.dominio.service;

import java.util.Calendar;
import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;

import co.com.ceiba.dominio.Registro;
import co.com.ceiba.dominio.excepcion.ParqueaderoException;
import co.com.ceiba.dominio.repository.RegistroRepository;

public class AdministradorService {

	@Autowired
	VehiculoService vehiculoService;

	private RegistroRepository registroRepository;
	private static final int COD_MOTO = 1;
	private static final int COD_CARRO = 2;

	public AdministradorService(RegistroRepository registroRepository) {
		this.registroRepository = registroRepository;
	}

	public static final String VEHICLE_WITH_NULL_FIELDS = "Verifique que toda la informacion del Registro ha sido ingresada, no se permiten campos vacios";
	public static final String LISENCE_PLATE_START_WITH_A = "El vehiculo solo puede ingresar los dias Lunes y Domingos";
	public static final String NOT_EXIST_VEHICLE = "Este vehiculo no se encuentra en el parqueadero";
	public static final String THERE_IS_NOT_SPACE_FOR_MOTO = "No hay cupo para motos en el parqueadero";
	public static final String THERE_IS_NOT_SPACE_FOR_CARRO = "No hay cupo para carros en el parqueadero";

	public void registrarIngresoVehiculo(Registro registro) {
		int tipoVehiculo = registro.getVehiculo().getTipoVehiculo().getCodigo();
		int cantVehiculosEnParqueadero = contarVehiculos(tipoVehiculo);

		if (tipoVehiculo == COD_MOTO) {
			if (cantVehiculosEnParqueadero < 10) {
				validarPlaca(registro.getVehiculo().getPlaca());
				vehiculoService.crearVehiculo(registro.getVehiculo());
			}else {
				throw new ParqueaderoException(THERE_IS_NOT_SPACE_FOR_MOTO);
			}
		}
		
		if (tipoVehiculo == COD_CARRO) {
			if (cantVehiculosEnParqueadero < 20) {
				vehiculoService.crearVehiculo(registro.getVehiculo());
			} else {
				throw new ParqueaderoException(THERE_IS_NOT_SPACE_FOR_CARRO);
			}
		}	
	}

	public void registrarSalidaVehiculo(Registro registro) {
		if (registroRepository.obtenterRegistro(registro.getVehiculo().getPlaca()) != null) {
			// TODO Recuperar el registo para dar salida
		} else {
			throw new ParqueaderoException(NOT_EXIST_VEHICLE);
		}
	}

	public int contarVehiculos(int idTipoVehiculo) {
		return registroRepository.numeroVehiculosEnParqueadero(idTipoVehiculo);
	}

	public void validarPlaca(String placaVehiculo) {
		Calendar calendar = Calendar.getInstance();
		if (calendar.getDisplayName(Calendar.DAY_OF_WEEK, Calendar.LONG, Locale.US).toUpperCase() != "MONDAY"
				&& calendar.getDisplayName(Calendar.DAY_OF_WEEK, Calendar.LONG, Locale.US).toUpperCase() != "SUNDAY"
				&& placaVehiculo.startsWith("A")) {
			throw new ParqueaderoException(LISENCE_PLATE_START_WITH_A);
		}
	}

}
