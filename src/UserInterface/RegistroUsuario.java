package UserInterface;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

import bbdd.IUsuarioRegistrado;

import java.awt.event.ActionListener;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.awt.event.ActionEvent;

public class RegistroUsuario extends DatosUsuario {
	
	private JButton registrarse;
	protected JButton volver;
	
	public RegistroUsuario() {
		
		
		nombrePanel.setText("Registrar Usuario");
		
		volver = new JButton("Volver");
		volver.setBounds(53, 469, 79, 23);
		add(volver);
		
		registrarse = new JButton("Registrarse");
		registrarse.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				IUsuarioRegistrado iur = null;
				try {
					Registry registry = LocateRegistry.getRegistry(1099);
					iur = (IUsuarioRegistrado) registry.lookup("Servidor3");
					if (iur.Registrarse(nombreTF.getText(), apellidosTF.getText(),
							direccion.getText(), municipioTF.getText(),
							provinciaTF.getText(), cpTF.getText(),
							emailTF.getText(), String.valueOf(contraseñaTF.getPassword())))
						JOptionPane.showMessageDialog(new JFrame(), "Registrado con exito");
					else 
						JOptionPane.showMessageDialog(new JFrame(), "Datos incorrectos");
				} catch (Exception e1) {
					e1.printStackTrace();
				}
			}
		});
		registrarse.setBounds(316, 469, 115, 23);
		add(registrarse);
	}

	
}