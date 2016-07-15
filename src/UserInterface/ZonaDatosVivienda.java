package UserInterface;

import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.DefaultComboBoxModel;

public class ZonaDatosVivienda extends LinkExternos {

	private JLabel ascensorL;
	protected JCheckBox ascensorChB;
	private JLabel parkingL;
	protected JCheckBox parkingChB;
	private JLabel piscinaL;
	protected JCheckBox piscinaChB;
	private JLabel estadoL;
	protected JComboBox estadoCB;
	private JLabel fotosL;
	private JLabel precioL;
	protected JTextField precioTF;
	private JLabel superficieL;
	protected JTextField superficieTF;
	private JLabel numeroHabitacionesL;
	protected JTextField numeroHabitacionesTF;
	private JLabel numeroBañosL;
	protected JTextField numeroBañosTF;
	private JLabel tipoL;
	protected JComboBox tipoCB;
	private JLabel terrazaL;
	protected JCheckBox terrazaCB;
	private JLabel extrasL;
	private JLabel jardinL;
	protected JCheckBox jardinCB;
	private JLabel amuebladaL;
	protected JCheckBox amuebladaCB;
	private JLabel calefaccionL;
	protected JCheckBox calefaccionCB;
	private JLabel trasteroL;
	protected JCheckBox trasteroCB;
	private JLabel mapaL;
	private JLabel acciónL;
	protected JComboBox acciónCB;
	private JLabel provinciaL;
	protected JTextField provinciaTF;
	private JLabel cpL;
	protected JTextField cpTF;
	private JLabel municipioL;
	protected JTextField municipioTF;
	private JLabel direccionL;
	protected JTextField direccion;

