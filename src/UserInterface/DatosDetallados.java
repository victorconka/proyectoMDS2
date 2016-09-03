package UserInterface;

import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.JSeparator;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import java.util.ArrayList;
import java.util.Iterator;

import org.orm.PersistentException;
import org.orm.PersistentTransaction;

import bbdd_gestion.Casa;
import bbdd_gestion.CasaDAO;
import bbdd_gestion.Extra;
import bbdd_gestion.ExtraCriteria;
import bbdd_gestion.ExtraDAO;
import bbdd_gestion.ExtraSetCollection;
import bbdd_gestion.Inmueble;
import bbdd_gestion.InmuebleDAO;

import javax.swing.AbstractListModel;
import javax.swing.JButton;
import java.awt.FlowLayout;

//el extends no tiene que estar, visual paradigm dejó enlaces residuo
public class DatosDetallados extends JPanel{
	JLabel price;
	
	private Foto foto;
	private Mapa mapa;
	private JLabel dLargaL;
	private JLabel precio;
	private JList extras;
	private JLabel direccion;
	private JLabel estadoL;
	private int iconoVisitas;
	private JTable table;
	private JPanel panel;
	private JPanel panel_1;
	private JPanel panel_2;
	private JPanel panel_3;
	
	protected JButton volver;
	protected JButton contactar;
	protected JButton cita;
	private JLabel dLargaTF;
	private JLabel favoritos;
	private JLabel fav;
	private JLabel nVisto;
	private JLabel visto;
	private JLabel estado;
	

	public void cargarDatosVivienda(Casa c){
		PersistentTransaction t = null;

		try {			
			t = bbdd_gestion.ProjectMDS2PersistentManager.instance().getSession().beginTransaction();
			ArrayList<String> al = new ArrayList<String>();
			System.out.println(c.getPrecio());
			Casa otra = CasaDAO.getCasaByORMID(c.getORMID());
			
			ExtraCriteria crit = new ExtraCriteria();
			crit.inmueble.equals(c);
			Extra[] ex = ExtraDAO.listExtraByCriteria(crit);

			for(Extra e : ex){
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
								
			
			this.dLargaTF.setText(c.getdLarga());
			this.price.setText(String.valueOf(c.getPrecio()));
			this.direccion.setText(c.getDireccion());
			this.visto.setText(String.valueOf(c.getNumVisitas()));
			this.fav.setText(String.valueOf(c.getNumFavoritos()));
			this.estado.setText(c.getEstado());
			
			int visto = c.getNumVisitas();
			visto++;
			
			Casa caserio = CasaDAO.createCasa();
			caserio = CasaDAO.getCasaByORMID(c.getORMID());
			caserio.setNumVisitas(visto);
			
			
			CasaDAO.save(caserio);
			t.commit();
		} catch (PersistentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		
	}
	
	public DatosDetallados() {
		setLayout(null);
		this.setSize(Utils.wMedio,Utils.hMedio);
		
		this.volver = new JButton("Volver");
		this.volver.setBounds(48, 364, 81, 23);
		this.add(volver);
		
		this.contactar = new JButton("Contactar");
		this.contactar.setBounds(184, 364, 81, 23);
		this.add(contactar);
		
		this.cita = new JButton("Cita");
		this.cita.setBounds(321, 364, 81, 23);
		this.add(cita);
		
		mapa = new Mapa();
		mapa.setBackground(Color.PINK);
		mapa.setBounds(0,164,152, 193);
		this.add(mapa);
		
		
		dLargaL = new JLabel("Descripcion detallada");
		dLargaL.setLocation(162, 45);
		dLargaL.setSize(101, 14);
		this.add(dLargaL);
		
		precio = new JLabel("Precio");
		precio.setLocation(356, 45);
		precio.setSize(46, 14);
		this.add(precio);
		
		extras = new JList();
		extras.setSize(95, 167);
		this.add(extras);
		extras.setLocation(354, 114);
			
		
		
		direccion = new JLabel("Direccion");
		direccion.setLocation(156, 286);
		direccion.setSize(60, 14);
		this.add(direccion);
		
		estadoL = new JLabel("Estado");
		estadoL.setLocation(303, 286);
		estadoL.setSize(49, 14);
		this.add(estadoL);
		
		
		foto = new Foto();
		foto.setBounds(0,0,152, 167);
		this.add(foto);
		
		JLabel lblExtras = new JLabel("Extras");
		lblExtras.setBackground(Color.LIGHT_GRAY);
		lblExtras.setBounds(356, 96, 46, 14);
		add(lblExtras);
		
		panel = new JPanel();
		panel.setBackground(Color.YELLOW);
		panel.setBounds(152, 37, 200, 244);
		add(panel);
		panel.setLayout(null);
		
		dLargaTF = new JLabel("");
		dLargaTF.setBounds(10, 29, 180, 204);
		panel.add(dLargaTF);
		
		panel_1 = new JPanel();
		panel_1.setBackground(Color.ORANGE);
		panel_1.setBounds(152, 280, 88, 77);
		add(panel_1);
		
		panel_2 = new JPanel();
		panel_2.setBackground(Color.PINK);
		panel_2.setBounds(299, 280, 150, 77);
		add(panel_2);
		panel_2.setLayout(null);
		
		estado = new JLabel("");
		estado.setBounds(10, 23, 140, 43);
		panel_2.add(estado);
		
		panel_3 = new JPanel();
		panel_3.setBackground(Color.CYAN);
		panel_3.setBounds(240, 280, 60, 77);
		add(panel_3);
		panel_3.setLayout(null);
		
		favoritos = new JLabel("FAV");
		favoritos.setBounds(10, 11, 46, 14);
		panel_3.add(favoritos);
		
		fav = new JLabel("");
		fav.setBounds(10, 24, 46, 14);
		panel_3.add(fav);
		
		nVisto = new JLabel("VISTO");
		nVisto.setBounds(10, 41, 46, 14);
		panel_3.add(nVisto);
		
		visto = new JLabel("");
		visto.setBounds(10, 54, 46, 14);
		panel_3.add(visto);
		
		price = new JLabel("");
		price.setBackground(new Color(204, 255, 153));
		price.setBounds(356, 70, 46, 14);
		add(price);
		//iconoVisitas = new JLabel("IV");
		
	}
}