package flecha;

import grafo.Punto;

public class RutaEnConstruccion extends RutaPavimentada {
	private float tiempoEstadar = 0;
	private static float PorcentajeDeDemora = (float) 0.3;
	private float tiempoEnConstruccion = 0;

	public RutaEnConstruccion(int longitud, float velocidadMaxima,Punto extremoA, Punto extremoB) {
		super(longitud, velocidadMaxima, extremoA, extremoB);

	}

	@Override
	public float calcularTiempoRecorrido(float longitud, float velocidadMaxima) {
		tiempoEstadar = super.calcularTiempoRecorrido(longitud, velocidadMaxima);
		tiempoEnConstruccion = tiempoEstadar + tiempoEstadar * PorcentajeDeDemora;
		return tiempoEnConstruccion;
	}

}
