package co.com.ceiba.dominio.service;

import java.util.Calendar;
import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;

import co.com.ceiba.dominio.Celda;
import co.com.ceiba.dominio.FactoryCelda;
import co.com.ceiba.dominio.Registro;
import co.com.ceiba.dominio.Vehiculo;
import co.com.ceiba.dominio.excepcion.ParqueaderoException;
import co.com.ceiba.dominio.repository.RegistroRepository;

public class VigilanteService {

	@Autowired
	VehiculoService vehiculoService;
	
	@Autowired
	RegistroService registroService;
	
	private RegistroRepository registroRepository;
	private static final int COD_MOTORCYCLE = 1;
	private static final int CILYNDER_MAX = 500;
	private static final int START_TIME_DAY = 9;
	private static final int CAR_HOUR_VALUE = 1000;
	private static final int MOTORCYCLE_HOUR_VALUE = 500;
	private static final int CAR_DAY_VALUE = 8000;
	private static final int MOTORCYCLE_DAY_VALUE = 4000;
	private static final int SURPLUS_MOTORCYCLE = 2000;

	public VigilanteService(RegistroRepository registroRepository) {
		this.registroRepository = registroRepository;
	}

	public static final String VEHICLE_WITH_NULL_FIELDS = "Verifique que toda la informacion del Registro ha sido ingresada, no se permiten campos vacios";
	public static final String LISENCE_PLATE_START_WITH_A = "El vehiculo solo puede ingresar los dias Lunes y Domingos";
	public static final String NOT_EXIST_VEHICLE = "Este vehiculo no se encuentra en el parqueadero";
	public static final String THERE_IS_NOT_SPACE_FOR_VEHICLE = "No hay cupo para este tipo de vehiculo en el parqueadero";
	public static final String EXIST_REGISTER = "El registro del vehiculo ya se encuentra ingresado en el sistema";
	public static final int CANT_HORAS_DIA = 24;
	
	public void registrarIngresoVehiculo(Registro registro) {
		int tipoVehiculo = registro.getVehiculo().getTipoVehiculo().getCodigo();
		int cantVehiculosEnParqueadero = contarVehiculos(tipoVehiculo);
		registro.setFechaLlegada(Calendar.getInstance());

		Celda celda = FactoryCelda.obtenerCelda(tipoVehiculo);
		
		if( cantVehiculosEnParqueadero >= celda.getMaximoCelda() ) {
			throw new ParqueaderoException(THERE_IS_NOT_SPACE_FOR_VEHICLE);
		}
			
		validarPlaca(registro.getVehiculo().getPlaca(), registro.getFechaLlegada());
		ingresarAParqueadero(registro);

	}

	public void registrarSalidaVehiculo(Registro registro) {
		double totalPagar;
		
		if (registroRepository.obtenerRegistro(registro.getVehiculo().getPlaca()) != null) {
			registro.setFechaSalida(Calendar.getInstance());
			totalPagar = calcularTotalAPagar(registro.getVehiculo(), registro.getFechaLlegada(), registro.getFechaSalida());
			registro.setTotalPagar(totalPagar);
			registroRepository.registrarSalida(registro);
		} else {
			throw new ParqueaderoException(NOT_EXIST_VEHICLE);
		}
	}

	public int contarVehiculos(int idTipoVehiculo) {
		return registroRepository.numeroVehiculosEnParqueadero(idTipoVehiculo);
	}

	public void validarPlaca(String placaVehiculo, Calendar calendar) {
		if (calendar.getDisplayName(Calendar.DAY_OF_WEEK, Calendar.LONG, Locale.US).toUpperCase() != "MONDAY"
				&& calendar.getDisplayName(Calendar.DAY_OF_WEEK, Calendar.LONG, Locale.US).toUpperCase() != "SUNDAY"
				&& placaVehiculo.startsWith("A")) {
			throw new ParqueaderoException(LISENCE_PLATE_START_WITH_A);
		}
	}

	public Boolean validarCilindrajeMoto (int cilindraje) {
		return cilindraje > CILYNDER_MAX;
	}
	
	public void ingresarAParqueadero(Registro registro) {
		if(!vehiculoService.existeVehiculo(registro.getVehiculo().getPlaca())) {
			vehiculoService.crearVehiculo(registro.getVehiculo());
		}if(registroRepository.obtenerRegistro(registro.getVehiculo().getPlaca()) != null) {
			throw new ParqueaderoException(EXIST_REGISTER);
		}else {
			registroService.crearRegistro(registro);
		}
	}

	public int calcularTiempoEnParqueadero(Calendar fechaLlegada, Calendar fechaSalida) {
		int diaDeEntrada;
		int diaDeSalida;
		int maxDiaDelMes;
		int horaDeEntrada;
		int horaDeSalida;
		int totalDias;
		int tiempoTotal;
		
		diaDeEntrada = fechaLlegada.get(Calendar.DAY_OF_MONTH);
		diaDeSalida = fechaSalida.get(Calendar.DAY_OF_MONTH);
		
		if(fechaSalida.get(Calendar.MONTH) > fechaLlegada.get(Calendar.MONTH)) {
			maxDiaDelMes = fechaLlegada.getActualMaximum(Calendar.DAY_OF_MONTH);
			diaDeSalida = diaDeSalida + maxDiaDelMes;
		}
		
		totalDias = diaDeSalida - diaDeEntrada;
		
		horaDeEntrada = fechaLlegada.get(Calendar.HOUR_OF_DAY);
		horaDeSalida = fechaSalida.get(Calendar.HOUR_OF_DAY);
		tiempoTotal = (totalDias * CANT_HORAS_DIA) + horaDeSalida - horaDeEntrada;
		
		return tiempoTotal;
	}
	
	public int calcularTotalAPagar(Vehiculo vehiculo, Calendar fechaLlegada, Calendar fechaSalida) {
		int totalTiempoEnParqueadero;
		int horas = 0;
		int dias = 0;
		int totalAPagar=0;
		
		totalTiempoEnParqueadero = calcularTiempoEnParqueadero(fechaLlegada, fechaSalida);
		
		if(totalTiempoEnParqueadero >= CANT_HORAS_DIA) {
			horas = totalTiempoEnParqueadero % CANT_HORAS_DIA;
			dias = totalTiempoEnParqueadero / CANT_HORAS_DIA;
		}else if(totalTiempoEnParqueadero > START_TIME_DAY && totalTiempoEnParqueadero <= CANT_HORAS_DIA) {
			dias= 1;
		}else {
			horas = totalTiempoEnParqueadero;
		}
		
		int tipoVehiculo = vehiculo.getTipoVehiculo().getCodigo();
		
		if(tipoVehiculo == COD_MOTORCYCLE) {
			horas = horas * MOTORCYCLE_HOUR_VALUE;
			dias = dias * MOTORCYCLE_DAY_VALUE;
			
			if(validarCilindrajeMoto(vehiculo.getCilindraje())) {
				totalAPagar = horas + dias + SURPLUS_MOTORCYCLE;
			}else {
				totalAPagar = horas + dias;
			}
			
		}else {
			horas = horas * CAR_HOUR_VALUE;
			dias = dias * CAR_DAY_VALUE;
			totalAPagar = horas + dias;
		}
		
		return totalAPagar;
		
	}
}
