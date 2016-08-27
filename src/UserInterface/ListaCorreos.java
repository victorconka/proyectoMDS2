package UserInterface;

import java.awt.Component;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.HashMap;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableModel;

import bbdd.IUsuarioRegistrado;

public class ListaCorreos extends JPanel {

	private JLabel correos;
	protected Correo co = new Correo();
	protected JButton coBoton;
	private HashMap<JButton, bbdd_gestion.Correo> map;
	private JTable tabla;
	private JScrollPane p;
	private DefaultTableModel dtm;
	
	public ListaCorreos() {
		setOpaque(false);
		setLayout(null);
		setSize(Utils.wMedio, Utils.hMedio);
		
		coBoton = new JButton("");
		coBoton.setContentAreaFilled(false);
		coBoton.setBounds(35, 59, 356, 17);
		//add(coBoton);
		
		correos = new JLabel("Correos");
		correos.setBounds(35, 11, 56, 27);
		add(correos);
		
		map = new HashMap<JButton, bbdd_gestion.Correo>();
		
		add(co).setVisible(false);
	}
	
	protected void cargarDatos() {
		JButton[] botones = null;
		bbdd_gestion.Correo[] c = null;
		try {
			Registry r = LocateRegistry.getRegistry(1099);
			IUsuarioRegistrado iu = (IUsuarioRegistrado) r.lookup("Servidor3");
			c = iu.cargarListadoCorreos(String.valueOf(Utils.idCasa), String.valueOf(Utils.id));
			if (c == null) c = new bbdd_gestion.Correo[0];
			botones = new JButton[c.length];
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		String[] cabecera = {"Fuente", "Asunto", "Texto"};
		String[][] datos = new String[c.length][3];
		int y = coBoton.getY();
		map.clear();
		
		for (int i = 0; i < datos.length; i++) {
			datos[i][0] = c[i].getFuente();
			datos[i][1] = c[i].getAsunto();
			datos[i][2] = c[i].getTexto();
			botones[i] = coBoton;
			botones[i].setLocation(35, y);
			y += 16;
			map.put(botones[i], c[i]);
			add(botones[i]);
		}
		
		System.out.println(c[0].getFuente());
		System.out.println(datos[0][0]);
		
		if (dtm != null) {
			dtm.removeRow(0);
			System.out.println("asd");
		}
		
		dtm = new DefaultTableModel(datos, cabecera);
		tabla = new JTable(new DefaultTableModel(datos, cabecera));
		tabla.setRowSelectionAllowed(false);
		tabla.setEnabled(false);
		tabla.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
		tabla.setShowHorizontalLines(false);
		tabla.setAutoResizeMode(JTable.AUTO_RESIZE_NEXT_COLUMN);
		p = new JScrollPane();
		p.setBounds(35, 38, 373, 117);
		p.setViewportView(tabla);
		p.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		add(p);
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