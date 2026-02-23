package uniandes.dpoo.aerolinea.modelo.tarifas;

import uniandes.dpoo.aerolinea.modelo.cliente.Cliente;
import uniandes.dpoo.aerolinea.modelo.Aeropuerto;
import uniandes.dpoo.aerolinea.modelo.Vuelo;
import uniandes.dpoo.aerolinea.modelo.Ruta;
import uniandes.dpoo.aerolinea.modelo.cliente.ClienteCorporativo;

public class CalculadoraTarifasTemporadaBaja extends CalculadoraTarifas{

	protected final int COSTO_POR_KM_NATURAL = 600;
	protected final int COSTO_POR_KM_CORPORATIVO = 900;
	protected final double DESCUENTO_PEQ = 0.02;
	protected final double  DESCUENTO_MEDIANAS = 0.1;
	protected final double DESCUENTO_GRANDES = 0.2;
	
	
	
	public CalculadoraTarifasTemporadaBaja() {
		super();
	}
	
	
	@Override
	public int calcularCostoBase (Vuelo vuelo, Cliente cliente) {
		
		int distancia = calcularDistanciaVuelo(vuelo.getRuta());
		int costoBase=0; 
		if (cliente.getTipoCliente().equals("Natural")){
			
			costoBase= COSTO_POR_KM_NATURAL* distancia;
			
		}
		if (cliente.getTipoCliente().equals("Corporativo")) {
			costoBase= COSTO_POR_KM_CORPORATIVO * distancia;
		}
		return costoBase;
	}
	
	public double calcularPorcentajeDescuento(Cliente cliente) {
		if (cliente.getTipoCliente().equals("Natural")){
			return 0.0;
		}
		ClienteCorporativo corporativo = (ClienteCorporativo) cliente;
		
			if (corporativo.getTamanoEmpresa()== ClienteCorporativo.GRANDE){
				return DESCUENTO_GRANDES;
		}
			if (corporativo.getTamanoEmpresa()== ClienteCorporativo.MEDIANA){
				return DESCUENTO_MEDIANAS;
		}
			if (corporativo.getTamanoEmpresa()== ClienteCorporativo.PEQUENA){
				return DESCUENTO_PEQ;
			}
		return 0.0;
		
		
		
	}
}
	
	
