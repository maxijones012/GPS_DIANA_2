package packGps;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Dialog;
import java.awt.Dimension;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import javax.imageio.ImageIO;
import javax.swing.JOptionPane;
import packGps.*;

public class DibujoCanvas extends Canvas implements packGps.Observable {
	private HashMap<String, BufferedImage> listaImagenes;
	private Observador observador;

	public static DibujoCanvas instancia = new DibujoCanvas();

	/**
	 * Devuelve la única instancia de DibujoCanvas
	 * @return instancia.
	 */
	public static DibujoCanvas getInstancia() {
		return instancia;
	}

	/**
	 * Contructor de DibujoCanvas.
	 */
	private DibujoCanvas() {

		this.setVisible(true);
		this.setSize(800, 600);
		this.addMouseListener(new MouseListener() {

			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mousePressed(MouseEvent e) {

			}

			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mouseClicked(MouseEvent e) {
				System.out.println("hola");
			}

		});
	}
	
    /**
     *  
     */
	@Override
	public void paint(Graphics g) {
		g.setColor(this.getBackground().red);
		dibujarFondo(g);

		dibujarElementos(g);

	}

	private void dibujarElementos(Graphics g) {
		dibujarPunto(g);
		dibujarRuta(g);
	}

	private void dibujarPunto(Graphics g) {
		for (int i = 0; i < Mapa.getInstancia().getListaPuntos().size(); i++) {
			int latitud = (int) Mapa.getInstancia().getListaPuntos().get(i).getPosicion().getLatitud();
			int longitud = (int) Mapa.getInstancia().getListaPuntos().get(i).getPosicion().getLongitud();
			String nombrePunto = Mapa.getInstancia().getListaPuntos().get(i).getNombre();
			//TODO DIBUJAR STRING (.drawSgtring)
			this.getGraphics().setColor(Color.red);
			this.getGraphics().drawOval(latitud-10, longitud-10, 25, 25);
			this.getGraphics().drawString(nombrePunto, (latitud-20), longitud-5);
		}
	}

	private void dibujarRuta(Graphics g) {
		for (int i= 0; i< Mapa.getInstancia().getListaRuta().size(); i++) {
			Punto origen=Mapa.getInstancia().getListaRuta().get(i).getOrigen();
			Punto destino=Mapa.getInstancia().getListaRuta().get(i).getDestino();
			
			int x1=(int) origen.getPosicion().getLatitud();
			int y1=		(int) origen.getPosicion().getLongitud();
			int x2=(int) destino.getPosicion().getLatitud();
			int y2=(int) destino.getPosicion().getLongitud();
			this.getGraphics().drawLine(x1,y1 ,x2 ,y2);
		}
	}



	public void actualizar() {
		paint(this.getGraphics());
	}

	private void dibujarFondo(Graphics g) {
		g.drawImage(getImagen("fondo"), 0, 0, getWidth(), getHeight(), null);
	};

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

	private BufferedImage cargarImagen(String fileName) {
		try {
			return ImageIO.read(new File(fileName));
		} catch (Exception e) {
			System.out.println("No se encontro la imagen " + fileName);

			return null;
		}

	}

	public static BufferedImage cambiarTamanio(BufferedImage img, int ancho, int alto) {

		BufferedImage newImage = new BufferedImage(ancho, alto, BufferedImage.TYPE_INT_RGB); // esto
																								// agrega																						// elementos

		Graphics2D g = newImage.createGraphics();
		// g.setPaint(Color.red);
		g.drawImage(img, 0, 0, ancho, alto, null);
		return newImage;
	}

	@Override
	public void addObservador(Observador obs) {
		this.observador = obs;
	}

	@Override
	public void removerObservador(Observador obs) {
		this.observador = null;
	}

	@Override
	public void notificar() {
		this.observador.actualizar();

	}

	public void cargarComponentes(Mapa mapaModelo) {
		paint(getGraphics());
	}
}
