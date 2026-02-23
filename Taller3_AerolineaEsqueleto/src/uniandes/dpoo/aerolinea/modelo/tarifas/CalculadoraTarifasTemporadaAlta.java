package uniandes.dpoo.aerolinea.modelo.tarifas;
import uniandes.dpoo.aerolinea.modelo.cliente.Cliente;
import uniandes.dpoo.aerolinea.modelo.Aeropuerto;
import uniandes.dpoo.aerolinea.modelo.Ruta;
import uniandes.dpoo.aerolinea.modelo.Vuelo;

public class CalculadoraTarifasTemporadaAlta extends CalculadoraTarifas{
	
	protected final int COSTO_POR_KM= 1000;
	
	public int calcularCostoBase(Vuelo vuelo, Cliente cliente) {
		
		int distancia = calcularDistanciaVuelo(vuelo.getRuta());
		return COSTO_POR_KM* distancia;
	}
	public double calcularPorcentajeDescuento(Cliente cliente) {
		return 0.0;
	}
	
	protected int distanciaVuelo(Ruta ruta) {
		Aeropuerto origen = ruta.getOrigen();
		Aeropuerto destino = ruta.getDestino();
		
		return Aeropuerto.calcularDistancia(origen, destino);
	}

}
