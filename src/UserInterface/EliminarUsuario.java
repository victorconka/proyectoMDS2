package UserInterface;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

import javax.swing.JButton;
import javax.swing.JPanel;

import bbdd.IUsuario;

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

	public boolean eliminarUsuario(String Email) {
		try {
			Registry r = LocateRegistry.getRegistry(null);
			IUsuario iu = (IUsuario) r.lookup("Servidor2");
			return iu.eliminarUsuario(Email);
		} catch (Exception e1) {
			e1.printStackTrace();
		}
		return false;
	}

}