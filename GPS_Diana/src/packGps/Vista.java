package packGps;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JTextPane;

import dijkstra.CalculoDistancia;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JRadioButton;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import java.awt.Canvas;
import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

public class Vista implements Observable {

	JFrame frmGpsDiana;
	JRadioButton radioBotonMasCorto = new JRadioButton("Más corto");
	JRadioButton radioBotonMasRapido = new JRadioButton("Más rápido");
	private Observador observador;
	public String eleccionDestino;
	
	private static Vista instancia = new Vista();// Usamos Singleton.

	/**
	 * @wbp.parser.entryPoint
	 */
	public static Vista getInstancia() {// Metodo delpatron singleton.
		return instancia;
	}

	/**
	 * Launch the application.
	 * 
	 * @wbp.parser.entryPoint
	 */
	private void crearVentana() {//Private para que no se generen más ventanas.
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Vista window = Vista.getInstancia();// Llamo al
																// metodo
																// getInstancia
																// del Patron
																// Singleton.//Llamo
																// al metodo
																// getInstancia
																// del Patron
																// Singleton.
					window.frmGpsDiana.setVisible(true);
					window.frmGpsDiana.setSize(1000, 700);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 * 
	 */
	private Vista() {
		initializar();
	}

	/**
	 * Initialize the contents of the frame.
	 * @wbp.parser.entryPoint
	 */
	private void initializar() {
		frmGpsDiana = new JFrame();
		frmGpsDiana.setTitle("GPS Diana21");
		frmGpsDiana.setBounds(0, 0, 663, 424);
		frmGpsDiana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmGpsDiana.getContentPane().setLayout(null);
//		frmGpsDiana.setVisible(true);

		JPanel panelDeOpciones = agregarPanelOpciones();

		agregarOrigen(panelDeOpciones);

		JTextPane txtpnPuntoDiana = new JTextPane();
		txtpnPuntoDiana.setBounds(15, 65, 91, 20);
		txtpnPuntoDiana.setText("Punto Diana");
		txtpnPuntoDiana.setEditable(false);
		panelDeOpciones.add(txtpnPuntoDiana);

		agregarBotonBuscar(panelDeOpciones);

		JButton btnLimpiar = new JButton("Limpiar");
		btnLimpiar.setBounds(41, 253, 65, 23);
		panelDeOpciones.add(btnLimpiar);
		btnLimpiar.addMouseListener(new MouseListener() {

			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub

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
				System.out.println("Limpio pantalla.");

			}
		});

		JCheckBox chckbxSoloPavimentada = new JCheckBox("Solo Pavimentada");
		chckbxSoloPavimentada.setBounds(14, 196, 117, 23);
		panelDeOpciones.add(chckbxSoloPavimentada);

		JCheckBox chckbxConGnc = new JCheckBox("Con GNC");
		chckbxConGnc.setBounds(14, 223, 97, 23);
		panelDeOpciones.add(chckbxConGnc);

		radioBotonMasRapido.setBounds(14, 130, 109, 23);

		radioBotonMasRapido.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				Vista.getInstancia().radioBotonMasCorto.setSelected(false);
			}
		});
		panelDeOpciones.add(radioBotonMasRapido);
		// Mandé la línea d declaración y creación arriba p asignar dependencia
		// d botones.
		radioBotonMasCorto.setBounds(14, 156, 109, 23);

		radioBotonMasCorto.addActionListener(new ActionListener() {// Boton mas
																	// corto
																	// observa a
																	// la
																	// instancia
																	// d
																	// Practica2?

			@Override
			public void actionPerformed(ActionEvent e) {// Es el Actualizar,
														// esta es una Clase
														// Observadora.
				Vista.getInstancia().radioBotonMasRapido.setSelected(false);
			}
		});
		panelDeOpciones.add(radioBotonMasCorto);

		JComboBox comboBoxOrigen = new JComboBox();
		// comboBox.setModel(new DefaultComboBoxModel(new String[] {"Trelew"}));
		for (int i = 0; i < Mapa.getInstancia().getListaPuntos().size(); i++) {
			comboBoxOrigen.addItem(Mapa.getInstancia().getListaPuntos().get(i).getNombre());
			
		}
		
		
		
		
		comboBoxOrigen.setToolTipText("");
		comboBoxOrigen.setBounds(14, 34, 117, 20);
		panelDeOpciones.add(comboBoxOrigen);

		JComboBox comboBoxDestino = new JComboBox();
		comboBoxDestino.addMouseListener(new MouseListener() {
			
			@Override
			public void mouseReleased(MouseEvent e) {
				Vista.getInstancia().eleccionDestino=comboBoxDestino.getSelectedItem().toString();
				System.out.println("comboboxDestino, "+ comboBoxDestino.getSelectedItem().toString());
				
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
				// TODO Auto-generated method stub
				
			}
		});
		for (int i = 0; i < Mapa.getInstancia().getListaPuntos().size(); i++) {
			comboBoxDestino.addItem(Mapa.getInstancia().getListaPuntos().get(i).getNombre());
			
		}
		
		comboBoxDestino.setBounds(14, 103, 109, 20);
		panelDeOpciones.add(comboBoxDestino);

		JPanel panelDibujo = new JPanel();
		panelDibujo.setBounds(180, 11, 800, 600);
		frmGpsDiana.getContentPane().add(panelDibujo);

		panelDibujo.add(DibujoCanvas.getInstancia());
		crearVentana();
	}

	private void agregarOrigen(JPanel panelDeOpciones) {
		JTextPane txtpnPuntoSalida = new JTextPane();
		txtpnPuntoSalida.setBounds(14, 5, 92, 20);
		txtpnPuntoSalida.setText("Punto Salida");
		txtpnPuntoSalida.setEditable(false);
		panelDeOpciones.add(txtpnPuntoSalida);
	}

	private void agregarBotonBuscar(JPanel panelDeOpciones) {
		JButton btnBuscar = new JButton("Buscar");
		btnBuscar.setBounds(41, 287, 65, 23);
		panelDeOpciones.add(btnBuscar);
		btnBuscar.addMouseListener(new MouseListener() {

			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub

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
				CalculoDistancia calculoDistancia = new CalculoDistancia();
				ArrayList<Ruta> listaRuta=Mapa.getInstancia().getListaRuta();
//				calculoDistancia.CalcularCamino(listaRuta, eleccionOrigen, eleccionDestino);
				System.out.println(
						"Busco, hago el grueso del batallón: la parte lógica, y arrojo el resultado, incluso en la GUI");
			}
		});
	}

	private JPanel agregarPanelOpciones() {
		JPanel panelDeOpciones = new JPanel();
		panelDeOpciones.setToolTipText("");
		panelDeOpciones.setBounds(10, 11, 160, 363);
		frmGpsDiana.getContentPane().add(panelDeOpciones);
		panelDeOpciones.setLayout(null);
		return panelDeOpciones;
	}

	@Override
	public void addObservador(Observador obs) {
		this.observador=obs;
	}

	@Override
	public void removerObservador(Observador obs) {
		this.observador=null;
	}

	@Override
	public void notificar() {
		this.observador.actualizar();

	}
}
