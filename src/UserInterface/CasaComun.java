package UserInterface;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JPanel;
import java.awt.Color;

public class CasaComun extends ZonaBotonesComun {
	private DatosDetallados dt;
	public CasaComun() {
		/*
		 * todos estos botones van en su correspondiente panel
		fav.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		contactar.setLocation(181, 367);
		cita.setLocation(372, 367);
		numVistoL.setLocation(245, 320);
		numFavL.setLocation(245, 286);
		fav.setLocation(275, 286);
		separator_2.setSize(0, 0);
		separator_1.setSize(0, 0);
		separator.setSize(0, 0);
		separator.setLocation(0, 0);
		*/
		this.setSize(Utils.wMedio, Utils.hMedio);
		dt = new DatosDetallados();
		dt.setLocation(0, 0);
		dt.setSize(450	, 356);
		this.add(dt);
		
		JButton btnNewButton = new JButton("Volver");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnNewButton.setBounds(10, 367, 89, 23);
		add(btnNewButton);
	}

	private JButton volver;
}