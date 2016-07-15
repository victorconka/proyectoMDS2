package UserInterface;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Ordenar extends JPanel {

	private JButton fecha;
	private JComboBox precio;
	private JButton numeroHabitaciones;
	private JButton superficie;
	private JLabel ordenarL;

	public Ordenar() {
		setOpaque(false);
		setSize(Utils.wMedio, Utils.hMedio);
		setLayout(null);
		
		ordenarL = new JLabel("Ordenar por");
		ordenarL.setBounds(10, 41, 79, 14);
		add(ordenarL);
		
		fecha = new JButton("Fecha");
		fecha.setBounds(10, 66, 68, 23);
		add(fecha);
		
		precio = new JComboBox();
		precio.setModel(new DefaultComboBoxModel(new String[] {"Precio alto", "Precio bajo"}));
		precio.setBounds(76, 66, 98, 23);
		add(precio);
		
		numeroHabitaciones = new JButton("Num habitaciones");
		numeroHabitaciones.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		numeroHabitaciones.setBounds(171, 66, 145, 23);
		add(numeroHabitaciones);
		
		superficie = new JButton("Superficie");
		superficie.setBounds(311, 66, 98, 23);
		add(superficie);
	}
}