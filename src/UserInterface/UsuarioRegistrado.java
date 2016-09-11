package UserInterface;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;

import bbdd.IUsuario;

public class UsuarioRegistrado extends UsuarioGenerico {
	

	private JLabel perfilL;
	private JButton perfil;
	protected PerfilDeUsuarioRegistrado pur = new PerfilDeUsuarioRegistrado();
	private ZonaDeBotonesRegistrado zbr = new ZonaDeBotonesRegistrado();

	public UsuarioRegistrado() {
		setLayout(null);

		add(pur);
		pfc.setVisible(false);

		perfil = new JButton("");
		perfil.setIcon(new ImageIcon(getClass().getClassLoader().getResource("Iconos/icono_perfil.png")));
		perfil.setBounds(368, 11, 35, 36);
		perfil.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				for (Component jc: getContentPane().getComponents())
					jc.setVisible(false);
				pur.setVisible(true);
				pur.lvp.cagarDatos();
			}
		});
		add(perfil).setVisible(false);;
		
		pur.cerrarSesion.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				Utils.id = 0;
				cambiarUsuario(true, false);
			}
		});
		
		pur.volver.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				for (Component jc: getContentPane().getComponents())
					jc.setVisible(false);
				pfc.setVisible(true);
				perfil.setVisible(true);
				perfilL.setVisible(true);
			}
		});
		
		pur.buscar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				for (Component jc: getContentPane().getComponents())
					jc.setVisible(false);
				pfc.setVisible(true);
				perfil.setVisible(true);
				perfilL.setVisible(true);
			}
		});
		
		pur.mp.eliminarPerfil.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				eliminarPerfil();
			}
		});

		perfilL = new JLabel("Perfil");
		perfilL.setBounds(318, 24, 40, 23);
		getContentPane().add(perfilL).setVisible(false);		
		
		getContentPane().add(zbr);
				
		zbr.cr.volverB.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				zbr.setVisible(false);
				zbr.cr.setVisible(false);
				rc.setVisible(true);
			}
		});
		
		zbr.contr.volverB.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				zbr.setVisible(false);
				zbr.contr.setVisible(false);
				rc.setVisible(true);
			}
		});
	}

	public void eliminarPerfil() {
		try {
			Registry r = LocateRegistry.getRegistry(null);
			IUsuario iu = (IUsuario) r.lookup("Servidor2");
			iu.eliminarUsuario(String.valueOf(Utils.id));
		} catch (Exception e1) {
			e1.printStackTrace();
		}
		pur.resetear();	
		cambiarUsuario(true, false);
	}
}