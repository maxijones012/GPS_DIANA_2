package packGps;

import java.util.ArrayList;

public interface Observable {
	public void addObservador(Observador obs);
	public void removerObservador(Observador obs);
	public void notificar();
}
