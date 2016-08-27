package UserInterface;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

import bbdd.IUsuario;

public class Mensaje extends ZonaMensaje {

	protected JButton enviarB;
	protected JButton volverB;
	
	public Mensaje() {
		
		enviarB = new JButton("Enviar");
		enviarB.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Registry r = LocateRegistry.getRegistry(null);
					IUsuario iu = (IUsuario) r.lookup("Servidor2");
					if (iu.enviar(String.valueOf(Utils.id), String.valueOf(Utils.idCasa), paraTF.getText(), asuntoTF.getText(), textoTA.getText())) {
						JOptionPane.showMessageDialog(new JFrame(), "Mensaje enviado");
						paraTF.setText("");
						asuntoTF.setText("");
						textoTA.setText("");
					}
					else
						JOptionPane.showMessageDialog(new JFrame(), "Mensaje no enviado");
				} catch (Exception e1) {
					e1.printStackTrace();
				}
			}
		});
		enviarB.setLocation(316, 332);
		enviarB.setSize(100, 24);
		add(enviarB);
		
		volverB = new JButton("Volver");
		volverB.setLocation(32, 332);
		volverB.setSize(100, 24);
		add(volverB);
	}
	
}