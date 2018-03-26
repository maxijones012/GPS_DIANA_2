package packGps;

public class Alojamiento extends PuntoDeInteres {
	private int cantidadEstrellas;
	private String nombre;
	private boolean cochera;
	
	public Alojamiento(int kilometro, Ruta ruta) {
		super(kilometro, ruta);
	}

	public Alojamiento(int cantidadEstrellas, String nombre, boolean cochera, int kilometro, Ruta ruta) {
		super(kilometro, ruta);
		this.cantidadEstrellas = cantidadEstrellas;
		this.nombre = nombre;
		this.cochera = cochera;
	}

	public int getCantidadEstrellas() {
		return cantidadEstrellas;
	}

	public void setCantidadEstrellas(int cantidadEstrellas) {
		this.cantidadEstrellas = cantidadEstrellas;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public boolean isCochera() {
		return cochera;
	}

	public void setCochera(boolean cochera) {
		this.cochera = cochera;
	}

}
