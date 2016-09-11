package UserInterface;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JSeparator;
import java.awt.Color;
import javax.swing.SwingConstants;

import bbdd.IUsuarioRegistrado;

import java.awt.event.ActionListener;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.awt.event.ActionEvent;

public class Estado extends JPanel {

	protected JButton modificarEstado;
	private JLabel estadoL;
	protected JComboBox estadoCB;
	
	public Estado() {
		setOpaque(false);
		setLayout(null);
		setSize(Utils.wMedio, Utils.hMedio);
	
		modificarEstado = new JButton("Modificar Visibilidad");
		/*
		modificarEstado.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Registry r = LocateRegistry.getRegistry(1099);
					IUsuarioRegistrado iu = (IUsuarioRegistrado) r.lookup("Servidor3");
					String est =  (estadoCB.getSelectedItem().toString().equals("Disponible"))?"si":"no";
					iu.modificarEstadoVivienda(String.valueOf(Utils.id), String.valueOf(Utils.idCasa), est);
				} catch (Exception e1) {
					e1.printStackTrace();
				}
			}
		});
		*/
		modificarEstado.setBounds(217, 267, 175, 28);
		
		add(modificarEstado);
		
		estadoL = new JLabel("Visibilidad");
		estadoL.setBounds(213, 223, 60, 21);
		add(estadoL);
		
		estadoCB = new JComboBox();
		estadoCB.setModel(new DefaultComboBoxModel(new String[] {"Disponible", "No disponible"}));
		estadoCB.setBounds(291, 219, 101, 28);
		add(estadoCB);
		
		JSeparator separator = new JSeparator();
		separator.setForeground(Color.BLACK);
		separator.setBounds(204, 201, 198, 11);
		add(separator);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setForeground(Color.BLACK);
		separator_1.setBounds(204, 306, 198, 11);
		add(separator_1);
		
		JSeparator separator_2 = new JSeparator();
		separator_2.setOrientation(SwingConstants.VERTICAL);
		separator_2.setForeground(Color.BLACK);
		separator_2.setBounds(204, 201, 15, 107);
		add(separator_2);
		
		JSeparator separator_3 = new JSeparator();
		separator_3.setOrientation(SwingConstants.VERTICAL);
		separator_3.setForeground(Color.BLACK);
		separator_3.setBounds(402, 201, 15, 106);
		add(separator_3);
	}
}