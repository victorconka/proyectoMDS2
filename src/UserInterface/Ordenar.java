package UserInterface;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;

public class Ordenar extends JPanel {

	protected JButton fecha;
	protected JButton precio;
	protected JButton numeroHabitaciones;
	protected JButton superficie;
	protected JLabel ordenarL;

	public Ordenar() {
		setOpaque(false);
		setSize(Utils.wMedio, Utils.hMedio);
		setLayout(null);
		
		ordenarL = new JLabel("Ordenar por");
		ordenarL.setBounds(10, 41, 79, 14);
		add(ordenarL);
		
		fecha = new JButton("Fecha ^");
		fecha.setBackground(Color.WHITE);
		fecha.setBounds(0, 66, 85, 23);
		add(fecha);
		
		precio = new JButton("Precio ^");
		precio.setBackground(Color.WHITE);
		//precio.setModel(new DefaultComboBoxModel(new String[] {"Precio alto", "Precio bajo"}));
		precio.setBounds(85, 66, 85, 23);
		add(precio);
		
		numeroHabitaciones = new JButton("Num habitaciones ^");
		numeroHabitaciones.setBackground(Color.WHITE);
		numeroHabitaciones.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		numeroHabitaciones.setBounds(170, 66, 155, 23);
		add(numeroHabitaciones);
		
		superficie = new JButton("Superficie ^");
		superficie.setBackground(Color.WHITE);
		superficie.setBounds(325, 66, 125, 23);
		add(superficie);
	}
}