package co.com.ceiba.dominio.unitariaTest.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import java.util.Calendar;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import co.com.ceiba.dominio.Registro;
import co.com.ceiba.dominio.TipoVehiculo;
import co.com.ceiba.dominio.Vehiculo;
import co.com.ceiba.dominio.excepcion.ParqueaderoException;
import co.com.ceiba.dominio.repository.RegistroRepository;
import co.com.ceiba.dominio.service.VigilanteService;
import co.com.ceiba.dominio.service.RegistroService;
import co.com.ceiba.dominio.service.VehiculoService;
import co.com.ceiba.testdatabuilder.RegisterTestDataBuilder;
import co.com.ceiba.testdatabuilder.TipoVehiculoTestDataBuilder;
import co.com.ceiba.testdatabuilder.VehiculoTestDataBuilder;

public class VigilanteServiceTest {
	
	@InjectMocks
	private VigilanteService administradorService;
	private RegistroRepository registroRepository;
	private RegisterTestDataBuilder registerTestDataBuilder;
	private VehiculoTestDataBuilder vehiculoTestDataBuilder;
	private TipoVehiculoTestDataBuilder tipoVehiculoTestDataBuilder;
	private Calendar fechaLlegada;
	private Calendar fechaSalida;
	
	@Mock
	private VehiculoService vehiculoService;
	
	@Mock
	private RegistroService registroService;
	
	private static final int COD_MOTO = 1;
	private static final int COD_CARRO = 2;	
	public static final String VEHICLE_WITH_NULL_FIELDS = "Verifique que toda la informacion del Registro ha sido ingresada, no se permiten campos vacios";
	public static final String LISENCE_PLATE_START_WITH_A = "El vehiculo solo puede ingresar los dias Lunes y Domingos";
	public static final String NOT_EXIST_VEHICLE = "Este vehiculo no se encuentra en el parqueadero";
	public static final String THERE_IS_NOT_SPACE_FOR_VEHICLE = "No hay cupo para este tipo de vehiculo en el parqueadero";
	
	
	@Before
	public void setUp() {
		registroRepository = Mockito.mock(RegistroRepository.class);
		administradorService = new VigilanteService(registroRepository);
		registerTestDataBuilder = new RegisterTestDataBuilder();
		vehiculoTestDataBuilder = new VehiculoTestDataBuilder();
		tipoVehiculoTestDataBuilder = new TipoVehiculoTestDataBuilder();
		MockitoAnnotations.initMocks(this);
		
		fechaLlegada = Calendar.getInstance();
		fechaSalida = Calendar.getInstance();
	}
	
	@Test
	public void registrarIngresoMotoTest() {
		//Arrange
		Registro registro = registerTestDataBuilder.build();
		Mockito.when(registroRepository.numeroVehiculosEnParqueadero(COD_MOTO)).thenReturn(9);
		//Act
		administradorService.registrarIngresoVehiculo(registro);
		//Assert
		Mockito.verify(registroService).crearRegistro(registro);
	}
	
	@Test
	public void registrarIngresoMotoSinCupoTest() {
		//Arrange
		Registro registro = registerTestDataBuilder.build();
		Mockito.when(registroRepository.numeroVehiculosEnParqueadero(COD_MOTO)).thenReturn(10);
		//Assert
		try {
			//Act
			administradorService.registrarIngresoVehiculo(registro);
			fail(THERE_IS_NOT_SPACE_FOR_VEHICLE);
		} catch (ParqueaderoException e) {
			assertEquals((THERE_IS_NOT_SPACE_FOR_VEHICLE), e.getMessage());
		}
	}
	
	@Test
	public void registrarIngresoCarroTest() {
		//Arrange
		TipoVehiculo tipoVehiculo = tipoVehiculoTestDataBuilder.setCodigo(COD_CARRO).build();
		Vehiculo vehiculo = vehiculoTestDataBuilder.setTipoVehiculo(tipoVehiculo).build();
		Registro registro = registerTestDataBuilder.setVehiculo(vehiculo).build();
		Mockito.when(registroRepository.numeroVehiculosEnParqueadero(COD_CARRO)).thenReturn(19);
		Mockito.doNothing().when(vehiculoService).crearVehiculo(vehiculo);
		//Act
		administradorService.registrarIngresoVehiculo(registro);
		//Assert
		Mockito.verify(vehiculoService).crearVehiculo(vehiculo);
	}
	
	@Test
	public void registrarIngresoCarroSinCupoTest() {
		//Arrange
		TipoVehiculo tipoVehiculo = tipoVehiculoTestDataBuilder.setCodigo(COD_CARRO).build();
		Vehiculo vehiculo = vehiculoTestDataBuilder.setTipoVehiculo(tipoVehiculo).build();
		Registro registro = registerTestDataBuilder.setVehiculo(vehiculo).build();
		Mockito.when(registroRepository.numeroVehiculosEnParqueadero(COD_CARRO)).thenReturn(20);
		//Assert
		try {
			//Act
			administradorService.registrarIngresoVehiculo(registro);
			fail(THERE_IS_NOT_SPACE_FOR_VEHICLE);
		} catch (ParqueaderoException e) {
			assertEquals((THERE_IS_NOT_SPACE_FOR_VEHICLE), e.getMessage());
		}
	}

	
	@Test
	public void validarPlacaIniciaconATest() {
		//Assert
		try {
		//Act
			administradorService.validarPlaca("AXD345");
			fail(LISENCE_PLATE_START_WITH_A);
		} catch (ParqueaderoException e) {
				assertEquals((LISENCE_PLATE_START_WITH_A), e.getMessage());
		}
	}
	
