package UserInterface;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import java.awt.Color;
import javax.swing.SwingConstants;

import org.orm.PersistentException;
import org.orm.PersistentManager;
import org.orm.PersistentTransaction;

import bbdd_gestion.Casa;
import bbdd_gestion.CasaCriteria;
import bbdd_gestion.CasaDAO;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class ZonaBotonesComun extends JPanel {

	protected Casa casa;
	protected JButton contactar;
	protected JButton cita;
	private JLabel numFavL;
	protected JButton fav;
	private JLabel numVistoL;
	protected ImageIcon iconoVisitas;
	private JSeparator separator;
	private JSeparator separator_1;
	private JSeparator separator_2;

	public void setNumFav(String numFav){
		this.numFavL.setText(numFav);
	}
	public void setNumVisto(String numVisto){
		this.numVistoL.setText(numVisto);
	}
	
	public ZonaBotonesComun() {

		setBackground(Color.ORANGE);
		setBorder(null);
		setOpaque(false);
		setLayout(null);
		this.setSize(Utils.wMedio, 80);
		
		contactar = new JButton("Contactar");
		contactar.setLocation(265, 31);
		contactar.setSize(91, 23);
		add(contactar);
		
		cita = new JButton("Cita");
		cita.setLocation(355, 31);
		cita.setSize(68, 23);
		add(cita);
		
		numFavL = new JLabel("2");
		numFavL.setLocation(342, 55);
		numFavL.setSize(20, 23);
		add(numFavL);
		
		
		fav = new JButton();
		fav.setLocation(322, 55);
		fav.setIcon(new ImageIcon(getClass().getClassLoader().getResource("Iconos/icono_fav.png")));
		fav.setSize(18, 22);
		add(fav);
		
		
		numVistoL = new JLabel("7");
		numVistoL.setLocation(302, 56);
		numVistoL.setSize(22, 20);
		add(numVistoL);
		
		iconoVisitas = new ImageIcon(getClass().getClassLoader().getResource("Iconos/icono_ojo.png"));
		JLabel iv = new JLabel();
		iv.setLocation(268, 55);
		iv.setIcon(iconoVisitas);
		iv.setSize(32, 23);
		add(iv);
		
		/*
		separator = new JSeparator();
		separator.setForeground(Color.BLACK);
		separator.setBounds(265, 76, 159, 2);
		add(separator);
		
		separator_1 = new JSeparator();
		separator_1.setOrientation(SwingConstants.VERTICAL);
		separator_1.setForeground(Color.BLACK);
		separator_1.setBounds(355, 53, 13, 24);
		add(separator_1);
		
		separator_2 = new JSeparator();
		separator_2.setOrientation(SwingConstants.VERTICAL);
		separator_2.setForeground(Color.BLACK);
		separator_2.setBounds(265, 54, 24, 24);
		add(separator_2);
		*/
	}

}