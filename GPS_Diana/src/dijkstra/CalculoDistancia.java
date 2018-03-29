package dijkstra;

import java.util.ArrayList;

import packGps.Mapa;
import packGps.Ruta;

public class CalculoDistancia {
/**
 * Obtiene el camino óptimo utilizando la lista de rutas, según las elecciones de origen y destino del usuario.
 * @param listaRuta
 * @param eleccionOrigen
 * @param eleccionDestino
 */
	public void calcularCamino(ArrayList<Ruta> listaRuta, String eleccionOrigen, String eleccionDestino){
		Nodo nodoA = new Nodo();
		nodoA.setNombre(" SOY NODO A");
				
		Nodo nodoB = new Nodo();
		nodoB.setNombre(" SOY NODO B");
		
		Grafo grafo = new Grafo();
		
		
		
		for (int i = 0; i < listaRuta.size(); i++) {
			Ruta rutaActual = listaRuta.get(i);
			
			nodoA.setNombre(rutaActual.getOrigen().getNombre());
			nodoB.setNombre(rutaActual.getDestino().getNombre());
			
			grafo.agregarNodo(nodoA);
			grafo.agregarNodo(nodoB);
			
			
			grafo.agregarCamino(nodoA,nodoB , (int) listaRuta.get(i).getLongitud());
		}
		
		grafo.mostrarNodos();
		grafo.generarRecorrido(nodoA);	
		
		
		nodoA = buscarEleccionOrigen(grafo.getNodos(), eleccionOrigen);
		
		//ACA VA LA OPCION DEL USUARIO!!
		grafo.caminoOptimo(nodoA,nodoB); 
		
//		actualizarColor(Mapa.getInstancia());
		
		
	}


	private Nodo buscarEleccionOrigen(ArrayList<Nodo> nodos, String eleccionOrigen) {
		
		Nodo aux = null;
		for (int i = 0; i < nodos.size(); i++) {
			if (nodos.get(i).getNombre()==eleccionOrigen){
				aux = nodos.get(i);
			}
		}
		return aux;
		
	}


}
