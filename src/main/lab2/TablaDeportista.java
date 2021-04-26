package main.lab2;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class TablaDeportista {
	private Deportista[] tabla;
	private int n;  // cantidad de deportistas en la tabla
	private int max;  // capacidad de la tabla
		
	public TablaDeportista(String nombreFich){
		File fichero = new File(nombreFich);
		
		n=0;
		max=20;
		tabla = new Deportista[max];

		try{
			FileReader flujoLectura = new FileReader(fichero);
			BufferedReader flujoBuffer = new BufferedReader(flujoLectura);
			String linea;
			String[] datos;
			Deportista e;
			while ((linea = flujoBuffer.readLine()) != null){
				datos = linea.split(" ");
				e = new Deportista(datos[0],Boolean.parseBoolean(datos[1]),datos[2],Float.parseFloat(datos[3]));
				if (n < max){
					tabla[n] = e;
					n++;
				}				
			}
			flujoBuffer.close();
		}
		catch (FileNotFoundException e){
			e.printStackTrace();
		}
		catch (IOException e){
			e.printStackTrace();
		}			
	}
	
	public int obtenerNumDeportistas(){
		return n;
	}
	
	public String obtenerEquipo(int iD){
		return tabla[iD].obtenerEquipo();
	}
	
	public boolean obtenerEsCapi(int iD){
		return tabla[iD].obtenerEsCapi();
	}
	
	public float obtenerFicha(int iD){
		return tabla[iD].obtenerFicha();
	}
	
	public void incrementarFicha(int iD, float prima){
		tabla[iD].incrementarFicha(prima);
	}
	
	public void mostrarDeportistas(){
		for (int i = 0; i<n; i++)
			tabla[i].mostrarDeportista();
	}
}
