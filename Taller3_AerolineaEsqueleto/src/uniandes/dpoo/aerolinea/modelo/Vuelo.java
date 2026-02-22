package uniandes.dpoo.aerolinea.modelo;

import java.util.Map;
import java.util.Collection;
import java.util.HashMap;

public class Vuelo {
	
	private String fecha;
	private Avion avion;
	private Ruta ruta;
	private Map<String, Tiquete> tiquetes;

	public Vuelo(String fecha, Avion avion, Ruta ruta) {
		this.fecha = fecha;
		this.avion = avion;
		this.ruta = ruta;
	}
	
	public Ruta getRuta() {
		return ruta;
	}
	
	public String getFecha() {
		return fecha;
	}
	
	public Avion getAvion() {
		return avion;
	}
	public Collection<Tiquete> getTiquetes(){
		return tiquetes.values();
	}
	
	public int venderTiquetes(Cliente cliente, CalculadoraTarifas calculadora, int cantidad)throws VueloSobrevendidoException {
		int cantidadTiquetes= tiquetes.length;
		int cupos=avion.getCapacidad()- cantidadTiquetes;
		
		if (cupos<cantidad) {
			throw new VueloSobrevendidoException();
		}
		
	}
	
	
	

}
