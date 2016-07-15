package UserInterface;

import java.awt.Color;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class ZonaMensaje extends JPanel {

	private JLabel mensaje;
	private JLabel paraL;
	protected JTextField paraTF;
	private JLabel asuntoL;
	protected JTextField asuntoTF;
	private JLabel textoL;
	protected JTextArea textoTA;
	private JScrollBar barra;
	private JScrollPane pane;
	
	protected JSeparator separator, separator_1, separator_2, separator_3;

	public ZonaMensaje() {
		setOpaque(false);
		setLayout(null);
		setSize(Utils.wMedio, Utils.hGrande);
		
		mensaje = new JLabel("Mensaje");
		mensaje.setBounds(78, 30, 60, 14);
		add(mensaje);
		
		paraL = new JLabel("Para");
		paraL.setBounds(78, 82, 47, 14);
		add(paraL);
		
		paraTF = new JTextField();
		paraTF.setBounds(180, 76, 205, 26);
		add(paraTF);
		
		asuntoL = new JLabel("Asunto");
		asuntoL.setBounds(78, 131, 60, 14);
		add(asuntoL);
		
		asuntoTF = new JTextField();
		asuntoTF.setEditable(false);
		asuntoTF.setBounds(180, 125, 205, 26);
		add(asuntoTF);
		
		textoL = new JLabel("Texto");
		textoL.setBounds(78, 169, 60, 14);
		add(textoL);
		
		barra = new JScrollBar();
		barra.setLocation(371, 194);
		barra.setSize(14, 113);
		//add(barra);
		
		textoTA = new JTextArea();
		textoTA.setBounds(78, 194, 307, 113);
		//add(textoTA);
		pane = new JScrollPane(textoTA, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		pane.setBounds(78, 194, 307, 113);
		add(pane);
		
		separator = new JSeparator();
		separator.setForeground(Color.BLACK);
		separator.setBounds(32, 318, 384, 14);
		add(separator);
		
		separator_1 = new JSeparator();
		separator_1.setForeground(Color.BLACK);
		separator_1.setBounds(32, 57, 384, 14);
		add(separator_1);
		
		separator_2 = new JSeparator();
		separator_2.setOrientation(SwingConstants.VERTICAL);
		separator_2.setForeground(Color.BLACK);
		separator_2.setBounds(32, 57, 14, 262);
		add(separator_2);
		
		separator_3 = new JSeparator();
		separator_3.setOrientation(SwingConstants.VERTICAL);
		separator_3.setForeground(Color.BLACK);
		separator_3.setBounds(415, 57, 14, 262);
		add(separator_3);
	}
}