package bbdd;

import bbdd_gestion.UsuarioR;
import bbdd_gestion.UsuarioRCriteria;
import bbdd_gestion.UsuarioRDAO;
import bbdd_gestion.Casa;
import bbdd_gestion.CasaCriteria;
import bbdd_gestion.CasaDAO;
import bbdd_gestion.ProjectMDS2PersistentManager;
import bbdd_gestion.Usuario;
import bbdd_gestion.UsuarioDAO;

import java.util.Iterator;
import org.orm.PersistentException;
import org.orm.PersistentTransaction;

import UserInterface.Utils;

public class Usuarios {
	public BDPrincipal _bd_prin_usuarios;
	public UsuarioR[] _conts_usuarioR = new UsuarioR[0];

	public boolean Registrarse(String aNombre, String aApellidos, String aDireccion, String aMunicipio, String aProvincia, String aCp, String aEmail, String aContrasenia) throws PersistentException{
		UsuarioR u = null;
		PersistentTransaction t = null;
		try {	
			t = bbdd_gestion.ProjectMDS2PersistentManager.instance().getSession().beginTransaction();
			//codigo aqui
			//comprobamos unicidad email
			if (UsuarioDAO.loadUsuarioByQuery("correo = '"+aEmail+"'", null) != null)
				return false;
			//primero se crea el objeto			
			u = bbdd_gestion.UsuarioRDAO.createUsuarioR();
			//ahora las propiedades se asignan
			u.setNombre(aNombre);
			u.setApellidos(aApellidos);
			u.setCorreo(aEmail);
			u.setContrasenia(aContrasenia);
			u.setCodigoPostal(aCp); //cp ha de ser un STRING
			
			String direccion = aDireccion + "; " + aMunicipio + "; " + aProvincia;
			u.setDireccion(direccion);			
			//aplicar cambios y realizar commit
			bbdd_gestion.UsuarioRDAO.save(u);
			t.commit();
			ProjectMDS2PersistentManager.instance().disposePersistentManager();
			return true;
		}
		catch (Exception e) {
			t.rollback();
		}
		ProjectMDS2PersistentManager.instance().disposePersistentManager();
		return false;
	}

	public boolean eliminarPerfil(String aIdUsuario)  throws PersistentException{
		throw new UnsupportedOperationException();
	}

	// El String que se le pasa por parametro sera un email cunado lo llame
	// el administrador y un numero cuando lo llame el usuario (su propio id)
	public boolean eliminarUsuario(String aEmail)  throws PersistentException{
		PersistentTransaction t = bbdd_gestion.ProjectMDS2PersistentManager.instance().getSession().beginTransaction();
		int ID = 0;
		UsuarioR u;
		
		//eliminar casas que vende
		try {	
			if (aEmail.contains("@"))				
				u = UsuarioRDAO.loadUsuarioRByQuery("correo = '"+aEmail+"'", null);
			else {
				ID = Integer.parseInt(aEmail);
				u = UsuarioRDAO.loadUsuarioRByORMID(ID);
			}
			
			//eliminar casas que alquila
			bbdd_gestion.Casa casa = u.getEs_Alquilada();
			if (casa != null)
				bbdd_gestion.CasaDAO.delete(casa);
			
			//eliminar casas que vende			
			Iterator<Casa> it = u.es_Vendida.getIterator();
			while (it.hasNext()){
				casa = it.next();
				bbdd_gestion.CasaDAO.delete(casa);
			}
			
			//eliminar correos de entrada
			bbdd_gestion.Correo correo;
			Iterator<bbdd_gestion.Correo> it2 = u.entrada.getIterator();
			while(it2.hasNext()){
				correo = it2.next();
				bbdd_gestion.CorreoDAO.delete(correo);
			}
			
			//eliminar correos de salida
			it2 = u.salida.getIterator();
			while(it2.hasNext()){
				correo = it2.next();
				bbdd_gestion.CorreoDAO.delete(correo);
			}		
			//eliminar usuario
			
			bbdd_gestion.UsuarioRDAO.delete(u);
			t.commit();
			ProjectMDS2PersistentManager.instance().disposePersistentManager();
			return true;
		}
		catch (Exception e) {
			t.rollback();
			
		}
		ProjectMDS2PersistentManager.instance().disposePersistentManager();
		return false;
	}
	
	public Usuario acceder(String aEmail, String aContrasenia)  throws PersistentException{
		Usuario u = null;
		try{
			String consulta = "correo = '"+aEmail+"' and contrasenia = '"+aContrasenia+"'";
			u = UsuarioDAO.loadUsuarioByQuery(consulta, "nombre");		
			if (u != null){
				Utils.id = u.getORMID();
			}
		}
		catch (Exception e) {		
		}
			return u;
			
		}


	public Casa[] obtenerFavoritas(UsuarioR aU)  throws PersistentException{
		try{
			aU = UsuarioRDAO.loadUsuarioRByORMID(Utils.id);
			System.out.println("id = "+Utils.id);
			System.out.println(aU.es_Favorita.toArray().length);
			if(aU!=null){
				return aU.es_Favorita.toArray();
			}
		}catch (Exception e) {		
			e.printStackTrace();
		}
		return null;
	}
	
//se ha modificado este metodo en su llamada (PerfilDeUsuarioRegistrado -> linea 75)
	//se agrego el id del usuario que se esta modificando los datos. 
	//sin esto no sabemos a quien se lo modificamos
	public boolean guardarDatos(UsuarioR aUsuario, String ORMidUsuario)  throws PersistentException{
		PersistentTransaction t = null;
		try {
			t = bbdd_gestion.ProjectMDS2PersistentManager.instance().getSession().beginTransaction();
			//---------------------a cambiar durante la proxima integración con visual paradigm
			//primero hay que recuperar al usuario
			UsuarioRCriteria c = new UsuarioRCriteria();
			c.id_Usuario.eq(Integer.valueOf(ORMidUsuario));
			UsuarioR u = bbdd_gestion.UsuarioRDAO.createUsuarioR();
			u = UsuarioRDAO.loadUsuarioRByCriteria(c);
			
			//aplicamos cambios
			u.setApellidos(aUsuario.getApellidos());
			u.setCodigoPostal(aUsuario.getCodigoPostal());
			u.setContrasenia(aUsuario.getContrasenia());
			u.setDireccion(aUsuario.getDireccion());
			u.setNombre(aUsuario.getNombre());
			u.setCorreo(aUsuario.getCorreo());
			
			
			boolean b = bbdd_gestion.UsuarioRDAO.save(u);
			t.commit();
			ProjectMDS2PersistentManager.instance().disposePersistentManager();
			return b;
		}
		catch (Exception e) {
			t.rollback();
		}
		ProjectMDS2PersistentManager.instance().disposePersistentManager();
		return false;
	}
//implementado, pero sin testear.
	public String[] cargarUsuariosInteresados(String aId_usuario, String aId_vivienda)  throws PersistentException{
		String dev[] = null;
		try{
			CasaCriteria c = new CasaCriteria();
			c.id_casa.eq(Integer.valueOf(aId_vivienda));
			Casa casa = CasaDAO.loadCasaByCriteria(c);
			UsuarioR[] interesados = casa.favorita.toArray();
			dev = new String[interesados.length];
			int i = 0;
			for(UsuarioR u : interesados){
				dev[i] = u.getNombre();
				i++;
			}
		}catch (Exception e) {
		}
		return dev;
	}

	public UsuarioR cargarDatosUsuario(String aId_usuario)  throws PersistentException{
		return UsuarioRDAO.getUsuarioRByORMID(Integer.parseInt(aId_usuario));
	}
}