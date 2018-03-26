package dijkstra;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;


public class Grafo {
	private ArrayList<Nodo>  nodos;	
	private ArrayList<Nodo> listaAux;
	
	// C O N S T R U C T O R 
	public Grafo(){
		this.nodos = new ArrayList<Nodo>();
	}
	
	
	public ArrayList<Nodo> getNodos() {
		return nodos;
	}
	public void setNodos(ArrayList<Nodo> nodos) {
		this.nodos = nodos;
	}

	
	// M E T O D O S 
	
	
	
	public void agregarNodo(Nodo nodo){
		this.nodos.add(nodo);
	}

	
	public void agregarCamino(Nodo nodo1, Nodo nodo2, int peso ){		//nodo 1 tiene que ser el ORIGEN, PESO es la distancia;
			Camino camino=new Camino(nodo1,nodo2,peso);
			nodo1.getCaminosAdyasentes().add(camino);
			nodo2.getCaminosAdyasentes().add(camino);		
	}
	
		
	public void mostrarNodos() {
		Iterator i = this.nodos.iterator();
		while(i.hasNext()){
			Nodo var= (Nodo)i.next();	
			System.out.println(var.toString());
		}		
	}
	
	
	
	public void caminoOptimo(Nodo nodo1, Nodo nodo2){
				
		if ((this.esValido(nodo1)) && (this.esValido(nodo2))){
			System.out.println("RECORRIDO desde  "+ nodo1 + "  hasta  "+ nodo2);
			this.mostrarCamino(nodo1, nodo2);	
			System.out.println("FIN DE CAMINO OPTIMO");			
		}		
	}
		
		
	public void generarRecorrido(Nodo nodo1){
		if (this.esValido(nodo1))
			dijkstra(nodo1);				
	}
		
						
		
	public void dijkstra(Nodo nodo1){
				
		System.out.println("MARCO A "  + nodo1);
		nodo1.setMarcado(true);		
		Nodo nodoAux = new Nodo();
		this.listaAux= new ArrayList<Nodo>();		
			
					//	RECORRO Y SETEO VALORES
		
		Iterator i = nodo1.getCaminosAdyasentes().iterator();		
		while (i.hasNext()){
			Camino cam = (Camino)i.next();			
			nodoAux = cam.devolverNodo(nodo1);			
			if (nodoAux.isMarcado() == false) {
				this.listaAux.add(nodoAux);
				if (nodoAux.isVisitado()){
					if ((nodoAux.getPesoAcumulado()) > (nodo1.getPesoAcumulado() + cam.getPeso()))
						this.setearDatos(nodoAux,nodo1,cam.getPeso());		
				}
				else{
					this.setearDatos(nodoAux,nodo1,cam.getPeso());	
				}				
			}
		}
		
							//BUSCO EL DE MENOR PESO.
		if (this.listaAux.size() == 0)
			return;
		
		nodoAux = this.listaAux.get(0);		
		Iterator j = this.listaAux.iterator();		
		while (j.hasNext()){
			Nodo nodo = (Nodo)j.next();	
			if ((nodoAux.getPesoAcumulado() > (nodo.getPesoAcumulado())))
				nodoAux = nodo;
		}
		
		System.out.println("EL NODO CON MENOR PESO ES:" + nodoAux.getNombre());
		this.dijkstra(nodoAux);
				
			
	}
	
	
	
	
	public void mostrarCamino(Nodo nodo1, Nodo nodo2){
	
		Stack pila = new Stack();
		Nodo nodoAux= new Nodo();
		nodoAux=nodo2;		
		while (nodoAux!=null){
			pila.push(nodoAux);
			nodoAux = nodoAux.getNodoAnterior();			
		}
		int x=0;
		while (!(pila.empty())){
			x++;
			nodoAux = (Nodo)pila.pop();
			System.out.println(x + "_  A  "+ nodoAux.getPesoAcumulado() + " km se encuentra:  " + nodoAux );
		}		
		
	}
	
	
	
	
	
	public void setearDatos(Nodo temp,Nodo nodo1, int pesoCamino){
			//seteo el nodoAnterior del nodo que esta conectado con nodo1		
		temp.setNodoAnterior(nodo1); 
			//seteo peso acumulado del nodo conectado con nodo1
		temp.setPesoAcumulado(nodo1.getPesoAcumulado()+ pesoCamino);					
			//LO MARCO COMO VISITADO.
		temp.setVisitado(true); 		
		System.out.println("peso acumulado para "+ temp.getNombre() + "= "+temp.getPesoAcumulado() );		
				
	}


	/*public boolean nodoExiste(Nodo nodo1){
	
	Iterator i = this.nodos.iterator();
	
	while (i.hasNext()) {
		Nodo nodo = (Nodo)i.next();
		if (nodo.equals(nodo1))
			return true;
		}
	System.out.println( nodo1 +"NO EXISTE EN EL GRAFO");
	return false;
	}
*/


	
	public void objetoPosicion(int pos){
		try{
			System.out.println(this.nodos.get(pos));
		}
		catch (Exception e){
			System.out.println("ERROR POSICION NO ENCONTRADA");					
		}
		
	}





	public boolean esValido (Nodo nodo1){
		
		if (this.nodos.contains(nodo1)){
			if (nodo1.getCaminosAdyasentes().size()==0){
				System.out.println("NODO:  "+ nodo1 + "  NO TIENE NODOS ADYASENTES");				
			}
			else{
				return true;
			}
		}
		else{
			System.out.println("EL NODO INGRESADO NO PERTENECE AL GRAFO.");
		}
		return false;
		
	
		
	}
}
