package camino;

public class Nodo {
	private Nodo NodoAnterior;
	private String nombre;
	private float longuitud;

	// constructor
	public Nodo(Nodo nodoAnterior, String nombre, float f) {
		NodoAnterior = nodoAnterior;
		this.nombre = nombre;
		this.longuitud = f;
	}

	public Nodo getNodoAnterior() {
		return NodoAnterior;
	}

	public void setNodoAnterior(Nodo nodoAnterior) {
		NodoAnterior = nodoAnterior;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public float getLonguitud() {
		return longuitud;
	}

	public void setLonguitud(int longuitud) {
		this.longuitud = longuitud;
	}

}
