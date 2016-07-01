package UserInterface;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Collections;
import java.awt.event.ActionEvent;

public class SegundoFiltroComun extends JPanel {

	private JLabel buscadorL;
	
	private JLabel precioL;
	private JTextField precioTF;
	
	private JLabel superficieL;
	private JTextField superficieTF;
	
	private JLabel habitacionesL;
	private JTextField habitacionesTF;
	
	private JLabel ba�osL;
	private JTextField ba�osTF;
	
	private JLabel tipoL;
	private JComboBox tipoCB;
	
	private JLabel extrasL;
	
	private JLabel terrazaL;
	private JCheckBox terrazaChB;
	
	private JLabel ascensorL;
	private JCheckBox ascensorChB;
	
	private JLabel parkingL;
	private JCheckBox parkingChB;
	
	private JLabel amuebladaL;
	private JCheckBox amuebladaChB;
	
	private JLabel calefacci�n;
	private JCheckBox calefacci�nChB;
	
	private JLabel piscinaL;
	private JCheckBox piscinaChB;
	
	private JLabel jard�nL;
	private JCheckBox jard�nChB;
	
	private JLabel trasteroL;
	private JCheckBox trasteroChB;
	
	private JLabel estadoL;
	private JComboBox estadoCB;
	
	protected JButton buscar;
	protected JButton volver;

	public SegundoFiltroComun() {
		int a = 25;
		int b = 30;
		int c = 150;
		int w = 90;
		
		setLayout(null);
		this.setBounds(5, 5, Utils.wMedio, Utils.hMedio);
		
		this.buscadorL = new JLabel("Buscador");
		this.buscadorL.setBounds(a, 1*b, w, a);
		this.add(buscadorL);
		
		this.precioL = new JLabel("Precio");
		this.precioL.setBounds(a, 2*b, w, a);
		this.add(precioL);
		
		this.precioTF = new JTextField();
		this.precioTF.setBounds(c, 2*b, 2*w, a);
		this.add(precioTF);
		
		this.superficieL = new JLabel("Superficie");
		this.superficieL.setBounds(a, 3*b, w, a);
		this.add(superficieL);
		
		this.superficieTF = new JTextField();
		this.superficieTF.setBounds(c, 3*b, 2*w, a);
		this.add(superficieTF);
		
		this.habitacionesL = new JLabel("N� Habitaciones");
		this.habitacionesL.setBounds(a, 4*b, w, a);
		this.add(habitacionesL);
		
		this.habitacionesTF = new JTextField();
		this.habitacionesTF.setBounds(c, 4*b, 2*w, a);
		this.add(habitacionesTF);
		
		this.ba�osL = new JLabel("N� Ba�os");
		this.ba�osL.setBounds(a, 5*b, w, a);
		this.add(ba�osL);
		
		this.ba�osTF = new JTextField();
		this.ba�osTF.setBounds(c, 5*b, 2*w, a);
		this.add(ba�osTF);
		
		this.tipoL = new JLabel("Tipo");
		this.tipoL.setBounds(a, 6*b, w, a);
		this.add(tipoL);
		
		this.tipoCB = new JComboBox();
		tipoCB.setModel(new DefaultComboBoxModel(new String[] {"Apartamento", "\u00C1tico"}));
		this.tipoCB.setBounds(c, 6*b, 2*w, a);
		this.add(tipoCB);
//-------------------------------------------------------------------------------------------------		
		this.extrasL = new JLabel("Extras");
		this.extrasL.setBounds(25, 210, 47, 25);
		this.add(extrasL);
//-------------------------------------------------------------------------------------------------			
		//fila 1
		this.terrazaL = new JLabel("Terraza");
		this.terrazaL.setBounds(108, 210, 47, 25);
		this.add(terrazaL);
		
		this.terrazaChB = new JCheckBox();
		this.terrazaChB.setBounds(150, 210, 21, 25);
		this.add(terrazaChB);
		
		this.ascensorL = new JLabel("Ascensor");
		this.ascensorL.setBounds(192, 210, 63, 25);
		this.add(ascensorL);
		
		this.ascensorChB = new JCheckBox();
		this.ascensorChB.setBounds(245, 212, 21, 25);
		this.add(ascensorChB);
		
		this.parkingL = new JLabel("Parking");
		this.parkingL.setBounds(272, 212, 47, 25);
		this.add(parkingL);
		
		this.parkingChB = new JCheckBox();
		this.parkingChB.setBounds(315, 212, 21, 25);
		this.add(parkingChB);
		
		//fila 2
		this.amuebladaL = new JLabel("Amueblada");
		this.amuebladaL.setBounds(92, 235, 79, 25);
		this.add(amuebladaL);
		
		this.amuebladaChB = new JCheckBox();
		this.amuebladaChB.setBounds(160, 235, 21, 25);
		this.add(amuebladaChB);
		
		this.calefacci�n = new JLabel("Calefacci�n");
		this.calefacci�n.setBounds(184, 235, 71, 25);
		this.add(calefacci�n);
		
		this.calefacci�nChB = new JCheckBox();
		this.calefacci�nChB.setBounds(255, 235, 21, 25);
		this.add(calefacci�nChB);
		
		this.piscinaL = new JLabel("Piscina");
		this.piscinaL.setBounds(282, 235, 47, 25);
		this.add(piscinaL);
		
		this.piscinaChB = new JCheckBox();
		this.piscinaChB.setBounds(325, 235, 21, 25);
		this.add(piscinaChB);
		
		//fila 3
		this.jard�nL = new JLabel("Jard�n");
		this.jard�nL.setBounds(132, 260, 39, 25);
		this.add(jard�nL);
		
		this.jard�nChB = new JCheckBox();
		this.jard�nChB.setBounds(170, 260, 21, 25);
		this.add(jard�nChB);
		
		this.trasteroL = new JLabel("Trastero");
		this.trasteroL.setBounds(207, 260, 59, 25);
		this.add(trasteroL);
		
		this.trasteroChB = new JCheckBox();
		this.trasteroChB.setBounds(265, 260, 21, 25);
		this.add(trasteroChB);
		
//-------------------------------------------------------------------------------------------------
		this.estadoL = new JLabel("Estado");
		this.estadoL.setBounds(a, 10*b, w, a);
		this.add(estadoL);
		
		this.estadoCB = new JComboBox();
		estadoCB.setModel(new DefaultComboBoxModel(new String[] {"Segunda mano"}));
		this.estadoCB.setBounds(c, 10*b, 2*w, a);
		this.add(estadoCB);
		
//--------------------------------------------------------------------------------------------------
		this.volver = new JButton("Volver");
		this.volver.setBounds(105, 336, 76, 25);
		this.add(volver);
		
		this.buscar = new JButton("buscar");
		this.buscar.setBounds(254, 336, 76, 25);
		this.add(buscar);
	}

