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
public class Extra implements Serializable {
	public Extra() {
	}
	
	private java.util.Set this_getSet (int key) {
		if (key == bbdd_gestion.ORMConstants.KEY_EXTRA_INMUEBLE) {
			return ORM_inmueble;
		}
		
		return null;
	}
	
	org.orm.util.ORMAdapter _ormAdapter = new org.orm.util.AbstractORMAdapter() {
		public java.util.Set getSet(int key) {
			return this_getSet(key);
		}
		
	};
	
	private int id_Extra;
	
	private String nombreExtra;
	
	private String tipo;
	
	private java.util.Set ORM_inmueble = new java.util.HashSet();
	
	private void setId_Extra(int value) {
		this.id_Extra = value;
	}
	
	public int getId_Extra() {
		return id_Extra;
	}
	
	public int getORMID() {
		return getId_Extra();
	}
	
	public void setNombreExtra(String value) {
		this.nombreExtra = value;
	}
	
	public String getNombreExtra() {
		return nombreExtra;
	}
	
	public void setTipo(String value) {
		this.tipo = value;
	}
	
	public String getTipo() {
		return tipo;
	}
	
	private void setORM_Inmueble(java.util.Set value) {
		this.ORM_inmueble = value;
	}
	
	private java.util.Set getORM_Inmueble() {
		return ORM_inmueble;
	}
	
	public final bbdd_gestion.InmuebleSetCollection inmueble = new bbdd_gestion.InmuebleSetCollection(this, _ormAdapter, bbdd_gestion.ORMConstants.KEY_EXTRA_INMUEBLE, bbdd_gestion.ORMConstants.KEY_INMUEBLE_EXTRA, bbdd_gestion.ORMConstants.KEY_MUL_MANY_TO_MANY);
	
	public String toString() {
		return String.valueOf(getId_Extra());
	}
	
}
