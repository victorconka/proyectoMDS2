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
public class CodigoPostal implements Serializable {
	public CodigoPostal() {
	}
	
	private java.util.Set this_getSet (int key) {
		if (key == bbdd_gestion.ORMConstants.KEY_CODIGOPOSTAL_INMUEBLE) {
			return ORM_inmueble;
		}
		
		return null;
	}
	
	private void this_setOwner(Object owner, int key) {
		if (key == bbdd_gestion.ORMConstants.KEY_CODIGOPOSTAL_PROVINCIA) {
			this.provincia = (bbdd_gestion.Provincia) owner;
		}
		
		else if (key == bbdd_gestion.ORMConstants.KEY_CODIGOPOSTAL_MUNICIPIO) {
			this.municipio = (bbdd_gestion.Municipio) owner;
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
	
	private int id_CodigoPostal;
	
	private bbdd_gestion.Municipio municipio;
	
	private String codigo_postal;
	
	private java.util.Set ORM_inmueble = new java.util.HashSet();
	
	private bbdd_gestion.Provincia provincia;
	
	private void setId_CodigoPostal(int value) {
		this.id_CodigoPostal = value;
	}
	
	public int getId_CodigoPostal() {
		return id_CodigoPostal;
	}
	
	public int getORMID() {
		return getId_CodigoPostal();
	}
	
	public void setCodigo_postal(String value) {
		this.codigo_postal = value;
	}
	
	public String getCodigo_postal() {
		return codigo_postal;
	}
	
	private void setORM_Inmueble(java.util.Set value) {
		this.ORM_inmueble = value;
	}
	
	private java.util.Set getORM_Inmueble() {
		return ORM_inmueble;
	}
	
	public final bbdd_gestion.InmuebleSetCollection inmueble = new bbdd_gestion.InmuebleSetCollection(this, _ormAdapter, bbdd_gestion.ORMConstants.KEY_CODIGOPOSTAL_INMUEBLE, bbdd_gestion.ORMConstants.KEY_INMUEBLE_CODIGOPOSTAL, bbdd_gestion.ORMConstants.KEY_MUL_ONE_TO_MANY);
	
	public void setProvincia(bbdd_gestion.Provincia value) {
		if (this.provincia != value) {
			bbdd_gestion.Provincia lprovincia = this.provincia;
			this.provincia = value;
			if (value != null) {
				provincia.setCodigoPostal(this);
			}
			if (lprovincia != null && lprovincia.getCodigoPostal() == this) {
				lprovincia.setCodigoPostal(null);
			}
		}
	}
	
	public bbdd_gestion.Provincia getProvincia() {
		return provincia;
	}
	
	public void setMunicipio(bbdd_gestion.Municipio value) {
		if (municipio != null) {
			municipio.codigoPostals.remove(this);
		}
		if (value != null) {
			value.codigoPostals.add(this);
		}
	}
	
	public bbdd_gestion.Municipio getMunicipio() {
		return municipio;
	}
	
	/**
	 * This method is for internal use only.
	 */
	public void setORM_Municipio(bbdd_gestion.Municipio value) {
		this.municipio = value;
	}
	
	private bbdd_gestion.Municipio getORM_Municipio() {
		return municipio;
	}
	
	public String toString() {
		return String.valueOf(getId_CodigoPostal());
	}
	
}
