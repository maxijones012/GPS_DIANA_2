package packGps;

public class EstacionDeServicio extends PuntoDeInteres {
	private TipoDeCombustible tipoDeCombustible;
	private Marca marca;

	
	public EstacionDeServicio(int kilometro, Ruta ruta) {
		super(kilometro, ruta);
		// TODO Auto-generated constructor stub
	}



	public EstacionDeServicio(TipoDeCombustible tipoDeCombustible, Marca marca,int kilometro, Ruta ruta) {
		super(kilometro, ruta);
		this.tipoDeCombustible = tipoDeCombustible;
		this.marca = marca;
	}

	

	public TipoDeCombustible getTipoDeCombustible() {
		return tipoDeCombustible;
	}

	public void setTipoDeCombustible(TipoDeCombustible tipoDeCombustible) {
		this.tipoDeCombustible = tipoDeCombustible;
	}

	public Marca getMarca() {
		return marca;
	}

	public void setMarca(Marca marca) {
		this.marca = marca;
	}

}
