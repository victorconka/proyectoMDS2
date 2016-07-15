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

import java.io.Serializable;
public class Mapa implements Serializable {
	public Mapa() {
	}
	
	private java.util.Set this_getSet (int key) {
		if (key == bbdd_gestion.ORMConstants.KEY_MAPA_CASAS) {
			return ORM_casas;
		}
		
		return null;
	}
	
	org.orm.util.ORMAdapter _ormAdapter = new org.orm.util.AbstractORMAdapter() {
		public java.util.Set getSet(int key) {
			return this_getSet(key);
		}
		
	};
	
	private int id_mapa;
	
	private String longitud;
	
	private String latitud;
	
	private String codigoPostal;
	
	private java.util.Set ORM_casas = new java.util.HashSet();
	
	private void setId_mapa(int value) {
		this.id_mapa = value;
	}
	
	public int getId_mapa() {
		return id_mapa;
	}
	
	public int getORMID() {
		return getId_mapa();
	}
	
	public void setLongitud(String value) {
		this.longitud = value;
	}
	
	public String getLongitud() {
		return longitud;
	}
	
	public void setLatitud(String value) {
		this.latitud = value;
	}
	
	public String getLatitud() {
		return latitud;
	}
	
	public void setCodigoPostal(String value) {
		this.codigoPostal = value;
	}
	
	public String getCodigoPostal() {
		return codigoPostal;
	}
	
	private void setORM_Casas(java.util.Set value) {
		this.ORM_casas = value;
	}
	
	private java.util.Set getORM_Casas() {
		return ORM_casas;
	}
	
	public final bbdd_gestion.CasaSetCollection casas = new bbdd_gestion.CasaSetCollection(this, _ormAdapter, bbdd_gestion.ORMConstants.KEY_MAPA_CASAS, bbdd_gestion.ORMConstants.KEY_CASA_MAPA, bbdd_gestion.ORMConstants.KEY_MUL_ONE_TO_MANY);
	
	public String toString() {
		return String.valueOf(getId_mapa());
	}
	
}
