package uniandes.dpoo.aerolinea.modelo;

import java.util.Map;

import uniandes.dpoo.aerolinea.tiquetes.Tiquete;

import uniandes.dpoo.aerolinea.modelo.cliente.Cliente;
import uniandes.dpoo.aerolinea.modelo.tarifas.CalculadoraTarifas;
import uniandes.dpoo.aerolinea.exceptions.VueloSobrevendidoException;

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
		this.tiquetes= new HashMap<String, Tiquete>();
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
		int cantidadVendidos= tiquetes.size();
		int cupos=avion.getCapacidad()- cantidadVendidos;
		
		if (cupos<cantidad) {
			throw new VueloSobrevendidoException(this);
		}
		
		int totalVendidos=0;
		
		for (int i=0; i< cantidad; i++) {
			int tarifa = calculadora.calcularTarifa(this, cliente);
			String codigo= this.fecha + "-"+( cantidadVendidos + i+1);
			
			Tiquete nuevot = new Tiquete ( codigo, this, cliente, tarifa);
			
			tiquetes.put(codigo,  nuevot);
			
			totalVendidos +=tarifa;
			
		}
		return totalVendidos;
		
	}
	
	@Override	
	public boolean equals(Object obj) {
			if (obj == null) {
				return false;
			}
			Vuelo otro = (Vuelo)obj;
			
			return this.fecha.equals(otro.fecha) && this.ruta.getCodigoRuta().equals(otro.ruta.getCodigoRuta());
			
		}
		
}
	
	
	


