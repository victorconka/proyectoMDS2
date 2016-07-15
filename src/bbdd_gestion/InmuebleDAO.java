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

public class InmuebleDAO {
	public static Inmueble loadInmuebleByORMID(int id_Inmueble) throws PersistentException {
		try {
			PersistentSession session = bbdd_gestion.ProjectMDS2PersistentManager.instance().getSession();
			return loadInmuebleByORMID(session, id_Inmueble);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Inmueble getInmuebleByORMID(int id_Inmueble) throws PersistentException {
		try {
			PersistentSession session = bbdd_gestion.ProjectMDS2PersistentManager.instance().getSession();
			return getInmuebleByORMID(session, id_Inmueble);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Inmueble loadInmuebleByORMID(int id_Inmueble, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = bbdd_gestion.ProjectMDS2PersistentManager.instance().getSession();
			return loadInmuebleByORMID(session, id_Inmueble, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Inmueble getInmuebleByORMID(int id_Inmueble, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = bbdd_gestion.ProjectMDS2PersistentManager.instance().getSession();
			return getInmuebleByORMID(session, id_Inmueble, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Inmueble loadInmuebleByORMID(PersistentSession session, int id_Inmueble) throws PersistentException {
		try {
			return (Inmueble) session.load(bbdd_gestion.Inmueble.class, new Integer(id_Inmueble));
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Inmueble getInmuebleByORMID(PersistentSession session, int id_Inmueble) throws PersistentException {
		try {
			return (Inmueble) session.get(bbdd_gestion.Inmueble.class, new Integer(id_Inmueble));
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Inmueble loadInmuebleByORMID(PersistentSession session, int id_Inmueble, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			return (Inmueble) session.load(bbdd_gestion.Inmueble.class, new Integer(id_Inmueble), lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Inmueble getInmuebleByORMID(PersistentSession session, int id_Inmueble, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			return (Inmueble) session.get(bbdd_gestion.Inmueble.class, new Integer(id_Inmueble), lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static List queryInmueble(String condition, String orderBy) throws PersistentException {
		try {
			PersistentSession session = bbdd_gestion.ProjectMDS2PersistentManager.instance().getSession();
			return queryInmueble(session, condition, orderBy);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static List queryInmueble(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = bbdd_gestion.ProjectMDS2PersistentManager.instance().getSession();
			return queryInmueble(session, condition, orderBy, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Inmueble[] listInmuebleByQuery(String condition, String orderBy) throws PersistentException {
		try {
			PersistentSession session = bbdd_gestion.ProjectMDS2PersistentManager.instance().getSession();
			return listInmuebleByQuery(session, condition, orderBy);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Inmueble[] listInmuebleByQuery(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = bbdd_gestion.ProjectMDS2PersistentManager.instance().getSession();
			return listInmuebleByQuery(session, condition, orderBy, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static List queryInmueble(PersistentSession session, String condition, String orderBy) throws PersistentException {
		StringBuffer sb = new StringBuffer("From bbdd_gestion.Inmueble as Inmueble");
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
	
	public static List queryInmueble(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		StringBuffer sb = new StringBuffer("From bbdd_gestion.Inmueble as Inmueble");
		if (condition != null)
			sb.append(" Where ").append(condition);
		if (orderBy != null)
			sb.append(" Order By ").append(orderBy);
		try {
			Query query = session.createQuery(sb.toString());
			query.setLockMode("Inmueble", lockMode);
			return query.list();
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Inmueble[] listInmuebleByQuery(PersistentSession session, String condition, String orderBy) throws PersistentException {
		try {
			List list = queryInmueble(session, condition, orderBy);
			return (Inmueble[]) list.toArray(new Inmueble[list.size()]);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Inmueble[] listInmuebleByQuery(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			List list = queryInmueble(session, condition, orderBy, lockMode);
			return (Inmueble[]) list.toArray(new Inmueble[list.size()]);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Inmueble loadInmuebleByQuery(String condition, String orderBy) throws PersistentException {
		try {
			PersistentSession session = bbdd_gestion.ProjectMDS2PersistentManager.instance().getSession();
			return loadInmuebleByQuery(session, condition, orderBy);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Inmueble loadInmuebleByQuery(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = bbdd_gestion.ProjectMDS2PersistentManager.instance().getSession();
			return loadInmuebleByQuery(session, condition, orderBy, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Inmueble loadInmuebleByQuery(PersistentSession session, String condition, String orderBy) throws PersistentException {
		Inmueble[] inmuebles = listInmuebleByQuery(session, condition, orderBy);
		if (inmuebles != null && inmuebles.length > 0)
			return inmuebles[0];
		else
			return null;
	}
	
	public static Inmueble loadInmuebleByQuery(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		Inmueble[] inmuebles = listInmuebleByQuery(session, condition, orderBy, lockMode);
		if (inmuebles != null && inmuebles.length > 0)
			return inmuebles[0];
		else
			return null;
	}
	
	public static java.util.Iterator iterateInmuebleByQuery(String condition, String orderBy) throws PersistentException {
		try {
			PersistentSession session = bbdd_gestion.ProjectMDS2PersistentManager.instance().getSession();
			return iterateInmuebleByQuery(session, condition, orderBy);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static java.util.Iterator iterateInmuebleByQuery(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = bbdd_gestion.ProjectMDS2PersistentManager.instance().getSession();
			return iterateInmuebleByQuery(session, condition, orderBy, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static java.util.Iterator iterateInmuebleByQuery(PersistentSession session, String condition, String orderBy) throws PersistentException {
		StringBuffer sb = new StringBuffer("From bbdd_gestion.Inmueble as Inmueble");
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
	
	public static java.util.Iterator iterateInmuebleByQuery(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		StringBuffer sb = new StringBuffer("From bbdd_gestion.Inmueble as Inmueble");
		if (condition != null)
			sb.append(" Where ").append(condition);
		if (orderBy != null)
			sb.append(" Order By ").append(orderBy);
		try {
			Query query = session.createQuery(sb.toString());
			query.setLockMode("Inmueble", lockMode);
			return query.iterate();
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Inmueble createInmueble() {
		return new bbdd_gestion.Inmueble();
	}
	
	public static boolean save(bbdd_gestion.Inmueble inmueble) throws PersistentException {
		try {
			bbdd_gestion.ProjectMDS2PersistentManager.instance().saveObject(inmueble);
			return true;
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static boolean delete(bbdd_gestion.Inmueble inmueble) throws PersistentException {
		try {
			bbdd_gestion.ProjectMDS2PersistentManager.instance().deleteObject(inmueble);
			return true;
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static boolean deleteAndDissociate(bbdd_gestion.Inmueble inmueble)throws PersistentException {
		if (inmueble instanceof bbdd_gestion.Casa) {
			return bbdd_gestion.CasaDAO.deleteAndDissociate((bbdd_gestion.Casa) inmueble);
		}
		
		try {
			if (inmueble.getCodigoPostal() != null) {
				inmueble.getCodigoPostal().inmueble.remove(inmueble);
			}
			
			if (inmueble.getProvincia() != null) {
				inmueble.getProvincia().inmueble.remove(inmueble);
			}
			
			if (inmueble.getMunicipio() != null) {
				inmueble.getMunicipio().inmueble.remove(inmueble);
			}
			
			bbdd_gestion.Foto[] lFotos = inmueble.foto.toArray();
			for(int i = 0; i < lFotos.length; i++) {
				lFotos[i].setInmueble(null);
			}
			bbdd_gestion.Extra[] lExtras = inmueble.extra.toArray();
			for(int i = 0; i < lExtras.length; i++) {
				lExtras[i].inmueble.remove(inmueble);
			}
			return delete(inmueble);
		}
		catch(Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static boolean deleteAndDissociate(bbdd_gestion.Inmueble inmueble, org.orm.PersistentSession session)throws PersistentException {
		if (inmueble instanceof bbdd_gestion.Casa) {
			return bbdd_gestion.CasaDAO.deleteAndDissociate((bbdd_gestion.Casa) inmueble, session);
		}
		
		try {
			if (inmueble.getCodigoPostal() != null) {
				inmueble.getCodigoPostal().inmueble.remove(inmueble);
			}
			
			if (inmueble.getProvincia() != null) {
				inmueble.getProvincia().inmueble.remove(inmueble);
			}
			
			if (inmueble.getMunicipio() != null) {
				inmueble.getMunicipio().inmueble.remove(inmueble);
			}
			
			bbdd_gestion.Foto[] lFotos = inmueble.foto.toArray();
			for(int i = 0; i < lFotos.length; i++) {
				lFotos[i].setInmueble(null);
			}
			bbdd_gestion.Extra[] lExtras = inmueble.extra.toArray();
			for(int i = 0; i < lExtras.length; i++) {
				lExtras[i].inmueble.remove(inmueble);
			}
			try {
				session.delete(inmueble);
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
	
	public static boolean refresh(bbdd_gestion.Inmueble inmueble) throws PersistentException {
		try {
			bbdd_gestion.ProjectMDS2PersistentManager.instance().getSession().refresh(inmueble);
			return true;
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static boolean evict(bbdd_gestion.Inmueble inmueble) throws PersistentException {
		try {
			bbdd_gestion.ProjectMDS2PersistentManager.instance().getSession().evict(inmueble);
			return true;
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Inmueble loadInmuebleByCriteria(InmuebleCriteria inmuebleCriteria) {
		Inmueble[] inmuebles = listInmuebleByCriteria(inmuebleCriteria);
		if(inmuebles == null || inmuebles.length == 0) {
			return null;
		}
		return inmuebles[0];
	}
	
	public static Inmueble[] listInmuebleByCriteria(InmuebleCriteria inmuebleCriteria) {
		return inmuebleCriteria.listInmueble();
	}
}
