package dijkstra;

public class Camino {
	
	private int peso;	
	private Nodo nodo1,nodo2;
	
	
	// C O N S T R U C T O R
	public Camino(Nodo nodo1, Nodo nodo2, int peso){
		this.nodo1=nodo1;
		this.nodo2=nodo2;
		this.peso=peso;		
	} 
	

	public int getPeso() {
		return peso;
	}
	public void setPeso(int peso) {
		this.peso = peso;
	}
	public Nodo getNodo1() {
		return nodo1;
	}
	public void setNodo1(Nodo nodo1) {
		this.nodo1 = nodo1;
	}
	public Nodo getNodo2() {
		return nodo2;
	}
	public void setNodo2(Nodo nodo2) {
		this.nodo2 = nodo2;
	}
	
	
	//metodo que devuelve el nodo que esta conectado con el nodo que se recibe.
	public Nodo devolverNodo(Nodo nodo){
		if (this.nodo1.equals(nodo)){
			return this.nodo2;
		}
		else{
			return this.nodo1;
		}
	}
	
	
}
