package PaqueteAux;

import java.util.ArrayList;
import java.util.LinkedHashSet;


public class Nodo {
	
	private String nombre;
	private int pesoAcumulado;
	private boolean marcado, visitado;
	private ArrayList<Camino> caminosAdyasentes;
	private Nodo nodoAnterior;
	
	// C O N S T R R U C T O R E S 
	
	public Nodo(){
		this.nombre=" ";
		this.pesoAcumulado=0;
		this.marcado=false;
		this.visitado=false;
		this.nodoAnterior=null;
		this.caminosAdyasentes=new  ArrayList<Camino>();
	}
	public Nodo(String nombre){
		this.nombre=nombre;
	}

	

	//METODOS SETTER Y GETTERS
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public int getPesoAcumulado() {
		return pesoAcumulado;
	}
	public void setPesoAcumulado(int pesoAcumulado) {
		this.pesoAcumulado = pesoAcumulado;
	}
	public boolean isMarcado() {
		return marcado;
	}
	public void setMarcado(boolean marcado) {
		this.marcado = marcado;
	}
	public boolean isVisitado() {
		return visitado;
	}
	public void setVisitado(boolean visitado) {
		this.visitado = visitado;
	}
	public ArrayList<Camino> getCaminosAdyasentes() {
		return caminosAdyasentes;
	}
	public void setCaminosAdyasentes(ArrayList<Camino> caminosAdyasentes) {
		this.caminosAdyasentes = caminosAdyasentes;
	}
	public Nodo getNodoAnterior() {
		return nodoAnterior;
	}
	public void setNodoAnterior(Nodo nodoAnterior) {
		this.nodoAnterior = nodoAnterior;
	}

	

	@Override
	public String toString() {
		return  this.nombre ;
	}
	
	
	public boolean equals (Object obj) {
		// TODO Auto-generated method stub
		if (obj instanceof Nodo == false)
			return false;
		Nodo nodo = (Nodo)obj;
		if (this.getNombre().compareTo(nodo.getNombre())==0)
			return true;
		return false;
				}
	
	
}
