//package co.com.ceiba.integracionTest;
//
//import java.util.List;
//
//import javax.transaction.Transactional;
//
//import org.junit.Assert;
//import org.junit.Before;
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.test.context.junit4.SpringRunner;
//import co.com.ceiba.WebApplication;
//import co.com.ceiba.dominio.Registro;
//import co.com.ceiba.persistencia.builder.RegistroBuilder;
//import co.com.ceiba.persistencia.builder.VehiculoBuilder;
//import co.com.ceiba.persistencia.jpa.RegistroJpa;
//import co.com.ceiba.persistencia.jpa.VehiculoJpa;
//import co.com.ceiba.testdatabuilder.RegisterTestDataBuilder;
//import co.com.ceiba.testdatabuilder.VehiculoTestDataBuilder;
//import co.com.ceiba.web.controlador.RegistroController;
//
//@RunWith(SpringRunner.class)
//@SpringBootTest(classes = WebApplication.class)
//@Transactional
//public class RegistroControllerTest {
//	
//	@Autowired
//	private RegistroController registroController;
//	
//	@Autowired
//	private RegistroJpa registroJpa;
//	
//	@Autowired
//	private VehiculoJpa vehiculoJpa;
//	
//	private RegisterTestDataBuilder registerTestDataBuilder;
//	private VehiculoTestDataBuilder vehiculoTestDataBuilder;
//	
//	@Before
//	public void setUp() {
//		registerTestDataBuilder = new RegisterTestDataBuilder();
//		vehiculoTestDataBuilder = new VehiculoTestDataBuilder();
//		vehiculoJpa.save(VehiculoBuilder.convertirAEntidad(vehiculoTestDataBuilder.build()));
//	}
//	
//	//TODO Corregir me esta sacando un error por el tipo de vehiculo
//	@Test
//	public void listarRegistroTest() {
//		//Arrange
//		registroJpa.save(RegistroBuilder.convertirAEntidad(registerTestDataBuilder.build()));
//		//Act
//		List<Registro> registros = registroController.listar();
//		//Assert
//		Assert.assertNotNull(registros);
//	}
//	
//	@Test
//	public void crearRegistro() {
//		//Arrange
//		Registro registro = registerTestDataBuilder.build();
//		//Act
//		registroController.crear(registro);
//		//Assert
//		Assert.assertNotNull(vehiculoJpa.findById(registro.getVehiculo().getPlaca()));
//	}
//}
