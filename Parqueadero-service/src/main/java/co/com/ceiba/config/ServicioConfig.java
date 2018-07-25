package co.com.ceiba.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import co.com.ceiba.dominio.repository.RegistroRepository;
import co.com.ceiba.dominio.repository.VehiculoRepository;
import co.com.ceiba.dominio.service.RegistroService;
import co.com.ceiba.dominio.service.VehiculoService;
import co.com.ceiba.dominio.service.VigilanteService;

@Configuration
public class ServicioConfig {

	@Bean
	public VehiculoService instanciarVehiculoService(VehiculoRepository vehiculoRepository) {
		return new VehiculoService(vehiculoRepository);
	}
	
	@Bean
	public RegistroService instanciarRegistroService(RegistroRepository registroRepository) {
		return new RegistroService(registroRepository);
	}
	
	@Bean
	public VigilanteService instanciarAdministradorService(RegistroRepository registroRepository) {
		return new VigilanteService(registroRepository);
	}
}
