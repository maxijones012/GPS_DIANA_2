package grafica;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.FlowLayout;
import javax.swing.JScrollBar;
import java.awt.Choice;
import javax.swing.JRadioButton;
import java.awt.Checkbox;
import javax.swing.JCheckBox;
import javax.swing.JButton;
import java.awt.Canvas;
import javax.swing.JTextPane;

import packGps.Mapa;
import packGps.MapaGrapics;

import java.awt.Color;

public class Panel {
	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Panel window = new Panel();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Panel() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		JPanel panel = new JPanel();
		frame.getContentPane().add(panel);
		panel.setLayout(new GridLayout(0, 1, 0, 0));
		
		JTextPane txtpnOrigen = new JTextPane();
		txtpnOrigen.setBackground(Color.LIGHT_GRAY);
		txtpnOrigen.setText("Origen");
		panel.add(txtpnOrigen);
		
		Choice choice = new Choice();
		panel.add(choice);
		
		JTextPane txtpnDestino = new JTextPane();
		txtpnDestino.setBackground(Color.LIGHT_GRAY);
		txtpnDestino.setEditable(false);
		txtpnDestino.setText("Destino");
		panel.add(txtpnDestino);
		
		Choice choice_1 = new Choice();
		panel.add(choice_1);
		
		JRadioButton rdbtnNewRadioButton = new JRadioButton("Mas Rapido");
		panel.add(rdbtnNewRadioButton);
		
		JRadioButton rdbtnNewRadioButton_1 = new JRadioButton("Mas corto");
		panel.add(rdbtnNewRadioButton_1);
		
		JCheckBox chckbxNewCheckBox_1 = new JCheckBox("Solo Pavimentada");
		panel.add(chckbxNewCheckBox_1);
		
		JCheckBox chckbxNewCheckBox = new JCheckBox("con GNC");
		panel.add(chckbxNewCheckBox);
		
		JButton btnNewButton = new JButton("Limpiar");
		panel.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Buscar");
		panel.add(btnNewButton_1);
		
		JPanel panelDibujo = new JPanel();
		FlowLayout flowLayout_1 = (FlowLayout) panelDibujo.getLayout();
		flowLayout_1.setVgap(120);
		flowLayout_1.setHgap(150);
		frame.getContentPane().add(panelDibujo);
		
		Canvas canvas = new Canvas();
		panelDibujo.add(canvas);
		
		MapaGrapics mapaG = new MapaGrapics();
		panelDibujo.add(mapaG);
	}

	public void actualizar(Mapa mapa) {
		
	}

	public JFrame getFrame() {
		return frame;
	}

	public void setFrame(JFrame frame) {
		this.frame = frame;
	}

}
