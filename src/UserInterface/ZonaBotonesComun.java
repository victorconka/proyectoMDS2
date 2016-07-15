package UserInterface;

import javax.swing.ImageIcon;
import javax.swing.JButton;
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
	private JButton contactar;
	private JButton cita;
	private JLabel numFavL;
	private JButton fav;
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
		contactar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				int confirmed = JOptionPane.showConfirmDialog(null, 
				        "Prueba funcionalidad boton contactar", "Exit Program Message Box",
				        JOptionPane.YES_NO_OPTION);

				    if (confirmed == JOptionPane.YES_OPTION) {
				    }
			}
		});
		contactar.setLocation(265, 31);
		contactar.setSize(91, 23);
		add(contactar);
		
		cita = new JButton("Cita");
		cita.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				int confirmed = JOptionPane.showConfirmDialog(null, 
				        "Prueba funcionalidad boton Cita", "Exit Program Message Box",
				        JOptionPane.YES_NO_OPTION);

				    if (confirmed == JOptionPane.YES_OPTION) {
				      //dispose();
				    }
			}
		});
		cita.setLocation(355, 31);
		cita.setSize(68, 23);
		add(cita);
		
		numFavL = new JLabel("2");
		numFavL.setLocation(327, 54);
		numFavL.setSize(13, 23);
		add(numFavL);
		
		
		fav = new JButton();
		fav.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				PersistentTransaction t = null;
				try {			
					t = bbdd_gestion.ProjectMDS2PersistentManager.instance().getSession().beginTransaction();
					Casa caserio = CasaDAO.createCasa();
					caserio = CasaDAO.getCasaByORMID(casa.getORMID());
					
					int value = caserio.getNumFavoritos();
					value ++;
					caserio.setNumFavoritos(value);	
					
					CasaDAO.save(caserio);
					t.commit();

				} catch (PersistentException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				int confirmed = JOptionPane.showConfirmDialog(null, 
				        "Prueba funcionalidad icono FAV", "Exit Program Message Box",
				        JOptionPane.YES_NO_OPTION);

				    if (confirmed == JOptionPane.YES_OPTION) {
				      //dispose();
				    }
			}
		});
		fav.setLocation(340, 54);
		fav.setIcon(new ImageIcon(getClass().getClassLoader().getResource("Iconos/icono_fav.png")));
		fav.setSize(18, 22);
		add(fav);
		
		
		numVistoL = new JLabel("7");
		numVistoL.setLocation(277, 54);
		numVistoL.setSize(20, 20);
		add(numVistoL);
		
		iconoVisitas = new ImageIcon(getClass().getClassLoader().getResource("Iconos/icono_ojo.png"));
		JLabel iv = new JLabel();
		iv.setLocation(291, 55);
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