package packGps;

import java.util.ArrayList;

public class Mapa implements Observador {
	private ArrayList<Punto> listaPuntos;
	private ArrayList<Ruta> listaRuta;
	private static Mapa instancia = new Mapa();

	public static Mapa getInstancia() {
		return instancia;
	}

	// Constructor
	private Mapa() {
		this.listaPuntos = new ArrayList<>();
		this.listaRuta = new ArrayList<>();
	}

	/**
	 * inicia el mapa, crea los elementos e inicia la vista
	 */
	public void iniciar() {
		crearElementos();
		crearVista();

	}

	/**
	 * crea la vista y agrega su observador
	 */
	private void crearVista() {
		Vista vista = Vista.getInstancia();
		vista.addObservador(this);

	}

	@Override // TODO VERIFICAR ESTO
	public void actualizar() {
	}

	/**
	 * Crea puntos y rutas y los agrega a la lista.
	 */
	private void crearElementos() {

		Rotonda rotonda1 = new Rotonda(new Posicion(400, 120), "5 de octubre");
		this.getListaPuntos().add(rotonda1);

		Ciudad esquel = new Ciudad(new Posicion(90, 180), "Esquel");
		this.getListaPuntos().add(esquel);

		Ciudad trelew = new Ciudad(new Posicion(450, 200), "Trelew");
		this.getListaPuntos().add(trelew);

		Ciudad comodoro = new Ciudad(new Posicion(550, 400), "Comodoro");
		this.getListaPuntos().add(comodoro);

		Ciudad rioMayo = new Ciudad(new Posicion(350, 430), "Rio Mayo");
		this.getListaPuntos().add(rioMayo);

		// --------------------------------------------------------

		RutaDeRipio rutaRipio = new RutaDeRipio(230, 230, rotonda1, esquel);
		this.getListaRuta().add(rutaRipio);

		RutaPavimentada rutaPavimentada1 = new RutaPavimentada(380, 100, trelew, comodoro);
		this.getListaRuta().add(rutaPavimentada1);

		RutaPavimentada rutaPavimentada2 = new RutaPavimentada(800, 120, esquel, comodoro);
		this.getListaRuta().add(rutaPavimentada2);

		RutaDeRipio rutaripio3 = new RutaDeRipio(380, 100, trelew, comodoro);
		this.getListaRuta().add(rutaripio3);

		RutaEnConstruccion rutaConst1 = new RutaEnConstruccion(200, 70, rioMayo, comodoro);
		this.getListaRuta().add(rutaConst1);

		RutaPavimentada rutaPavimentada3 = new RutaPavimentada(600, 110, rioMayo, esquel);
		this.getListaRuta().add(rutaPavimentada3);
	}

	/**
	 * Devuelve la lista de rutas.
	 * 
	 * @return listaRuta.
	 */
	public ArrayList<Ruta> getListaRuta() {
		return listaRuta;
	}

	/**
	 * Setea listaRuta.
	 */
	public void setListaRuta(ArrayList<Ruta> listaRuta) {
		this.listaRuta = listaRuta;
	}

	/**
	 * Devuelve la lista de puntos.
	 * 
	 * @return listaPuntos
	 */
	public ArrayList<Punto> getListaPuntos() {
		return listaPuntos;
	}

	/**
	 * Setea listaPuntos
	 * @param listaPuntos
	 */
	public void setListaPuntos(ArrayList<Punto> listaPuntos) {
		this.listaPuntos = listaPuntos;
	}

}
