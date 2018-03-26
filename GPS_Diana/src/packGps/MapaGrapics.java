package packGps;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.util.HashMap;

import javax.imageio.ImageIO;

import com.sun.prism.Graphics;

import flecha.Camino;
import flecha.Ruta;
import grafo.Punto;

public class MapaGrapics extends Canvas {
	private HashMap<String, BufferedImage> listaImagenes;

	/**
	 * Crea un buffer para eliminar el parpadeo de la pantalla
	 */
	public void inicializar() {
		// Crea dos buffers para dibujar.
		this.createBufferStrategy(2);
		// this.addKeyListener(this);
	}

	private void dibujar() {
		for (int i = 0; i < Mapa.getInstancia().getListaRuta().size(); i++) {
			Ruta aux = Mapa.getInstancia().getListaRuta().get(i);

			Punto origen = aux.getOrigen();
			Punto destino = aux.getDestino();

			int x1 = (int) origen.getPosicion().getLatitud();
			int y1 = (int) origen.getPosicion().getLongitud();
			int x2 = (int) destino.getPosicion().getLatitud();
			int y2 = (int) destino.getPosicion().getLongitud();

			this.getGraphics().drawLine(x1, y1, x2, y2);
			// this.getGraphics().drawLine(0, 0, 180, 180);

			// this.getGraphics().dispose();
			// this.getGraphics().fill

		}

		for (int j = 0; j < Mapa.getInstancia().getListaPuntos().size(); j++) {
			Punto aux = Mapa.getInstancia().getListaPuntos().get(j);

			int x = (int) aux.getPosicion().getLatitud();
			int y = (int) aux.getPosicion().getLongitud();

			// this.getGrafico2D().setColor(Color.red);
			this.getGraphics().fillOval(x-5, y-5, 10, 10);
			this.getGraphics().drawString(aux.getNombre(), x, y);

		}

		// this.getBufferStrategy().show();
	}

	/**
	 * Obtien el patch, o la ruta de la imagen dentro del proyecto
	 * 
	 * @param key
	 * @return
	 */
	private BufferedImage getImagen(String key) {
		if (listaImagenes == null)
			listaImagenes = new HashMap<String, BufferedImage>();
		BufferedImage img = listaImagenes.get(key);
		if (img == null) {
			img = cargarImagen(System.getProperty("user.dir") + File.separator + "img" + File.separator + key + ".png");
			if (img != null) {
				if (key != "fondo")
					img = cambiarTamanio(img, 50, 50);
				listaImagenes.put(key, img);

			}
		}
		return img;
	}

	public static BufferedImage cambiarTamanio(BufferedImage img, int ancho, int alto) {

		// BufferedImage newImage = new BufferedImage(ancho,alto,
		// BufferedImage.TYPE_INT_RGB); //esto agrega el fondo en los elementos
		BufferedImage newImage = new BufferedImage(ancho, alto, BufferedImage.TRANSLUCENT);

		Graphics2D g = newImage.createGraphics();
		g.drawImage(img, 0, 0, ancho, alto, null);
		g.dispose();

		return newImage;
	}

	/**
	 * Obtengo el buffer que contiene todas las imagenes del juego
	 * 
	 * @return listaImagenes
	 */
	public HashMap<String, BufferedImage> getListaImagenes() {
		return listaImagenes;
	}

	/**
	 * Carga las imagenes desde el fichero de sistema
	 * 
	 * @param fileName
	 * @return new FileName or "no se encontro la imagen"
	 */
	private BufferedImage cargarImagen(String fileName) {
		try {
			return ImageIO.read(new File(fileName));
		} catch (Exception e) {
			System.out.println("No se encontro la imagen " + fileName);

			return null;
		}

	}

	/**
	 * Actualiza la pantalla
	 */
	public void actualizar() {
		limpiar();
		dibujar();
	}

	/**
	 * Limpia la pantalla o ventana de juego
	 */
	private void limpiar() {
		this.getGraphics().drawImage(getImagen("fondo"), 0, 0, getWidth(), getHeight(), null);
		// this.getGrafico2D().drawImage(getImagen("fondo"), 0, 0, getWidth(),
		// getHeight(), null);
		this.getGrafico2D().dispose();

	}

	/**
	 * obtiene el buffer de imagenes
	 * 
	 * @return
	 */
	public Graphics2D getGrafico2D() {
		if (this.getBufferStrategy() == null)
			return (Graphics2D) this.getGraphics();
		else
			return (Graphics2D) this.getBufferStrategy().getDrawGraphics();
	}

}
