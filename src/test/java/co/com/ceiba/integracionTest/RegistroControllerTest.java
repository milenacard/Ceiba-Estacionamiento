package co.com.ceiba.integracionTest;

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
import co.com.ceiba.dominio.Registro;
import co.com.ceiba.persistencia.builder.RegistroBuilder;
import co.com.ceiba.persistencia.builder.TipoVehiculoBuilder;
import co.com.ceiba.persistencia.builder.VehiculoBuilder;
import co.com.ceiba.persistencia.jpa.RegistroJpa;
import co.com.ceiba.persistencia.jpa.TipoVehiculoJpa;
import co.com.ceiba.persistencia.jpa.VehiculoJpa;
import co.com.ceiba.testdatabuilder.RegisterTestDataBuilder;
import co.com.ceiba.testdatabuilder.TipoVehiculoTestDataBuilder;
import co.com.ceiba.testdatabuilder.VehiculoTestDataBuilder;
import co.com.ceiba.web.controlador.RegistroController;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = WebApplication.class)
@Transactional
public class RegistroControllerTest {
	
	@Autowired
	private RegistroController registroController;
	
	@Autowired
	private RegistroJpa registroJpa;
	
	@Autowired
	private VehiculoJpa vehiculoJpa;
	
	@Autowired
	private TipoVehiculoJpa tipoVehiculoJpa;
	
	private RegisterTestDataBuilder registerTestDataBuilder;
	private VehiculoTestDataBuilder vehiculoTestDataBuilder;
	private TipoVehiculoTestDataBuilder tipoVehiculoTestDataBuilder;
	
	@Before
	public void setUp() {
		registerTestDataBuilder = new RegisterTestDataBuilder();
		vehiculoTestDataBuilder = new VehiculoTestDataBuilder();
		tipoVehiculoTestDataBuilder = new TipoVehiculoTestDataBuilder();
		tipoVehiculoJpa.save(TipoVehiculoBuilder.convertirAEntidad(tipoVehiculoTestDataBuilder.build()));
		vehiculoJpa.save(VehiculoBuilder.convertirAEntidad(vehiculoTestDataBuilder.build()));		
	}
	
	//TODO Corregir me esta sacando un error en el listar
	@Test
	public void listarRegistroTest() {
		//Arrange
		registroJpa.save(RegistroBuilder.convertirAEntidad(registerTestDataBuilder.build()));
		//registroController.crear(registerTestDataBuilder.build());
		//Act
		List<Registro> registros = registroController.listar();
		//Assert
		Assert.assertNotNull(registros);
	}
	
	@Test
	public void crearRegistroTest() {
		//Arrange
		Registro registro = registerTestDataBuilder.build();
		//Act
		registroController.crear(registro);
		//Assert
		Assert.assertNotNull(vehiculoJpa.findById(registro.getVehiculo().getPlaca()));
	}
}
