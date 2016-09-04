package UserInterface;

import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.border.LineBorder;

import org.orm.PersistentException;
import org.orm.PersistentTransaction;

import bbdd_gestion.Casa;
import bbdd_gestion.CasaDAO;
import bbdd_gestion.UsuarioR;
import bbdd_gestion.UsuarioRDAO;

import java.awt.Color;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.AbstractAction;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;


public class DatosReducidos extends ZonaBotonesComun {

	
	protected JFrame frame = null;
	protected DatosDetallados dd = null;
	protected Mensaje mensaje;
	private JLabel descripcionCorta;
	private JLabel direccion;
	private JLabel precio;
	private JLabel foto;
	public JButton datosDetallados;

	
	protected void setCasa(Casa c){
		this.casa = c;
		this.setPrecio(String.valueOf(c.getPrecio()));
		this.setDireccion(c.getDireccion());
		this.setNumFav(String.valueOf(c.getNumFavoritos()));
		this.setNumVisto(String.valueOf(c.getNumVisitas()));
		this.setDescripcion("Descripcion de " + c.getId_casa());
	}
	protected Casa getCasa(){
		return this.casa;
	}
	protected int getCasaId(){
		return this.casa.getORMID();
	}
	public void setDescripcion(String descripcion){
		this.descripcionCorta.setText(descripcion);
	}
	public void setDireccion(String direccion){
		this.direccion.setText(direccion);
	}
	public void setPrecio(String precio){
		this.precio.setText(precio);
	}
	public void setFoto(){
		//TODO CARGAR FOTO
	}
	
	private JLabel getImageLabel(String location,int xSize, int ySize){
		JLabel label = new JLabel();
		
		ImageIcon icon = new ImageIcon(getClass().getClassLoader().getResource(location));	
		Image img2 = icon.getImage();
		Image newimg = img2.getScaledInstance(xSize, ySize,  java.awt.Image.SCALE_SMOOTH);
		ImageIcon newIcon = new ImageIcon(newimg);
		label.setBounds(0, 0, xSize, ySize);
		label.setIcon(newIcon);
		return label;
	}
	
	public DatosReducidos() {
		//creamos frame de los datos detallados y lo ponemos a invisible;
		frame = new JFrame();
		frame.setVisible(false);
		dd = new DatosDetallados();
		mensaje = new Mensaje();
		frame.setBounds(200, 200, Utils.wMedio+15, Utils.wMedio);
		frame.add(dd);
		frame.add(mensaje);
		
		
		casa = CasaDAO.createCasa();
		setBorder(new LineBorder(new Color(0, 0, 0), 2, true));
		setOpaque(false);
		setLayout(null);
		this.setSize(Utils.wMedio, 80);
		
		contactar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				if (Utils.id == 0) 
					JOptionPane.showMessageDialog(new JFrame(), "Debes estar registrado para hacer esto.");
				else
					mostrarMensaje("Solicitud de información");
			}
		});

		cita.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				if (Utils.id == 0) 
					JOptionPane.showMessageDialog(new JFrame(), "Debes estar registrado para hacer esto.");
				else
					mostrarMensaje("Solicitud de cita");
			}
		});
		
		fav.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				if (Utils.id == 0) 
					JOptionPane.showMessageDialog(new JFrame(), "Debes estar registrado para hacer esto.");
				else {
					PersistentTransaction t = null;
					try {			
						t = bbdd_gestion.ProjectMDS2PersistentManager.instance().getSession().beginTransaction();
						Casa caserio = CasaDAO.createCasa();
						caserio = CasaDAO.getCasaByORMID(casa.getORMID());
						UsuarioR ur = UsuarioRDAO.createUsuarioR();
						ur = UsuarioRDAO.getUsuarioRByORMID(Utils.id);

						int value = caserio.getNumFavoritos();
						value ++;
						caserio.setNumFavoritos(value);	
						caserio.favorita.add(ur);
						ur.es_Favorita.add(caserio);

						CasaDAO.save(caserio);
						t.commit();

						setNumFav(String.valueOf(value));
					} catch (PersistentException e) {
						e.printStackTrace();
					}
				}
			}
		});
		
		datosDetallados = new JButton("");
		datosDetallados.setContentAreaFilled(false);
		datosDetallados.setBounds(0, 0, 259, 80);
				
		//-------------------------------------------------
		//botones
		datosDetallados.addActionListener(
				new ActionListener(){
					public void actionPerformed(ActionEvent e){
						selectionButtonPressed();						
					}
				}
				);
		add(datosDetallados);
		
		//frame nuevo
		dd.volver.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//getParent().setVisible(true);
				frame.dispose();
				frame.setVisible(false);
			}
		});
		dd.cita.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//getParent().setVisible(true);
				frame.dispose();
				frame.setVisible(false);
			}
		});
		dd.contactar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//getParent().setVisible(true);
				frame.dispose();
				frame.setVisible(false);
			}
		});
		
		
		foto = getImageLabel("Iconos/imagen_casa.png",80,80);
		this.add(foto);
		
		descripcionCorta = new JLabel("Descripción corta");
		descripcionCorta.setLocation(90, 11);
		descripcionCorta.setSize(321, 14);
		add(descripcionCorta);
		
		direccion = new JLabel("Dirección");
		direccion.setVerticalAlignment(SwingConstants.TOP);
		direccion.setLocation(91, 34);
		direccion.setSize(168, 35);
		add(direccion);
		
		precio = new JLabel("€");
		precio.setSize(49, 14);
		precio.setLocation(365, 58);
		add(precio);

	}
	protected void selectionButtonPressed() {
		
		frame.setVisible(true);
		mensaje.setVisible(false);
		dd.setVisible(true);
		dd.cargarDatosVivienda(casa);		
		//dd.setBounds(0, 0, Utils.hMedio,  Utils.wGrande);
		
	}
	
	private void mostrarMensaje(String string) {
		frame.setVisible(true);
		mensaje.setVisible(true);
		dd.setVisible(false);
		mensaje.asuntoTF.setText(string);
		Utils.idCasa = this.getCasaId();
	}
	
	private class SwingAction extends AbstractAction {
		public SwingAction() {
			putValue(NAME, "SwingAction");
			putValue(SHORT_DESCRIPTION, "Some short description");
		}
		public void actionPerformed(ActionEvent e) {
		}
	}
}