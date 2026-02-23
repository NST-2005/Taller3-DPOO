package uniandes.dpoo.aerolinea.modelo.tarifas;

import uniandes.dpoo.aerolinea.modelo.Aeropuerto;
import uniandes.dpoo.aerolinea.modelo.Ruta;
import uniandes.dpoo.aerolinea.modelo.cliente.Cliente;
import uniandes.dpoo.aerolinea.modelo.cliente.ClienteCorporativo;
import uniandes.dpoo.aerolinea.modelo.cliente.ClienteNatural;
import uniandes.dpoo.aerolinea.modelo.Vuelo;


public abstract class CalculadoraTarifas {
	
	public static double IMPUESTO = 0.28;

	public CalculadoraTarifas() {
	}
	
	public int calcularTarifa(Vuelo vuelo, Cliente cliente) {	
		
		int costoBase = calcularCostoBase(vuelo, cliente);
		double descuento= calcularPorcentajeDescuento(cliente);
		int valorDescuento = (int) Math.round(costoBase *descuento);
		int costoDescuento= costoBase-valorDescuento;
		int impuestos= calcularValorImpuestos(costoDescuento);
		
		int total=costoDescuento + impuestos;
		
		return total;
	}
	
	protected abstract int calcularCostoBase(Vuelo vuelo, Cliente cliente);
	
	protected abstract double calcularPorcentajeDescuento(Cliente cliente);
	
	protected int calcularDistanciaVuelo(Ruta ruta){
		
		Aeropuerto A_Origen= ruta.getOrigen();
		Aeropuerto A_Destino= ruta.getDestino();
		
		int distanciaVuelo = Aeropuerto.calcularDistancia(A_Origen, A_Destino);
		
		return distanciaVuelo;
	}
	
	protected int calcularValorImpuestos(int costoBase) {
		int valorImpuestos= (int) Math.round(costoBase * IMPUESTO);
		return valorImpuestos;
	}
	
	
	

}
