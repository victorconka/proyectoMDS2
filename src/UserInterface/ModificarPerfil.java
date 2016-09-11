package UserInterface;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import bbdd_gestion.UsuarioR;
import bbdd_gestion.UsuarioRDAO;

public class ModificarPerfil extends DatosUsuario {

	protected JButton volver;
	protected JButton guardarCambios;
	protected JButton eliminarPerfil;
	
	public ModificarPerfil() {
		setSize(Utils.wGrande, Utils.hGrande);
		setLayout(null);
		
		nombrePanel.setText("Modificar Perfil");
		
		volver = new JButton("Volver");
		volver.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		volver.setBounds(53, 469, 79, 23);
		add(volver);
		
		guardarCambios = new JButton("Guardar cambios");
		guardarCambios.setBounds(156, 469, 135, 23);
		add(guardarCambios);
		
		eliminarPerfil = new JButton("Eliminar perfil");
		eliminarPerfil.setBounds(316, 469, 115, 23);
		add(eliminarPerfil);
		
	}

	public void cargarDatosUsuario() {
		UsuarioR u = null;
		String[] dir;
		try {
			u = UsuarioRDAO.getUsuarioRByORMID(Utils.id);
			
			nombreTF.setText(u.getNombre());
			apellidosTF.setText(u.getApellidos());
			dir = u.getDireccion().split("; ");
			direccion.setText(dir[0]);
			municipioTF.setText(dir[1]);
			provinciaTF.setText(dir[2]);
			cpTF.setText(u.getCodigoPostal()); 
			emailTF.setText(u.getCorreo());
			
		} catch (Exception e1) {
			e1.printStackTrace();
		}
	}
	
	public void resetear() {
		nombreTF.setText("");
		apellidosTF.setText("");
		direccion.setText("");
		municipioTF.setText("");
		provinciaTF.setText("");
		cpTF.setText(""); 
		emailTF.setText("");
		contraseñaTF.setText("");
		repContraseñaTF.setText("");
	}
}