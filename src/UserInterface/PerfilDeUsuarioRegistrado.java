package UserInterface;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import bbdd.IUsuarioRegistrado;

public class PerfilDeUsuarioRegistrado extends JPanel {

	protected JButton buscar;
	protected JButton cerrarSesion;
	protected JButton volver;
	protected JButton modificarPerfil;
	private JButton favoritas;
	private JLabel viviendasPropiasL;
	private JButton altaVivienda;
	protected ListaViviendasEnPropiedad lvp = new ListaViviendasEnPropiedad();
	protected ModificarPerfil mp = new ModificarPerfil();
	private DarAltaNuevaVivienda danv = new DarAltaNuevaVivienda();
	private ListaFavoritas lf = new ListaFavoritas();

	public PerfilDeUsuarioRegistrado() {
		setOpaque(false);
		setLayout(null);
		setSize(Utils.wMedio+15, Utils.hMedio);
		
		add(lvp);
		add(mp).setVisible(false);
		add(danv).setVisible(false);
		add(lf).setVisible(false);
		
		volver = new JButton("Volver");
		volver.setBounds(41, 345, 78, 20);
		add(volver);
		
		modificarPerfil = new JButton("Modificar perfil");
		modificarPerfil.setBounds(144, 345, 132, 20);
		modificarPerfil.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				for (Component c: getComponents())
					c.setVisible(false);
				UsuarioGenerico.getFrames()[1].setSize(Utils.wGrande, Utils.hGrande);
				setSize(Utils.wGrande, Utils.hGrande);
				mp.setVisible(true);
				mp.cargarDatos();
			}
		});
		add(modificarPerfil);
		
		mp.volver.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				resetear();	
			}
		});
		
		mp.guardarCambios.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Registry r = null;
				IUsuarioRegistrado u = null;
				String pass = String.valueOf(mp.contraseñaTF.getPassword());
				String pass2 = String.valueOf(mp.repContraseñaTF.getPassword());
				
				if (pass.isEmpty() || (!pass.equals(pass2))) {
					JOptionPane.showMessageDialog(new JFrame(), "Las contraseñas no pueden estar vacias y deben coincidir");
				} else {
					try {
						r = LocateRegistry.getRegistry(1099);
						u = (IUsuarioRegistrado) r.lookup("Servidor3");
						u.guardarDatos(mp.nombreTF.getText(), mp.apellidosTF.getText(), 
								mp.direccion.getText(), mp.municipioTF.getText(),
								mp.provinciaTF.getText(), mp.cpTF.getText(), 
								mp.emailTF.getText(), pass, String.valueOf(Utils.id));
					} catch (Exception e1) {
						e1.printStackTrace();
					}
					mp.resetear();
					resetear();
				}
			}
		});
		
		favoritas = new JButton("Favoritas");
		favoritas.setBounds(301, 345, 102, 20);
		favoritas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				for (Component c: getComponents())
					c.setVisible(false);
				lf.setVisible(true);
				lf.verCabecera();
				lf.cargarDatos();
			}
		});
		add(favoritas);
		
		lf.volverB.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				resetear();
			}
		});
		
		buscar = new JButton("Buscar");
		buscar.setBounds(28, 21, 78, 20);
		add(buscar);
				
		altaVivienda = new JButton("Dar de alta vivienda");
		altaVivienda.setBounds(126, 21, 150, 20);
		altaVivienda.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				for (Component jc: getComponents())
					jc.setVisible(false);
				UsuarioGenerico.getFrames()[1].setSize(Utils.wGrande, Utils.hGrande);
				setSize(Utils.wGrande, Utils.hGrande);
				danv.setVisible(true);
			}
		});
		add(altaVivienda);
		
		danv.volver.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				resetear();
			}
		});
		
		danv.registrarVivienda.addActionListener(new ActionListener() {
			String[] extras;
			public void actionPerformed(ActionEvent e) {
				extras = danv.obtenerExtras();
				try {
					Registry r = LocateRegistry.getRegistry(1099);
					IUsuarioRegistrado iu = (IUsuarioRegistrado) r.lookup("Servidor1");
					String visible = "si";
					if(danv.isVisible()){
						visible = "si";
					}
					
					String[] strFotos = null;;
					//obtenemos las fotos
					String aFotos = danv.fotosTA.getText().replaceAll("(?m)^[ \t]*\r?\n", "");
					if(danv.fotosTA != null){
						strFotos = aFotos.split("\\r?\\n");
					}
					
					iu.registrarVivienda(danv.direccion.getText(), danv.municipioTF.getText(), 
							danv.provinciaTF.getText(), danv.cpTF.getText(), strFotos, danv.precioTF.getText(), 
							danv.superficieTF.getText(), danv.numeroHabitacionesTF.getText(), danv.numeroBañosTF.getText(),
							danv.tipoCB.getSelectedItem().toString(), extras, danv.estadoCB.getSelectedItem().toString(),
							danv.acciónCB.getSelectedItem().toString(), danv.mapaUrlTF.getText(), danv.dCortaTF.getText(), danv.dLargaTF.getText(), visible);
				}catch(Exception e1) {
					e1.printStackTrace();
				}
				danv.resetear();
				resetear();
				lvp.cagarDatos();
			}
		});
		
		cerrarSesion = new JButton("Cerrar sesión");
		cerrarSesion.setBounds(286, 21, 117, 20);
		add(cerrarSesion);
		
		viviendasPropiasL = new JLabel("Viviendas propias");
		viviendasPropiasL.setBounds(28, 52, 102, 20);
		add(viviendasPropiasL);
		
		JButton btnNewButton = new JButton("");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				for(Component c: getComponents())
					c.setVisible(false);
				lvp.esconder();
				lvp.setVisible(true);
				lvp.v.setVisible(true);
			}
		});
		btnNewButton.setContentAreaFilled(false);
		btnNewButton.setBounds(10, 69, 363, 143);
		
		lvp.v.volver.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				lvp.mostrar();
				lvp.v.setVisible(false);
				lvp.v.lc.vaciar();
				resetear();
			}
		});
		
		lvp.v.eliminarVivienda.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Registry r = LocateRegistry.getRegistry(1099);
					IUsuarioRegistrado iu = (IUsuarioRegistrado) r.lookup("Servidor3");
					iu.eliminarVivienda(String.valueOf(Utils.id), String.valueOf(Utils.idCasa));
				} catch (Exception e1) {
					e1.printStackTrace();
				}
				lvp.mostrar();
				lvp.v.setVisible(false);
				resetear();
				lvp.cagarDatos();
			}
		});
		
		lvp.v.modificarVivienda.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				for(Component c: lvp.v.getComponents())
					c.setVisible(false);
				UsuarioGenerico.getFrames()[1].setSize(Utils.wGrande, Utils.hGrande);
				setSize(Utils.wGrande, Utils.hGrande);
				lvp.setSize(Utils.wGrande, Utils.hGrande);
				lvp.v.setSize(Utils.wGrande, Utils.hGrande);
				lvp.v.mv.setVisible(true);
			}
		});
		
		lvp.v.mv.volver.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				for(Component c: lvp.v.getComponents())
					c.setVisible(true);
				UsuarioGenerico.getFrames()[1].setSize(Utils.wMedio, Utils.hMedio);
				setSize(Utils.wMedio, Utils.hMedio);
				lvp.setSize(Utils.wMedio, Utils.hMedio);
				lvp.v.setSize(Utils.wMedio, Utils.hMedio);
				lvp.v.mv.setVisible(false);
			}
		});
		
		lvp.v.mv.guardarCambios.addActionListener(new ActionListener() {
			String[] extras;
			public void actionPerformed(ActionEvent e) {
				extras = lvp.v.mv.obtenerExtras();
				try {
					Registry r = LocateRegistry.getRegistry(1099);
					IUsuarioRegistrado iu = (IUsuarioRegistrado) r.lookup("Servidor3");
					
					String visible = "si";
					if(lvp.v.mv.isVisible()){
						visible = "si";
					}
					
					String[] strFotos = null;;
					//obtenemos las fotos
					String aFotos = lvp.v.mv.fotosTA.getText().replaceAll("(?m)^[ \t]*\r?\n", "");
					if(lvp.v.mv.fotosTA != null){
						strFotos = aFotos.split("\\r?\\n");
					}
					
					iu.modificarVivienda(lvp.v.mv.direccion.getText(), 
							lvp.v.mv.municipioTF.getText(), 
							lvp.v.mv.provinciaTF.getText(), 
							lvp.v.mv.cpTF.getText(), 
							strFotos, 
							lvp.v.mv.precioTF.getText(), 
							lvp.v.mv.superficieTF.getText(), 
							lvp.v.mv.numeroHabitacionesTF.getText(), 
							lvp.v.mv.numeroBañosTF.getText(),
							lvp.v.mv.tipoCB.getSelectedItem().toString(), 
							extras, 
							lvp.v.mv.estadoCB.getSelectedItem().toString(),
							lvp.v.mv.acciónCB.getSelectedItem().toString(), 
							lvp.v.mv.mapaUrlTF.getText(), 
							lvp.v.mv.dCortaTF.getText(), 
							lvp.v.mv.dLargaTF.getText(), 
							visible);
				} catch (Exception e1) {
					e1.printStackTrace();
				}
				
				for(Component c: lvp.v.getComponents())
					c.setVisible(true);
				UsuarioGenerico.getFrames()[1].setSize(Utils.wMedio, Utils.hMedio);
				setSize(Utils.wMedio, Utils.hMedio);
				lvp.setSize(Utils.wMedio, Utils.hMedio);
				lvp.v.setSize(Utils.wMedio, Utils.hMedio);
				lvp.v.mv.setVisible(false);
				lvp.cagarDatos();
			}
		});
		
		lvp.v.e.modificarEstado.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				lvp.mostrar();
				lvp.v.setVisible(false);
				resetear();
			}
		});
		
		lvp.v.lc.coBoton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				for(Component c: lvp.v.getComponents())
					c.setVisible(false);
				UsuarioGenerico.getFrames()[1].setSize(Utils.wMedio, Utils.hGrande);
				setSize(Utils.wMedio, Utils.hGrande);
				lvp.setSize(Utils.wMedio, Utils.hGrande);
				lvp.v.setSize(Utils.wMedio, Utils.hGrande);
				lvp.v.lc.setVisible(true);
				lvp.v.lc.esconder();
				lvp.v.lc.setSize(Utils.wMedio, Utils.hGrande);
				lvp.v.lc.co.setVisible(true);
			}
		});
		
		lvp.v.lc.co.volver.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				for(Component c: lvp.v.getComponents())
					c.setVisible(true);
				UsuarioGenerico.getFrames()[1].setSize(Utils.wMedio, Utils.hMedio);
				setSize(Utils.wMedio, Utils.hMedio);
				lvp.setSize(Utils.wMedio, Utils.hMedio);
				lvp.v.setSize(Utils.wMedio, Utils.hMedio);
				lvp.v.mv.setVisible(false);
				lvp.v.lc.mostrar();
				lvp.v.lc.co.setVisible(false);
			}
		});
		
	}
	
	protected void resetear() {
		UsuarioGenerico.getFrames()[1].setSize(Utils.wMedio+15, Utils.hMedio);
		setSize(Utils.wMedio+15, Utils.hMedio);
		for (Component c: getComponents())
			c.setVisible(true);
		mp.setVisible(false);
		danv.setVisible(false);
		lf.setVisible(false);
	}
}