package UserInterface;

import java.awt.Image;

import javax.swing.ImageIcon;

public class Utils{

	protected static int wPequeno = 300;
	protected static int hPequeno = 250;
	
	protected static int wMedio = 450;
	protected static int hMedio = 400;
	
	protected static int wGrande = 500;
	protected static int hGrande = 550;
	protected static int wOffset = 17;
	protected static int hDR = 80;
	public static int id = 0;
	protected static int idCasa = 0;
	
	public static ImageIcon getImageLabel(String location,int xSize, int ySize){
		
		ImageIcon icon = new ImageIcon(Utils.class.getResource(location));
		Image img2 = icon.getImage();
		Image newimg = img2.getScaledInstance(xSize, ySize,  java.awt.Image.SCALE_SMOOTH);
		ImageIcon newIcon = new ImageIcon(newimg);
		
		return newIcon;
	}

}