	public ZonaDatosVivienda() {
		setLayout(null);
		setOpaque(false);
		setSize(Utils.wGrande, Utils.hGrande);
		
		ascensorL = new JLabel("Ascensor");
		ascensorL.setBounds(247, 274, 70, 14);
		add(ascensorL);
		
		ascensorChB = new JCheckBox();
		ascensorChB.setBounds(301, 274, 21, 21);
		ascensorChB.setText("Ascensor");
		add(ascensorChB);
		
		parkingL = new JLabel("Parking");
		parkingL.setBounds(332, 274, 59, 14);
		add(parkingL);
		
		parkingChB = new JCheckBox();
		parkingChB.setBounds(381, 274, 21, 21);
		parkingChB.setText("Parking");
		add(parkingChB);
		
		piscinaL = new JLabel("Piscina");
		piscinaL.setBounds(257, 323, 50, 14);
		add(piscinaL);
		
		piscinaChB = new JCheckBox();
		piscinaChB.setBounds(304, 319, 21, 21);
		piscinaChB.setText("Piscina");
		add(piscinaChB);
		
		estadoL = new JLabel("Estado");
		estadoL.setBounds(29, 363, 62, 14);
		add(estadoL);
		
		estadoCB = new JComboBox();
		estadoCB.setModel(new DefaultComboBoxModel(new String[] {"Segunda mano", "Nueva"}));
		estadoCB.setBounds(170, 360, 221, 20);
		add(estadoCB);
		
		fotosL = new JLabel("Fotos");
		fotosL.setBounds(29, 127, 44, 14);
		add(fotosL);
		
		precioL = new JLabel("Precio");
		precioL.setBounds(29, 152, 44, 14);
		add(precioL);
		
		precioTF = new JTextField();
		precioTF.setBounds(170, 149, 221, 20);
		add(precioTF);
		
		superficieL = new JLabel("Superficie");
		superficieL.setBounds(29, 177, 85, 14);
		add(superficieL);
		
		superficieTF = new JTextField();
		superficieTF.setBounds(170, 174, 221, 20);
		add(superficieTF);
		
		numeroHabitacionesL = new JLabel("Número habitaciones");
		numeroHabitacionesL.setBounds(29, 202, 131, 14);
		add(numeroHabitacionesL);
		
		numeroHabitacionesTF = new JTextField();
		numeroHabitacionesTF.setBounds(170, 199, 221, 20);
		add(numeroHabitacionesTF);
		
		numeroBañosL = new JLabel("Número baños");
		numeroBañosL.setBounds(29, 227, 110, 14);
		add(numeroBañosL);
		
		numeroBañosTF = new JTextField();
		numeroBañosTF.setBounds(170, 224, 221, 20);
		add(numeroBañosTF);
		
		tipoL = new JLabel("Tipo");
		tipoL.setBounds(29, 252, 62, 14);
		add(tipoL);
		
		tipoCB = new JComboBox();
		tipoCB.setModel(new DefaultComboBoxModel(new String[] {"Apartamento", "Piso", "\u00C1tico"}));
		tipoCB.setBounds(170, 249, 221, 20);
		add(tipoCB);
		
		terrazaL = new JLabel("Terraza");
		terrazaL.setBounds(170, 274, 50, 14);
		add(terrazaL);
		
		terrazaCB = new JCheckBox();
		terrazaCB.setBounds(220, 274, 21, 21);
		terrazaCB.setText("Terraza");
		add(terrazaCB);
		
		extrasL = new JLabel("Extras");
		extrasL.setBounds(29, 277, 57, 14);
		add(extrasL);
		
		jardinL = new JLabel("Jardín");
		jardinL.setBounds(337, 323, 44, 14);
		add(jardinL);
		
		jardinCB = new JCheckBox();
		jardinCB.setBounds(381, 319, 21, 21);
		jardinCB.setText("Jardin");
		add(jardinCB);
		
		amuebladaL = new JLabel("Amueblada");
		amuebladaL.setBounds(170, 299, 76, 14);
		add(amuebladaL);
		
		amuebladaCB = new JCheckBox();
		amuebladaCB.setBounds(241, 295, 21, 21);
		amuebladaCB.setText("Amueblada");
		add(amuebladaCB);
		
		calefaccionL = new JLabel("Calefacción");
		calefaccionL.setBounds(281, 299, 85, 14);
		add(calefaccionL);
		
		calefaccionCB = new JCheckBox();
		calefaccionCB.setBounds(357, 295, 21, 21);
		calefaccionCB.setText("Calefaccion");
		add(calefaccionCB);
		
		trasteroL = new JLabel("Trastero");
		trasteroL.setBounds(170, 324, 61, 14);
		add(trasteroL);
		
		trasteroCB = new JCheckBox();
		trasteroCB.setBounds(220, 320, 21, 21);
		trasteroCB.setText("Trastero");
		add(trasteroCB);
		
		mapaL = new JLabel("Mapa");
		mapaL.setBounds(29, 413, 62, 14);
		add(mapaL);
		
		acciónL = new JLabel("Acción");
		acciónL.setBounds(29, 388, 62, 14);
		add(acciónL);
		
		acciónCB = new JComboBox();
		acciónCB.setModel(new DefaultComboBoxModel(new String[] {"Vender", "Alquilar"}));
		acciónCB.setBounds(170, 385, 221, 20);
		add(acciónCB);
		
		provinciaL = new JLabel("Provincia");
		provinciaL.setBounds(29, 77, 76, 14);
		add(provinciaL);
		
		provinciaTF = new JTextField();
		provinciaTF.setBounds(170, 74, 221, 20);
		add(provinciaTF);
		
		cpL = new JLabel("CP");
		cpL.setBounds(29, 102, 44, 14);
		add(cpL);
		
		cpTF = new JTextField();
		cpTF.setBounds(170, 99, 221, 20);
		add(cpTF);
		
		municipioL = new JLabel("Municipio");
		municipioL.setBounds(29, 52, 76, 14);
		add(municipioL);
		
		municipioTF = new JTextField();
		municipioTF.setBounds(170, 49, 221, 20);
		add(municipioTF);
		
		direccionL = new JLabel("Dirección");
		direccionL.setBounds(29, 27, 76, 14);
		add(direccionL);
		
		direccion = new JTextField();
		direccion.setBounds(170, 24, 221, 20);
		add(direccion);
		
	}
}