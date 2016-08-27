package bbdd;

import org.orm.PersistentException;
import org.orm.PersistentTransaction;

import bbdd_gestion.Casa;
import bbdd_gestion.CasaCriteria;
import bbdd_gestion.CasaDAO;
import bbdd_gestion.Correo;
import bbdd_gestion.CorreoCriteria;
import bbdd_gestion.CorreoDAO;
import bbdd_gestion.ProjectMDS2PersistentManager;
import bbdd_gestion.Usuario;
import bbdd_gestion.UsuarioDAO;
import bbdd_gestion.UsuarioR;
import bbdd_gestion.UsuarioRCriteria;
import bbdd_gestion.UsuarioRDAO;

public class Correos {
	public BDPrincipal _bd_prin_correos;
	public Correo[] _conts_correo = new Correo[0];

	public boolean enviar(String aId_usuario_origen, String aId_casa, String aDestinatario, String aAsunto, String aContenido) throws PersistentException {
		Usuario u1, u2 = null;
		Correo c = null;
		PersistentTransaction t = ProjectMDS2PersistentManager.instance().getSession().beginTransaction();
		try {
			
			c = CorreoDAO.createCorreo();
			c.setDestinatario(aDestinatario);
			c.setAsunto(aAsunto);
			c.setTexto(aContenido);
			
			u1 = UsuarioDAO.getUsuarioByORMID(Integer.parseInt(aId_usuario_origen));
			u2 = UsuarioDAO.loadUsuarioByQuery("correo = '"+aDestinatario+"'", null);
			
			c.setFuente(u1.getCorreo());
			c.setEnvia(u1);
			c.setRecibe(u2);
			
			Casa ca = null;
			if (Integer.parseInt(aId_casa) != -1) {
				ca = CasaDAO.getCasaByORMID(Integer.parseInt(aId_casa));
				c.setEs_CausaMensaje(ca);
			}
			
			CorreoDAO.save(c);
			
			u1.salida.add(c);
			UsuarioDAO.save(u1);
			u2.entrada.add(c);
			UsuarioDAO.save(u2);
			t.commit();
			ProjectMDS2PersistentManager.instance().disposePersistentManager();
			return true;
		} catch (Exception e) {
			t.rollback();
		}
		ProjectMDS2PersistentManager.instance().disposePersistentManager();
		return false;
	}

	//metodo no especifica si son correos de entrada o de salida
	//se ha de devolver una coleccion de correos y no de string
	public Correo[] cargarListadoCorreos(String aId_vivienda, String aId_usuario)  throws PersistentException {
		try {			
			//criterio correos : casa
			Correo[] c = CorreoDAO.listCorreoByQuery("casainmuebleid_inmueble = '"+aId_vivienda+"'", null);			
			return c;
					
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	//usuario es redundante parece ser ...
	public Correo cargarContenidoCorreo(String aId_usuario, String aId_correo)  throws PersistentException {
		try{
			Correo correo = CorreoDAO.createCorreo();
			CorreoCriteria c = new CorreoCriteria ();
			c.id_Correo.eq(Integer.valueOf(aId_correo));
			correo = CorreoDAO.loadCorreoByCriteria(c);
			return correo;
		} catch (Exception e) {
		}
		return null;
	}
}