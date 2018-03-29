package packGps;

public class RutaEnConstruccion extends RutaPavimentada {
	private float tiempoEstadar = 0;
	private static float PorcentajeDeDemora = (float) 0.3;
	private float tiempoEnConstruccion = 0;

	/**
	 * Es el Constructor de Ruta que recibe un {@link Punto punto}  de origen y un
	 * punto de destino y una velocidad maxima de l ruta.
	 * @param longitud
	 * @param velocidadMaxima
	 * @param origen
	 * @param destino
	 * 
	 * ver {@link Ruta ruta}
	 */
	public RutaEnConstruccion(int longitud, float velocidadMaxima,Punto extremoA, Punto extremoB) {
		super(longitud, velocidadMaxima, extremoA, extremoB);

	}

	@Override
	public float calcularTiempoRecorrido(float longitud, float velocidadMaxima) {
		tiempoEstadar = super.calcularTiempoRecorrido(longitud, velocidadMaxima);
		tiempoEnConstruccion = tiempoEstadar + tiempoEstadar * PorcentajeDeDemora;
		return tiempoEnConstruccion;
	}

}
