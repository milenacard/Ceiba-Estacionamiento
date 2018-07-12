package co.com.ceiba.dominio.service;

import co.com.ceiba.dominio.repository.RegistroRepository;
import co.com.ceiba.dominio.repository.VehiculoRepository;

public class RegistroServicio {
	
	private RegistroRepository registroRepository;
	
	public RegistroServicio(RegistroRepository registroRepository) {
		this.registroRepository = registroRepository;
	}
	

}
