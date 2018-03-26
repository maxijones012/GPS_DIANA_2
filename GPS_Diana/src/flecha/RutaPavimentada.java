package flecha;

import grafo.Punto;

public class RutaPavimentada extends Ruta {

	public RutaPavimentada(int longitud, float velocidadMaxima, Punto extremoA, Punto extremoB) {
		super(longitud, velocidadMaxima, extremoA, extremoB);

	}

	@Override
	public float calcularTiempoRecorrido(float longitud, float velocidadMaxima) {
		return super.calcularTiempoRecorrido(longitud, velocidadMaxima);
	}
}
