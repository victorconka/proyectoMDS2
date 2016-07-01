package UserInterface;

import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;

import bbdd_gestion.Casa;
import bbdd_gestion.CasaDAO;

import java.awt.Color;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.AbstractAction;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Action;

public class DatosReducidos extends ZonaBotonesComun {

	
	protected JFrame frame = null;
	protected DatosDetallados dd = null;
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
		frame.setBounds(200, 200, Utils.wMedio+15, Utils.wMedio);
		frame.add(dd);
		
		
		
		casa = CasaDAO.createCasa();
		setBorder(new LineBorder(new Color(0, 0, 0), 2, true));
		setOpaque(false);
		setLayout(null);
		this.setSize(Utils.wMedio, 80);
		
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
		precio.setLocation(362, 58);
		add(precio);

	}
	protected void selectionButtonPressed() {
		
		frame.setVisible(true);
		dd.cargarDatosVivienda(casa);		
		//dd.setBounds(0, 0, Utils.hMedio,  Utils.wGrande);
		
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