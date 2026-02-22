package uniandes.dpoo.aerolinea.modelo.cliente;
import uniandes.dpoo.aerolinea.tiquetes.Tiquete;

public abstract class Cliente {

	public Cliente() {
	}
	
	private Tiquete tiquetesSinUsar;
	private Tiquete tiquetesUsados;
	
	public abstract String getTipoCliente();
	
	public abstract String getIdentificador();
	
	public void agregarTiquete (Tiquete tiquete) {
		
	}
	
}
