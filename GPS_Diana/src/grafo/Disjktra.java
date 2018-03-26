//package grafo;
//
//import java.util.ArrayList;
//
//import flecha.Ruta;
//import packGps.Mapa;
//
//public class Disjktra {
//	private ArrayList<Nodo>ListaNodos;
////	public int buscarCamino(Punto puntoFinal, Punto puntoInicio){
////		
////		Punto aux = puntoFinal;
////		while (aux.getPuntoAntecesor()!=null){
////			if (aux.getPuntoAntecesor().getNombre()==puntoInicio.getPuntoAntecesor().getNombre()){
////				return ();
////			}else{
////				buscarCamino(puntoFinal.getPuntoAntecesor(), puntoInicio);
////			}
////		}
////		
////	};
//	
//	
////	public void buscarRutaOptima(String nombre){
////		ArrayList<Ruta> listAux = Mapa.getInstancia().getListaRuta();
////		
////		
////		for (int i = 0; i < listAux.size() ; i++) {
////			Punto auxO = listAux.get(i).getOrigen();
////			Punto auxD = listAux.get(i).getDestino();
////			if (auxO.getNombre()==nombre)
////		}
////	};
////	
//	private Disjktra() {
//		this.ListaNodos = new ArrayList<>();
//	}
//	
//	
//	public void convertirANodo(ArrayList<Ruta> listRuta){
//		for (int i = 0; i < listRuta.size(); i++) {
//			Nodo aux;
//			aux.setNodoAntecesor(listRuta.get(i).getOrigen());
//			this.ListaNodos.add(aux);
//			
//			
//		}
//	}
//
//	
//	
//	
//	
//	
//	
//	
//	
//	
//	
//
//	public Punto getListaNodos() {
//		return ListaNodos;
//	}
//
//
//	public void setListaNodos(Punto listaNodos) {
//		ListaNodos = listaNodos;
//	};
//	
//	
//}
