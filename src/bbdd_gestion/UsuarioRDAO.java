/**
 * "Visual Paradigm: DO NOT MODIFY THIS FILE!"
 * 
 * This is an automatic generated file. It will be regenerated every time 
 * you generate persistence class.
 * 
 * Modifying its content may cause the program not work, or your work may lost.
 */

/**
 * Licensee: University of Almeria
 * License Type: Academic
 */
package bbdd_gestion;

import org.orm.*;
import org.hibernate.Query;
import org.hibernate.LockMode;
import java.util.List;

public class UsuarioRDAO {
	public static UsuarioR loadUsuarioRByORMID(int id_Usuario) throws PersistentException {
		try {
			PersistentSession session = bbdd_gestion.ProjectMDS2PersistentManager.instance().getSession();
			return loadUsuarioRByORMID(session, id_Usuario);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static UsuarioR getUsuarioRByORMID(int id_Usuario) throws PersistentException {
		try {
			PersistentSession session = bbdd_gestion.ProjectMDS2PersistentManager.instance().getSession();
			return getUsuarioRByORMID(session, id_Usuario);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static UsuarioR loadUsuarioRByORMID(int id_Usuario, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = bbdd_gestion.ProjectMDS2PersistentManager.instance().getSession();
			return loadUsuarioRByORMID(session, id_Usuario, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static UsuarioR getUsuarioRByORMID(int id_Usuario, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = bbdd_gestion.ProjectMDS2PersistentManager.instance().getSession();
			return getUsuarioRByORMID(session, id_Usuario, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static UsuarioR loadUsuarioRByORMID(PersistentSession session, int id_Usuario) throws PersistentException {
		try {
			return (UsuarioR) session.load(bbdd_gestion.UsuarioR.class, new Integer(id_Usuario));
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static UsuarioR getUsuarioRByORMID(PersistentSession session, int id_Usuario) throws PersistentException {
		try {
			return (UsuarioR) session.get(bbdd_gestion.UsuarioR.class, new Integer(id_Usuario));
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static UsuarioR loadUsuarioRByORMID(PersistentSession session, int id_Usuario, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			return (UsuarioR) session.load(bbdd_gestion.UsuarioR.class, new Integer(id_Usuario), lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static UsuarioR getUsuarioRByORMID(PersistentSession session, int id_Usuario, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			return (UsuarioR) session.get(bbdd_gestion.UsuarioR.class, new Integer(id_Usuario), lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static List queryUsuarioR(String condition, String orderBy) throws PersistentException {
		try {
			PersistentSession session = bbdd_gestion.ProjectMDS2PersistentManager.instance().getSession();
			return queryUsuarioR(session, condition, orderBy);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static List queryUsuarioR(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = bbdd_gestion.ProjectMDS2PersistentManager.instance().getSession();
			return queryUsuarioR(session, condition, orderBy, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static UsuarioR[] listUsuarioRByQuery(String condition, String orderBy) throws PersistentException {
		try {
			PersistentSession session = bbdd_gestion.ProjectMDS2PersistentManager.instance().getSession();
			return listUsuarioRByQuery(session, condition, orderBy);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static UsuarioR[] listUsuarioRByQuery(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = bbdd_gestion.ProjectMDS2PersistentManager.instance().getSession();
			return listUsuarioRByQuery(session, condition, orderBy, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static List queryUsuarioR(PersistentSession session, String condition, String orderBy) throws PersistentException {
		StringBuffer sb = new StringBuffer("From bbdd_gestion.UsuarioR as UsuarioR");
		if (condition != null)
			sb.append(" Where ").append(condition);
		if (orderBy != null)
			sb.append(" Order By ").append(orderBy);
		try {
			Query query = session.createQuery(sb.toString());
			return query.list();
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static List queryUsuarioR(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		StringBuffer sb = new StringBuffer("From bbdd_gestion.UsuarioR as UsuarioR");
		if (condition != null)
			sb.append(" Where ").append(condition);
		if (orderBy != null)
			sb.append(" Order By ").append(orderBy);
		try {
			Query query = session.createQuery(sb.toString());
			query.setLockMode("UsuarioR", lockMode);
			return query.list();
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static UsuarioR[] listUsuarioRByQuery(PersistentSession session, String condition, String orderBy) throws PersistentException {
		try {
			List list = queryUsuarioR(session, condition, orderBy);
			return (UsuarioR[]) list.toArray(new UsuarioR[list.size()]);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static UsuarioR[] listUsuarioRByQuery(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			List list = queryUsuarioR(session, condition, orderBy, lockMode);
			return (UsuarioR[]) list.toArray(new UsuarioR[list.size()]);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static UsuarioR loadUsuarioRByQuery(String condition, String orderBy) throws PersistentException {
		try {
			PersistentSession session = bbdd_gestion.ProjectMDS2PersistentManager.instance().getSession();
			return loadUsuarioRByQuery(session, condition, orderBy);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static UsuarioR loadUsuarioRByQuery(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = bbdd_gestion.ProjectMDS2PersistentManager.instance().getSession();
			return loadUsuarioRByQuery(session, condition, orderBy, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static UsuarioR loadUsuarioRByQuery(PersistentSession session, String condition, String orderBy) throws PersistentException {
		UsuarioR[] usuarioRs = listUsuarioRByQuery(session, condition, orderBy);
		if (usuarioRs != null && usuarioRs.length > 0)
			return usuarioRs[0];
		else
			return null;
	}
	
	public static UsuarioR loadUsuarioRByQuery(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		UsuarioR[] usuarioRs = listUsuarioRByQuery(session, condition, orderBy, lockMode);
		if (usuarioRs != null && usuarioRs.length > 0)
			return usuarioRs[0];
		else
			return null;
	}
	
	public static java.util.Iterator iterateUsuarioRByQuery(String condition, String orderBy) throws PersistentException {
		try {
			PersistentSession session = bbdd_gestion.ProjectMDS2PersistentManager.instance().getSession();
			return iterateUsuarioRByQuery(session, condition, orderBy);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static java.util.Iterator iterateUsuarioRByQuery(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = bbdd_gestion.ProjectMDS2PersistentManager.instance().getSession();
			return iterateUsuarioRByQuery(session, condition, orderBy, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static java.util.Iterator iterateUsuarioRByQuery(PersistentSession session, String condition, String orderBy) throws PersistentException {
		StringBuffer sb = new StringBuffer("From bbdd_gestion.UsuarioR as UsuarioR");
		if (condition != null)
			sb.append(" Where ").append(condition);
		if (orderBy != null)
			sb.append(" Order By ").append(orderBy);
		try {
			Query query = session.createQuery(sb.toString());
			return query.iterate();
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static java.util.Iterator iterateUsuarioRByQuery(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		StringBuffer sb = new StringBuffer("From bbdd_gestion.UsuarioR as UsuarioR");
		if (condition != null)
			sb.append(" Where ").append(condition);
		if (orderBy != null)
			sb.append(" Order By ").append(orderBy);
		try {
			Query query = session.createQuery(sb.toString());
			query.setLockMode("UsuarioR", lockMode);
			return query.iterate();
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static UsuarioR createUsuarioR() {
		return new bbdd_gestion.UsuarioR();
	}
	
	public static boolean save(bbdd_gestion.UsuarioR usuarioR) throws PersistentException {
		try {
			bbdd_gestion.ProjectMDS2PersistentManager.instance().saveObject(usuarioR);
			return true;
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static boolean delete(bbdd_gestion.UsuarioR usuarioR) throws PersistentException {
		try {
			bbdd_gestion.ProjectMDS2PersistentManager.instance().deleteObject(usuarioR);
			return true;
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static boolean deleteAndDissociate(bbdd_gestion.UsuarioR usuarioR)throws PersistentException {
		try {
			if (usuarioR.getEs_Alquilada() != null) {
				usuarioR.getEs_Alquilada().setAlquila(null);
			}
			
			bbdd_gestion.Casa[] lEs_Favoritas = usuarioR.es_Favorita.toArray();
			for(int i = 0; i < lEs_Favoritas.length; i++) {
				lEs_Favoritas[i].favorita.remove(usuarioR);
			}
			bbdd_gestion.Casa[] lEs_Vendidas = usuarioR.es_Vendida.toArray();
			for(int i = 0; i < lEs_Vendidas.length; i++) {
				lEs_Vendidas[i].setVende(null);
			}
			bbdd_gestion.Correo[] lEntradas = usuarioR.entrada.toArray();
			for(int i = 0; i < lEntradas.length; i++) {
				lEntradas[i].setRecibe(null);
			}
			bbdd_gestion.Correo[] lSalidas = usuarioR.salida.toArray();
			for(int i = 0; i < lSalidas.length; i++) {
				lSalidas[i].setEnvia(null);
			}
			return delete(usuarioR);
		}
		catch(Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static boolean deleteAndDissociate(bbdd_gestion.UsuarioR usuarioR, org.orm.PersistentSession session)throws PersistentException {
		try {
			if (usuarioR.getEs_Alquilada() != null) {
				usuarioR.getEs_Alquilada().setAlquila(null);
			}
			
			bbdd_gestion.Casa[] lEs_Favoritas = usuarioR.es_Favorita.toArray();
			for(int i = 0; i < lEs_Favoritas.length; i++) {
				lEs_Favoritas[i].favorita.remove(usuarioR);
			}
			bbdd_gestion.Casa[] lEs_Vendidas = usuarioR.es_Vendida.toArray();
			for(int i = 0; i < lEs_Vendidas.length; i++) {
				lEs_Vendidas[i].setVende(null);
			}
			bbdd_gestion.Correo[] lEntradas = usuarioR.entrada.toArray();
			for(int i = 0; i < lEntradas.length; i++) {
				lEntradas[i].setRecibe(null);
			}
			bbdd_gestion.Correo[] lSalidas = usuarioR.salida.toArray();
			for(int i = 0; i < lSalidas.length; i++) {
				lSalidas[i].setEnvia(null);
			}
			try {
				session.delete(usuarioR);
				return true;
			} catch (Exception e) {
				return false;
			}
		}
		catch(Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static boolean refresh(bbdd_gestion.UsuarioR usuarioR) throws PersistentException {
		try {
			bbdd_gestion.ProjectMDS2PersistentManager.instance().getSession().refresh(usuarioR);
			return true;
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static boolean evict(bbdd_gestion.UsuarioR usuarioR) throws PersistentException {
		try {
			bbdd_gestion.ProjectMDS2PersistentManager.instance().getSession().evict(usuarioR);
			return true;
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static UsuarioR loadUsuarioRByCriteria(UsuarioRCriteria usuarioRCriteria) {
		UsuarioR[] usuarioRs = listUsuarioRByCriteria(usuarioRCriteria);
		if(usuarioRs == null || usuarioRs.length == 0) {
			return null;
		}
		return usuarioRs[0];
	}
	
	public static UsuarioR[] listUsuarioRByCriteria(UsuarioRCriteria usuarioRCriteria) {
		return usuarioRCriteria.listUsuarioR();
	}
}
