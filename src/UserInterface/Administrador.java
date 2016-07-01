package UserInterface;

import javax.swing.JButton;
import javax.swing.JFrame;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;

public class Administrador extends JFrame {

	private JButton cerrarSesion;
	private ZonaBúsqueda zb;
	private JLabel lblPerfil;
	private Mensaje mensaje;
	
	public void initialize() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(Utils.wMedio+Utils.wOffset, Utils.hGrande);
		this.getContentPane().setSize(Utils.wMedio, Utils.hMedio);
		
		getContentPane().setLayout(null);
		
		
		this.cerrarSesion = new JButton();
		cerrarSesion.setText("Cerrar Sesi\u00F3n");	
		cerrarSesion.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//int res = JOptionPane.showConfirmDialog(new JFrame(), "Hola Mundo");
				UsuarioGenerico ug = new UsuarioGenerico();
				ug.cambiarAdmin(true, false);
			}
		});
	
		this.cerrarSesion.setBounds(277, 27, 115, 25);
		getContentPane().add(this.cerrarSesion);
		
		
		lblPerfil = new JLabel("Perfil");
		lblPerfil.setBounds(24, 15, 46, 14);
		getContentPane().add(lblPerfil);
		
		mensaje = new Mensaje();
		mensaje.asuntoTF.setEditable(true);
		mensaje.setSize(450, 365);
		mensaje.setLocation(1,115);
		mensaje.volverB.setEnabled(false);
		mensaje.volverB.setContentAreaFilled(false);
		mensaje.volverB.setText("");
		mensaje.volverB.setBorderPainted(false);
		getContentPane().add(mensaje);
		
		zb = new ZonaBúsqueda();
		zb.setBounds(1, 88, 451, 47);
		getContentPane().add(zb);

	}
	
	public Administrador() {
		initialize();	
	}
}