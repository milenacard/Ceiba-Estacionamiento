package co.com.ceiba.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import co.com.ceiba.dominio.repository.AdministradorRepository;
import co.com.ceiba.dominio.repository.RegistroRepository;
import co.com.ceiba.dominio.repository.VehiculoRepository;
import co.com.ceiba.dominio.service.AdministradorService;
import co.com.ceiba.dominio.service.RegistroServicio;
import co.com.ceiba.dominio.service.VehiculoService;

@Configuration
public class ServicioConfig {

	@Bean
	public VehiculoService instanciarVehiculoService(VehiculoRepository vehiculoRepository) {
		return new VehiculoService(vehiculoRepository);
	}
	
	@Bean
	public AdministradorService instanciarAdministradorService(AdministradorRepository administradorRepository) {
		return new AdministradorService(administradorRepository);
	}
	
	@Bean
	public RegistroServicio instanciarRegistroService(RegistroRepository registroRepository) {
		return new RegistroServicio(registroRepository);
	}
}
