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

	private void dibujarPuntos() {

	}

	@Override
	public void actualizar() {
		// TODO cUANDO PRESIONE E BOTÓN bUSCAR deberia hacer los calculos d cual
		// es el camino optimo y su dibujo.

	}

	private void crearElementos() {

		Rotonda rotonda1 = new Rotonda(new Posicion(400, 120), "5 de octubre");
		this.getListaPuntos().add(rotonda1);

		Ciudad esquel = new Ciudad(new Posicion(90, 180), "Esquel");
		this.getListaPuntos().add(esquel);

		Ciudad trelew = new Ciudad(new Posicion(450, 200), "Trelew");
		this.getListaPuntos().add(trelew);

		Ciudad comodoro = new Ciudad(new Posicion(400, 400), "Comodoro");
		this.getListaPuntos().add(comodoro);

		// --------------------------------------------------------

		RutaDeRipio rutaRipio = new RutaDeRipio(230, 230, rotonda1, esquel);
		this.getListaRuta().add(rutaRipio);

		RutaPavimentada rutaPavimentada1 = new RutaPavimentada(380, 100, trelew, comodoro);
		this.getListaRuta().add(rutaPavimentada1);

		RutaPavimentada rutaPavimentada2 = new RutaPavimentada(800, 120, esquel, comodoro);
		this.getListaRuta().add(rutaPavimentada2);

	}

	public ArrayList<Ruta> getListaRuta() {
		return listaRuta;
	}

	public void setListaRuta(ArrayList<Ruta> listaRuta) {
		this.listaRuta = listaRuta;
	}

	public ArrayList<Punto> getListaPuntos() {
		return listaPuntos;
	}

	public void setListaPuntos(ArrayList<Punto> listaPuntos) {
		this.listaPuntos = listaPuntos;
	}

}
