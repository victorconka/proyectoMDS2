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
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.FlowLayout;
import javax.swing.SwingConstants;
import java.awt.Font;

//el extends no tiene que estar, visual paradigm dejó enlaces residuo
public class DatosDetallados extends JPanel{
	JLabel price;
	
	private Foto foto;
	private Mapa mapa;
	private JLabel dLargaL;
	private JLabel precio;
	private JList extras;
	private JLabel direccionL;
	private JLabel estadoL;
	private ImageIcon iconoVisitas;
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
	private JLabel visto;
	private JLabel estado;
	private JLabel direccionTF;
	

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
								
			
			this.dLargaTF.setText("<html>" + c.getdLarga() + "</html>");
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
			// TODO Auto-generated catch block
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
		
		precio = new JLabel("Precio:");
		precio.setFont(new Font("Tahoma", Font.BOLD, 12));
		precio.setLocation(356, 8);
		precio.setSize(84, 14);
		this.add(precio);
		
		extras = new JList();
		extras.setSize(95, 167);
		this.add(extras);
		extras.setLocation(354, 76);
		
		
		foto = new Foto();
		foto.initSlider();
		foto.setBounds(0,0,152, 165);
		this.add(foto);
		
		JLabel lblExtras = new JLabel("Extras:");
		lblExtras.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblExtras.setBackground(Color.LIGHT_GRAY);
		lblExtras.setBounds(356, 58, 84, 14);
		add(lblExtras);
		
		panel = new JPanel();
		panel.setBackground(Color.YELLOW);
		panel.setBounds(152, 0, 200, 244);
		add(panel);
		panel.setLayout(null);
		
		dLargaTF = new JLabel("");
		dLargaTF.setVerticalAlignment(SwingConstants.TOP);
		dLargaTF.setHorizontalAlignment(SwingConstants.LEFT);
		dLargaTF.setBounds(10, 29, 180, 204);
		panel.add(dLargaTF);
		
		panel_1 = new JPanel();
		panel_1.setBackground(Color.ORANGE);
		panel_1.setBounds(152, 243, 200, 77);
		add(panel_1);
		panel_1.setLayout(null);
		
		
		
		direccionL = new JLabel("Direccion:");
		direccionL.setFont(new Font("Tahoma", Font.BOLD, 12));
		direccionL.setBounds(10, 11, 190, 14);
		panel_1.add(direccionL);
		
		direccionTF = new JLabel("");
		direccionTF.setHorizontalAlignment(SwingConstants.LEFT);
		direccionTF.setVerticalAlignment(SwingConstants.TOP);
		direccionTF.setBounds(0, 36, 200, 41);
		panel_1.add(direccionTF);
		
		panel_2 = new JPanel();
		panel_2.setBackground(Color.PINK);
		panel_2.setBounds(352, 243, 96, 77);
		add(panel_2);
		panel_2.setLayout(null);
		
		estado = new JLabel("");
		estado.setHorizontalAlignment(SwingConstants.LEFT);
		estado.setVerticalAlignment(SwingConstants.TOP);
		estado.setBounds(0, 36, 95, 41);
		panel_2.add(estado);
		
		estadoL = new JLabel("Estado:");
		estadoL.setFont(new Font("Tahoma", Font.BOLD, 12));
		estadoL.setBounds(0, 11, 95, 14);
		panel_2.add(estadoL);
		
		panel_3 = new JPanel();
		panel_3.setBackground(Color.CYAN);
		panel_3.setBounds(152, 320, 297, 37);
		add(panel_3);
		panel_3.setLayout(null);
		
		visto = new JLabel("");
		visto.setBounds(98, 8, 44, 23);
		panel_3.add(visto);
		
		iconoVisitas = new ImageIcon(getClass().getClassLoader().getResource("Iconos/icono_ojo.png"));
		JLabel vistoL = new JLabel("VISTO:");
		vistoL.setFont(new Font("Tahoma", Font.BOLD, 11));
		vistoL.setBounds(10, 8, 86, 23);
		vistoL.setIcon(iconoVisitas);
		panel_3.add(vistoL);
		
		fav = new JLabel("");
		fav.setBounds(203, 8, 46, 23);
		panel_3.add(fav);
		
		favoritos = new JLabel("FAV:");
		favoritos.setBounds(142, 8, 60, 23);
		panel_3.add(favoritos);
		favoritos.setFont(new Font("Tahoma", Font.BOLD, 11));
		favoritos.setIcon(new ImageIcon(getClass().getClassLoader().getResource("Iconos/icono_fav.png")));
		
		price = new JLabel("");
		price.setBackground(new Color(204, 255, 153));
		price.setBounds(356, 33, 54, 14);
		add(price);
		
		JLabel priceEuro = new JLabel("\u20AC");
		priceEuro.setFont(new Font("Tahoma", Font.BOLD, 11));
		priceEuro.setBackground(new Color(204, 255, 153));
		priceEuro.setBounds(409, 33, 31, 14);
		add(priceEuro);
		//iconoVisitas = new JLabel("IV");
		
	}
}