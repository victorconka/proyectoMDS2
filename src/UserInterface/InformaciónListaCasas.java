package UserInterface;

import java.awt.Color;
import java.awt.Component;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JScrollBar;
import javax.swing.JSeparator;
import javax.swing.SwingConstants;

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
		infoEstadoL.setBounds(114, 47, 72, 23);
		
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