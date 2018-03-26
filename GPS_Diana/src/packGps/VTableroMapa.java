package packGps;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextPane;

import PaqueteAux.CalculoDistancia;
import flecha.Ruta;
import grafica.Panel;

import java.awt.BorderLayout;
import java.awt.Choice;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;


public class VTableroMapa extends JFrame implements MouseListener{
	private MapaGrapics mapa;
	private Choice choiceOrigen = new Choice();
	
	public VTableroMapa() {
		this.setLayout(new GridLayout(1, 2));
		mapa = new MapaGrapics();
		
//		mapa.inicializar();
		Container contenedor = this.getContentPane();
		panelizquierdo();
		contenedor.add(mapa);
		this.setSize(1000,600);
		this.setVisible(true);
	}
 
	
	/**
	 * Carga todos los datos de los componentes
	 * @param mapa2
	 */
	public void cargarComponentes(Mapa mapa2){
		actualizarChoiceOrigen(mapa2);
	};
	
	public void actualizar(Mapa mapa2) {
		this.mapa.actualizar();
		
	}
	
	
	
	private void actualizarChoiceOrigen(Mapa mapa2) {
		ArrayList<Ruta> listRuta = mapa2.getListaRuta();
		for (int i = 0; i < listRuta.size(); i++) {
			this.getChoiceOrigen().addItem(listRuta.get(i).getOrigen().getNombre());
		}
	}

	public void panelizquierdo(){
		JPanel panel = new JPanel();
		this.getContentPane().add(panel);
		panel.setLayout(new GridLayout(0, 1, 0, 0));
		
		JTextPane txtpnOrigen = new JTextPane();
		txtpnOrigen.setBackground(Color.LIGHT_GRAY);
		txtpnOrigen.setText("Origen");
		panel.add(txtpnOrigen);
		
		choiceOrigen.addMouseListener(new MouseListener() {
			
			@Override
			public void mouseReleased(MouseEvent e) {
				
//				System.out.println("PRESIONO: Choice Origen");
				
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
				Mapa.getInstancia().setEleccionOrigen(choiceOrigen.getSelectedItem().toString());
				// TODO Auto-generated method stub
				
			}
		});
		panel.add(choiceOrigen);
		
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
		btnNewButton_1.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				CalculoDistancia calculo = new CalculoDistancia();
				Mapa mapa = Mapa.getInstancia();
				calculo.CalcularCamino(mapa.getListaRuta(), mapa.getEleccionOrigen(), mapa.getEleccionDestino());
				
			}
		});
		panel.add(btnNewButton_1);
		
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	public Choice getChoiceOrigen() {
		return choiceOrigen;
	}

	public void setChoiceOrigen(Choice choiceOrigen) {
		this.choiceOrigen = choiceOrigen;
	};

}
