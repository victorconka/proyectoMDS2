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
public class Provincia implements Serializable {
	public Provincia() {
	}
	
	private java.util.Set this_getSet (int key) {
		if (key == bbdd_gestion.ORMConstants.KEY_PROVINCIA_CONTIENE) {
			return ORM_contiene;
		}
		else if (key == bbdd_gestion.ORMConstants.KEY_PROVINCIA_INMUEBLE) {
			return ORM_inmueble;
		}
		
		return null;
	}
	
	org.orm.util.ORMAdapter _ormAdapter = new org.orm.util.AbstractORMAdapter() {
		public java.util.Set getSet(int key) {
			return this_getSet(key);
		}
		
	};
	
	private int id_provincia;
	
	private bbdd_gestion.CodigoPostal codigoPostal;
	
	private String provincia;
	
	private java.util.Set ORM_contiene = new java.util.HashSet();
	
	private java.util.Set ORM_inmueble = new java.util.HashSet();
	
	private void setId_provincia(int value) {
		this.id_provincia = value;
	}
	
	public int getId_provincia() {
		return id_provincia;
	}
	
	public int getORMID() {
		return getId_provincia();
	}
	
	public void setProvincia(String value) {
		this.provincia = value;
	}
	
	public String getProvincia() {
		return provincia;
	}
	
	private void setORM_Contiene(java.util.Set value) {
		this.ORM_contiene = value;
	}
	
	private java.util.Set getORM_Contiene() {
		return ORM_contiene;
	}
	
	public final bbdd_gestion.MunicipioSetCollection contiene = new bbdd_gestion.MunicipioSetCollection(this, _ormAdapter, bbdd_gestion.ORMConstants.KEY_PROVINCIA_CONTIENE, bbdd_gestion.ORMConstants.KEY_MUNICIPIO_PERTENECE, bbdd_gestion.ORMConstants.KEY_MUL_ONE_TO_MANY);
	
	public void setCodigoPostal(bbdd_gestion.CodigoPostal value) {
		if (this.codigoPostal != value) {
			bbdd_gestion.CodigoPostal lcodigoPostal = this.codigoPostal;
			this.codigoPostal = value;
			if (value != null) {
				codigoPostal.setProvincia(this);
			}
			if (lcodigoPostal != null && lcodigoPostal.getProvincia() == this) {
				lcodigoPostal.setProvincia(null);
			}
		}
	}
	
	public bbdd_gestion.CodigoPostal getCodigoPostal() {
		return codigoPostal;
	}
	
	private void setORM_Inmueble(java.util.Set value) {
		this.ORM_inmueble = value;
	}
	
	private java.util.Set getORM_Inmueble() {
		return ORM_inmueble;
	}
	
	public final bbdd_gestion.InmuebleSetCollection inmueble = new bbdd_gestion.InmuebleSetCollection(this, _ormAdapter, bbdd_gestion.ORMConstants.KEY_PROVINCIA_INMUEBLE, bbdd_gestion.ORMConstants.KEY_INMUEBLE_PROVINCIA, bbdd_gestion.ORMConstants.KEY_MUL_ONE_TO_MANY);
	
	public String toString() {
		return String.valueOf(getId_provincia());
	}
	
}
