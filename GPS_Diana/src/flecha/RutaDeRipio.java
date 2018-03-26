package flecha;

import java.util.Random;

import grafo.Punto;

public class RutaDeRipio extends Ruta {
	private float porcentajeDisminucionVelocidad = (float) 0.25; // es un rango de 0 a 0.25, revisar!!!
	private float velocidadRipio;

	public RutaDeRipio(int longitud, float velocidadMaxima, Punto extremoA, Punto extremoB) {
		super(longitud, velocidadMaxima, extremoA, extremoB);

	}

	public float CalcularVelocidadMaxima(float velocidadMaxima) {
		Random rand = new Random();
		int val = rand.nextInt(25);
		velocidadRipio = velocidadMaxima * val;
		return velocidadRipio;

	}

}
