package UserInterface;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;

import bbdd.IUsuario;
import bbdd_gestion.Usuario;

public class UsuarioNoRegistrado extends UsuarioGenerico {

	private JLabel entrarL;
	private JButton entrar;
	protected Entrar ent = new Entrar();
	private ZonaDeBotenesNoRegistrado zbnr = new ZonaDeBotenesNoRegistrado();

	public UsuarioNoRegistrado() {
		getContentPane().setLayout(null);

		ent.setSize(Utils.wMedio, Utils.hMedio);
		getContentPane().add(ent).setVisible(false);

		entrar = new JButton("");
		entrar.setIcon(new ImageIcon(getClass().getClassLoader().getResource("Iconos/icono_perfil.png")));
		entrar.setBounds(368, 11, 35, 36);
		entrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				for (int i = 0; i < getContentPane().getComponents().length; i++) {
					getContentPane().getComponents()[i].setVisible(false);
				}
				ent.setVisible(true);
			}
		});

		getContentPane().add(entrar);

		entrarL = new JLabel("Entrar");
		entrarL.setBounds(318, 24, 40, 23);
		getContentPane().add(entrarL);		

		ent.volverB.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ent.setVisible(false);
				pfc.setVisible(true);
				entrar.setVisible(true);
				entrarL.setVisible(true);
			}
		});

		ent.acceder.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				IUsuario iu = null;
				Registry r = null;
				Usuario u = null;

				try {
					r = LocateRegistry.getRegistry(null);
					iu = (IUsuario) r.lookup("Servidor3");
					String pass = String.valueOf(ent.passPF.getPassword());
					u = iu.acceder(ent.usuarioTF.getText(), pass);
				} catch (Exception e1) {
					e1.printStackTrace();
				}

				if (u != null) {
					Utils.id = u.getORMID();
					if (ent.usuarioTF.getText().equals("admin@admin.com")) {
						cambiarAdmin(false, true);
					} else {
						cambiarUsuario(false, true);
					}
				}

				ent.usuarioTF.setText("");
				ent.passPF.setText("");
			}
		});

		zbnr.setBounds(0, 0, 450, 400);
		getContentPane().add(zbnr).setVisible(false);;

		/*
		 * los actionListener van dentro del panelillo de resultado
		rc.lcc.contactar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				zbnr.accion(ent, rc);
			}
		});

		rc.lcc.cita.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				zbnr.accion(ent, rc);
			}
		});

		rc.lcc.fav.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				zbnr.accion(ent, rc);
			}
		});
		*/

	}
}