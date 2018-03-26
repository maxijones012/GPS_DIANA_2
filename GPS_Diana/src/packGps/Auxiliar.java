package packGps;

import java.util.ArrayList;

import flecha.Ruta;
import grafo.Punto;

public class Auxiliar {
	private Punto[][] matriz = new Punto[100][100];

	public void pasarAMatriz(ArrayList<Ruta> listaRutas) {

		ArrayList<Punto> listaPuntos = obtenerPuntos(listaRutas);

		llenarFila(matriz, listaPuntos, listaRutas.size());
		llenarColumna(matriz, listaPuntos, listaRutas.size());

		mostrarMatrizConsola(matriz, listaRutas.size());

	}

	private void llenarColumna(Punto[][] matriz2, ArrayList<Punto> listaPuntos, int tope) {
		for (int fila = 0; fila < tope; fila++) {
			for (int col = 0; col < tope; col++) {

				// recorro la lista de puntos
				for (int j = 0; j < listaPuntos.size(); j++) {
					Punto puntero = listaPuntos.get(j); // solo lo uso para
														// buscar si se repite
														// en la lista

					// busco si ese punto se repite en la lista
					for (int i = 0; i < listaPuntos.size(); i++) {
						if (listaPuntos.get(i) == puntero) {
							matriz2[fila][fila] = listaPuntos.get(i);
						}
					}

				}

			}
		}

	}

	private void mostrarMatrizConsola(Punto[][] mat, int tope) {
		for (int fila = 0; fila < tope; fila++) {
			for (int col = 0; col < tope; col++) {
				Punto aux = mat[fila][col];
				System.out.print(aux.getNombre());
			}
			System.out.println("\n");
		}
	}

	private void llenarFila(Punto[][] matriz2, ArrayList<Punto> listaPuntos, int tope) {
		for (int fila = 0; fila < tope; fila++) {
			for (int col = 0; col < tope; col++) {

				// recorro la lista de puntos
				for (int j = 0; j < listaPuntos.size(); j++) {
					Punto puntero = listaPuntos.get(j); // solo lo uso para
														// buscar si se repite
														// en la lista

					// busco si ese punto se repite en la lista
					for (int i = 0; i < listaPuntos.size(); i++) {
						if (listaPuntos.get(i) == puntero) {
							matriz2[fila][col] = listaPuntos.get(i);
						}
					}

				}

			}
		}
	}

	/**
	 * obtengo todos los puntos de la lista de rutas;
	 * 
	 * @param listaRutas
	 * @return
	 */
	private ArrayList<Punto> obtenerPuntos(ArrayList<Ruta> listaRutas) {
		ArrayList<Punto> aux = new ArrayList<>();
		for (int i = 0; i < listaRutas.size(); i++) {
			aux.add(listaRutas.get(i).getOrigen());
			aux.add(listaRutas.get(i).getDestino());

		}
		return aux;

	};
}
