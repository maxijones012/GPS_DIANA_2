package grafo;

import java.util.ArrayList;

import packGps.Posicion;

public abstract class Punto {
	private Punto puntoAntecesor=null;
	private Posicion posicion;// Atributos comunes a las SubClases. Son equivalentes semánticamente los
								// atributos posicion ~ ubicacion, tomaaremos posicion.
	private String nombre;
	private ArrayList<Punto> listaAdyacentes = new ArrayList<>();

//	construcotr
	public Punto(Posicion posicion, String nombre) {
		this.posicion = posicion;
		this.nombre=nombre;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Posicion getPosicion() {
		return posicion;
	}

	public void setPosicion(Posicion posicion) {
		this.posicion = posicion;
	}

	public Punto getPuntoAntecesor() {
		return puntoAntecesor;
	}

	public void setPuntoAntecesor(Punto puntoAntecesor) {
		this.puntoAntecesor = puntoAntecesor;
	}

}
