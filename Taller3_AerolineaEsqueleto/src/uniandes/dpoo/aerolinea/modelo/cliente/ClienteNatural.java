package uniandes.dpoo.aerolinea.modelo.cliente;

public class ClienteNatural {
	
	public static final String NATURAL="Natural";
	private String nombre;
	
	public ClienteNatural(String nombre) {
		this.nombre = nombre;
	}
	
	public String getIdentificador() {
		
		String identificador= "N" + nombre;
		
		return identificador;
	}
	
	@Override
	public String getTipoCliente() {
		return NATURAL;
	}
	
	
	
}
