package co.com.ceiba.dominio.unitariaTest.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

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
import co.com.ceiba.dominio.service.AdministradorService;
import co.com.ceiba.dominio.service.VehiculoService;
import co.com.ceiba.testdatabuilder.RegisterTestDataBuilder;
import co.com.ceiba.testdatabuilder.TipoVehiculoTestDataBuilder;
import co.com.ceiba.testdatabuilder.VehiculoTestDataBuilder;

public class AdministradorServiceTest {
	
	@InjectMocks
	private AdministradorService administradorService;
	private RegistroRepository registroRepository;
	private RegisterTestDataBuilder registerTestDataBuilder;
	private VehiculoTestDataBuilder vehiculoTestDataBuilder;
	private TipoVehiculoTestDataBuilder tipoVehiculoTestDataBuilder;
	
	@Mock
	private VehiculoService vehiculoService;
	
	private static final int COD_MOTO = 1;
	private static final int COD_CARRO = 2;	
	public static final String VEHICLE_WITH_NULL_FIELDS = "Verifique que toda la informacion del Registro ha sido ingresada, no se permiten campos vacios";
	public static final String LISENCE_PLATE_START_WITH_A = "El vehiculo solo puede ingresar los dias Lunes y Domingos";
	public static final String NOT_EXIST_VEHICLE = "Este vehiculo no se encuentra en el parqueadero";
	public static final String THERE_IS_NOT_SPACE_FOR_MOTO = "No hay cupo para motos en el parqueadero";
	public static final String THERE_IS_NOT_SPACE_FOR_CARRO = "No hay cupo para carros en el parqueadero";
	
	
	@Before
	public void setUp() {
		registroRepository = Mockito.mock(RegistroRepository.class);
		administradorService = new AdministradorService(registroRepository);
		registerTestDataBuilder = new RegisterTestDataBuilder();
		vehiculoTestDataBuilder = new VehiculoTestDataBuilder();
		tipoVehiculoTestDataBuilder = new TipoVehiculoTestDataBuilder();
		 MockitoAnnotations.initMocks(this);
	}
	
	@Test
	public void registrarIngresoMotoTest() {
		//Arrange
		Registro registro = registerTestDataBuilder.build();
		Mockito.when(registroRepository.numeroVehiculosEnParqueadero(COD_MOTO)).thenReturn(9);
		//Act
		administradorService.registrarIngresoVehiculo(registro);
		//Assert
		Mockito.verify(vehiculoService).crearVehiculo(registro.getVehiculo());
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
			fail(THERE_IS_NOT_SPACE_FOR_MOTO);
		} catch (ParqueaderoException e) {
			assertEquals((THERE_IS_NOT_SPACE_FOR_MOTO), e.getMessage());
		}
	}
	
	@Test
	public void registrarIngresoCarroTest() {
		//Arrange
		TipoVehiculo tipoVehiculo = tipoVehiculoTestDataBuilder.setCodigo(COD_CARRO).build();
		Vehiculo vehiculo = vehiculoTestDataBuilder.setTipoVehiculo(tipoVehiculo).build();
		Registro registro = registerTestDataBuilder.setVehiculo(vehiculo).build();
		Mockito.when(registroRepository.numeroVehiculosEnParqueadero(COD_CARRO)).thenReturn(19);
		//Act
		administradorService.registrarIngresoVehiculo(registro);
		//Assert
		Mockito.verify(vehiculoService).crearVehiculo(registro.getVehiculo());
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
			fail(THERE_IS_NOT_SPACE_FOR_CARRO);
		} catch (ParqueaderoException e) {
			assertEquals((THERE_IS_NOT_SPACE_FOR_CARRO), e.getMessage());
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
	public void CilindrajeMayorA500Test() {
		//Arrange
		Vehiculo vehiculo= new VehiculoTestDataBuilder().setCilindraje(510).build();
		//Act
		Boolean auxBolean = administradorService.validarCilindrajeMoto(vehiculo.getCilindraje());
		//Assert
		Assert.assertTrue(auxBolean);
	}
	
//	@Test
//	public void registrarSalidaMotoPorHorasTest() {
//		
//	}
//	
//	@Test
//	public void registrarSalidaMotoPorDiasTest() {
//		
//	}
//	
//
//	
//	@Test
//	public void registrarSalidaCarroPorHorasTest() {
//		
//	}
//	
//	@Test
//	public void registrarSalidaCarroPorDiasTest() {
//		
//	}
//	
//	//TODO Mandar placa que no existe
//	@Test
//	public void registrarSalidoVehiculoInvalido() {
//		
//	}
}
