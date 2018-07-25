package co.com.ceiba.web.controlador;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import co.com.ceiba.dominio.Vehiculo;
import co.com.ceiba.dominio.service.VehiculoService;
import co.com.ceiba.persistencia.entity.VehiculoEntity;

@RestController
@CrossOrigin
@RequestMapping("/vehiculo")
public class VehiculoController {

	@Autowired
	private VehiculoService vehiculoService;
	
	@RequestMapping(value = "/listar", method=RequestMethod.GET)
	public List<Vehiculo> listar() {
		return vehiculoService.listarVehiculos();
	}

	@RequestMapping(value = "/create", method = RequestMethod.POST)
	public void crear(@RequestBody Vehiculo vehiculo) {
		vehiculoService.crearVehiculo(vehiculo);
	}
	
	@RequestMapping(value = "/find", method=RequestMethod.GET)
	public Optional<VehiculoEntity> obtenerPorId(@RequestParam String placa) {
		return vehiculoService.obtenerPorId(placa);
	}

}
