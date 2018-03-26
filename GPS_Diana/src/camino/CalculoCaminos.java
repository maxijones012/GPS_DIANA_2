package camino;

import java.util.ArrayList;

import flecha.Ruta;
import grafo.Punto;

public class CalculoCaminos {
	
	private ArrayList<Nodo> listaNodo = new ArrayList<>();
	
	public void convertiraNodo(ArrayList<Ruta> listaRuta){
		Nodo nodoAux;
		Nodo nodoAnterior;
		
		for (int i = 0; i < listaRuta.size(); i++) {
			listaRuta.get(i).getDestino();
			nodoAnterior = new Nodo(null, listaRuta.get(i).getOrigen().getNombre(), listaRuta.get(i).getLongitud());
			
			nodoAux = new Nodo(nodoAnterior, listaRuta.get(i).getOrigen().getNombre(), listaRuta.get(i).getLongitud());
			
			listaNodo.add(nodoAux);
		}
	}

}
