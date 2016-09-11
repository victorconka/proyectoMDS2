package UserInterface;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;

import javax.swing.AbstractListModel;
import javax.swing.JButton;
import javax.swing.JPanel;

import org.orm.PersistentTransaction;

import bbdd.IUsuarioRegistrado;
import bbdd_gestion.Casa;
import bbdd_gestion.CasaDAO;
import bbdd_gestion.Extra;
import bbdd_gestion.ProjectMDS2PersistentManager;

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
		
		e.modificarEstado.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				modificarEstadoVivienda();
			}
		});
		
		add(e);
		
		add(lc);
		
		add(lui);
		
		add(mv).setVisible(false);
		
	}
	
	private void modificarEstadoVivienda(){
		try {
			Registry r = LocateRegistry.getRegistry(1099);
			IUsuarioRegistrado iu = (IUsuarioRegistrado) r.lookup("Servidor3");
			String est =  (e.estadoCB.getSelectedItem().toString().equals("Disponible"))?"si":"no";
			iu.modificarEstadoVivienda(String.valueOf(Utils.id), String.valueOf(Utils.idCasa), est);
			
			volver.doClick();
		} catch (Exception e1) {
			e1.printStackTrace();
		}
	}
	
	protected void cargarDatosVivienda() {
		PersistentTransaction t = null;
		try {
			t = ProjectMDS2PersistentManager.instance().getSession().beginTransaction();
			Registry r = LocateRegistry.getRegistry(1099);
			IUsuarioRegistrado iu = (IUsuarioRegistrado) r.lookup("Servidor3");
			
			//este metodo genera problemas debido a que al transmitir
			//el objeto se pierde la sesion.
			//Casa casa = iu.cargarDatosVivienda(String.valueOf(Utils.idCasa));			
			
			Casa casa = CasaDAO.getCasaByORMID(Utils.idCasa);
			//estado es el estado de la visibilidad
			e.estadoCB.setSelectedIndex(casa.getVisible().equals("si")?0:1);
			mv.aaVisible = casa.getVisible();
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
			//cargamos los datos en la pantalla de modificar vivienda
			mv.direccion.setText(casa.getDireccion());
			mv.aaDireccion = casa.getDireccion();
			mv.municipioTF.setText(casa.getMunicipio().getMunicipio());
			mv.aaMunicipio = casa.getMunicipio().getMunicipio();
			mv.provinciaTF.setText(casa.getProvincia().getProvincia());
			mv.aaProvincia = casa.getProvincia().getProvincia();
			mv.cpTF.setText(casa.getCodigoPostal().getCodigo_postal());
			mv.aaCp = casa.getCodigoPostal().getCodigo_postal();
			
			//fotos se han de insertar con un bucle
			Iterator<bbdd_gestion.Foto> it = casa.fotos.getIterator();
			bbdd_gestion.Foto foto;
			String link;
			String ftsTA = "";		
			while(it.hasNext()){
				foto = it.next();
				link = foto.getLinkFoto();
				if(!link.equals(null) || !link.equals("") || !link.equals(" ")){
					ftsTA += link + "\n";
				}
			}
			
			mv.fotosTA.setText(ftsTA);
			mv.aaFotos = ftsTA;
			mv.precioTF.setText(String.valueOf(casa.getPrecio()));
			mv.aaPrecio = String.valueOf(casa.getPrecio());
			mv.superficieTF.setText(String.valueOf(casa.getSuperficie()));
			mv.aaSuperficie = String.valueOf(casa.getSuperficie());
			mv.numeroHabitacionesTF.setText(String.valueOf(casa.getHabitaciones()));
			mv.aaNHab = String.valueOf(casa.getHabitaciones());
			mv.numeroBañosTF.setText(String.valueOf(casa.getBanios()));
			mv.aaNBanios = String.valueOf(casa.getBanios());
			
			//tipo
			String tipo = casa.getTipo();
			if(casa.getTipo().equals("Apartamento")){
				mv.tipoCB.setSelectedIndex(0);
			}else if(casa.getTipo().equals("Piso")){
				mv.tipoCB.setSelectedIndex(1);
			}else{
				System.out.println("estoy entrando en else");
				mv.tipoCB.setSelectedIndex(2);
			}
			mv.aaTipo = casa.getTipo();
			
			//extras
			//mv.aaExtras = Arrays.toString(casa.extra.toArray());
			Iterator<bbdd_gestion.Extra> it3 = casa.extra.getIterator();
			String[] exts = new String[casa.extra.size()];
			int i = 0;
			while(it3.hasNext()){
				exts[i] = it3.next().getNombreExtra();
				i++;
			}
			mv.aaExtras = Arrays.toString(exts);
			
			ArrayList<String> al = new ArrayList<String>();
			Iterator<Extra> ite = casa.extra.getIterator();
			Extra e = bbdd_gestion.ExtraDAO.createExtra();
			while(ite.hasNext()){
				e = ite.next();
				al.add(e.getNombreExtra());
			}
			if(al.contains("Ascensor")){mv.ascensorChB.setSelected(true);}
			if(al.contains("Terraza")){mv.terrazaCB.setSelected(true);}
			if(al.contains("Trastero")){mv.trasteroCB.setSelected(true);}
			if(al.contains("Parking")){mv.parkingChB.setSelected(true);}
			if(al.contains("Piscina")){mv.piscinaChB.setSelected(true);}
			if(al.contains("Jardin")){mv.jardinCB.setSelected(true);}
			if(al.contains("Amueblada")){mv.amuebladaCB.setSelected(true);}
			if(al.contains("Calefaccion")){mv.calefaccionCB.setSelected(true);}
			
			String estado = casa.getEstado();
			if(!estado.equals("Segunda mano")){
				mv.estadoCB.setSelectedIndex(1);
			}
			mv.aaEstado = casa.getEstado();

			if(casa.getAccion().equals("Alquilar")){
				mv.acciónCB.setSelectedIndex(1);
			}else{
				mv.acciónCB.setSelectedIndex(0);
			}
			mv.aaAccion = casa.getAccion();
			
			mv.mapaUrlTF.setText(casa.getMapa().getUrl());
			mv.aaMapa = casa.getMapa().getUrl();
			mv.dCortaTF.setText(casa.getdCorta());
			mv.aaDCorta = casa.getdCorta();
			mv.dLargaTF.setText(casa.getdLarga());
			mv.aaDLarga =casa.getdLarga();
			mv.visibleCB.setSelected(casa.getVisible().equals("si")?true : false);
			mv.aaVisible = casa.getVisible();
			//t.commit();
			ProjectMDS2PersistentManager.instance().disposePersistentManager();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}