package UserInterface;

import java.awt.Component;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JCheckBox;

public class DarAltaNuevaVivienda extends ZonaDatosVivienda {
	
	protected JButton registrarVivienda;
	protected JButton volver;
	
	public DarAltaNuevaVivienda() {
		
		volver = new JButton("Volver");
		volver.setBounds(80, 560, 89, 23);
		add(volver);
		
		registrarVivienda = new JButton("Registrar Vivienda");
		registrarVivienda.setBounds(241, 560, 150, 23);
		add(registrarVivienda);
	}

	public String[] obtenerExtras() {
		ArrayList<String> aux = new ArrayList<String>();
		for (Component c: getComponents()) {
			if (c instanceof JCheckBox) {
				if (((JCheckBox) c).isSelected())
					aux.add(((JCheckBox) c).getText());
			}
		}
		String[] ext = new String[aux.size()];
		for (int i = 0; i < aux.size(); i++)
			ext[i] = aux.get(i);
		return ext;
	}

	protected void resetear() {
		fotosTA.setText("");
		direccion.setText("");
		municipioTF.setText(""); 
		provinciaTF.setText(""); 
		cpTF.setText("");
		precioTF.setText("");
		superficieTF.setText("");
		numeroHabitacionesTF.setText("");
		numeroBañosTF.setText("");
		mapaUrlTF.setText("");
		dCortaTF.setText("");
		dLargaTF.setText("");
	}

}