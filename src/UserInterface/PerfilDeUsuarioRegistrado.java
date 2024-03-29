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
				mp.cargarDatosUsuario();
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
				modificarPerfil();
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
			
			public void actionPerformed(ActionEvent e) {
				boolean camposVerificados = true;
				if(danv.direccion.getText().isEmpty()){
					camposVerificados = false;
				}
				if(danv.municipioTF.getText().isEmpty()){
					camposVerificados = false;
				}
				if(danv.provinciaTF.getText().isEmpty()){
					camposVerificados = false;
				}
				if(danv.cpTF.getText().isEmpty() || danv.cpTF.getText().length() != 5 ){
					camposVerificados = false;
				}
				if( danv.precioTF.getText().isEmpty()){
					camposVerificados = false;
				}
				if(danv.superficieTF.getText().isEmpty()){
					camposVerificados = false;
				}
				if(danv.numeroHabitacionesTF.getText().isEmpty()){
					camposVerificados = false;
				}
				if(danv.numeroBa�osTF.getText().isEmpty()){
					camposVerificados = false;
				}
			
				if(camposVerificados){	
					darAltaVivienda();
					danv.resetear();
					resetear();
					lvp.cargarViviendasPropias();
				}else{
					JOptionPane.showMessageDialog(null, "Verifique los campos");
				}
			}
		});
		
		cerrarSesion = new JButton("Cerrar sesi�n");
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
				eliminarVivienda();
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
			public void actionPerformed(ActionEvent e) {
				modificarVivienda();
				for(Component c: lvp.v.getComponents())
					c.setVisible(true);	
				
				UsuarioGenerico.getFrames()[1].setSize(Utils.wMedio, Utils.hMedio);
				setSize(Utils.wMedio, Utils.hMedio);

				lvp.v.setSize(Utils.wMedio, Utils.hMedio);
				lvp.v.mv.setVisible(false);
				//lvp.cagarDatos();
				cargarViviendasPropias();
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
	protected void cargarViviendasPropias(){
		lvp.cargarViviendasPropias();
	}
	public void eliminarVivienda() {
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
		lvp.cargarViviendasPropias();
	}
	
	public void modificarPerfil() {
		Registry r = null;
		IUsuarioRegistrado u = null;
		String pass = String.valueOf(mp.contrase�aTF.getPassword());
		String pass2 = String.valueOf(mp.repContrase�aTF.getPassword());
		
		if (pass.isEmpty() || (!pass.equals(pass2))) {
			JOptionPane.showMessageDialog(new JFrame(), "Las contrase�as no pueden estar vacias y deben coincidir");
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
	
	public void modificarVivienda() {
		String[] extras;
		extras = lvp.v.mv.obtenerExtras();
		try {
			Registry r = LocateRegistry.getRegistry(1099);
			IUsuarioRegistrado iu = (IUsuarioRegistrado) r.lookup("Servidor3");
			/*
			String visible = "no";
			if(lvp.v.mv.isVisible()){
				visible = "si";
			}
			*/
			String[] strFotos = null;;
			//obtenemos las fotos
			String aFotos = lvp.v.mv.fotosTA.getText().replaceAll("(?m)^\\s*$[\n\r]{1,}", "");//("(?m)^[ \t]*\r?\n", "");
			if(lvp.v.mv.fotosTA != null){
				strFotos = aFotos.split("\\r?\\n");
			}
			
			//los valores de los campos modificarVivienda se comparan con
			//su valor original y se manda null o valor
			
			//verificamos los extras
			//se han a�adido mas extras
			boolean contiene= true;
			for(int i = 0 ;i < extras.length; i++){
				//extras[i] = bbdd_gestion.ExtraDAO.getExtraByORMID(Integer.valueOf(extras[i])).getNombreExtra();
				if(!lvp.v.mv.aaExtras.toLowerCase().contains(extras[i].toLowerCase())){
					contiene = false;
				}
			}//se ha quitado extra
			int l =(lvp.v.mv.aaExtras.split(",")).length;
			if( l < extras.length ||  l > extras.length)
				contiene = false;
			
			iu.modificarVivienda(
					String.valueOf(Utils.idCasa),
					lvp.v.mv.direccion.getText().equals(lvp.v.mv.aaDireccion) ? null : lvp.v.mv.direccion.getText(), 
					lvp.v.mv.municipioTF.getText().equals(lvp.v.mv.aaMunicipio) ? null : lvp.v.mv.municipioTF.getText(), 
					lvp.v.mv.provinciaTF.getText().equals(lvp.v.mv.aaProvincia) ? null : lvp.v.mv.provinciaTF.getText(),
					lvp.v.mv.cpTF.getText().equals(lvp.v.mv.aaCp) ? null : lvp.v.mv.cpTF.getText(), 
					aFotos.equals(lvp.v.mv.aaFotos) ? null : strFotos, 
					lvp.v.mv.precioTF.getText().equals(lvp.v.mv.aaPrecio) ? null : lvp.v.mv.precioTF.getText(), 
					lvp.v.mv.superficieTF.getText().equals(lvp.v.mv.aaSuperficie) ? null : lvp.v.mv.superficieTF.getText(), 
					lvp.v.mv.numeroHabitacionesTF.getText().equals(lvp.v.mv.aaNHab) ? null : lvp.v.mv.numeroHabitacionesTF.getText(), 
					lvp.v.mv.numeroBa�osTF.getText().equals(lvp.v.mv.aaNBanios) ? null : lvp.v.mv.numeroBa�osTF.getText(),
					lvp.v.mv.tipoCB.getSelectedItem().toString().equals(lvp.v.mv.aaTipo) ? null : lvp.v.mv.tipoCB.getSelectedItem().toString(), 
					contiene ? null : extras, //FIXME
					lvp.v.mv.estadoCB.getSelectedItem().toString().equals(lvp.v.mv.aaEstado) ? null : lvp.v.mv.estadoCB.getSelectedItem().toString(),
					lvp.v.mv.acci�nCB.getSelectedItem().toString().equals(lvp.v.mv.aaAccion) ? null : lvp.v.mv.acci�nCB.getSelectedItem().toString(), 
					lvp.v.mv.mapaUrlTF.getText().equals(lvp.v.mv.aaMapa) ? null : lvp.v.mv.mapaUrlTF.getText(), 
					lvp.v.mv.dCortaTF.getText().equals(lvp.v.mv.aaDCorta) ? null : lvp.v.mv.dCortaTF.getText(), 
					lvp.v.mv.dLargaTF.getText().equals(lvp.v.mv.aaDLarga) ? null : lvp.v.mv.dLargaTF.getText(), 
				   (lvp.v.mv.visibleCB.isSelected() ? "si" : "no").equals(lvp.v.mv.aaVisible) ? null : lvp.v.mv.visibleCB.isSelected() ? "si" : "no" 
					   );
		} catch (Exception e1) {
			e1.printStackTrace();
		}
	}
	
	public void darAltaVivienda() {
		try {
			String[] extras = danv.obtenerExtras();
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
					danv.superficieTF.getText(), danv.numeroHabitacionesTF.getText(), danv.numeroBa�osTF.getText(),
					danv.tipoCB.getSelectedItem().toString(), extras, danv.estadoCB.getSelectedItem().toString(),
					danv.acci�nCB.getSelectedItem().toString(), danv.mapaUrlTF.getText(), danv.dCortaTF.getText(), danv.dLargaTF.getText(), visible);
		}catch(Exception e1) {
			e1.printStackTrace();
		}
	}
	
	protected void resetear() {
		UsuarioGenerico.getFrames()[1].setSize(Utils.wMedio+15, Utils.hMedio);
		setSize(Utils.wMedio+15, Utils.hMedio);
		for (Component c: getComponents())
			c.setVisible(true);
		lvp.panel.setVisible(true);
		mp.setVisible(false);
		danv.setVisible(false);
		lf.setVisible(false);
	}
}