	@Test
	public void validarPlacaIniciaconBTest() {
		//Assert
		try {
		//Act
			administradorService.validarPlaca("BXD345");
		} catch (ParqueaderoException e) {
			assertEquals("", e.getMessage());
		}		
	}
	
	@Test
	public void CilindrajeMayorA500Test() {
		//Arrange
		Vehiculo vehiculo= new VehiculoTestDataBuilder().setCilindraje(510).build();
		//Act
		Boolean auxBolean = administradorService.validarCilindrajeMoto(vehiculo.getCilindraje());
		//Assert
		Assert.assertTrue(auxBolean);
	}
	
	@Test
	public void calcularTiempoEnParqueaderoTest() {
		//Arrange
		fechaLlegada.set(Calendar.HOUR_OF_DAY, 5);
		fechaSalida.set(Calendar.HOUR_OF_DAY, 15);
		//Act
		int auxInt = administradorService.calcularTiempoEnParqueadero(fechaLlegada, fechaSalida);
		//Assert
		Assert.assertEquals(auxInt, 10);
	}
	
	@Test
	public void CalcularTotalAPagarMotoTest() {
		//Arrange
		fechaLlegada.set(Calendar.HOUR_OF_DAY, 5);
		fechaSalida.set(Calendar.HOUR_OF_DAY, 15);
		TipoVehiculo tipoVehiculo = tipoVehiculoTestDataBuilder.setCodigo(COD_MOTO).build();
		Vehiculo vehiculo = vehiculoTestDataBuilder.setCilindraje(400).setTipoVehiculo(tipoVehiculo).build();
		//Act
		int auxInt = administradorService.calcularTotalAPagar(vehiculo, fechaLlegada, fechaSalida);
		//Assert
		Assert.assertEquals(auxInt, 4000);
	}
	
	@Test
	public void CalcularTotalAPagarMotoConCilindrajeMaxTest() {
		//Arrange
		fechaLlegada.set(Calendar.HOUR_OF_DAY, 5);
		fechaSalida.set(Calendar.HOUR_OF_DAY, 15);
		TipoVehiculo tipoVehiculo = tipoVehiculoTestDataBuilder.setCodigo(COD_MOTO).build();
		Vehiculo vehiculo = vehiculoTestDataBuilder.setCilindraje(650).setTipoVehiculo(tipoVehiculo).build();
		//Act
		int auxInt = administradorService.calcularTotalAPagar(vehiculo, fechaLlegada, fechaSalida);
		//Assert
		Assert.assertEquals(auxInt, 6000);
	}
	
	@Test
	public void CalcularTotalAPagarCarroTest() {
		//Arrange
		int DiaLlegada = fechaLlegada.get(Calendar.DAY_OF_MONTH);
		fechaLlegada.set(Calendar.HOUR_OF_DAY, 1);
		fechaSalida.set(Calendar.DAY_OF_MONTH, DiaLlegada + 1);
		fechaSalida.set(Calendar.HOUR_OF_DAY, 4);
		TipoVehiculo tipoVehiculo = tipoVehiculoTestDataBuilder.setCodigo(COD_CARRO).build();
		Vehiculo vehiculo = vehiculoTestDataBuilder.setCilindraje(0).setTipoVehiculo(tipoVehiculo).build();
		//Act
		int auxInt = administradorService.calcularTotalAPagar(vehiculo, fechaLlegada, fechaSalida);
		//Assert
		Assert.assertEquals(auxInt, 11000);
	}
	
	@Test
	public void registrarSalidaTest() {
		//Arrange
		Registro registro = registerTestDataBuilder.build();
		Mockito.when(registroRepository.obtenerRegistro(registro.getVehiculo().getPlaca())).thenReturn(registro);
		//Act
		administradorService.registrarSalidaVehiculo(registro);
		//Assert
		Mockito.verify(registroRepository).registrarSalida(registro);
	}

	@Test
	public void registrarSalidoVehiculoInvalido() {
		//Arrange
		Vehiculo vehiculo = vehiculoTestDataBuilder.setPlaca("DFR852").build();
		Registro registro = registerTestDataBuilder.setVehiculo(vehiculo).build();
		//Assert
		try {
			//Act
			administradorService.registrarSalidaVehiculo(registro);
			fail(NOT_EXIST_VEHICLE);
		} catch (ParqueaderoException e) {
			assertEquals((NOT_EXIST_VEHICLE), e.getMessage());
		}
	}
}
