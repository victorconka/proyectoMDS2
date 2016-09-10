package UserInterface;

import java.awt.Color;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.ImageIcon;

import javax.swing.DefaultComboBoxModel;

public class PrimerFiltroComun extends JPanel{

	private JLabel accionL;
	private JLabel cpL;
	private JLabel provinciaL;
	private JComboBox accionCB;
	private JTextField cpTF;
	private JTextField provinciaTF;
	private JLabel inicioL;
	public JButton buscar;
	private JSeparator separator;
	private JSeparator separator_1;
	private JSeparator separator_2;
	private JSeparator separator_3;
//----------------------------obtener datos introducidos
	public String getAccion(){
		return String.valueOf(this.accionCB.getSelectedItem());
	}
	public String getCP(){
		return String.valueOf(this.cpTF.getText());
	}
	public String getProvincia(){
		return String.valueOf(this.provinciaTF.getText());
	}
//----------------------------	----------------------------	

	public PrimerFiltroComun() {

		
		setLayout(null);
		setSize(Utils.wMedio, Utils.hMedio);
		
		accionL = new JLabel("Acción");
		accionL.setBounds(36, 111, 65, 28);
		add(accionL);
		
		cpL = new JLabel("CP");
		cpL.setBounds(36, 168, 65, 28);
		add(cpL);
		
		provinciaL = new JLabel("Provincia");
		provinciaL.setBounds(36, 218, 87, 34);
		add(provinciaL);
		
		accionCB = new JComboBox();
		accionCB.setModel(new DefaultComboBoxModel(new String[] {"Comprar", "Alquilar"}));
		accionCB.setBounds(169, 111, 226, 28);
		add(accionCB);
		
		cpTF = new JTextField();
		cpTF.setBounds(169, 165, 226, 34);
		add(cpTF);
		
		provinciaTF = new JTextField();
		provinciaTF.setBounds(169, 218, 226, 34);
		add(provinciaTF);
		
		inicioL = new JLabel("Inicio");
		inicioL.setBounds(59, 36, 65, 28);
		add(inicioL);
		
		buscar = new JButton("Buscar");
		buscar.setIcon(new ImageIcon("..\\ProyectoMDS2\\Iconos\\icono_buscar.png"));
		buscar.setBounds(148, 286, 124, 44);
		add(buscar);
		
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