package UserInterface;

import java.awt.Graphics;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

public class Foto extends JPanel {

	protected ImageIcon foto;
	
	public Foto() {
		setOpaque(false);
		setLayout(null);
		setSize(Utils.wMedio, Utils.hMedio);
		foto = new ImageIcon(getClass().getClassLoader().getResource("Iconos/imagen_casa.png"));
	}

	protected void paintComponent(Graphics g) {
		//g.drawImage(foto.getImage(), 10, 110, 100, 100, null);
	}
}