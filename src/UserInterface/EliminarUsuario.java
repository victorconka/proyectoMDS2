package UserInterface;

import javax.swing.JButton;
import javax.swing.JPanel;

public class EliminarUsuario extends JPanel {
	protected JButton eliminar;
	
	public EliminarUsuario(){
		
		this.setSize(200, 50);
		eliminar = new JButton("Eliminar Usuario");
		eliminar.setBounds(21, 11, 144, 25);
		eliminar.setToolTipText("Eliminar Usuario");
		setLayout(null);
		this.add(eliminar);
	}

}