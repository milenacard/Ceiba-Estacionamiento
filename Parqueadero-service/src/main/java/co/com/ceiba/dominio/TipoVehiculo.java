package co.com.ceiba.dominio;

public class TipoVehiculo {
	private int codigo;
	private String nombre;
	
	
	public TipoVehiculo() {
		
	}
	
	public TipoVehiculo(int codigo, String nombre) {
		this.codigo = codigo;
		this.nombre = nombre;
	}

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
}
