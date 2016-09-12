package UserInterface;

import java.awt.Color;
import java.awt.Component;
import java.awt.Image;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JScrollBar;
import javax.swing.JSeparator;
import javax.swing.SwingConstants;

import org.orm.PersistentException;
import org.orm.PersistentTransaction;

import bbdd_gestion.Casa;
import bbdd_gestion.ProjectMDS2PersistentManager;

public class InformaciónListaCasas extends Foto {

	private JLabel fotoL;
	private JLabel estadoL;
	private JLabel visitasL;
	private JLabel interesadosL;
	protected JLabel infoEstadoL;
	protected JLabel infoVisitasL;
	protected JLabel infoInteresadosL;
	private JLabel f;
	
	public InformaciónListaCasas() {
		
		fotoL = new JLabel("Foto");
		fotoL.setBounds(20, 78, 72, 12);
		
		
		estadoL = new JLabel("Estado");
		estadoL.setBounds(114, 79, 63, 10);
		
		
		visitasL = new JLabel("Visitas");
		visitasL.setBounds(215, 77, 54, 14);
		
		
		interesadosL = new JLabel("Interesados");
		interesadosL.setBounds(300, 79, 72, 10);
		
		
		infoEstadoL = new JLabel("En venta");
		infoEstadoL.setBounds(100, 47, 106, 23);
		
		infoVisitasL = new JLabel("8");
		infoVisitasL.setBounds(221, 41, 34, 34);
		
		infoInteresadosL = new JLabel("2");
		infoInteresadosL.setBounds(304, 41, 44, 34);
	}
	
	protected void verDatos() {
		add(infoEstadoL);
		add(infoVisitasL);
		add(infoInteresadosL);
		f = getImageLabel("Iconos/imagen_casa.png",80,80);
		this.add(f);
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
	protected void setFoto(Casa casa){
		PersistentTransaction t = null;
		
		try {
			t = ProjectMDS2PersistentManager.instance().getSession().beginTransaction();
			Registry r = LocateRegistry.getRegistry(1099);
			
			Casa c2 = bbdd_gestion.CasaDAO.createCasa();
			c2 = bbdd_gestion.CasaDAO.loadCasaByORMID(casa.getId_Inmueble());
			if(c2.fotos.size() > 0){
				bbdd_gestion.Foto f = (bbdd_gestion.Foto) c2.fotos.getIterator().next();
				this.setFoto(f.getLinkFoto());
			}			
			ProjectMDS2PersistentManager.instance().disposePersistentManager();		
		} catch (PersistentException | RemoteException e) {
			e.printStackTrace();
		}
	}
	public void setFoto(String foto){
		this.remove(this.f);
		
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

        this.f.setIcon(new ImageIcon(imScaled));
  
        this.add(this.f);
	}
	protected void verCabecera() {
		add(fotoL);
		add(estadoL);
		add(visitasL);
		add(interesadosL);
	}
	
	protected void esconder() {
		for (Component c: getComponents())
			c.setVisible(false);
	}
	
	protected void mostrar() {
		for (Component c: getComponents())
			c.setVisible(true);
	}
}