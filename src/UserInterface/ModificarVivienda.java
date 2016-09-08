package UserInterface;

import java.awt.Component;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JCheckBox;

public class ModificarVivienda extends ZonaDatosVivienda {

	protected JButton guardarCambios;
	protected JButton volver;
	
	//valores originales de los campos que sirven
	//para verificar si el campo fue modificado
	//si es asi, dicho campo será pasado al metodo
	//modificarVivienda.
	String aaDireccion, aaMunicipio, aaProvincia, aaCp, aaFotos,
	aaPrecio, aaSuperficie, aaNHab, aaNBanios, aaTipo, aaExtras, 
	aaEstado, aaAccion, aaMapa, aaDCorta, aaDLarga, aaVisible;
	
	public ModificarVivienda() {
		setLayout(null);
		setOpaque(false);
		setSize(500, 600);
		
		guardarCambios = new JButton("Guardar cambios");
		guardarCambios.setBounds(241, 560, 150, 23);
		add(guardarCambios);
		
		volver = new JButton("Volver");
		volver.setBounds(80, 560, 89, 21);
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
		//el -1 es debido al ultimo checkbox (suponemos que es el ultimo)
		
		String[] ext = new String[aux.size()-1];
		for (int i = 0; i < aux.size()-1; i++)
			ext[i] = aux.get(i);
		return ext;
	}

}