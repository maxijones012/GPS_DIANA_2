package PaqueteAux;

import java.util.ArrayList;

import flecha.Ruta;
import grafo.Punto;

public class test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		//crear nodos
		Nodo nodoA = new Nodo();
		nodoA.setNombre(" SOY NODO A");
				
		Nodo nodoB = new Nodo();
		nodoB.setNombre(" SOY NODO B");
		
		Nodo nodoC = new Nodo();
		nodoC.setNombre(" SOY NODO C");
		
		Nodo nodoD = new Nodo();
		nodoD.setNombre(" SOY NODO D");
		
		Nodo nodoE = new Nodo();
		nodoE.setNombre(" SOY NODO E");
		
		Nodo nodoF = new Nodo();
		nodoF.setNombre(" SOY NODO F");

		Nodo nodoG = new Nodo();
		nodoG.setNombre(" SOY NODO G");
		
		Nodo nodoH = new Nodo();
		nodoH.setNombre(" SOY NODO H");
		
		
		//CREO GRAFO E INGRESO LOS NODOS
		Grafo grafo = new Grafo();

//		grafo.agregarNodo(nodoC);
//		grafo.agregarNodo(nodoD);
//		grafo.agregarNodo(nodoE);
//		grafo.agregarNodo(nodoF);
//		grafo.agregarNodo(nodoG);
//		grafo.agregarNodo(nodoH);
//	
		
		//AGREGO CAMINOS
//		grafo.agregarCamino(nodoA,nodoB,6);		
//		grafo.agregarCamino(nodoA,nodoG,8);		
//		grafo.agregarCamino(nodoA,nodoD,5);	
//		grafo.agregarCamino(nodoB,nodoC,7);	
//		grafo.agregarCamino(nodoD,nodoB,1);		
//		grafo.agregarCamino(nodoD,nodoC,4);
//		grafo.agregarCamino(nodoD,nodoE,6);	
//		grafo.agregarCamino(nodoD,nodoH,3);		
//		grafo.agregarCamino(nodoC,nodoF,2);
//		grafo.agregarCamino(nodoC,nodoE,11);
//		grafo.agregarCamino(nodoE,nodoF,2);		
//		grafo.agregarCamino(nodoF,nodoH,4);
//		grafo.agregarCamino(nodoH,nodoG,2);		
//		grafo.agregarCamino(nodoG,nodoE,10);		
//		
		ArrayList<Ruta > listaRuta = new ArrayList<>(); 
//		agregarCamino(grafo, listaRuta);
		
		
		for (int i = 0; i < listaRuta.size(); i++) {
			Ruta rutaActual = listaRuta.get(i);
			
			grafo.agregarNodo(nodoA);
			grafo.agregarNodo(nodoB);
			
			nodoA.setNombre(rutaActual.getOrigen().getNombre());
			nodoB.setNombre(rutaActual.getDestino().getNombre());
			
			grafo.agregarCamino(nodoA,nodoB , (int) listaRuta.get(i).getLongitud());
		}
		
		
		grafo.mostrarNodos();
		grafo.generarRecorrido(nodoA);		
		grafo.caminoOptimo(nodoA,nodoF);
				
		
		System.out.println("*****	FIN	  *****");
		
		
		
	}
	
	public static void agregarCamino(Grafo grafo, ArrayList<Ruta> listaRuta){

		
		
	}
	
	
	
		
	
	
	
	
	
	
	
	
	
}
