package UserInterface;

import javax.swing.JPanel;

import bbdd.IUsuario;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class ZonaBúsqueda extends JPanel {

	private Buscador buscador;
	private EliminarUsuario delUser;
	
	public void init(){
		this.setBounds(5, 5, Utils.hMedio, 50);
		setLayout(null);
		
		delUser = new EliminarUsuario();
		delUser.setBounds(228,0,200,50);
		delUser.eliminar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int res = JOptionPane.showConfirmDialog(new JFrame(), "Desea eliminar usuario?");
				if (res == 0) {
					try {
						Registry r = LocateRegistry.getRegistry(null);
						IUsuario iu = (IUsuario) r.lookup("Servidor2");
						if (iu.eliminarUsuario(buscador.txtBuscarUsuario.getText()))
							JOptionPane.showMessageDialog(new JFrame(), "Usuario eliminado");
						else
							JOptionPane.showMessageDialog(new JFrame(), "Usuario NO eliminado");	
						buscador.txtBuscarUsuario.setText("");
					} catch (Exception e1) {
						e1.printStackTrace();
					}
				}
			}
		});
		this.add(delUser);
		
		buscador = new Buscador();
		buscador.setBounds(18, 0, 200, 50);
		this.add(buscador);
		
	}
	public ZonaBúsqueda() {
		init();
		
	}
	
}