package packGps;

import java.util.ArrayList;

import PaqueteAux.CalculoDistancia;
import flecha.Camino;
import flecha.Ruta;
import flecha.RutaDeRipio;
import flecha.RutaPavimentada;
import grafica.Panel;
import grafo.Ciudad;
import grafo.Punto;
import grafo.Rotonda;
import interfaces.ActualizarVista;

public class Mapa implements ActualizarVista{
//	private ArrayList<Camino> listaObservadores = new ArrayList<>();
	private String eleccionOrigen;
	private String eleccionDestino;
	private ArrayList<Punto> listaPuntos;
	private ArrayList<Ruta> listaRuta;


	public static Mapa instancia = new Mapa();
	
	// Interaccion con camino???
	
	private Mapa() {
		this.listaPuntos=new ArrayList<>();
		this.listaRuta= new ArrayList<>();
	}
	
	public static Mapa getInstancia(){
		return instancia;
	}
	
	public ArrayList<Punto> getListaPuntos() {
		return listaPuntos;
	}

	public void setListaPuntos(ArrayList<Punto> listaPuntos) {
		this.listaPuntos = listaPuntos;
	}

	public void iniciar() {
//		Panel panel = new Panel();
		VTableroMapa vista = new VTableroMapa();
//		vista.main(null);
		
		crearElementos();
		
		vista.cargarComponentes(this);
		
//		CalculoDistancia calculo = new CalculoDistancia();
//		calculo.CalcularCamino(listaRuta, this.eleccionOrigen, this.eleccionDestino);
		while (true) {
			vista.actualizar(this);
			
		}
		
		
	}


	private void crearElementos() {
//		this.listaPuntos = new ArrayList<>();
		
		Rotonda rotonda1 = new Rotonda(new Posicion(400, 120), "Profe enojado");
		this.getListaPuntos().add(rotonda1);
		
		Rotonda rotonda2 = new Rotonda(new Posicion(430, 400), "Objetos");
		this.getListaPuntos().add(rotonda2);
		
		Ciudad esquel = new Ciudad(new Posicion(90,180), "Esquel");
		this.getListaPuntos().add(esquel);
		
		Ciudad trelew = new Ciudad(new Posicion(450, 200),"Trelew");
		this.getListaPuntos().add(trelew);
		
		Ciudad comodoro = new Ciudad(new Posicion(400, 400), "Comodoro");
		this.getListaPuntos().add(comodoro);
		
		//--------------------------------------------------------
		
		RutaDeRipio rutaRipio = new RutaDeRipio(230, 230, rotonda1, esquel);
		this.getListaRuta().add(rutaRipio);
		
		
		RutaPavimentada rutaPavimentada1 = new RutaPavimentada(380, 100, trelew, comodoro);
		this.getListaRuta().add(rutaPavimentada1);
		
		
	}

	public ArrayList<Ruta> getListaRuta() {
		return listaRuta;
	}

	public void setListaRuta(ArrayList<Ruta> listaRuta) {
		this.listaRuta = listaRuta;
	}

	@Override
	public void actualizar() {
//		for (int i = 0; i < listaObservadores.size(); i++) {
//			listaObservadores.get(i).actualizar();
//		}
		
	}

	public String getEleccionOrigen() {
		return eleccionOrigen;
	}

	public void setEleccionOrigen(String eleccion) {
		this.eleccionOrigen = eleccion;
	}

	public String getEleccionDestino() {
		return eleccionDestino;
	}

	public void setEleccionDestino(String eleccionDestino) {
		this.eleccionDestino = eleccionDestino;
	}


}
