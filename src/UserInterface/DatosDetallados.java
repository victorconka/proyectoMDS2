package UserInterface;

import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import java.awt.Color;
import javax.swing.JSeparator;
import javax.swing.JTable;
import javax.swing.JTextArea;
import java.util.ArrayList;
import java.util.Iterator;

import org.orm.PersistentException;
import org.orm.PersistentTransaction;

import bbdd_gestion.Casa;
import bbdd_gestion.CasaDAO;
import bbdd_gestion.Extra;
import bbdd_gestion.ExtraCriteria;

import javax.swing.AbstractListModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import java.awt.Font;

//el extends no tiene que estar, visual paradigm dejó enlaces residuo
public class DatosDetallados extends JPanel{
	JLabel price;
	
	private Foto foto;
	private Mapa mapa;
	private JLabel dLargaL;
	private JLabel precio;
	private JScrollPane extrasSP;
	private JList extras;
	private JLabel direccionL;
	private JLabel estadoL;
	private ImageIcon iconoVisitas;
	private JTable table;
	private JPanel panel;
	private JPanel panel_2;
	private JPanel panel_3;
	
	protected JButton volver;
	protected JButton contactar;
	protected JButton cita;
	private JLabel dLargaTF;
	private JScrollPane dLargaSP;
	protected JTextArea dLargaTA;
	private JLabel favoritos;
	private JLabel fav;
	private JLabel visto;
	private JLabel estado;
	private JLabel direccionTF;
	private JLabel supL;
	private JLabel nHabL;
	private JLabel nBaniosL;
	private JLabel sup;
	private JLabel nHab;
	private JLabel nBanios;
	private JLabel tipoVivL;
	private JLabel tipoViv;
	private JSeparator separator_1;
	private JSeparator separator_2;
	private JSeparator separator_3;
	

	public void cargarDatosVivienda(Casa c){
		PersistentTransaction t = null;

		try {			
			t = bbdd_gestion.ProjectMDS2PersistentManager.instance().getSession().beginTransaction();
			ArrayList<String> al = new ArrayList<String>();
			Casa otra = CasaDAO.getCasaByORMID(c.getORMID());
			
			ExtraCriteria crit = new ExtraCriteria();
			crit.inmueble.equals(c);
			//Extra[] ex = ExtraDAO.listExtraByCriteria(crit);
			
			Iterator<Extra> it = otra.extra.getIterator();
			Extra e = bbdd_gestion.ExtraDAO.createExtra();
			while(it.hasNext()){
				e = it.next();
				al.add(e.getNombreExtra());
			}
			
			extras.setModel(new AbstractListModel() {
				String[] values = al.toArray(new String[al.size()]);
				public int getSize() {
					return values.length;
				}
				public Object getElementAt(int index) {
					return values[index];
				}
			});
								
			this.sup.setText(c.getSuperficie().toString() + " m2");
			this.nBanios.setText(String.valueOf(c.getBanios()));
			this.nHab.setText(String.valueOf(c.getHabitaciones()));
			this.tipoViv.setText(c.getTipo());
			this.dLargaTA.setText(c.getdLarga());
			this.price.setText(String.valueOf(c.getPrecio()));
			this.direccionTF.setText("<html>" + c.getDireccion() + ", " + c.getMunicipio() + ", " + c.getProvincia() + ", " + c.getCodigoPostal() + "</html>");
			this.visto.setText(String.valueOf(c.getNumVisitas()));
			this.fav.setText(String.valueOf(c.getNumFavoritos()));
			this.estado.setText("<html>" + c.getEstado() + "</html>");
			
			int visto = c.getNumVisitas();
			visto++;
			
			Casa caserio = CasaDAO.createCasa();
			caserio = CasaDAO.getCasaByORMID(c.getORMID());
			caserio.setNumVisitas(visto);
			
			
			CasaDAO.save(caserio);
			t.commit();
		} catch (PersistentException e) {
			e.printStackTrace();
		}

		
	}
	
