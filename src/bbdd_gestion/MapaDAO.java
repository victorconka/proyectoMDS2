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

public class MapaDAO {
	public static Mapa loadMapaByORMID(int id_mapa) throws PersistentException {
		try {
			PersistentSession session = bbdd_gestion.ProjectMDS2PersistentManager.instance().getSession();
			return loadMapaByORMID(session, id_mapa);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Mapa getMapaByORMID(int id_mapa) throws PersistentException {
		try {
			PersistentSession session = bbdd_gestion.ProjectMDS2PersistentManager.instance().getSession();
			return getMapaByORMID(session, id_mapa);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Mapa loadMapaByORMID(int id_mapa, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = bbdd_gestion.ProjectMDS2PersistentManager.instance().getSession();
			return loadMapaByORMID(session, id_mapa, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Mapa getMapaByORMID(int id_mapa, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = bbdd_gestion.ProjectMDS2PersistentManager.instance().getSession();
			return getMapaByORMID(session, id_mapa, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Mapa loadMapaByORMID(PersistentSession session, int id_mapa) throws PersistentException {
		try {
			return (Mapa) session.load(bbdd_gestion.Mapa.class, new Integer(id_mapa));
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Mapa getMapaByORMID(PersistentSession session, int id_mapa) throws PersistentException {
		try {
			return (Mapa) session.get(bbdd_gestion.Mapa.class, new Integer(id_mapa));
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Mapa loadMapaByORMID(PersistentSession session, int id_mapa, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			return (Mapa) session.load(bbdd_gestion.Mapa.class, new Integer(id_mapa), lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Mapa getMapaByORMID(PersistentSession session, int id_mapa, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			return (Mapa) session.get(bbdd_gestion.Mapa.class, new Integer(id_mapa), lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static List queryMapa(String condition, String orderBy) throws PersistentException {
		try {
			PersistentSession session = bbdd_gestion.ProjectMDS2PersistentManager.instance().getSession();
			return queryMapa(session, condition, orderBy);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static List queryMapa(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = bbdd_gestion.ProjectMDS2PersistentManager.instance().getSession();
			return queryMapa(session, condition, orderBy, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Mapa[] listMapaByQuery(String condition, String orderBy) throws PersistentException {
		try {
			PersistentSession session = bbdd_gestion.ProjectMDS2PersistentManager.instance().getSession();
			return listMapaByQuery(session, condition, orderBy);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Mapa[] listMapaByQuery(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = bbdd_gestion.ProjectMDS2PersistentManager.instance().getSession();
			return listMapaByQuery(session, condition, orderBy, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static List queryMapa(PersistentSession session, String condition, String orderBy) throws PersistentException {
		StringBuffer sb = new StringBuffer("From bbdd_gestion.Mapa as Mapa");
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
	
	public static List queryMapa(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		StringBuffer sb = new StringBuffer("From bbdd_gestion.Mapa as Mapa");
		if (condition != null)
			sb.append(" Where ").append(condition);
		if (orderBy != null)
			sb.append(" Order By ").append(orderBy);
		try {
			Query query = session.createQuery(sb.toString());
			query.setLockMode("Mapa", lockMode);
			return query.list();
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Mapa[] listMapaByQuery(PersistentSession session, String condition, String orderBy) throws PersistentException {
		try {
			List list = queryMapa(session, condition, orderBy);
			return (Mapa[]) list.toArray(new Mapa[list.size()]);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Mapa[] listMapaByQuery(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			List list = queryMapa(session, condition, orderBy, lockMode);
			return (Mapa[]) list.toArray(new Mapa[list.size()]);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Mapa loadMapaByQuery(String condition, String orderBy) throws PersistentException {
		try {
			PersistentSession session = bbdd_gestion.ProjectMDS2PersistentManager.instance().getSession();
			return loadMapaByQuery(session, condition, orderBy);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Mapa loadMapaByQuery(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = bbdd_gestion.ProjectMDS2PersistentManager.instance().getSession();
			return loadMapaByQuery(session, condition, orderBy, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Mapa loadMapaByQuery(PersistentSession session, String condition, String orderBy) throws PersistentException {
		Mapa[] mapas = listMapaByQuery(session, condition, orderBy);
		if (mapas != null && mapas.length > 0)
			return mapas[0];
		else
			return null;
	}
	
	public static Mapa loadMapaByQuery(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		Mapa[] mapas = listMapaByQuery(session, condition, orderBy, lockMode);
		if (mapas != null && mapas.length > 0)
			return mapas[0];
		else
			return null;
	}
	
	public static java.util.Iterator iterateMapaByQuery(String condition, String orderBy) throws PersistentException {
		try {
			PersistentSession session = bbdd_gestion.ProjectMDS2PersistentManager.instance().getSession();
			return iterateMapaByQuery(session, condition, orderBy);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static java.util.Iterator iterateMapaByQuery(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = bbdd_gestion.ProjectMDS2PersistentManager.instance().getSession();
			return iterateMapaByQuery(session, condition, orderBy, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static java.util.Iterator iterateMapaByQuery(PersistentSession session, String condition, String orderBy) throws PersistentException {
		StringBuffer sb = new StringBuffer("From bbdd_gestion.Mapa as Mapa");
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
	
	public static java.util.Iterator iterateMapaByQuery(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		StringBuffer sb = new StringBuffer("From bbdd_gestion.Mapa as Mapa");
		if (condition != null)
			sb.append(" Where ").append(condition);
		if (orderBy != null)
			sb.append(" Order By ").append(orderBy);
		try {
			Query query = session.createQuery(sb.toString());
			query.setLockMode("Mapa", lockMode);
			return query.iterate();
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Mapa createMapa() {
		return new bbdd_gestion.Mapa();
	}
	
	public static boolean save(bbdd_gestion.Mapa mapa) throws PersistentException {
		try {
			bbdd_gestion.ProjectMDS2PersistentManager.instance().saveObject(mapa);
			return true;
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static boolean delete(bbdd_gestion.Mapa mapa) throws PersistentException {
		try {
			bbdd_gestion.ProjectMDS2PersistentManager.instance().deleteObject(mapa);
			return true;
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static boolean deleteAndDissociate(bbdd_gestion.Mapa mapa)throws PersistentException {
		try {
			bbdd_gestion.Casa[] lCasass = mapa.casas.toArray();
			for(int i = 0; i < lCasass.length; i++) {
				lCasass[i].setMapa(null);
			}
			return delete(mapa);
		}
		catch(Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static boolean deleteAndDissociate(bbdd_gestion.Mapa mapa, org.orm.PersistentSession session)throws PersistentException {
		try {
			bbdd_gestion.Casa[] lCasass = mapa.casas.toArray();
			for(int i = 0; i < lCasass.length; i++) {
				lCasass[i].setMapa(null);
			}
			try {
				session.delete(mapa);
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
	
	public static boolean refresh(bbdd_gestion.Mapa mapa) throws PersistentException {
		try {
			bbdd_gestion.ProjectMDS2PersistentManager.instance().getSession().refresh(mapa);
			return true;
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static boolean evict(bbdd_gestion.Mapa mapa) throws PersistentException {
		try {
			bbdd_gestion.ProjectMDS2PersistentManager.instance().getSession().evict(mapa);
			return true;
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Mapa loadMapaByCriteria(MapaCriteria mapaCriteria) {
		Mapa[] mapas = listMapaByCriteria(mapaCriteria);
		if(mapas == null || mapas.length == 0) {
			return null;
		}
		return mapas[0];
	}
	
	public static Mapa[] listMapaByCriteria(MapaCriteria mapaCriteria) {
		return mapaCriteria.listMapa();
	}
}
