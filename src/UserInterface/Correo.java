package UserInterface;

import javax.swing.JButton;
import javax.swing.JTextArea;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;

public class Correo extends ZonaMensaje {
	
	protected JButton responder;
	protected JButton volver;
	private JTextArea textArea;
	private JScrollPane pane;
	private JLabel respuesta;
	
	public Correo() {
		separator_3.setLocation(415, 45);
		separator_2.setLocation(32, 45);
		separator_1.setLocation(32, 45);
		asuntoTF.setLocation(180, 113);
		asuntoTF.setEditable(true);
		separator_2.setSize(14, 470);
		separator_3.setSize(14, 470);
		separator.setLocation(32, 513);
		this.setSize(Utils.wMedio, Utils.hGrande);
		
		textArea = new JTextArea();
		textArea.setBounds(78, 339, 307, 113);
		pane = new JScrollPane(textArea);
		pane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		pane.setBounds(78, 339, 307, 113);
		add(pane);
		
		respuesta = new JLabel("Respuesta");
		respuesta.setBounds(78, 314, 89, 14);
		add(respuesta);
		
		volver = new JButton("Volver");
		volver.setBounds(78, 479, 89, 23);
		add(volver);
		
		responder = new JButton("Responder");
		responder.setBounds(254, 479, 131, 23);
		add(responder);
	}
}