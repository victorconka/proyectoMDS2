package UserInterface;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class CasaComun extends ZonaBotonesComun {
	private DatosDetallados dt;
	public CasaComun() {
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