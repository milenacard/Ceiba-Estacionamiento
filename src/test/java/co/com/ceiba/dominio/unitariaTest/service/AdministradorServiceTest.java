package co.com.ceiba.dominio.unitariaTest.service;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import co.com.ceiba.dominio.repository.RegistroRepository;
import co.com.ceiba.dominio.service.AdministradorService;

public class AdministradorServiceTest {
	
	private AdministradorService administradorService;
	private RegistroRepository registroRepository;
	
	public static final String VEHICLE_WITH_NULL_FIELDS = "Verifique que toda la informacion del Registro ha sido ingresada, no se permiten campos vacios";
	public static final String LISENCE_PLATE_START_WITH_A = "El vehiculo solo puede ingresar los dias Lunes y Domingos";
	public static final String NOT_EXIST_VEHICLE = "Este vehiculo no se encuentra en el parqueadero";
	public static final String THERE_IS_NOT_SPACE = "No hay cupo para este tipo de vehiculo en el parqueadero";
	
	
	@Before
	public void setUp() {
		registroRepository = Mockito.mock(RegistroRepository.class);
		administradorService = new AdministradorService(registroRepository);
	}
	
	@Test
	public void contarVehiculosTest() {
		//Arrange
		
		//Act
		
		//Assert
		
	}
}
