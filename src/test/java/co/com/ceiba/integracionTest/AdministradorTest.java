//package co.com.ceiba.integracionTest;
//
//import javax.transaction.Transactional;
//
//import org.junit.Assert;
//import org.junit.Before;
//import org.junit.runner.RunWith;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.test.context.junit4.SpringRunner;
//
//import co.com.ceiba.WebApplication;
//import co.com.ceiba.dominio.Registro;
//import co.com.ceiba.dominio.repository.RegistroRepository;
//import co.com.ceiba.dominio.service.AdministradorService;
//import co.com.ceiba.persistencia.builder.TipoVehiculoBuilder;
//import co.com.ceiba.persistencia.builder.VehiculoBuilder;
//import co.com.ceiba.persistencia.jpa.RegistroJpa;
//import co.com.ceiba.persistencia.jpa.TipoVehiculoJpa;
//import co.com.ceiba.persistencia.jpa.VehiculoJpa;
//import co.com.ceiba.testdatabuilder.RegisterTestDataBuilder;
//import co.com.ceiba.testdatabuilder.TipoVehiculoTestDataBuilder;
//import co.com.ceiba.testdatabuilder.VehiculoTestDataBuilder;
//
//@RunWith(SpringRunner.class)
//@SpringBootTest(classes = WebApplication.class)
//@Transactional
//public class AdministradorTest {
//	
//	@Autowired
//	private AdministradorService administradorService;
//	
//	@Autowired
//	private RegistroRepository registroRepository;
//	
//	@Autowired
//	private RegistroJpa registroJpa;
//	
//	@Autowired
//	private VehiculoJpa vehiculoJpa;
//	
//	@Autowired
//	private TipoVehiculoJpa tipoVehiculoJpa;
//	
//	private RegisterTestDataBuilder registerTestDataBuilder;
//	private VehiculoTestDataBuilder vehiculoTestDataBuilder;
//	private TipoVehiculoTestDataBuilder tipoVehiculoTestDataBuilder;
//	
//	@Before
//	public void setUp() {
//		registerTestDataBuilder = new RegisterTestDataBuilder();
//		vehiculoTestDataBuilder = new VehiculoTestDataBuilder();
//		tipoVehiculoTestDataBuilder = new TipoVehiculoTestDataBuilder();
//		tipoVehiculoJpa.saveAndFlush(TipoVehiculoBuilder.convertirAEntidad(tipoVehiculoTestDataBuilder.build()));
//		vehiculoJpa.saveAndFlush(VehiculoBuilder.convertirAEntidad(vehiculoTestDataBuilder.build()));		
//	}
//	
//	//@Test
//	public void registrarIngresoMotoTest() {
//		//Arrange
//		Registro registro = registerTestDataBuilder.build();
//		//Act
//		administradorService.registrarIngresoVehiculo(registro);
//		//Assert
//		Assert.assertNotNull(registroJpa.buscarVehiculoEnParqueadero(registro.getVehiculo().getPlaca()));
//	}
//	
//	
//
//}
