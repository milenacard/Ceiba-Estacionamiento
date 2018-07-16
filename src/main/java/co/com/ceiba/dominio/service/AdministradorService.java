package co.com.ceiba.dominio.service;

import java.util.List;

import co.com.ceiba.dominio.Registro;
import co.com.ceiba.dominio.Vehiculo;
import co.com.ceiba.dominio.repository.AdministradorRepository;

public class AdministradorService {
	
	AdministradorRepository administradorRepository;
	public static final String VEHICLE_WITH_NULL_FIELDS = "Verifique que toda la informacion del Registro ha sido ingresada, no se permiten campos vacios";
	
	public AdministradorService(AdministradorRepository administradorRepository) {
		this.administradorRepository = administradorRepository;
	}
	
	public int contarVehiculos (int idTipoVehiculo) {
		return administradorRepository.contarVehiculos(idTipoVehiculo);	
	}
	
	//TODO RegistrarEntrada Vehiculo Existe? SI => Vehiculo, fechaLLegada NO=> Cree el vehiculo
	public void registrarIngresoVehiculo (Registro registro) {
		
	}
	
	//TODO Salida Registro existe? SI => Traiga el registro, fecha salida sea null NO=> Cree el registro
	public void registrarSalidaVehiculo (Registro registro) {
		
	}
		
//		public void registrarSalidaVehiculo(Registro registro) {
//			if(existeRegistroDeVehiculo(registro.getVehiculo())) {		
//				registroRepositoyImp.registar(registro);
//			}
//		}
}
