package packGps;

import java.awt.Choice;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JComboBox;


//Clase para recibir los eventos ItemListener generados por el objeto
//Choice de la aplicación
class MiItemListenerDestino implements ItemListener {  //seria como la INTERFAZ OBSERVADOR, y el observador tiene el metodo actualizar();
	JComboBox comboAux;

	MiItemListenerDestino(JComboBox comboBoxDestino) {
		// Guardamos una referencia al objeto Choice
		comboAux = comboBoxDestino;
	}

	// Sobreescribimos el metodo itemStateChanged() del interfaz del
	// ItemListener
	public void itemStateChanged(ItemEvent evt) { //actualizar();
		System.out.println(comboAux.getSelectedItem().toString());
		Vista.getInstancia().setEleccionDestino(comboAux.getSelectedItem().toString());
	}
}
