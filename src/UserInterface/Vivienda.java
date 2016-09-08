package UserInterface;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

import javax.swing.AbstractListModel;
import javax.swing.JButton;
import javax.swing.JPanel;

import bbdd.IUsuarioRegistrado;
import bbdd_gestion.Casa;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Vivienda extends JPanel {

	protected JButton volver;
	protected JButton modificarVivienda;
	protected JButton eliminarVivienda;
	private EliminarVivienda ev = new EliminarVivienda();
	protected ModificarVivienda mv = new ModificarVivienda();
	protected Estado e = new Estado();
	protected ListaCorreos lc = new ListaCorreos();
	private ListaUsuariosInteresados lui = new ListaUsuariosInteresados();
	
	public Vivienda() {
		setLayout(null);
		setSize(Utils.wMedio + 20, Utils.hMedio);
		
		volver = new JButton("Volver");
		volver.setBounds(23, 332, 72, 29);
		add(volver);
		
		eliminarVivienda = new JButton("Eliminar vivienda");
		eliminarVivienda.setBounds(270, 332, 142, 29);
		add(eliminarVivienda);
		
		modificarVivienda = new JButton("Modificar vivienda");
		modificarVivienda.setBounds(110, 332, 143, 29);
		add(modificarVivienda);
		
		add(e);
		
		add(lc);
		
		add(lui);
		
		add(mv).setVisible(false);
		
	}
	
	protected void cargarDatos() {
		try {
			Registry r = LocateRegistry.getRegistry(1099);
			IUsuarioRegistrado iu = (IUsuarioRegistrado) r.lookup("Servidor3");
			//FIXME casa estaba comentada
			Casa casa = iu.cargarDatosVivienda(String.valueOf(Utils.idCasa));
			//estado es el estado de la visibilidad
			e.estadoCB.setSelectedIndex(casa.getVisible().equals("si")?0:1);
			lui.usuariosL.setModel(new AbstractListModel<String>() {
				String[] values = iu.cargarUsuariosInteresados(String.valueOf(Utils.id), String.valueOf(Utils.idCasa));
				public int getSize() {
					if (values != null)
						return values.length;
					else
						return 0;
				}
				
				public String getElementAt(int index) {
					return values[index];
				}
			});
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}