package co.com.ceiba.web.controlador;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import co.com.ceiba.dominio.service.AdministradorService;

@RestController
@RequestMapping("/registro")
public class RegistroController {
	
	@Autowired
	private AdministradorService administradorService;

}
