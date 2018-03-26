package packGps;

import java.util.*;

public class Dijkstra {
	public int distancia[] = new int[10];
	public int costo[][] = new int[10][10];

	
	//	buscarTotalPunto(Mapa.getInstancia().getListaPuntos().size()); //DEBERIA DEVOLVER 'N'

	public void calcular(int n, int origen) { //N= NUMERO DE NOTODS
		int bandera[] = new int[n + 1];
		int i, minpos = 1, k, c, minimum;

		for (i = 1; i <= n; i++) {
			bandera[i] = 0;
			this.distancia[i] = this.costo[origen][i];
		}
		c = 2;
		while (c <= n) {
			minimum = 99;
			for (k = 1; k <= n; k++) {
				if (this.distancia[k] < minimum && bandera[k] != 1) {
					minimum = this.distancia[i];
					minpos = k;
				}
			}
			bandera[minpos] = 1;
			c++;
			for (k = 1; k <= n; k++) {
				if (this.distancia[minpos] + this.costo[minpos][k] < this.distancia[k] && bandera[k] != 1)
					this.distancia[k] = this.distancia[minpos] + this.costo[minpos][k];
			}
		}

	}

	public static void main(String args[]) {
		int nodes, source, i, j; //buscar la cantidad de puntos
		Scanner in = new Scanner(System.in);
//		buscarTotalPunto(Mapa.getInstancia().getListaPuntos().size());
		System.out.println("ingrese la cantidad de nodos \n");
		nodes = in.nextInt();
		Dijkstra d = new Dijkstra();
		System.out.println("Enter the Cost Matrix Weights: \n");
		for (i = 1; i <= nodes; i++)
			for (j = 1; j <= nodes; j++) {
				d.costo[i][j] = in.nextInt();
				if (d.costo[i][j] == 0)
					d.costo[i][j] = 999;
			}
		System.out.println("Enter the Source Vertex :\n");
		source = in.nextInt();

		d.calcular(nodes, source);
		System.out.println("The Shortest Path from Source \t" + source + "\t to all other vertices are : \n");
		for (i = 1; i <= nodes; i++)
			if (i != source)
				System.out.println(
						"source :" + source + "\t destination :" + i + "\t MinCost is :" + d.distancia[i] + "\t");

	}
}