package UserInterface;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import org.orm.PersistentException;
import org.orm.PersistentTransaction;

import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import bbdd_gestion.Casa;
import bbdd_gestion.CasaDAO;
import bbdd_gestion.UsuarioR;
import bbdd_gestion.UsuarioRDAO;


public class ZonaBotonesComun extends JPanel {

	protected Casa casa;
	protected JButton contactar;
	protected JButton cita;
	private JLabel numFavL;
	protected JButton fav;
	private JLabel numVistoL;
	protected ImageIcon iconoVisitas;


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
		fav.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				favCasa(String.valueOf(Utils.idCasa), String.valueOf(Utils.id));
			}
		});
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
		

	}
	
	public void favCasa(String id_casa, String id_usuario) {
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

}