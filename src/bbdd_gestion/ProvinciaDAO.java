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

public class ProvinciaDAO {
	public static Provincia loadProvinciaByORMID(int id_provincia) throws PersistentException {
		try {
			PersistentSession session = bbdd_gestion.ProjectMDS2PersistentManager.instance().getSession();
			return loadProvinciaByORMID(session, id_provincia);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Provincia getProvinciaByORMID(int id_provincia) throws PersistentException {
		try {
			PersistentSession session = bbdd_gestion.ProjectMDS2PersistentManager.instance().getSession();
			return getProvinciaByORMID(session, id_provincia);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Provincia loadProvinciaByORMID(int id_provincia, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = bbdd_gestion.ProjectMDS2PersistentManager.instance().getSession();
			return loadProvinciaByORMID(session, id_provincia, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Provincia getProvinciaByORMID(int id_provincia, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = bbdd_gestion.ProjectMDS2PersistentManager.instance().getSession();
			return getProvinciaByORMID(session, id_provincia, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Provincia loadProvinciaByORMID(PersistentSession session, int id_provincia) throws PersistentException {
		try {
			return (Provincia) session.load(bbdd_gestion.Provincia.class, new Integer(id_provincia));
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Provincia getProvinciaByORMID(PersistentSession session, int id_provincia) throws PersistentException {
		try {
			return (Provincia) session.get(bbdd_gestion.Provincia.class, new Integer(id_provincia));
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Provincia loadProvinciaByORMID(PersistentSession session, int id_provincia, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			return (Provincia) session.load(bbdd_gestion.Provincia.class, new Integer(id_provincia), lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Provincia getProvinciaByORMID(PersistentSession session, int id_provincia, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			return (Provincia) session.get(bbdd_gestion.Provincia.class, new Integer(id_provincia), lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static List queryProvincia(String condition, String orderBy) throws PersistentException {
		try {
			PersistentSession session = bbdd_gestion.ProjectMDS2PersistentManager.instance().getSession();
			return queryProvincia(session, condition, orderBy);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static List queryProvincia(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = bbdd_gestion.ProjectMDS2PersistentManager.instance().getSession();
			return queryProvincia(session, condition, orderBy, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Provincia[] listProvinciaByQuery(String condition, String orderBy) throws PersistentException {
		try {
			PersistentSession session = bbdd_gestion.ProjectMDS2PersistentManager.instance().getSession();
			return listProvinciaByQuery(session, condition, orderBy);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Provincia[] listProvinciaByQuery(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = bbdd_gestion.ProjectMDS2PersistentManager.instance().getSession();
			return listProvinciaByQuery(session, condition, orderBy, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static List queryProvincia(PersistentSession session, String condition, String orderBy) throws PersistentException {
		StringBuffer sb = new StringBuffer("From bbdd_gestion.Provincia as Provincia");
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
	
	public static List queryProvincia(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		StringBuffer sb = new StringBuffer("From bbdd_gestion.Provincia as Provincia");
		if (condition != null)
			sb.append(" Where ").append(condition);
		if (orderBy != null)
			sb.append(" Order By ").append(orderBy);
		try {
			Query query = session.createQuery(sb.toString());
			query.setLockMode("Provincia", lockMode);
			return query.list();
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Provincia[] listProvinciaByQuery(PersistentSession session, String condition, String orderBy) throws PersistentException {
		try {
			List list = queryProvincia(session, condition, orderBy);
			return (Provincia[]) list.toArray(new Provincia[list.size()]);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Provincia[] listProvinciaByQuery(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			List list = queryProvincia(session, condition, orderBy, lockMode);
			return (Provincia[]) list.toArray(new Provincia[list.size()]);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Provincia loadProvinciaByQuery(String condition, String orderBy) throws PersistentException {
		try {
			PersistentSession session = bbdd_gestion.ProjectMDS2PersistentManager.instance().getSession();
			return loadProvinciaByQuery(session, condition, orderBy);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Provincia loadProvinciaByQuery(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = bbdd_gestion.ProjectMDS2PersistentManager.instance().getSession();
			return loadProvinciaByQuery(session, condition, orderBy, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Provincia loadProvinciaByQuery(PersistentSession session, String condition, String orderBy) throws PersistentException {
		Provincia[] provincias = listProvinciaByQuery(session, condition, orderBy);
		if (provincias != null && provincias.length > 0)
			return provincias[0];
		else
			return null;
	}
	
	public static Provincia loadProvinciaByQuery(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		Provincia[] provincias = listProvinciaByQuery(session, condition, orderBy, lockMode);
		if (provincias != null && provincias.length > 0)
			return provincias[0];
		else
			return null;
	}
	
	public static java.util.Iterator iterateProvinciaByQuery(String condition, String orderBy) throws PersistentException {
		try {
			PersistentSession session = bbdd_gestion.ProjectMDS2PersistentManager.instance().getSession();
			return iterateProvinciaByQuery(session, condition, orderBy);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static java.util.Iterator iterateProvinciaByQuery(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = bbdd_gestion.ProjectMDS2PersistentManager.instance().getSession();
			return iterateProvinciaByQuery(session, condition, orderBy, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static java.util.Iterator iterateProvinciaByQuery(PersistentSession session, String condition, String orderBy) throws PersistentException {
		StringBuffer sb = new StringBuffer("From bbdd_gestion.Provincia as Provincia");
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
	
	public static java.util.Iterator iterateProvinciaByQuery(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		StringBuffer sb = new StringBuffer("From bbdd_gestion.Provincia as Provincia");
		if (condition != null)
			sb.append(" Where ").append(condition);
		if (orderBy != null)
			sb.append(" Order By ").append(orderBy);
		try {
			Query query = session.createQuery(sb.toString());
			query.setLockMode("Provincia", lockMode);
			return query.iterate();
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Provincia createProvincia() {
		return new bbdd_gestion.Provincia();
	}
	
	public static boolean save(bbdd_gestion.Provincia provincia) throws PersistentException {
		try {
			bbdd_gestion.ProjectMDS2PersistentManager.instance().saveObject(provincia);
			return true;
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static boolean delete(bbdd_gestion.Provincia provincia) throws PersistentException {
		try {
			bbdd_gestion.ProjectMDS2PersistentManager.instance().deleteObject(provincia);
			return true;
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static boolean deleteAndDissociate(bbdd_gestion.Provincia provincia)throws PersistentException {
		try {
			if (provincia.getCodigoPostal() != null) {
				provincia.getCodigoPostal().setProvincia(null);
			}
			
			bbdd_gestion.Municipio[] lContienes = provincia.contiene.toArray();
			for(int i = 0; i < lContienes.length; i++) {
				lContienes[i].setPertenece(null);
			}
			bbdd_gestion.Inmueble[] lInmuebles = provincia.inmueble.toArray();
			for(int i = 0; i < lInmuebles.length; i++) {
				lInmuebles[i].setProvincia(null);
			}
			return delete(provincia);
		}
		catch(Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static boolean deleteAndDissociate(bbdd_gestion.Provincia provincia, org.orm.PersistentSession session)throws PersistentException {
		try {
			if (provincia.getCodigoPostal() != null) {
				provincia.getCodigoPostal().setProvincia(null);
			}
			
			bbdd_gestion.Municipio[] lContienes = provincia.contiene.toArray();
			for(int i = 0; i < lContienes.length; i++) {
				lContienes[i].setPertenece(null);
			}
			bbdd_gestion.Inmueble[] lInmuebles = provincia.inmueble.toArray();
			for(int i = 0; i < lInmuebles.length; i++) {
				lInmuebles[i].setProvincia(null);
			}
			try {
				session.delete(provincia);
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
	
	public static boolean refresh(bbdd_gestion.Provincia provincia) throws PersistentException {
		try {
			bbdd_gestion.ProjectMDS2PersistentManager.instance().getSession().refresh(provincia);
			return true;
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static boolean evict(bbdd_gestion.Provincia provincia) throws PersistentException {
		try {
			bbdd_gestion.ProjectMDS2PersistentManager.instance().getSession().evict(provincia);
			return true;
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Provincia loadProvinciaByCriteria(ProvinciaCriteria provinciaCriteria) {
		Provincia[] provincias = listProvinciaByCriteria(provinciaCriteria);
		if(provincias == null || provincias.length == 0) {
			return null;
		}
		return provincias[0];
	}
	
	public static Provincia[] listProvinciaByCriteria(ProvinciaCriteria provinciaCriteria) {
		return provinciaCriteria.listProvincia();
	}
}
