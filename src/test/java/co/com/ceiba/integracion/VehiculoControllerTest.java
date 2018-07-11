package co.com.ceiba.integracion;

import static org.junit.Assert.assertNotNull;

import java.util.List;

import javax.transaction.Transactional;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import co.com.ceiba.WebApplication;
import co.com.ceiba.dominio.Vehiculo;
import co.com.ceiba.persistencia.builder.VehiculoBuilder;
import co.com.ceiba.persistencia.jpa.VehiculoJpa;
import co.com.ceiba.testdatabuilder.VehiculoTestDataBuilder;
import co.com.ceiba.web.controlador.VehiculoController;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = WebApplication.class)
@Transactional
public class VehiculoControllerTest {
	
	@Autowired
	private VehiculoController vehiculoController;
	
	@Autowired
	private VehiculoJpa vehiculoJpa;
	
	private VehiculoTestDataBuilder vehiculoTestDataBuilder;
	
	@Before
	public void setUp() {
		vehiculoTestDataBuilder = new VehiculoTestDataBuilder();
	}
	
	@Test
	public void listarVehiculosTest() {
		//arrange
		vehiculoJpa.save(VehiculoBuilder.convertirAEntidad(vehiculoTestDataBuilder.build()));
		//act
		List<Vehiculo> vehiculos = vehiculoController.listar();
		//assert
		Assert.assertNotNull(vehiculos);
	}
	
	@Test
	public void crearVehiculoTest() {
		//arrange
		Vehiculo vehiculo = vehiculoTestDataBuilder.build();
		//act
		vehiculoController.crear(vehiculo);
		//assert
		assertNotNull(vehiculoJpa.findById(vehiculo.getPlaca()));
	}
	
	
}
