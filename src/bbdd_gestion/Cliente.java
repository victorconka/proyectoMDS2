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
public class Cliente extends bbdd_gestion.Usuario implements Serializable {
	public Cliente() {
	}
	
	private java.util.Set this_getSet (int key) {
		if (key == bbdd_gestion.ORMConstants.KEY_CLIENTE_ES_VENDIDA) {
			return ORM_es_Vendida;
		}
		
		return null;
	}
	
	org.orm.util.ORMAdapter _ormAdapter = new org.orm.util.AbstractORMAdapter() {
		public java.util.Set getSet(int key) {
			return this_getSet(key);
		}
		
	};
	
	private String direccion;
	
	private String codigoPostal;
	
	private java.util.Set ORM_es_Vendida = new java.util.HashSet();
	
	public void setDireccion(String value) {
		this.direccion = value;
	}
	
	public String getDireccion() {
		return direccion;
	}
	
	public void setCodigoPostal(String value) {
		this.codigoPostal = value;
	}
	
	public String getCodigoPostal() {
		return codigoPostal;
	}
	
	private void setORM_Es_Vendida(java.util.Set value) {
		this.ORM_es_Vendida = value;
	}
	
	private java.util.Set getORM_Es_Vendida() {
		return ORM_es_Vendida;
	}
	
	public final bbdd_gestion.CasaSetCollection es_Vendida = new bbdd_gestion.CasaSetCollection(this, _ormAdapter, bbdd_gestion.ORMConstants.KEY_CLIENTE_ES_VENDIDA, bbdd_gestion.ORMConstants.KEY_CASA_VENDE, bbdd_gestion.ORMConstants.KEY_MUL_ONE_TO_MANY);
	
	public String toString() {
		return super.toString();
	}
	
}
