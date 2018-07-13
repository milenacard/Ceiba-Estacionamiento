package co.com.ceiba.web.controlador;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import co.com.ceiba.dominio.Registro;
import co.com.ceiba.dominio.service.RegistroServicio;

@RestController
@RequestMapping("/registro")
public class RegistroController {
	
	@Autowired
	RegistroServicio registroServicio;
	
	@RequestMapping(method=RequestMethod.GET)
	public List<Registro> listar() {
		return registroServicio.listarRegistros();
	}
	
	@RequestMapping(value = "/create", method = RequestMethod.POST)
	public void crear(@RequestBody Registro registro) {
		registroServicio.crearRegistro(registro);
	}
}
