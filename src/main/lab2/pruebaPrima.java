package main.lab2;

public class pruebaPrima {

	/**
	 */
	public static void main(String[] args) {

		String fD = "deportistas.txt";
		String resourcePathFD = pruebaPrima.class.getResource("/"+fD).getPath();
		TablaDeportista tD = new TablaDeportista(resourcePathFD);
		System.out.println("Tabla de deportistas ANTES DE sumar primas...");
		tD.mostrarDeportistas();
		System.out.println();

		String fE = "equipos.txt";
		String resourcePathFE = pruebaPrima.class.getResource("/"+fE).getPath();
		TablaEquipo tE = new TablaEquipo(resourcePathFE);
		
		Prima i = new Prima(200, 2100);
		int codErr = i.sumarPrima(tD, tE);
		System.out.println("Resultados...");
		System.out.println("Valor devuelto = " + codErr);
		System.out.println("Tabla de deportistas TRAS sumar primas...");
		tD.mostrarDeportistas();
		System.out.println();

	}

}
