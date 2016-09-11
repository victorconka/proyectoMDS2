package UserInterface;

import java.awt.Color;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JSeparator;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.JCheckBox;
import javax.swing.JLabel;

public class Entrar extends JPanel {

	protected JButton acceder;
	protected JButton registrarUsuarioB;
	protected JButton volverB;
	protected JCheckBox recordarme;
	private JLabel usuarioL;
	protected JTextField usuarioTF;
	private JLabel passL;
	private JLabel acceso;
	protected JPasswordField passPF;
	private JSeparator separator;
	private JSeparator separator_1;
	private JSeparator separator_2;
	private JSeparator separator_3;
	protected RegistroUsuario ru = new RegistroUsuario();

	public Entrar() {
		setLayout(null);
		setSize(Utils.wMedio, Utils.hMedio);
		
		add(ru).setVisible(false);
		
		ru.volver.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				for (Component c: getComponents())
					c.setVisible(true);
				UsuarioGenerico.getFrames()[0].setSize(Utils.wMedio, Utils.hMedio);
				setSize(Utils.wMedio, Utils.hMedio);
				ru.setVisible(false);
				
			}
		});
		
		acceder = new JButton("Acceder");
		acceder.setBounds(302, 307, 93, 23);
		add(acceder);
		
		registrarUsuarioB = new JButton("Registrarse");
		registrarUsuarioB.setLocation(162, 307);
		registrarUsuarioB.setSize(118, 23);
		registrarUsuarioB.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				for (Component c: getComponents())
					c.setVisible(false);
				
				
				UsuarioGenerico.getFrames()[0].setSize(Utils.wGrande, Utils.hGrande);				
				setSize(Utils.wGrande, Utils.hGrande);
				ru.setVisible(true);
			}
		});
		add(registrarUsuarioB);
		
		volverB = new JButton("Volver");
		volverB.setBounds(37, 307, 104, 23);
		add(volverB);
		volverB.setIcon(new ImageIcon("..\\ProyectoMDS2\\Iconos\\icono_volver.png"));
		
		
		recordarme = new JCheckBox("Recordarme");
		recordarme.setBounds(298, 222, 97, 23);
		//add(recordarme);
		
		usuarioL = new JLabel("Email");
		usuarioL.setBounds(57, 117, 97, 23);
		add(usuarioL);
		
		usuarioTF = new JTextField();
		usuarioTF.setLocation(190, 111);
		usuarioTF.setSize(191, 34);
		add(usuarioTF);
		
		passL = new JLabel("Contraseña");
		passL.setBounds(57, 167, 97, 23);
		add(passL);
		
		passPF = new JPasswordField();
		passPF.setLocation(190, 161);
		passPF.setSize(191, 34);
		add(passPF);
		
		acceso = new JLabel("Acceso");
		acceso.setBounds(47, 35, 52, 23);
		add(acceso);
		
		separator = new JSeparator();
		separator.setForeground(Color.BLACK);
		separator.setBounds(24, 341, 381, 12);
		add(separator);
		
		separator_1 = new JSeparator();
		separator_1.setForeground(Color.BLACK);
		separator_1.setBounds(24, 59, 381, 12);
		add(separator_1);
		
		separator_2 = new JSeparator();
		separator_2.setOrientation(SwingConstants.VERTICAL);
		separator_2.setForeground(Color.BLACK);
		separator_2.setBounds(24, 59, 23, 284);
		add(separator_2);
		
		separator_3 = new JSeparator();
		separator_3.setOrientation(SwingConstants.VERTICAL);
		separator_3.setForeground(Color.BLACK);
		separator_3.setBounds(405, 59, 23, 284);
		add(separator_3);

	}
}