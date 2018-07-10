package co.com.ceiba.dominio.unitaria.service;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import co.com.ceiba.dominio.Vehiculo;
import co.com.ceiba.dominio.repositorio.VehiculoRepository;
import co.com.ceiba.dominio.servicio.VehiculoService;
import co.com.ceiba.testdatabuilder.TipoVehiculoTestDataBuilder;
import co.com.ceiba.testdatabuilder.VehiculoTestDataBuilder;

@SpringBootTest
@RunWith(SpringRunner.class)
public class VehiculoServiceTest {
	
	private VehiculoRepository vehiculoRepository;
	private VehiculoService vehiculoService;
	private VehiculoTestDataBuilder vehiculoBuilder;
	
	
	@Before
	public void setUp() {
		vehiculoRepository = Mockito.mock(VehiculoRepository.class);
		vehiculoService = new VehiculoService(vehiculoRepository);
		vehiculoBuilder = new VehiculoTestDataBuilder();
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
	
	private List<Vehiculo> buildVehiculos() {
		
		List<Vehiculo> vehiculos = new ArrayList<>();
		vehiculos.add(vehiculoBuilder.build());
		return vehiculos;
	}
}
