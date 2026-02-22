package uniandes.dpoo.aerolinea.modelo.tarifas;


import uniandes.dpoo.aerolinea.modelo.Aeropuerto;
import uniandes.dpoo.aerolinea.modelo.Ruta;

public abstract class CalculadoraTarifas {
	
	public static double IMPUESTO = 0.28;

	public CalculadoraTarifas() {
	}
	
	public int calcularTarifa(Vuelo vuelo, Cliente cliente) {	
		
	}
	
	protected abstract int calcularCostoBase(Vuelo vuelo, Cliente cliente) {
		
	}
	
	protected abstract double calcularPorcentajeDescuento(Cliente cliente) {
		
	}
	
	protected int calcularDistanciaVuelo(Ruta ruta){
		
		Aeropuerto A_Origen= ruta.getOrigen();
		Aeropuerto A_Destino= ruta.getDestino();
		
		int distanciaVuelo = Aeropuerto.calcularDistancia(A_Origen, A_Destino);
		
		return distanciaVuelo;
	}
	
	protected int calcularValormpuestos(int costoBase) {
		int valorImpuestos= (int) Math.round(costoBase * IMPUESTO);
		return valorImpuestos;
	}
	
	
	

}
