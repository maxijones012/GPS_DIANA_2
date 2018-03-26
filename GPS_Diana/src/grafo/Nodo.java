package grafo;

public class Nodo {
	private Punto punto;

	private Nodo NodoAntecesor;

	public void setPunto(Punto punto) {
		this.punto = punto;
	}

	public Nodo getNodoAntecesor() {
		return NodoAntecesor;
	}

	public void setNodoAntecesor(Nodo nodoAntecesor) {
		NodoAntecesor = nodoAntecesor;
	}

}
