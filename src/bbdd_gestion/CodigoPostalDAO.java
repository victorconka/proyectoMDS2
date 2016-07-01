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

public class CodigoPostalDAO {
	public static CodigoPostal loadCodigoPostalByORMID(int id_CodigoPostal) throws PersistentException {
		try {
			PersistentSession session = bbdd_gestion.ProjectMDS2PersistentManager.instance().getSession();
			return loadCodigoPostalByORMID(session, id_CodigoPostal);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static CodigoPostal getCodigoPostalByORMID(int id_CodigoPostal) throws PersistentException {
		try {
			PersistentSession session = bbdd_gestion.ProjectMDS2PersistentManager.instance().getSession();
			return getCodigoPostalByORMID(session, id_CodigoPostal);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static CodigoPostal loadCodigoPostalByORMID(int id_CodigoPostal, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = bbdd_gestion.ProjectMDS2PersistentManager.instance().getSession();
			return loadCodigoPostalByORMID(session, id_CodigoPostal, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static CodigoPostal getCodigoPostalByORMID(int id_CodigoPostal, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = bbdd_gestion.ProjectMDS2PersistentManager.instance().getSession();
			return getCodigoPostalByORMID(session, id_CodigoPostal, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static CodigoPostal loadCodigoPostalByORMID(PersistentSession session, int id_CodigoPostal) throws PersistentException {
		try {
			return (CodigoPostal) session.load(bbdd_gestion.CodigoPostal.class, new Integer(id_CodigoPostal));
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static CodigoPostal getCodigoPostalByORMID(PersistentSession session, int id_CodigoPostal) throws PersistentException {
		try {
			return (CodigoPostal) session.get(bbdd_gestion.CodigoPostal.class, new Integer(id_CodigoPostal));
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static CodigoPostal loadCodigoPostalByORMID(PersistentSession session, int id_CodigoPostal, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			return (CodigoPostal) session.load(bbdd_gestion.CodigoPostal.class, new Integer(id_CodigoPostal), lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static CodigoPostal getCodigoPostalByORMID(PersistentSession session, int id_CodigoPostal, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			return (CodigoPostal) session.get(bbdd_gestion.CodigoPostal.class, new Integer(id_CodigoPostal), lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static List queryCodigoPostal(String condition, String orderBy) throws PersistentException {
		try {
			PersistentSession session = bbdd_gestion.ProjectMDS2PersistentManager.instance().getSession();
			return queryCodigoPostal(session, condition, orderBy);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static List queryCodigoPostal(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = bbdd_gestion.ProjectMDS2PersistentManager.instance().getSession();
			return queryCodigoPostal(session, condition, orderBy, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static CodigoPostal[] listCodigoPostalByQuery(String condition, String orderBy) throws PersistentException {
		try {
			PersistentSession session = bbdd_gestion.ProjectMDS2PersistentManager.instance().getSession();
			return listCodigoPostalByQuery(session, condition, orderBy);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static CodigoPostal[] listCodigoPostalByQuery(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = bbdd_gestion.ProjectMDS2PersistentManager.instance().getSession();
			return listCodigoPostalByQuery(session, condition, orderBy, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static List queryCodigoPostal(PersistentSession session, String condition, String orderBy) throws PersistentException {
		StringBuffer sb = new StringBuffer("From bbdd_gestion.CodigoPostal as CodigoPostal");
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
	
	public static List queryCodigoPostal(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		StringBuffer sb = new StringBuffer("From bbdd_gestion.CodigoPostal as CodigoPostal");
		if (condition != null)
			sb.append(" Where ").append(condition);
		if (orderBy != null)
			sb.append(" Order By ").append(orderBy);
		try {
			Query query = session.createQuery(sb.toString());
			query.setLockMode("CodigoPostal", lockMode);
			return query.list();
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static CodigoPostal[] listCodigoPostalByQuery(PersistentSession session, String condition, String orderBy) throws PersistentException {
		try {
			List list = queryCodigoPostal(session, condition, orderBy);
			return (CodigoPostal[]) list.toArray(new CodigoPostal[list.size()]);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static CodigoPostal[] listCodigoPostalByQuery(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			List list = queryCodigoPostal(session, condition, orderBy, lockMode);
			return (CodigoPostal[]) list.toArray(new CodigoPostal[list.size()]);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static CodigoPostal loadCodigoPostalByQuery(String condition, String orderBy) throws PersistentException {
		try {
			PersistentSession session = bbdd_gestion.ProjectMDS2PersistentManager.instance().getSession();
			return loadCodigoPostalByQuery(session, condition, orderBy);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static CodigoPostal loadCodigoPostalByQuery(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = bbdd_gestion.ProjectMDS2PersistentManager.instance().getSession();
			return loadCodigoPostalByQuery(session, condition, orderBy, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static CodigoPostal loadCodigoPostalByQuery(PersistentSession session, String condition, String orderBy) throws PersistentException {
		CodigoPostal[] codigoPostals = listCodigoPostalByQuery(session, condition, orderBy);
		if (codigoPostals != null && codigoPostals.length > 0)
			return codigoPostals[0];
		else
			return null;
	}
	
	public static CodigoPostal loadCodigoPostalByQuery(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		CodigoPostal[] codigoPostals = listCodigoPostalByQuery(session, condition, orderBy, lockMode);
		if (codigoPostals != null && codigoPostals.length > 0)
			return codigoPostals[0];
		else
			return null;
	}
	
	public static java.util.Iterator iterateCodigoPostalByQuery(String condition, String orderBy) throws PersistentException {
		try {
			PersistentSession session = bbdd_gestion.ProjectMDS2PersistentManager.instance().getSession();
			return iterateCodigoPostalByQuery(session, condition, orderBy);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static java.util.Iterator iterateCodigoPostalByQuery(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = bbdd_gestion.ProjectMDS2PersistentManager.instance().getSession();
			return iterateCodigoPostalByQuery(session, condition, orderBy, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static java.util.Iterator iterateCodigoPostalByQuery(PersistentSession session, String condition, String orderBy) throws PersistentException {
		StringBuffer sb = new StringBuffer("From bbdd_gestion.CodigoPostal as CodigoPostal");
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
	
	public static java.util.Iterator iterateCodigoPostalByQuery(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		StringBuffer sb = new StringBuffer("From bbdd_gestion.CodigoPostal as CodigoPostal");
		if (condition != null)
			sb.append(" Where ").append(condition);
		if (orderBy != null)
			sb.append(" Order By ").append(orderBy);
		try {
			Query query = session.createQuery(sb.toString());
			query.setLockMode("CodigoPostal", lockMode);
			return query.iterate();
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static CodigoPostal createCodigoPostal() {
		return new bbdd_gestion.CodigoPostal();
	}
	
	public static boolean save(bbdd_gestion.CodigoPostal codigoPostal) throws PersistentException {
		try {
			bbdd_gestion.ProjectMDS2PersistentManager.instance().saveObject(codigoPostal);
			return true;
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static boolean delete(bbdd_gestion.CodigoPostal codigoPostal) throws PersistentException {
		try {
			bbdd_gestion.ProjectMDS2PersistentManager.instance().deleteObject(codigoPostal);
			return true;
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static boolean deleteAndDissociate(bbdd_gestion.CodigoPostal codigoPostal)throws PersistentException {
		try {
			if (codigoPostal.getMunicipio() != null) {
				codigoPostal.getMunicipio().codigoPostals.remove(codigoPostal);
			}
			
			bbdd_gestion.Inmueble[] lInmuebles = codigoPostal.inmueble.toArray();
			for(int i = 0; i < lInmuebles.length; i++) {
				lInmuebles[i].setCodigoPostal(null);
			}
			if (codigoPostal.getProvincia() != null) {
				codigoPostal.getProvincia().setCodigoPostal(null);
			}
			
			return delete(codigoPostal);
		}
		catch(Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static boolean deleteAndDissociate(bbdd_gestion.CodigoPostal codigoPostal, org.orm.PersistentSession session)throws PersistentException {
		try {
			if (codigoPostal.getMunicipio() != null) {
				codigoPostal.getMunicipio().codigoPostals.remove(codigoPostal);
			}
			
			bbdd_gestion.Inmueble[] lInmuebles = codigoPostal.inmueble.toArray();
			for(int i = 0; i < lInmuebles.length; i++) {
				lInmuebles[i].setCodigoPostal(null);
			}
			if (codigoPostal.getProvincia() != null) {
				codigoPostal.getProvincia().setCodigoPostal(null);
			}
			
			try {
				session.delete(codigoPostal);
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
	
	public static boolean refresh(bbdd_gestion.CodigoPostal codigoPostal) throws PersistentException {
		try {
			bbdd_gestion.ProjectMDS2PersistentManager.instance().getSession().refresh(codigoPostal);
			return true;
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static boolean evict(bbdd_gestion.CodigoPostal codigoPostal) throws PersistentException {
		try {
			bbdd_gestion.ProjectMDS2PersistentManager.instance().getSession().evict(codigoPostal);
			return true;
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static CodigoPostal loadCodigoPostalByCriteria(CodigoPostalCriteria codigoPostalCriteria) {
		CodigoPostal[] codigoPostals = listCodigoPostalByCriteria(codigoPostalCriteria);
		if(codigoPostals == null || codigoPostals.length == 0) {
			return null;
		}
		return codigoPostals[0];
	}
	
	public static CodigoPostal[] listCodigoPostalByCriteria(CodigoPostalCriteria codigoPostalCriteria) {
		return codigoPostalCriteria.listCodigoPostal();
	}
}
