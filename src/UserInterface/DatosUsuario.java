package UserInterface;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.JSeparator;
import java.awt.Color;
import javax.swing.SwingConstants;

public class DatosUsuario extends JPanel {
	
	protected JLabel nombreL;
	protected JTextField nombreTF;
	protected JLabel apellidosL;
	protected JTextField apellidosTF;
	protected JLabel emailL;
	protected JTextField emailTF;
	protected JLabel contraseñaL;
	protected JPasswordField contraseñaTF;
	protected JLabel provinciaL;
	protected JTextField provinciaTF;
	protected JLabel cpL;
	protected JTextField cpTF;
	protected JLabel municipioL;
	protected JTextField municipioTF;
	protected JLabel direccionL;
	protected JTextField direccion;
	protected JLabel repContraseñaL;
	protected JPasswordField repContraseñaTF;
	protected JLabel nombrePanel;

	public DatosUsuario() {
		setLayout(null);
		setSize(Utils.wGrande, Utils.hGrande);
		
		nombrePanel = new JLabel("Datos Usuario");
		nombrePanel.setBounds(62, 36, 109, 27);
		add(nombrePanel);
		
		nombreL = new JLabel("Nombre");
		nombreL.setBounds(65, 85, 84, 27);
		add(nombreL);
		
		nombreTF = new JTextField();
		nombreTF.setBounds(234, 85, 202, 27);
		add(nombreTF);
		
		apellidosL = new JLabel("Apellidos");
		apellidosL.setBounds(65, 123, 58, 27);
		add(apellidosL);
		
		apellidosTF = new JTextField();
		apellidosTF.setBounds(234, 123, 202, 27);
		add(apellidosTF);
		
		emailL = new JLabel("Email");
		emailL.setBounds(65, 313, 58, 27);
		add(emailL);
		
		emailTF = new JTextField();
		emailTF.setBounds(234, 313, 202, 27);
		add(emailTF);
		
		contraseñaL = new JLabel("Contraseña");
		contraseñaL.setBounds(65, 351, 67, 27);
		add(contraseñaL);

		contraseñaTF = new JPasswordField();
		contraseñaTF.setBounds(234, 351, 202, 27);
		add(contraseñaTF);
		
		provinciaL = new JLabel("Provincia");
		provinciaL.setBounds(65, 237, 67, 27);
		add(provinciaL);
		
		provinciaTF = new JTextField();
		provinciaTF.setBounds(234, 237, 202, 27);
		add(provinciaTF);
		
		cpL = new JLabel("CP");
		cpL.setBounds(65, 275, 67, 27);
		add(cpL);
		
		cpTF = new JTextField();
		cpTF.setBounds(234, 275, 202, 27);
		add(cpTF);
		
		municipioL = new JLabel("Municipio");
		municipioL.setBounds(65, 199, 67, 27);
		add(municipioL);
		
		municipioTF = new JTextField();
		municipioTF.setBounds(234, 199, 202, 27);
		add(municipioTF);
		
		direccionL = new JLabel("Dirección");
		direccionL.setBounds(65, 161, 67, 27);
		add(direccionL);
		
		direccion = new JTextField();
		direccion.setBounds(234, 161, 202, 27);
		add(direccion);
		
		repContraseñaL = new JLabel("Repetir contraseña");
		repContraseñaL.setBounds(65, 389, 131, 27);
		add(repContraseñaL);
		
		repContraseñaTF = new JPasswordField();
		repContraseñaTF.setBounds(234, 389, 202, 27);
		add(repContraseñaTF);
		
		JSeparator separator = new JSeparator();
		separator.setForeground(Color.BLACK);
		separator.setBounds(37, 59, 431, 13);
		add(separator);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setForeground(Color.BLACK);
		separator_1.setBounds(37, 511, 431, 13);
		add(separator_1);
		
		JSeparator separator_2 = new JSeparator();
		separator_2.setOrientation(SwingConstants.VERTICAL);
		separator_2.setForeground(Color.BLACK);
		separator_2.setBounds(37, 59, 15, 453);
		add(separator_2);
		
		JSeparator separator_3 = new JSeparator();
		separator_3.setOrientation(SwingConstants.VERTICAL);
		separator_3.setForeground(Color.BLACK);
		separator_3.setBounds(467, 59, 12, 453);
		add(separator_3);
		
	}
}