package co.com.ceiba.dominio.service;

import java.util.Calendar;
import java.util.List;

import co.com.ceiba.dominio.Registro;
import co.com.ceiba.dominio.excepcion.ParqueaderoException;
import co.com.ceiba.dominio.repository.RegistroRepository;

public class RegistroService {
	
	private RegistroRepository registroRepository;
	public static final String 	REGISTER_INVALID = "Registro invalido";
	
	public RegistroService(RegistroRepository registroRepository) {
		this.registroRepository = registroRepository;
	}
	
	public List<Registro> listarRegistros(){
		return registroRepository.listar();
	}
	
	public void crearRegistro(Registro registro) {
		if(!registro.esValido()){
			throw new ParqueaderoException(REGISTER_INVALID);
		}else {
			registro.setFechaLlegada(Calendar.getInstance());
			registroRepository.registar(registro);
		}
	}
}

