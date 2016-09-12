package UserInterface;



import org.orm.PersistentException;
import org.orm.PersistentTransaction;

import bbdd_gestion.Casa;
import bbdd_gestion.CasaDAO;
import bbdd_gestion.Foto;
import bbdd_gestion.ProjectMDS2PersistentManager;
import bbdd_gestion.UsuarioR;
import bbdd_gestion.UsuarioRDAO;
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.border.LineBorder;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.imageio.ImageIO;
import javax.swing.AbstractAction;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;


public class DatosReducidos extends ZonaBotonesComun {

	
	protected JFrame frame = null;
	protected DatosDetallados dd = null;
	protected Mensaje mensaje;
	private JLabel descripcionCorta;
	private JLabel direccion;
	private JLabel precio;
	private JLabel foto;
	public JButton datosDetallados;
	private boolean auxiliar;
	
	protected void setCasa(Casa c){
		this.casa = c;
		this.setPrecio(String.valueOf(c.getPrecio()));
		this.setDireccion(c.getDireccion() + ", " + c.getMunicipio().getMunicipio());
		this.setNumFav(String.valueOf(c.getNumFavoritos()));
		this.setNumVisto(String.valueOf(c.getNumVisitas()));
		this.setDescripcion(c.getdCorta());
		this.setFoto();				
	}
	protected void setFoto(){
		PersistentTransaction t = null;
		
		try {
			t = ProjectMDS2PersistentManager.instance().getSession().beginTransaction();
			Registry r = LocateRegistry.getRegistry(1099);
			
			Casa c2 = bbdd_gestion.CasaDAO.createCasa();
			c2 = bbdd_gestion.CasaDAO.loadCasaByORMID(this.casa.getId_Inmueble());
			if(c2.fotos.size() > 0){
				bbdd_gestion.Foto f = (Foto) c2.fotos.getIterator().next();
				this.setFoto(f.getLinkFoto());
			}			
			ProjectMDS2PersistentManager.instance().disposePersistentManager();		
		} catch (PersistentException | RemoteException e) {
			e.printStackTrace();
		}
	}
	protected Casa getCasa(){
		return this.casa;
	}
	protected int getCasaId(){
		return this.casa.getORMID();
	}
	public void setDescripcion(String descripcion){
		this.descripcionCorta.setText("<html>" + descripcion + "</html>");
	}
	public void setDireccion(String direccion){
		this.direccion.setText("<html> " + direccion + " </html>");
	}
	public void setPrecio(String precio){
		this.precio.setText(precio);
	}
	public void setFoto(String foto){
		this.remove(this.foto);
		
		Image im = null;
		Image imScaled = null;
		InputStream is = null;
		
        try {
            URL url = new URL(foto);
            
            URLConnection openConnection = url.openConnection();
    		openConnection.addRequestProperty("User-Agent", "Mozilla/5.0 (Windows NT 6.1; WOW64; rv:25.0) Gecko/20100101 Firefox/25.0");
    		is = openConnection.getInputStream();
    		
            im = ImageIO.read(is);
            imScaled = im.getScaledInstance(80	, 80, Image.SCALE_SMOOTH);
            is.close();
        } catch (IOException e) {
        	e.printStackTrace();
        }

        this.foto.setIcon(new ImageIcon(imScaled));
  
        this.add(this.foto);
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
		auxiliar = false;
		
		mensaje.volverB.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				mensaje.setVisible(false);
				if (auxiliar)
					dd.setVisible(true);
				else {
					frame.dispose();
					frame.setVisible(false);
				}
			}
		});
		
		casa = CasaDAO.createCasa();
		setBorder(new LineBorder(new Color(0, 0, 0), 2, true));
		setOpaque(false);
		setLayout(null);
		this.setSize(Utils.wMedio, 80);
		
		contactar.addActionListener( new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (Utils.id == 0) 
					JOptionPane.showMessageDialog(new JFrame(), "Debes estar registrado para hacer esto.");
				else
					enviar("Solicitud de información");
			}
		});

		cita.addActionListener( new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (Utils.id == 0) 
					JOptionPane.showMessageDialog(new JFrame(), "Debes estar registrado para hacer esto.");
				else
					enviar("Solicitud de cita");
			}
		});
		
		fav.addActionListener( new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (Utils.id == 0) 
					JOptionPane.showMessageDialog(new JFrame(), "Debes estar registrado para hacer esto.");
				else {
					PersistentTransaction t = null;
					try {
						t = ProjectMDS2PersistentManager.instance().getSession().beginTransaction();

						Casa c= CasaDAO.createCasa();
						c = CasaDAO.loadCasaByORMID(casa.getId_Inmueble());

						if(c != null){
							UsuarioR u = UsuarioRDAO.loadUsuarioRByORMID(Utils.id);							
							if(!u.es_Favorita.contains(c)){										
								int value = c.favorita.size();	
								u.es_Favorita.add(c);	
								value ++;
								setNumFav(String.valueOf(value));
								c.setNumFavoritos(value);
								
								CasaDAO.save(c);
								UsuarioRDAO.save(u);
								t.commit();
							}else{
								JOptionPane.showMessageDialog(new JFrame(), "Te gustará un monton, pero no puede gustarte mas de 1 vez.");
							}
							ProjectMDS2PersistentManager.instance().disposePersistentManager();
						}else{
							System.out.println("Casa para fav no existe ?!?!");
						}
						
					} catch (PersistentException ex) {
						ex.printStackTrace();
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
				auxiliar = false;
			}
		});
		dd.cita.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (Utils.id == 0) 
					JOptionPane.showMessageDialog(new JFrame(), "Debes estar registrado para hacer esto.");
				else
					enviar("Solicitud de cita");
			}
		});
		dd.contactar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
					enviar("Solicitud de información");
			}
		});
		
		
		foto = getImageLabel("Iconos/imagen_casa.png",80,80);
		this.add(foto);
		
		descripcionCorta = new JLabel("Descripción corta");
		descripcionCorta.setLocation(85, 5);
		descripcionCorta.setSize(175, 70);
		add(descripcionCorta);
		
		direccion = new JLabel("Dirección");
		direccion.setHorizontalAlignment(SwingConstants.LEFT);
		direccion.setFont(new Font("Tahoma", Font.PLAIN, 10));
		direccion.setVerticalAlignment(SwingConstants.TOP);
		direccion.setLocation(265, 0);
		direccion.setSize(180, 30);
		add(direccion);
		
		precio = new JLabel("€");
		precio.setSize(49, 14);
		precio.setLocation(365, 58);
		add(precio);

	}
	protected void selectionButtonPressed() {
		
		frame.setVisible(true);
		frame.setResizable(false);
		mensaje.setVisible(false);
		dd.setVisible(true);
		dd.cargarDatosVivienda(casa);		
		auxiliar = true;
		
	}
	
	private void enviar(String string) {
		if (Utils.id == 0) 
			JOptionPane.showMessageDialog(new JFrame(), "Debes estar registrado para hacer esto.");
		else {
			frame.setVisible(true);
			mensaje.setVisible(true);
			dd.setVisible(false);
			mensaje.asuntoTF.setText(string);
			Utils.idCasa = this.getCasaId();
			if (this.casa.getAlquila() != null)
				mensaje.paraTF.setText(this.casa.getAlquila().getCorreo());
			else
				mensaje.paraTF.setText(this.casa.getVende().getCorreo());
		}
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