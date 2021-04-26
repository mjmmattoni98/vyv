package main.lab2;

public class Deportista {
	private String nombre;
	private boolean esCapi;
	private String equipo;
	private float ficha;
	
	public Deportista(String n, boolean eC, String e, float f){
		nombre = n;
		esCapi = eC;
		equipo = e;
		ficha = f;
	}
	
	public String obtenerEquipo(){
		return equipo;
	}
	
	public boolean obtenerEsCapi(){
		return esCapi;
	}
	
	public float obtenerFicha(){
		return ficha;
	}
	
	public void incrementarFicha(float prima){
		ficha += prima;
	}
	
	public void mostrarDeportista(){
		System.out.println(nombre+" "+ esCapi +" "+ equipo +" "+ ficha);
	}
}

