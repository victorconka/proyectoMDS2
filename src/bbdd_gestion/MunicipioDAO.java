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

public class MunicipioDAO {
	public static Municipio loadMunicipioByORMID(int id_Municipio) throws PersistentException {
		try {
			PersistentSession session = bbdd_gestion.ProjectMDS2PersistentManager.instance().getSession();
			return loadMunicipioByORMID(session, id_Municipio);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Municipio getMunicipioByORMID(int id_Municipio) throws PersistentException {
		try {
			PersistentSession session = bbdd_gestion.ProjectMDS2PersistentManager.instance().getSession();
			return getMunicipioByORMID(session, id_Municipio);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Municipio loadMunicipioByORMID(int id_Municipio, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = bbdd_gestion.ProjectMDS2PersistentManager.instance().getSession();
			return loadMunicipioByORMID(session, id_Municipio, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Municipio getMunicipioByORMID(int id_Municipio, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = bbdd_gestion.ProjectMDS2PersistentManager.instance().getSession();
			return getMunicipioByORMID(session, id_Municipio, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Municipio loadMunicipioByORMID(PersistentSession session, int id_Municipio) throws PersistentException {
		try {
			return (Municipio) session.load(bbdd_gestion.Municipio.class, new Integer(id_Municipio));
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Municipio getMunicipioByORMID(PersistentSession session, int id_Municipio) throws PersistentException {
		try {
			return (Municipio) session.get(bbdd_gestion.Municipio.class, new Integer(id_Municipio));
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Municipio loadMunicipioByORMID(PersistentSession session, int id_Municipio, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			return (Municipio) session.load(bbdd_gestion.Municipio.class, new Integer(id_Municipio), lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Municipio getMunicipioByORMID(PersistentSession session, int id_Municipio, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			return (Municipio) session.get(bbdd_gestion.Municipio.class, new Integer(id_Municipio), lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static List queryMunicipio(String condition, String orderBy) throws PersistentException {
		try {
			PersistentSession session = bbdd_gestion.ProjectMDS2PersistentManager.instance().getSession();
			return queryMunicipio(session, condition, orderBy);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static List queryMunicipio(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = bbdd_gestion.ProjectMDS2PersistentManager.instance().getSession();
			return queryMunicipio(session, condition, orderBy, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Municipio[] listMunicipioByQuery(String condition, String orderBy) throws PersistentException {
		try {
			PersistentSession session = bbdd_gestion.ProjectMDS2PersistentManager.instance().getSession();
			return listMunicipioByQuery(session, condition, orderBy);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Municipio[] listMunicipioByQuery(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = bbdd_gestion.ProjectMDS2PersistentManager.instance().getSession();
			return listMunicipioByQuery(session, condition, orderBy, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static List queryMunicipio(PersistentSession session, String condition, String orderBy) throws PersistentException {
		StringBuffer sb = new StringBuffer("From bbdd_gestion.Municipio as Municipio");
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
	
	public static List queryMunicipio(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		StringBuffer sb = new StringBuffer("From bbdd_gestion.Municipio as Municipio");
		if (condition != null)
			sb.append(" Where ").append(condition);
		if (orderBy != null)
			sb.append(" Order By ").append(orderBy);
		try {
			Query query = session.createQuery(sb.toString());
			query.setLockMode("Municipio", lockMode);
			return query.list();
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Municipio[] listMunicipioByQuery(PersistentSession session, String condition, String orderBy) throws PersistentException {
		try {
			List list = queryMunicipio(session, condition, orderBy);
			return (Municipio[]) list.toArray(new Municipio[list.size()]);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Municipio[] listMunicipioByQuery(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			List list = queryMunicipio(session, condition, orderBy, lockMode);
			return (Municipio[]) list.toArray(new Municipio[list.size()]);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Municipio loadMunicipioByQuery(String condition, String orderBy) throws PersistentException {
		try {
			PersistentSession session = bbdd_gestion.ProjectMDS2PersistentManager.instance().getSession();
			return loadMunicipioByQuery(session, condition, orderBy);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Municipio loadMunicipioByQuery(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = bbdd_gestion.ProjectMDS2PersistentManager.instance().getSession();
			return loadMunicipioByQuery(session, condition, orderBy, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Municipio loadMunicipioByQuery(PersistentSession session, String condition, String orderBy) throws PersistentException {
		Municipio[] municipios = listMunicipioByQuery(session, condition, orderBy);
		if (municipios != null && municipios.length > 0)
			return municipios[0];
		else
			return null;
	}
	
	public static Municipio loadMunicipioByQuery(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		Municipio[] municipios = listMunicipioByQuery(session, condition, orderBy, lockMode);
		if (municipios != null && municipios.length > 0)
			return municipios[0];
		else
			return null;
	}
	
	public static java.util.Iterator iterateMunicipioByQuery(String condition, String orderBy) throws PersistentException {
		try {
			PersistentSession session = bbdd_gestion.ProjectMDS2PersistentManager.instance().getSession();
			return iterateMunicipioByQuery(session, condition, orderBy);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static java.util.Iterator iterateMunicipioByQuery(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = bbdd_gestion.ProjectMDS2PersistentManager.instance().getSession();
			return iterateMunicipioByQuery(session, condition, orderBy, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static java.util.Iterator iterateMunicipioByQuery(PersistentSession session, String condition, String orderBy) throws PersistentException {
		StringBuffer sb = new StringBuffer("From bbdd_gestion.Municipio as Municipio");
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
	
	public static java.util.Iterator iterateMunicipioByQuery(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		StringBuffer sb = new StringBuffer("From bbdd_gestion.Municipio as Municipio");
		if (condition != null)
			sb.append(" Where ").append(condition);
		if (orderBy != null)
			sb.append(" Order By ").append(orderBy);
		try {
			Query query = session.createQuery(sb.toString());
			query.setLockMode("Municipio", lockMode);
			return query.iterate();
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Municipio createMunicipio() {
		return new bbdd_gestion.Municipio();
	}
	
	public static boolean save(bbdd_gestion.Municipio municipio) throws PersistentException {
		try {
			bbdd_gestion.ProjectMDS2PersistentManager.instance().saveObject(municipio);
			return true;
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static boolean delete(bbdd_gestion.Municipio municipio) throws PersistentException {
		try {
			bbdd_gestion.ProjectMDS2PersistentManager.instance().deleteObject(municipio);
			return true;
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static boolean deleteAndDissociate(bbdd_gestion.Municipio municipio)throws PersistentException {
		try {
			if (municipio.getPertenece() != null) {
				municipio.getPertenece().contiene.remove(municipio);
			}
			
			bbdd_gestion.CodigoPostal[] lCodigoPostalss = municipio.codigoPostals.toArray();
			for(int i = 0; i < lCodigoPostalss.length; i++) {
				lCodigoPostalss[i].setMunicipio(null);
			}
			bbdd_gestion.Inmueble[] lInmuebles = municipio.inmueble.toArray();
			for(int i = 0; i < lInmuebles.length; i++) {
				lInmuebles[i].setMunicipio(null);
			}
			return delete(municipio);
		}
		catch(Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static boolean deleteAndDissociate(bbdd_gestion.Municipio municipio, org.orm.PersistentSession session)throws PersistentException {
		try {
			if (municipio.getPertenece() != null) {
				municipio.getPertenece().contiene.remove(municipio);
			}
			
			bbdd_gestion.CodigoPostal[] lCodigoPostalss = municipio.codigoPostals.toArray();
			for(int i = 0; i < lCodigoPostalss.length; i++) {
				lCodigoPostalss[i].setMunicipio(null);
			}
			bbdd_gestion.Inmueble[] lInmuebles = municipio.inmueble.toArray();
			for(int i = 0; i < lInmuebles.length; i++) {
				lInmuebles[i].setMunicipio(null);
			}
			try {
				session.delete(municipio);
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
	
	public static boolean refresh(bbdd_gestion.Municipio municipio) throws PersistentException {
		try {
			bbdd_gestion.ProjectMDS2PersistentManager.instance().getSession().refresh(municipio);
			return true;
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static boolean evict(bbdd_gestion.Municipio municipio) throws PersistentException {
		try {
			bbdd_gestion.ProjectMDS2PersistentManager.instance().getSession().evict(municipio);
			return true;
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Municipio loadMunicipioByCriteria(MunicipioCriteria municipioCriteria) {
		Municipio[] municipios = listMunicipioByCriteria(municipioCriteria);
		if(municipios == null || municipios.length == 0) {
			return null;
		}
		return municipios[0];
	}
	
	public static Municipio[] listMunicipioByCriteria(MunicipioCriteria municipioCriteria) {
		return municipioCriteria.listMunicipio();
	}
}
