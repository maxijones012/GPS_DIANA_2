package flecha;

import java.util.ArrayList;

import grafo.Punto;
import packGps.PuntoDeInteres;

public abstract class Ruta extends Camino{
	private int longitud;
	private float velocidadMaxima;
	private ArrayList<PuntoDeInteres> listPuntosDeInteres;
	private float tiempoDeRecorrido;
	private Punto origen;
	private Punto destino;

	// Constructores
	public Ruta(int longitud, float velocidadMaxima, Punto origen, Punto destino) {
		this.origen = origen;
		this.destino = destino;
		this.longitud = longitud;
		this.velocidadMaxima = velocidadMaxima;
	}


	// Getters and Setters
	public float getLongitud() {
		return longitud;
	}

	public void setLongitud(int longitud) {
		this.longitud = longitud;
	}

	public float getVelocidadMaxima() {
		return velocidadMaxima;
	}

	public void setVelocidadMaxima(float velocidadMaxima) {
		this.velocidadMaxima = velocidadMaxima;
	}

	public ArrayList<PuntoDeInteres> getPuntosDeInteres() {
		return listPuntosDeInteres;
	}


	// TODO e podria agregar un metodo que olo reciba un puntgo de intere
	public void agregarPuntoInteres(PuntoDeInteres puntoInteres) {
		this.getPuntosDeInteres().add(puntoInteres);

	}

	public float getTiempoDeRecorrido() {
		return tiempoDeRecorrido;
	}

	public float calcularTiempoRecorrido(float longitud, float velocidadMaxima) {
		tiempoDeRecorrido = longitud * velocidadMaxima;
		return tiempoDeRecorrido;
	}



	public void setTiempoDeRecorrido(float tiempoDeRecorrido) {
		this.tiempoDeRecorrido = tiempoDeRecorrido;
	}


	public Punto getOrigen() {
		return origen;
	}


	public Punto getDestino() {
		return destino;
	}



	
	
}
