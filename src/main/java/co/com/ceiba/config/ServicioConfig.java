package co.com.ceiba.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import co.com.ceiba.dominio.repositorio.VehiculoRepository;
import co.com.ceiba.dominio.servicio.VehiculoService;

@Configuration
public class ServicioConfig {

	@Bean
	public VehiculoService instanciarVehiculoService(VehiculoRepository vehiculoRepository) {
		return new VehiculoService(vehiculoRepository);
	}
}
