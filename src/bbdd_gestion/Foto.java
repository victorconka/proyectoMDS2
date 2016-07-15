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
public class Foto implements Serializable {
	public Foto() {
	}
	
	private void this_setOwner(Object owner, int key) {
		if (key == bbdd_gestion.ORMConstants.KEY_FOTO_INMUEBLE) {
			this.inmueble = (bbdd_gestion.Inmueble) owner;
		}
		
		else if (key == bbdd_gestion.ORMConstants.KEY_FOTO_CASA) {
			this.casa = (bbdd_gestion.Casa) owner;
		}
	}
	
	org.orm.util.ORMAdapter _ormAdapter = new org.orm.util.AbstractORMAdapter() {
		public void setOwner(Object owner, int key) {
			this_setOwner(owner, key);
		}
		
	};
	
	private int id_foto;
	
	private bbdd_gestion.Casa casa;
	
	private bbdd_gestion.Inmueble inmueble;
	
	private String linkFoto;
	
	private void setId_foto(int value) {
		this.id_foto = value;
	}
	
	public int getId_foto() {
		return id_foto;
	}
	
	public int getORMID() {
		return getId_foto();
	}
	
	public void setLinkFoto(String value) {
		this.linkFoto = value;
	}
	
	public String getLinkFoto() {
		return linkFoto;
	}
	
	public void setInmueble(bbdd_gestion.Inmueble value) {
		if (inmueble != null) {
			inmueble.foto.remove(this);
		}
		if (value != null) {
			value.foto.add(this);
		}
	}
	
	public bbdd_gestion.Inmueble getInmueble() {
		return inmueble;
	}
	
	/**
	 * This method is for internal use only.
	 */
	public void setORM_Inmueble(bbdd_gestion.Inmueble value) {
		this.inmueble = value;
	}
	
	private bbdd_gestion.Inmueble getORM_Inmueble() {
		return inmueble;
	}
	
	public void setCasa(bbdd_gestion.Casa value) {
		if (casa != null) {
			casa.fotos.remove(this);
		}
		if (value != null) {
			value.fotos.add(this);
		}
	}
	
	public bbdd_gestion.Casa getCasa() {
		return casa;
	}
	
	/**
	 * This method is for internal use only.
	 */
	public void setORM_Casa(bbdd_gestion.Casa value) {
		this.casa = value;
	}
	
	private bbdd_gestion.Casa getORM_Casa() {
		return casa;
	}
	
	public String toString() {
		return String.valueOf(getId_foto());
	}
	
}
