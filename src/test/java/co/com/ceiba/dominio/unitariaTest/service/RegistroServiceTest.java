package co.com.ceiba.dominio.unitariaTest.service;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import co.com.ceiba.dominio.Registro;
import co.com.ceiba.dominio.repository.RegistroRepository;
import co.com.ceiba.dominio.service.RegistroServicio;
import co.com.ceiba.testdatabuilder.RegisterTestDataBuilder;


public class RegistroServiceTest {

	private RegistroRepository registroRepository;
	private RegistroServicio registroServicio;
	private RegisterTestDataBuilder registerTestDataBuilder;
	
	@Before
	public void setUp() {
		registroRepository = Mockito.mock(RegistroRepository.class);
		registroServicio = new RegistroServicio(registroRepository);
		registerTestDataBuilder = new RegisterTestDataBuilder();
		
	}
	
	@Test
	public void listarRegistrosTest() {
		//Arrange
		Mockito.when(registroRepository.listar()).thenReturn(buildRegitros());
		//Act
		List<Registro> registros = registroServicio.listarRegistros();
		//Assert
		Assert.assertEquals(buildRegitros().get(0).getVehiculo().getPlaca(), registros.get(0).getVehiculo().getPlaca());
	}
	
	@Test
	public void crearRegistroTest() {
		//Arrange
		Registro registro = registerTestDataBuilder.build();
		//Act
		registroServicio.crearRegistro(registro);
		//Assert
		Mockito.verify(registroRepository).registar(registro);
	}
	
	public List<Registro> buildRegitros() {
		List<Registro> registros = new ArrayList<>();
		registros.add(registerTestDataBuilder.build());
		return registros;
	}
}
