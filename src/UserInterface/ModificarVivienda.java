package UserInterface;

import java.awt.Component;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JCheckBox;

public class ModificarVivienda extends ZonaDatosVivienda {

	protected JButton guardarCambios;
	protected JButton volver;
	
	public ModificarVivienda() {
		
		setLayout(null);
		setOpaque(false);
		setSize(Utils.wGrande, Utils.hGrande);
		
		guardarCambios = new JButton("Guardar cambios");
		guardarCambios.setBounds(233, 465, 156, 28);
		add(guardarCambios);
		
		volver = new JButton("Volver");
		volver.setBounds(58, 465, 113, 28);
		add(volver);
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

}