	public String getPrecioTF() {
		if(!precioTF.getText().trim().isEmpty())
			return String.valueOf(precioTF.getText());
		return null;
	}

	public String getSuperficieTF() {
		if(!superficieTF.getText().trim().isEmpty())
			return String.valueOf(superficieTF.getText());
		return null;
	}

	public String getHabitacionesTF() {
		if(!habitacionesTF.getText().trim().isEmpty())
			return String.valueOf(habitacionesTF.getText());
		return null;
	}

	public String getBa�osTF() {
		if(!ba�osTF.getText().trim().isEmpty())
			return String.valueOf(ba�osTF.getText());
		return null;
	}

	public String getTipoCB() {
		return String.valueOf(tipoCB.getSelectedItem());
	}

	public String getTerrazaChB() {
		if(terrazaChB.isSelected())
			return "terraza";		
		return null;
	}

	public String getAscensorChB() {
		if(ascensorChB.isSelected())
			return "ascensor";
		return null;
	}

	public String getParkingChB() {
		if(parkingChB.isSelected())
			return "parking";
		return null;
	}

	public String getAmuebladaChB() {
		if(amuebladaChB.isSelected())
			return "amueblada";
		return null;
	}

	public String getCalefacci�nChB() {
		if(calefacci�nChB.isSelected())
			return "calefaccion";
		return null;
	}

	public String getPiscinaChB() {
		if(piscinaChB.isSelected())
			return "piscina";
		return null;
	}

	public String getJard�nChB() {
		if(jard�nChB.isSelected())
			return "jardin";
		return null;
	}

	public String getTrasteroChB() {
		if(trasteroChB.isSelected())
			return "trastero";
		return null;
	}

	public String getEstadoCB() {
		return String.valueOf(estadoCB.getSelectedItem());
	}
	public String[] getExtras(){
		ArrayList<String> el = new ArrayList<String>();
		
		el.add(this.getTerrazaChB());
		el.add(this.getAscensorChB());
		el.add(this.getParkingChB());
		el.add(this.getAmuebladaChB());
		el.add(this.getCalefacci�nChB());
		el.add(this.getPiscinaChB());
		el.add(this.getJard�nChB());
		el.add(this.getTrasteroChB());
		
		el.removeAll(Collections.singleton(null));
		if(el.size() == 0){
			return null;
		}else{
			String []dsf = new String[el.size()];
			el.toArray(dsf);
			return dsf;
			
		}
		
	}
	
}