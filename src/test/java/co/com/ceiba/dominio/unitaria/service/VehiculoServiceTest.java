package co.com.ceiba.dominio.unitaria.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import java.util.ArrayList;
import java.util.List;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;
import co.com.ceiba.dominio.Vehiculo;
import co.com.ceiba.dominio.excepcion.VehiculoException;
import co.com.ceiba.dominio.repositorio.VehiculoRepository;
import co.com.ceiba.dominio.servicio.VehiculoService;
import co.com.ceiba.testdatabuilder.VehiculoTestDataBuilder;

public class VehiculoServiceTest {
	
	private VehiculoRepository vehiculoRepository;
	private VehiculoService vehiculoService;
	private VehiculoTestDataBuilder vehiculoTestDataBuilderBuilder;
	private static final String VEHICLE_WITH_NULL_FIELDS = "Verifique que toda la información del Vehiculo ha sido ingresada, no se permiten campos vacios";
	
	
	@Before
	public void setUp() {
		vehiculoRepository = Mockito.mock(VehiculoRepository.class);
		vehiculoService = new VehiculoService(vehiculoRepository);
		vehiculoTestDataBuilderBuilder = new VehiculoTestDataBuilder();
	}

	@Test
	public void listarVehiculosTest() {
		//Arrange 
		Mockito.when(vehiculoRepository.listar()).thenReturn(buildVehiculos());
		//Act
		List<Vehiculo> vehiculos = vehiculoService.listarVehiculos();
		//Assert
		Assert.assertEquals(buildVehiculos().get(0).getPlaca(), vehiculos.get(0).getPlaca());
	}
	
	@Test
	public void registrarVehiculoTest() {
		//Arrange
		Vehiculo vehiculo = vehiculoTestDataBuilderBuilder.build();
		//Act
		vehiculoService.crearVehiculo(vehiculo);
		//Assert
		Mockito.verify(vehiculoRepository).registar(vehiculo);	
	}
	
	@Test
	public void registrarVehiculoInvalido() {
		//Arrange
		Vehiculo vehiculo = vehiculoTestDataBuilderBuilder.setPlaca(null).build();
		//Assert
		try {
			//Act
			vehiculoService.crearVehiculo(vehiculo);
			fail(VEHICLE_WITH_NULL_FIELDS);
		} catch (VehiculoException e) {
			assertEquals((VEHICLE_WITH_NULL_FIELDS), e.getMessage());
		}
	}
	
	private List<Vehiculo> buildVehiculos() {
		List<Vehiculo> vehiculos = new ArrayList<>();
		vehiculos.add(vehiculoTestDataBuilderBuilder.build());
		return vehiculos;
	}
}
