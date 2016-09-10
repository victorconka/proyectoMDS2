package UserInterface;

import java.awt.Color;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class ResultadosComun extends JPanel {

	protected JButton volver;
	private Ordenar ord;
	protected ListaCasasComun lcc;
	
	public ResultadosComun() {		
		//UsuarioGenerico.getFrames()[0].setSize(Utils.wMedio+15, Utils.hMedio);
		
		setLayout(null);
		
		volver = new JButton("Volver");
		volver.setBounds(22, 335, 104, 23);
		add(volver);
		volver.setIcon(new ImageIcon("..\\ProyectoMDS2\\Iconos\\icono_volver.png"));
		
		ord = new Ordenar();
		ord.fecha.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(ord.fecha.getText().contains("^")){
					lcc.ordenar(1);//ordenarLccFechaG
					ord.fecha.setText(ord.fecha.getText().replace("^", "v"));
				}
				else{
					lcc.ordenar(0);//ordenarLccFechaL
					ord.fecha.setText(ord.fecha.getText().replace("v","^"));
				}
				//cambiamos colores
				ord.fecha.setBackground(Color.LIGHT_GRAY);
				ord.precio.setBackground(Color.WHITE);
				ord.numeroHabitaciones.setBackground(Color.WHITE);
				ord.superficie.setBackground(Color.WHITE);
						
			}
		});
		ord.precio.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(ord.precio.getText().contains("^")){
					lcc.ordenar(3);//ordenarLccprecioG
					ord.precio.setText(ord.precio.getText().replace("^", "v"));
				}
				else{
					lcc.ordenar(2);//ordenarLccprecioL
					ord.precio.setText(ord.precio.getText().replace("v","^"));
				}
				//cambiamos colores
				ord.precio.setBackground(Color.LIGHT_GRAY);
				ord.fecha.setBackground(Color.WHITE);
				ord.numeroHabitaciones.setBackground(Color.WHITE);
				ord.superficie.setBackground(Color.WHITE);
						
			}
		});
		
		
		ord.numeroHabitaciones.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(ord.numeroHabitaciones.getText().contains("^")){
					lcc.ordenar(5);//ordenarLccnumeroHabitacionesG
					ord.numeroHabitaciones.setText(ord.numeroHabitaciones.getText().replace("^", "v"));
				}
				else{
					lcc.ordenar(4);//ordenarLccnumeroHabitacionesL
					ord.numeroHabitaciones.setText(ord.numeroHabitaciones.getText().replace("v","^"));
				}
				//cambiamos colores
				ord.numeroHabitaciones.setBackground(Color.LIGHT_GRAY);
				ord.fecha.setBackground(Color.WHITE);
				ord.precio.setBackground(Color.WHITE);
				ord.superficie.setBackground(Color.WHITE);
						
			}
		});
		ord.superficie.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(ord.superficie.getText().contains("^")){
					lcc.ordenar(7);//ordenarLccsuperficieG
					ord.superficie.setText(ord.superficie.getText().replace("^", "v"));
				}
				else{
					lcc.ordenar(6);//ordenarLccsuperficieL
					ord.superficie.setText(ord.superficie.getText().replace("v","^"));
				}
				//cambiamos colores
				ord.superficie.setBackground(Color.LIGHT_GRAY);
				ord.fecha.setBackground(Color.WHITE);
				ord.precio.setBackground(Color.WHITE);
				ord.numeroHabitaciones.setBackground(Color.WHITE);
						
			}
		});
		
		add(ord);
	
		lcc = new ListaCasasComun();
		lcc.setOpaque(false);
		lcc.setLocation(0, 90);
		
		add(lcc);
						
	}
}