package uniandes.dpoo.aerolinea.modelo.cliente;
import uniandes.dpoo.aerolinea.tiquetes.Tiquete;

import uniandes.dpoo.aerolinea.modelo.Vuelo;

import java.util.List;
import java.util.ArrayList;

public abstract class Cliente {
	
	private List<Tiquete> tiquetesSinUsar;
	private List<Tiquete> tiquetesUsados;
	
	
	public Cliente() {
		tiquetesSinUsar = new ArrayList<>();
		tiquetesUsados = new ArrayList<>();
	}

	public abstract String getTipoCliente();
	
	public abstract String getIdentificador();
	
	public void agregarTiquete (Tiquete tiquete) {
		tiquetesSinUsar.add(tiquete);
		
	}
	public int calcularValorTotalTiquetes() {
		
		int totalValor=0;
		for (Tiquete t: tiquetesSinUsar) {
			totalValor += t.getTarifa();
		}
		
		return totalValor;
		
	}
	
	public void usarTiquetes (Vuelo vuelo) {
		
		List<Tiquete> paraMover = new ArrayList<>();
		
		for (Tiquete t: tiquetesSinUsar) {
			if(t.getVuelo().equals(vuelo)) {
				t.marcarComoUsado();
				paraMover.add(t);
			}
		}
		for (Tiquete t: paraMover) {
			tiquetesSinUsar.remove(t);
			tiquetesUsados.add(t);
		}
	}
	
	
}