	public DatosDetallados() {
		setLayout(null);
		this.setSize(Utils.wMedio,Utils.hMedio);
		
		this.volver = new JButton("Volver");
		volver.setFont(new Font("Tahoma", Font.BOLD, 11));
		this.volver.setBounds(10, 364, 100, 23);
		this.add(volver);
		
		this.contactar = new JButton("Contactar");
		contactar.setFont(new Font("Tahoma", Font.BOLD, 11));
		this.contactar.setBounds(168, 364, 100, 23);
		this.add(contactar);
		
		this.cita = new JButton("Cita");
		cita.setFont(new Font("Tahoma", Font.BOLD, 11));
		this.cita.setBounds(340, 364, 100, 23);
		this.add(cita);
		
		mapa = new Mapa();
		mapa.setBackground(Color.PINK);
		mapa.setBounds(0,164,152, 193);
		this.add(mapa);
		
		
		dLargaL = new JLabel("Descripcion detallada:");
		dLargaL.setFont(new Font("Tahoma", Font.BOLD, 12));
		dLargaL.setLocation(162, 8);
		dLargaL.setSize(184, 14);
		this.add(dLargaL);
		
		extras = new JList();		
		extras.setSize(95, 85);
		extrasSP = new JScrollPane(extras);
		extrasSP.setLocation(353, 18);
		extrasSP.setBounds(351, 29, 99, 136);
		this.add(extrasSP);
		//this.add(extras);
		
		
		foto = new Foto();
		foto.initSlider();
		foto.setBounds(0,0,152, 165);
		this.add(foto);
		
		JLabel lblExtras = new JLabel("Extras:");
		lblExtras.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblExtras.setBackground(Color.LIGHT_GRAY);
		lblExtras.setBounds(355, 8, 84, 14);
		add(lblExtras);
		
		panel = new JPanel();
		panel.setBackground(Color.YELLOW);
		panel.setBounds(152, 0, 200, 328);
		add(panel);
		panel.setLayout(null);
		
		/*
		dLargaTF = new JLabel("");
		dLargaTF.setVerticalAlignment(SwingConstants.TOP);
		dLargaTF.setHorizontalAlignment(SwingConstants.LEFT);
		dLargaTF.setBounds(10, 29, 180, 204);
		panel.add(dLargaTF);
		*/
		
		dLargaTA = new JTextArea();
		dLargaTA.setBounds(10, 29, 180, 137);
		dLargaTA.setLineWrap( true );
		dLargaTA.setWrapStyleWord( true );
		dLargaTA.setEditable(false);
		dLargaSP = new JScrollPane(dLargaTA);
		dLargaSP.setBounds(10, 29, 180, 135);
		panel.add(dLargaSP);
		
		supL = new JLabel("Superficie");
		supL.setFont(new Font("Tahoma", Font.BOLD, 11));
		supL.setBounds(10, 175, 100, 15);
		panel.add(supL);
		
		nHabL = new JLabel("N\u00BA Habitaciones");
		nHabL.setFont(new Font("Tahoma", Font.BOLD, 11));
		nHabL.setBounds(10, 200, 100, 15);
		panel.add(nHabL);
		
		nBaniosL = new JLabel("N\u00BA Ba\u00F1os");
		nBaniosL.setFont(new Font("Tahoma", Font.BOLD, 11));
		nBaniosL.setBounds(10, 225, 100, 15);
		panel.add(nBaniosL);
		
		sup = new JLabel("");
		sup.setBounds(115, 175, 80, 15);
		panel.add(sup);
		
		nHab = new JLabel("");
		nHab.setBounds(115, 200, 80, 15);
		panel.add(nHab);
		
		nBanios = new JLabel("");
		nBanios.setBounds(115, 225, 80, 15);
		panel.add(nBanios);
		
		
		
		direccionL = new JLabel("Direccion:");
		direccionL.setBounds(10, 250, 190, 14);
		panel.add(direccionL);
		direccionL.setFont(new Font("Tahoma", Font.BOLD, 12));
		
		direccionTF = new JLabel("");
		direccionTF.setBounds(10, 275, 180, 50);
		panel.add(direccionTF);
		direccionTF.setHorizontalAlignment(SwingConstants.LEFT);
		direccionTF.setVerticalAlignment(SwingConstants.TOP);
		
		panel_2 = new JPanel();
		panel_2.setBackground(Color.PINK);
		panel_2.setBounds(352, 164, 96, 164);
		add(panel_2);
		panel_2.setLayout(null);
		
		estado = new JLabel("");
		estado.setHorizontalAlignment(SwingConstants.LEFT);
		estado.setVerticalAlignment(SwingConstants.TOP);
		estado.setBounds(0, 67, 95, 14);
		panel_2.add(estado);
		
		estadoL = new JLabel("Estado:");
		estadoL.setFont(new Font("Tahoma", Font.BOLD, 12));
		estadoL.setBounds(0, 53, 95, 14);
		panel_2.add(estadoL);
		
		tipoVivL = new JLabel("Tipo Vivienda");
		tipoVivL.setFont(new Font("Tahoma", Font.BOLD, 12));
		tipoVivL.setBounds(0, 9, 95, 14);
		panel_2.add(tipoVivL);
		
		tipoViv = new JLabel("");
		tipoViv.setBounds(0, 24, 95, 14);
		panel_2.add(tipoViv);
		
		price = new JLabel("");
		price.setBounds(0, 137, 54, 14);
		panel_2.add(price);
		price.setBackground(new Color(204, 255, 153));
		
		JLabel priceEuro = new JLabel("\u20AC");
		priceEuro.setBounds(53, 137, 31, 14);
		panel_2.add(priceEuro);
		priceEuro.setFont(new Font("Tahoma", Font.BOLD, 11));
		priceEuro.setBackground(new Color(204, 255, 153));
		
		precio = new JLabel("Precio:");
		precio.setBounds(0, 122, 84, 14);
		panel_2.add(precio);
		precio.setFont(new Font("Tahoma", Font.BOLD, 12));
		
		JSeparator separator = new JSeparator();
		separator.setBounds(0, 109, 96, 2);
		panel_2.add(separator);
		
		separator_1 = new JSeparator();
		separator_1.setBounds(0, 162, 96, 2);
		panel_2.add(separator_1);
		
		separator_2 = new JSeparator();
		separator_2.setBounds(0, 110, 1, 51);
		panel_2.add(separator_2);
		
		separator_3 = new JSeparator();
		separator_3.setBounds(94, 113, 1, 51);
		panel_2.add(separator_3);
		
		panel_3 = new JPanel();
		panel_3.setBackground(Color.CYAN);
		panel_3.setBounds(152, 328, 297, 29);
		add(panel_3);
		panel_3.setLayout(null);
		
		visto = new JLabel("");
		visto.setBounds(115, 3, 44, 23);
		panel_3.add(visto);
		
		iconoVisitas = new ImageIcon(getClass().getClassLoader().getResource("Iconos/icono_ojo.png"));
		JLabel vistoL = new JLabel("VISTO:");
		vistoL.setFont(new Font("Tahoma", Font.BOLD, 11));
		vistoL.setBounds(27, 3, 86, 23);
		vistoL.setIcon(iconoVisitas);
		panel_3.add(vistoL);
		
		fav = new JLabel("");
		fav.setBounds(220, 3, 46, 23);
		panel_3.add(fav);
		
		favoritos = new JLabel("FAV:");
		favoritos.setBounds(159, 3, 60, 23);
		panel_3.add(favoritos);
		favoritos.setFont(new Font("Tahoma", Font.BOLD, 11));
		favoritos.setIcon(new ImageIcon(getClass().getClassLoader().getResource("Iconos/icono_fav.png")));
		//iconoVisitas = new JLabel("IV");
		
	}
}