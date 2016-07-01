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
public class Municipio implements Serializable {
	public Municipio() {
	}
	
	private java.util.Set this_getSet (int key) {
		if (key == bbdd_gestion.ORMConstants.KEY_MUNICIPIO_CODIGOPOSTALS) {
			return ORM_codigoPostals;
		}
		else if (key == bbdd_gestion.ORMConstants.KEY_MUNICIPIO_INMUEBLE) {
			return ORM_inmueble;
		}
		
		return null;
	}
	
	private void this_setOwner(Object owner, int key) {
		if (key == bbdd_gestion.ORMConstants.KEY_MUNICIPIO_PERTENECE) {
			this.pertenece = (bbdd_gestion.Provincia) owner;
		}
	}
	
	org.orm.util.ORMAdapter _ormAdapter = new org.orm.util.AbstractORMAdapter() {
		public java.util.Set getSet(int key) {
			return this_getSet(key);
		}
		
		public void setOwner(Object owner, int key) {
			this_setOwner(owner, key);
		}
		
	};
	
	private int id_Municipio;
	
	private bbdd_gestion.Provincia pertenece;
	
	private String municipio;
	
	private java.util.Set ORM_codigoPostals = new java.util.HashSet();
	
	private java.util.Set ORM_inmueble = new java.util.HashSet();
	
	private void setId_Municipio(int value) {
		this.id_Municipio = value;
	}
	
	public int getId_Municipio() {
		return id_Municipio;
	}
	
	public int getORMID() {
		return getId_Municipio();
	}
	
	public void setMunicipio(String value) {
		this.municipio = value;
	}
	
	public String getMunicipio() {
		return municipio;
	}
	
	private void setORM_CodigoPostals(java.util.Set value) {
		this.ORM_codigoPostals = value;
	}
	
	private java.util.Set getORM_CodigoPostals() {
		return ORM_codigoPostals;
	}
	
	public final bbdd_gestion.CodigoPostalSetCollection codigoPostals = new bbdd_gestion.CodigoPostalSetCollection(this, _ormAdapter, bbdd_gestion.ORMConstants.KEY_MUNICIPIO_CODIGOPOSTALS, bbdd_gestion.ORMConstants.KEY_CODIGOPOSTAL_MUNICIPIO, bbdd_gestion.ORMConstants.KEY_MUL_ONE_TO_MANY);
	
	private void setORM_Inmueble(java.util.Set value) {
		this.ORM_inmueble = value;
	}
	
	private java.util.Set getORM_Inmueble() {
		return ORM_inmueble;
	}
	
	public final bbdd_gestion.InmuebleSetCollection inmueble = new bbdd_gestion.InmuebleSetCollection(this, _ormAdapter, bbdd_gestion.ORMConstants.KEY_MUNICIPIO_INMUEBLE, bbdd_gestion.ORMConstants.KEY_INMUEBLE_MUNICIPIO, bbdd_gestion.ORMConstants.KEY_MUL_ONE_TO_MANY);
	
	public void setPertenece(bbdd_gestion.Provincia value) {
		if (pertenece != null) {
			pertenece.contiene.remove(this);
		}
		if (value != null) {
			value.contiene.add(this);
		}
	}
	
	public bbdd_gestion.Provincia getPertenece() {
		return pertenece;
	}
	
	/**
	 * This method is for internal use only.
	 */
	public void setORM_Pertenece(bbdd_gestion.Provincia value) {
		this.pertenece = value;
	}
	
	private bbdd_gestion.Provincia getORM_Pertenece() {
		return pertenece;
	}
	
	public String toString() {
		return String.valueOf(getId_Municipio());
	}
	
}
