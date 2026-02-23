package uniandes.dpoo.aerolinea.persistencia;
import java.nio.file.Files;
import java.nio.file.Path;

import org.json.JSONObject;

import java.io.FileReader;

import java.io.BufferedReader;
import java.io.File;

import uniandes.dpoo.aerolinea.modelo.Aerolinea;

public class PersistenciaAerolineaJson implements IPersistenciaAerolinea{
	
	private static final String AEROPUERTOS = "aeropuertos";
	private static final String AVIONES = "aviones";
	private static final String RUTAS = "aviones";
	private static final String Vuelos="vuelos";
	
	
	

	public PersistenciaAerolineaJson() {
		super();
	}
	public void cargarAerolinea(String archivo, Aerolinea aerolinea) throws java.io.IOException{
		{
	        String jsonCompleto = new String( Files.readAllBytes( new File( archivo ).toPath( ) ) );
	        JSONObject raiz = new JSONObject( jsonCompleto );

	        cargarAeropuertos( aerolinea, raiz.getJSONArray( "AEROPUERTOS" ) );
	        cargarAviones( aerolinea, raiz.getJSONArray( "AVIONES" ) );
	        cargarRutas( aerolinea, raiz.getJSONArray( "RUTAS" ) );
	        cargarVuelos( aerolinea, raiz.getJSONArray( "VUELOS" ) );
	        
	    }
		
	}
	public void salvarAerolinea(String archivo, Aerolinea aerolinea) {
		
	}
}
