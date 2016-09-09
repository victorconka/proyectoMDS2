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

public class CasaDAO {
	public static Casa loadCasaByORMID(int id_Inmueble) throws PersistentException {
		try {
			PersistentSession session = bbdd_gestion.ProjectMDS2PersistentManager.instance().getSession();
			return loadCasaByORMID(session, id_Inmueble);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Casa getCasaByORMID(int id_Inmueble) throws PersistentException {
		try {
			PersistentSession session = bbdd_gestion.ProjectMDS2PersistentManager.instance().getSession();
			return getCasaByORMID(session, id_Inmueble);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Casa loadCasaByORMID(int id_Inmueble, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = bbdd_gestion.ProjectMDS2PersistentManager.instance().getSession();
			return loadCasaByORMID(session, id_Inmueble, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Casa getCasaByORMID(int id_Inmueble, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = bbdd_gestion.ProjectMDS2PersistentManager.instance().getSession();
			return getCasaByORMID(session, id_Inmueble, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Casa loadCasaByORMID(PersistentSession session, int id_Inmueble) throws PersistentException {
		try {
			return (Casa) session.load(bbdd_gestion.Casa.class, new Integer(id_Inmueble));
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Casa getCasaByORMID(PersistentSession session, int id_Inmueble) throws PersistentException {
		try {
			return (Casa) session.get(bbdd_gestion.Casa.class, new Integer(id_Inmueble));
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Casa loadCasaByORMID(PersistentSession session, int id_Inmueble, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			return (Casa) session.load(bbdd_gestion.Casa.class, new Integer(id_Inmueble), lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Casa getCasaByORMID(PersistentSession session, int id_Inmueble, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			return (Casa) session.get(bbdd_gestion.Casa.class, new Integer(id_Inmueble), lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static List queryCasa(String condition, String orderBy) throws PersistentException {
		try {
			PersistentSession session = bbdd_gestion.ProjectMDS2PersistentManager.instance().getSession();
			return queryCasa(session, condition, orderBy);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static List queryCasa(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = bbdd_gestion.ProjectMDS2PersistentManager.instance().getSession();
			return queryCasa(session, condition, orderBy, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Casa[] listCasaByQuery(String condition, String orderBy) throws PersistentException {
		try {
			PersistentSession session = bbdd_gestion.ProjectMDS2PersistentManager.instance().getSession();
			return listCasaByQuery(session, condition, orderBy);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Casa[] listCasaByQuery(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = bbdd_gestion.ProjectMDS2PersistentManager.instance().getSession();
			return listCasaByQuery(session, condition, orderBy, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static List queryCasa(PersistentSession session, String condition, String orderBy) throws PersistentException {
		StringBuffer sb = new StringBuffer("From bbdd_gestion.Casa as Casa");
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
	
	public static List queryCasa(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		StringBuffer sb = new StringBuffer("From bbdd_gestion.Casa as Casa");
		if (condition != null)
			sb.append(" Where ").append(condition);
		if (orderBy != null)
			sb.append(" Order By ").append(orderBy);
		try {
			Query query = session.createQuery(sb.toString());
			query.setLockMode("Casa", lockMode);
			return query.list();
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Casa[] listCasaByQuery(PersistentSession session, String condition, String orderBy) throws PersistentException {
		try {
			List list = queryCasa(session, condition, orderBy);
			return (Casa[]) list.toArray(new Casa[list.size()]);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Casa[] listCasaByQuery(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			List list = queryCasa(session, condition, orderBy, lockMode);
			return (Casa[]) list.toArray(new Casa[list.size()]);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Casa loadCasaByQuery(String condition, String orderBy) throws PersistentException {
		try {
			PersistentSession session = bbdd_gestion.ProjectMDS2PersistentManager.instance().getSession();
			return loadCasaByQuery(session, condition, orderBy);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Casa loadCasaByQuery(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = bbdd_gestion.ProjectMDS2PersistentManager.instance().getSession();
			return loadCasaByQuery(session, condition, orderBy, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Casa loadCasaByQuery(PersistentSession session, String condition, String orderBy) throws PersistentException {
		Casa[] casas = listCasaByQuery(session, condition, orderBy);
		if (casas != null && casas.length > 0)
			return casas[0];
		else
			return null;
	}
	
	public static Casa loadCasaByQuery(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		Casa[] casas = listCasaByQuery(session, condition, orderBy, lockMode);
		if (casas != null && casas.length > 0)
			return casas[0];
		else
			return null;
	}
	
	public static java.util.Iterator iterateCasaByQuery(String condition, String orderBy) throws PersistentException {
		try {
			PersistentSession session = bbdd_gestion.ProjectMDS2PersistentManager.instance().getSession();
			return iterateCasaByQuery(session, condition, orderBy);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static java.util.Iterator iterateCasaByQuery(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = bbdd_gestion.ProjectMDS2PersistentManager.instance().getSession();
			return iterateCasaByQuery(session, condition, orderBy, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static java.util.Iterator iterateCasaByQuery(PersistentSession session, String condition, String orderBy) throws PersistentException {
		StringBuffer sb = new StringBuffer("From bbdd_gestion.Casa as Casa");
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
	
	public static java.util.Iterator iterateCasaByQuery(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		StringBuffer sb = new StringBuffer("From bbdd_gestion.Casa as Casa");
		if (condition != null)
			sb.append(" Where ").append(condition);
		if (orderBy != null)
			sb.append(" Order By ").append(orderBy);
		try {
			Query query = session.createQuery(sb.toString());
			query.setLockMode("Casa", lockMode);
			return query.iterate();
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Casa createCasa() {
		return new bbdd_gestion.Casa();
	}
	
	public static boolean save(bbdd_gestion.Casa casa) throws PersistentException {
		try {
			bbdd_gestion.ProjectMDS2PersistentManager.instance().saveObject(casa);
			return true;
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static boolean delete(bbdd_gestion.Casa casa) throws PersistentException {
		try {
			bbdd_gestion.ProjectMDS2PersistentManager.instance().deleteObject(casa);
			return true;
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static boolean deleteAndDissociate(bbdd_gestion.Casa casa)throws PersistentException {
		try {
			if (casa.getVende() != null) {
				casa.getVende().es_Vendida.remove(casa);
			}
			
			if (casa.getMapa() != null) {
				casa.getMapa().casas.remove(casa);
			}
			
			bbdd_gestion.UsuarioR[] lFavoritas = casa.favorita.toArray();
			for(int i = 0; i < lFavoritas.length; i++) {
				lFavoritas[i].es_Favorita.remove(casa);
			}
			bbdd_gestion.Correo[] lCorreos = casa.correo.toArray();
			for(int i = 0; i < lCorreos.length; i++) {
				lCorreos[i].setEs_CausaMensaje(null);
			}
			bbdd_gestion.Foto[] lFotoss = casa.fotos.toArray();
			for(int i = 0; i < lFotoss.length; i++) {
				lFotoss[i].setCasa(null);
			}
			if (casa.getAlquila() != null) {
				casa.getAlquila().setEs_Alquilada(null);
			}
			
			if (casa.getCodigoPostal() != null) {
				casa.getCodigoPostal().inmueble.remove(casa);
			}
			
			if (casa.getProvincia() != null) {
				casa.getProvincia().inmueble.remove(casa);
			}
			
			if (casa.getMunicipio() != null) {
				casa.getMunicipio().inmueble.remove(casa);
			}
			
			bbdd_gestion.Extra[] lExtras = casa.extra.toArray();
			for(int i = 0; i < lExtras.length; i++) {
				lExtras[i].inmueble.remove(casa);
			}
			return delete(casa);
		}
		catch(Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static boolean deleteAndDissociate(bbdd_gestion.Casa casa, org.orm.PersistentSession session)throws PersistentException {
		try {
			if (casa.getVende() != null) {
				casa.getVende().es_Vendida.remove(casa);
			}
			
			if (casa.getMapa() != null) {
				casa.getMapa().casas.remove(casa);
			}
			
			bbdd_gestion.UsuarioR[] lFavoritas = casa.favorita.toArray();
			for(int i = 0; i < lFavoritas.length; i++) {
				lFavoritas[i].es_Favorita.remove(casa);
			}
			bbdd_gestion.Correo[] lCorreos = casa.correo.toArray();
			for(int i = 0; i < lCorreos.length; i++) {
				lCorreos[i].setEs_CausaMensaje(null);
			}
			bbdd_gestion.Foto[] lFotoss = casa.fotos.toArray();
			for(int i = 0; i < lFotoss.length; i++) {
				lFotoss[i].setCasa(null);
			}
			if (casa.getAlquila() != null) {
				casa.getAlquila().setEs_Alquilada(null);
			}
			
			if (casa.getCodigoPostal() != null) {
				casa.getCodigoPostal().inmueble.remove(casa);
			}
			
			if (casa.getProvincia() != null) {
				casa.getProvincia().inmueble.remove(casa);
			}
			
			if (casa.getMunicipio() != null) {
				casa.getMunicipio().inmueble.remove(casa);
			}
			
			bbdd_gestion.Extra[] lExtras = casa.extra.toArray();
			for(int i = 0; i < lExtras.length; i++) {
				lExtras[i].inmueble.remove(casa);
			}
			try {
				session.delete(casa);
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
	
	public static boolean refresh(bbdd_gestion.Casa casa) throws PersistentException {
		try {
			bbdd_gestion.ProjectMDS2PersistentManager.instance().getSession().refresh(casa);
			return true;
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static boolean evict(bbdd_gestion.Casa casa) throws PersistentException {
		try {
			bbdd_gestion.ProjectMDS2PersistentManager.instance().getSession().evict(casa);
			return true;
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Casa loadCasaByCriteria(CasaCriteria casaCriteria) {
		Casa[] casas = listCasaByCriteria(casaCriteria);
		if(casas == null || casas.length == 0) {
			return null;
		}
		return casas[0];
	}
	
	public static Casa[] listCasaByCriteria(CasaCriteria casaCriteria) {
		return casaCriteria.listCasa();
	}
}
