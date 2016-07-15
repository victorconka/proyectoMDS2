package UserInterface;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollBar;
import javax.swing.JList;
import javax.swing.JSeparator;
import java.awt.Color;
import java.awt.Component;

import javax.swing.JSlider;
import javax.swing.SwingConstants;

import bbdd.IUsuarioRegistrado;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.awt.event.ActionEvent;

public class ListaCorreos extends JPanel {

	private JLabel correos;
	private JLabel fuente;
	private JLabel asunto;
	private JLabel texto;
	private JLabel contenidoFuente;
	private JLabel contenidoAsuton;
	private JLabel contenidoTexto;
	private JScrollBar barra;
	private JSeparator separator_1;
	protected Correo co = new Correo();
	protected JButton coBoton;
	protected DefaultListModel dlm = new DefaultListModel();
	protected JList list = new JList();
	
	public ListaCorreos() {
		setOpaque(false);
		setLayout(null);
		setSize(Utils.wMedio, Utils.hMedio);
		
		coBoton = new JButton("");
		coBoton.setContentAreaFilled(false);
		coBoton.setBounds(35, 61, 335, 23);
		//add(coBoton);
		
		correos = new JLabel("Correos");
		correos.setBounds(35, 11, 56, 27);
		add(correos);
		
		fuente = new JLabel("Fuente");
		fuente.setBounds(45, 37, 76, 27);
		add(fuente);
		
		asunto = new JLabel("Asunto");
		asunto.setBounds(123, 37, 61, 27);
		add(asunto);
		
		texto = new JLabel("Texto");
		texto.setBounds(260, 37, 76, 27);
		add(texto);
		
		contenidoFuente = new JLabel("Pepe");
		contenidoFuente.setBounds(45, 71, 56, 13);
		//add(contenidoFuente);
		
		contenidoAsuton = new JLabel("Solicitud de información");
		contenidoAsuton.setBounds(113, 64, 133, 27);
		//add(contenidoAsuton);
		
		contenidoTexto = new JLabel();
		contenidoTexto.setText("Buenas, me gustar\u00EDa contactar");
		contenidoTexto.setBounds(260, 64, 110, 27);
		//add(contenidoTexto);
		
		barra = new JScrollBar();
		barra.setBounds(370, 62, 17, 105);
		//add(barra);
		
		JSeparator separator = new JSeparator();
		separator.setOrientation(SwingConstants.VERTICAL);
		separator.setForeground(Color.BLACK);
		separator.setBounds(100, 62, 21, 105);
		add(separator);
		
		separator_1 = new JSeparator();
		separator_1.setOrientation(SwingConstants.VERTICAL);
		separator_1.setForeground(Color.BLACK);
		separator_1.setBounds(251, 62, 21, 105);
		add(separator_1);
		
		
		dlm.addElement("Pepe\tSolicitud de informacion\tBuenas, me gustaria...");
		list = new JList(dlm);
		
		list.setBounds(35, 61, 353, 105);
		add(list);
		
		add(co).setVisible(false);
	}
	
	protected void cargarDatos() {
		try {
			Registry r = LocateRegistry.getRegistry(1099);
			IUsuarioRegistrado iu = (IUsuarioRegistrado) r.lookup("Servidor3");
			bbdd_gestion.Correo[] c = iu.cargarListadoCorreos(String.valueOf(Utils.idCasa), String.valueOf(Utils.id));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	protected void esconder() {
		for(Component c: getComponents())
			c.setVisible(false);
	}
	
	protected void mostrar() {
		for(Component c: getComponents())
			c.setVisible(true);
	}
}