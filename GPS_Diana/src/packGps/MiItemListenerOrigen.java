package packGps;

import java.awt.Choice;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JComboBox;


//Clase para recibir los eventos ItemListener generados por el objeto
//Choice de la aplicación
class MiItemListenerOrigen implements ItemListener {  //seria como la INTERFAZ OBSERVADOR, y el observador tiene el metodo actualizar();
	JComboBox comboAux;

	MiItemListenerOrigen(JComboBox comboBoxOrigen) {
		// Guardamos una referencia al objeto Choice
		comboAux = comboBoxOrigen;
	}

	// Sobreescribimos el metodo itemStateChanged() del interfaz del
	// ItemListener
	public void itemStateChanged(ItemEvent evt) { //actualizar();
		
		Vista.getInstancia().setEleccionOrigen(comboAux.getSelectedItem().toString());
	}
}
