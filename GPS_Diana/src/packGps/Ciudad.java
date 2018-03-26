package packGps;

public class Ciudad extends Punto {
	
	
	public Ciudad(Posicion posicion,String nombre) {
		super(posicion, nombre);
		// TODO Auto-generated constructor stub
	}

	private long cantidadDeHabitantes;

	public long getCantidadDeHabitantes() {
		return cantidadDeHabitantes;
	}

	public void setCantidadDeHabitantes(long cantidadDeHabitantes) {
		this.cantidadDeHabitantes = cantidadDeHabitantes;
	}

}
