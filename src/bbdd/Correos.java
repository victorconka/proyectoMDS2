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

	public boolean enviar(String aId_usuario_origen, String aDestinatario, String aAsunto, String aContenido) throws PersistentException {
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
		return false;
	}

	//metodo no especifica si son correos de entrada o de salida
	//se ha de devolver una coleccion de correos y no de string
	public Correo[] cargarListadoCorreos(String aId_vivienda, String aId_usuario)  throws PersistentException {
		try {
			/*
			 //cargar casa
			Casa casa = CasaDAO.createCasa();
			CasaCriteria c1 = new CasaCriteria();
			c1.id_casa.eq(Integer.valueOf(aId_vivienda));
			casa = CasaDAO.loadCasaByCriteria(c1);
			*/
			/*
			 //cargar usuario
			Usuario usuario = UsuarioRDAO.createUsuarioR();
			UsuarioRCriteria c2 = new UsuarioRCriteria();
			c2.id_Usuario.eq(Integer.valueOf(aId_usuario));
			usuario = UsuarioRDAO.loadUsuarioRByCriteria(c2);
			*/
			
			//criterio correos : casa
			Correo[] correos;
			CorreoCriteria c3 = new CorreoCriteria();
			c3.es_CausaMensajeId.eq(Integer.valueOf(aId_vivienda));
			c3.enviaId.eq(Integer.valueOf(aId_usuario));
			c3.recibeId.eq(Integer.valueOf(aId_usuario));
			correos = CorreoDAO.listCorreoByCriteria(c3);
			
			return correos;
					
		} catch (Exception e) {
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