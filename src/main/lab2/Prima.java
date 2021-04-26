package main.lab2;

public class Prima {
	private float prima;
	private float umbralFicha;
	
	public Prima(float p, float uF){
		prima = p;
		umbralFicha = uF;
	}
	
	public int sumarPrima(TablaDeportista tD, TablaEquipo tE){
		int puntosEquipo;
		String equipoDeportista;
		String mejorEquipo;
		boolean esCapiDeportista;
		float fichaDeportista;
		byte encontrado;
		int maxPuntos = 0;
		int codError = 0;  // valor que devolver (0 == sin incidencias)
		int numDeportistas = tD.obtenerNumDeportistas();  // obtiene cantidad de deportistas de la tabla
		int numEquipos = tE.obtenerNumEquipos();  // obtiene cantidad de equipos de la tabla

		if (numDeportistas == 0 || numEquipos == 0)
			codError = 1;  // 1 == al menos una tabla SIN entradas
		else{
			// busca mayor cantidad de puntos entre equipos
			for (int i=0; i<numEquipos; i++){
				puntosEquipo = tE.obtenerPuntos(i);  // puntos del equipo #i en la tabla
				if (puntosEquipo > maxPuntos) maxPuntos = puntosEquipo;
			}
			// busca equipos con mayor cantidad de puntos (mejores equipos)
			for (int i=0; i<numEquipos; i++){
				puntosEquipo = tE.obtenerPuntos(i);
				if (puntosEquipo == maxPuntos){
					mejorEquipo = tE.obtenerNombre(i);
					// busca deportistas de mejor equipo
					encontrado = 0; 
					for (int j=0; j<numDeportistas; j++){
						equipoDeportista = tD.obtenerEquipo(j);
						if (mejorEquipo.equals(equipoDeportista)){
							encontrado = 1;
							fichaDeportista = tD.obtenerFicha(j);
							esCapiDeportista = tD.obtenerEsCapi(j);
							if (fichaDeportista < umbralFicha && esCapiDeportista)
								tD.incrementarFicha(j, 2*prima);
							else
								tD.incrementarFicha(j, prima);
						}
					}
					if (encontrado == 0)
						codError = 2;  // 2 == al menos un mejor equipo SIN deportistas
				}
				
			}
		}		
		return codError;
	}
}
