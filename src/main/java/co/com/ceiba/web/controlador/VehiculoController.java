package co.com.ceiba.web.controlador;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import co.com.ceiba.dominio.Vehiculo;
import co.com.ceiba.dominio.servicio.VehiculoService;

@RestController
@RequestMapping("/vehiculo")
public class VehiculoController {

	@Autowired
	private VehiculoService vehiculoService;
	
	@RequestMapping(method=RequestMethod.GET)
	public List<Vehiculo> listar() {
		return vehiculoService.listarVehiculos();
	}

	@RequestMapping(value = "/create", method = RequestMethod.POST)
	public void create(@RequestBody Vehiculo vehiculo) {
		vehiculoService.crear(vehiculo);
	}

}
