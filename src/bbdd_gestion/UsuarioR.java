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
public class UsuarioR extends bbdd_gestion.Cliente implements Serializable {
	public UsuarioR() {
	}
	
	private java.util.Set this_getSet (int key) {
		if (key == bbdd_gestion.ORMConstants.KEY_USUARIOR_ES_FAVORITA) {
			return ORM_es_Favorita;
		}
		
		return null;
	}
	
	private void this_setOwner(Object owner, int key) {
		if (key == bbdd_gestion.ORMConstants.KEY_USUARIOR_ES_ALQUILADA) {
			this.es_Alquilada = (bbdd_gestion.Casa) owner;
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
	
	private String apellidos;
	
	private bbdd_gestion.Casa es_Alquilada;
	
	private java.util.Set ORM_es_Favorita = new java.util.HashSet();
	
	public void setApellidos(String value) {
		this.apellidos = value;
	}
	
	public String getApellidos() {
		return apellidos;
	}
	
	public void setEs_Alquilada(bbdd_gestion.Casa value) {
		if (this.es_Alquilada != value) {
			bbdd_gestion.Casa les_Alquilada = this.es_Alquilada;
			this.es_Alquilada = value;
			if (value != null) {
				es_Alquilada.setAlquila(this);
			}
			if (les_Alquilada != null && les_Alquilada.getAlquila() == this) {
				les_Alquilada.setAlquila(null);
			}
		}
	}
	
	public bbdd_gestion.Casa getEs_Alquilada() {
		return es_Alquilada;
	}
	
	private void setORM_Es_Favorita(java.util.Set value) {
		this.ORM_es_Favorita = value;
	}
	
	private java.util.Set getORM_Es_Favorita() {
		return ORM_es_Favorita;
	}
	
	public final bbdd_gestion.CasaSetCollection es_Favorita = new bbdd_gestion.CasaSetCollection(this, _ormAdapter, bbdd_gestion.ORMConstants.KEY_USUARIOR_ES_FAVORITA, bbdd_gestion.ORMConstants.KEY_CASA_FAVORITA, bbdd_gestion.ORMConstants.KEY_MUL_MANY_TO_MANY);
	
	public String toString() {
		return super.toString();
	}
	
}
