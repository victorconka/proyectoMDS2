package UserInterface;

import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JTextArea;
import javax.swing.JScrollPane;

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
	protected JTextArea fotosTA;
	protected JScrollPane fotosSP;
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
	protected JTextField mapaUrlTF;
	protected JTextField dCortaTF;
	protected JTextField dLargaTF;
	protected JCheckBox visibleCB;

	public ZonaDatosVivienda() {
		setOpaque(false);
		setSize(Utils.wGrande, Utils.hGrande);
		setLayout(null);
		
		ascensorL = new JLabel("Ascensor");
		ascensorL.setBounds(247, 313, 70, 14);
		add(ascensorL);
		
		ascensorChB = new JCheckBox();
		ascensorChB.setBounds(301, 313, 21, 21);
		ascensorChB.setText("Ascensor");
		add(ascensorChB);
		
		parkingL = new JLabel("Parking");
		parkingL.setBounds(332, 313, 59, 14);
		add(parkingL);
		
		parkingChB = new JCheckBox();
		parkingChB.setBounds(381, 313, 21, 21);
		parkingChB.setText("Parking");
		add(parkingChB);
		
		piscinaL = new JLabel("Piscina");
		piscinaL.setBounds(257, 362, 50, 14);
		add(piscinaL);
		
		piscinaChB = new JCheckBox();
		piscinaChB.setBounds(304, 358, 21, 21);
		piscinaChB.setText("Piscina");
		add(piscinaChB);
		
		estadoL = new JLabel("Estado");
		estadoL.setBounds(29, 390, 62, 14);
		add(estadoL);
		
		estadoCB = new JComboBox();
		estadoCB.setBounds(170, 387, 221, 20);
		estadoCB.setModel(new DefaultComboBoxModel(new String[] {"Segunda mano", "Nueva"}));
		add(estadoCB);
		
		fotosL = new JLabel("Fotos");
		fotosL.setBounds(29, 114, 44, 14);
		add(fotosL);
		
		precioL = new JLabel("Precio");
		precioL.setBounds(29, 191, 44, 14);
		add(precioL);
		
		precioTF = new JTextField();
		precioTF.setBounds(170, 188, 221, 20);
		add(precioTF);
		
		superficieL = new JLabel("Superficie");
		superficieL.setBounds(29, 216, 85, 14);
		add(superficieL);
		
		superficieTF = new JTextField();
		superficieTF.setBounds(170, 213, 221, 20);
		add(superficieTF);
		
		numeroHabitacionesL = new JLabel("Número habitaciones");
		numeroHabitacionesL.setBounds(29, 241, 131, 14);
		add(numeroHabitacionesL);
		
		numeroHabitacionesTF = new JTextField();
		numeroHabitacionesTF.setBounds(170, 238, 221, 20);
		add(numeroHabitacionesTF);
		
		numeroBañosL = new JLabel("Número baños");
		numeroBañosL.setBounds(29, 266, 110, 14);
		add(numeroBañosL);
		
		numeroBañosTF = new JTextField();
		numeroBañosTF.setBounds(170, 263, 221, 20);
		add(numeroBañosTF);
		
		tipoL = new JLabel("Tipo");
		tipoL.setBounds(29, 291, 62, 14);
		add(tipoL);
		
		tipoCB = new JComboBox();
		tipoCB.setBounds(170, 288, 221, 20);
		tipoCB.setModel(new DefaultComboBoxModel(new String[] {"Apartamento", "Piso", "\u00C1tico"}));
		add(tipoCB);
		
		terrazaL = new JLabel("Terraza");
		terrazaL.setBounds(170, 313, 50, 14);
		add(terrazaL);
		
		terrazaCB = new JCheckBox();
		terrazaCB.setBounds(220, 313, 21, 21);
		terrazaCB.setText("Terraza");
		add(terrazaCB);
		
		extrasL = new JLabel("Extras");
		extrasL.setBounds(29, 316, 57, 14);
		add(extrasL);
		
		jardinL = new JLabel("Jardín");
		jardinL.setBounds(337, 362, 44, 14);
		add(jardinL);
		
		jardinCB = new JCheckBox();
		jardinCB.setBounds(381, 358, 21, 21);
		jardinCB.setText("Jardin");
		add(jardinCB);
		
		amuebladaL = new JLabel("Amueblada");
		amuebladaL.setBounds(170, 338, 76, 14);
		add(amuebladaL);
		
		amuebladaCB = new JCheckBox();
		amuebladaCB.setBounds(241, 334, 21, 21);
		amuebladaCB.setText("Amueblada");
		add(amuebladaCB);
		
		calefaccionL = new JLabel("Calefacción");
		calefaccionL.setBounds(281, 338, 85, 14);
		add(calefaccionL);
		
		calefaccionCB = new JCheckBox();
		calefaccionCB.setBounds(357, 334, 21, 21);
		calefaccionCB.setText("Calefaccion");
		add(calefaccionCB);
		
		trasteroL = new JLabel("Trastero");
		trasteroL.setBounds(170, 363, 61, 14);
		add(trasteroL);
		
		trasteroCB = new JCheckBox();
		trasteroCB.setBounds(220, 359, 21, 21);
		trasteroCB.setText("Trastero");
		add(trasteroCB);
		
		mapaL = new JLabel("Mapa");
		mapaL.setBounds(29, 440, 62, 14);
		add(mapaL);
		
		acciónL = new JLabel("Acción");
		acciónL.setBounds(29, 415, 62, 14);
		add(acciónL);
		
		acciónCB = new JComboBox();
		acciónCB.setBounds(170, 412, 221, 20);
		acciónCB.setModel(new DefaultComboBoxModel(new String[] {"Vender", "Alquilar"}));
		add(acciónCB);
		
		provinciaL = new JLabel("Provincia");
		provinciaL.setBounds(29, 64, 76, 14);
		add(provinciaL);
		
		provinciaTF = new JTextField();
		provinciaTF.setBounds(170, 61, 221, 20);
		add(provinciaTF);
		
		cpL = new JLabel("CP");
		cpL.setBounds(29, 89, 44, 14);
		add(cpL);
		
		cpTF = new JTextField();
		cpTF.setBounds(170, 86, 221, 20);
		add(cpTF);
		
		municipioL = new JLabel("Municipio");
		municipioL.setBounds(29, 39, 76, 14);
		add(municipioL);
		
		municipioTF = new JTextField();
		municipioTF.setBounds(170, 36, 221, 20);
		add(municipioTF);
		
		direccionL = new JLabel("Dirección");
		direccionL.setBounds(29, 14, 76, 14);
		add(direccionL);
		
		direccion = new JTextField();
		direccion.setBounds(170, 11, 221, 20);
		add(direccion);
		
		mapaUrlTF = new JTextField();
		mapaUrlTF.setBounds(170, 437, 221, 20);
		add(mapaUrlTF);
		
		JLabel dCortaL = new JLabel("Descripcion Corta");
		dCortaL.setBounds(29, 464, 131, 14);
		add(dCortaL);
		
		dCortaTF = new JTextField();
		dCortaTF.setBounds(170, 461, 221, 20);
		add(dCortaTF);
		
		JLabel dLargaL = new JLabel("Descripcion Larga");
		dLargaL.setBounds(29, 488, 131, 14);
		add(dLargaL);
		
		dLargaTF = new JTextField();
		dLargaTF.setBounds(170, 485, 221, 30);
		dLargaTF.setToolTipText("Descripcion Larga");
		add(dLargaTF);
		
		JLabel visibleL = new JLabel("Mostrar cada en las busquedas");
		visibleL.setBounds(29, 525, 233, 14);
		add(visibleL);
		
		visibleCB = new JCheckBox();
		visibleCB.setToolTipText("\u00BFHacer la vivienda visible para las busquedas ?");
		visibleCB.setBounds(370, 522, 21, 21);
		visibleCB.setText("Trastero");
		add(visibleCB);
		

		fotosTA = new JTextArea();
		fotosTA.setToolTipText("Inserte los enlaces de fotos separados por saltos de linea");
		fotosSP = new JScrollPane(fotosTA);
		fotosSP.setBounds(170, 109, 221, 76);
		add(fotosSP);	
		
		dLargaTF.setToolTipText("Descripcion Larga de la vivienda (1024 caracteres).");
		dCortaTF.setToolTipText("descripcion corta de la vivienda (255 caracteres). ");
		mapaUrlTF.setToolTipText("URL de google maps de la ubicacion de la vivienda");
		acciónCB.setToolTipText("proposito del apartamento en la pagina");
		estadoCB.setToolTipText("estado del apartamento");
		tipoCB.setToolTipText("tipo de la vivienda");
		numeroBañosTF.setToolTipText("numero de ba\u00F1os");
		numeroHabitacionesTF.setToolTipText("numero de habitaciones");
		superficieTF.setToolTipText("superficie");
		precioTF.setToolTipText("precio");
		cpTF.setToolTipText("codigo postal");
		provinciaTF.setToolTipText("provincia");
		municipioTF.setToolTipText("municipio");
		direccion.setToolTipText("direccion");
	}
}