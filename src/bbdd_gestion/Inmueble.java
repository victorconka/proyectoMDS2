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
public class Inmueble implements Serializable {
	public Inmueble() {
	}
	
	private java.util.Set this_getSet (int key) {
		if (key == bbdd_gestion.ORMConstants.KEY_INMUEBLE_FOTO) {
			return ORM_foto;
		}
		else if (key == bbdd_gestion.ORMConstants.KEY_INMUEBLE_EXTRA) {
			return ORM_extra;
		}
		
		return null;
	}
	
	private void this_setOwner(Object owner, int key) {
		if (key == bbdd_gestion.ORMConstants.KEY_INMUEBLE_MUNICIPIO) {
			this.municipio = (bbdd_gestion.Municipio) owner;
		}
		
		else if (key == bbdd_gestion.ORMConstants.KEY_INMUEBLE_PROVINCIA) {
			this.provincia = (bbdd_gestion.Provincia) owner;
		}
		
		else if (key == bbdd_gestion.ORMConstants.KEY_INMUEBLE_CODIGOPOSTAL) {
			this.codigoPostal = (bbdd_gestion.CodigoPostal) owner;
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
	
	private int id_Inmueble;
	
	private bbdd_gestion.CodigoPostal codigoPostal;
	
	private bbdd_gestion.Provincia provincia;
	
	private bbdd_gestion.Municipio municipio;
	
	private String linkFoto;
	
	private String direccion;
	
	private java.util.Set ORM_foto = new java.util.HashSet();
	
	private java.util.Set ORM_extra = new java.util.HashSet();
	
	private void setId_Inmueble(int value) {
		this.id_Inmueble = value;
	}
	
	public int getId_Inmueble() {
		return id_Inmueble;
	}
	
	public int getORMID() {
		return getId_Inmueble();
	}
	
	public void setLinkFoto(String value) {
		this.linkFoto = value;
	}
	
	public String getLinkFoto() {
		return linkFoto;
	}
	
	public void setDireccion(String value) {
		this.direccion = value;
	}
	
	public String getDireccion() {
		return direccion;
	}
	
	private void setORM_Foto(java.util.Set value) {
		this.ORM_foto = value;
	}
	
	private java.util.Set getORM_Foto() {
		return ORM_foto;
	}
	
	public final bbdd_gestion.FotoSetCollection foto = new bbdd_gestion.FotoSetCollection(this, _ormAdapter, bbdd_gestion.ORMConstants.KEY_INMUEBLE_FOTO, bbdd_gestion.ORMConstants.KEY_FOTO_INMUEBLE, bbdd_gestion.ORMConstants.KEY_MUL_ONE_TO_MANY);
	
	public void setMunicipio(bbdd_gestion.Municipio value) {
		if (municipio != null) {
			municipio.inmueble.remove(this);
		}
		if (value != null) {
			value.inmueble.add(this);
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
	
	public void setProvincia(bbdd_gestion.Provincia value) {
		if (provincia != null) {
			provincia.inmueble.remove(this);
		}
		if (value != null) {
			value.inmueble.add(this);
		}
	}
	
	public bbdd_gestion.Provincia getProvincia() {
		return provincia;
	}
	
	/**
	 * This method is for internal use only.
	 */
	public void setORM_Provincia(bbdd_gestion.Provincia value) {
		this.provincia = value;
	}
	
	private bbdd_gestion.Provincia getORM_Provincia() {
		return provincia;
	}
	
	public void setCodigoPostal(bbdd_gestion.CodigoPostal value) {
		if (codigoPostal != null) {
			codigoPostal.inmueble.remove(this);
		}
		if (value != null) {
			value.inmueble.add(this);
		}
	}
	
	public bbdd_gestion.CodigoPostal getCodigoPostal() {
		return codigoPostal;
	}
	
	/**
	 * This method is for internal use only.
	 */
	public void setORM_CodigoPostal(bbdd_gestion.CodigoPostal value) {
		this.codigoPostal = value;
	}
	
	private bbdd_gestion.CodigoPostal getORM_CodigoPostal() {
		return codigoPostal;
	}
	
	private void setORM_Extra(java.util.Set value) {
		this.ORM_extra = value;
	}
	
	private java.util.Set getORM_Extra() {
		return ORM_extra;
	}
	
	public final bbdd_gestion.ExtraSetCollection extra = new bbdd_gestion.ExtraSetCollection(this, _ormAdapter, bbdd_gestion.ORMConstants.KEY_INMUEBLE_EXTRA, bbdd_gestion.ORMConstants.KEY_EXTRA_INMUEBLE, bbdd_gestion.ORMConstants.KEY_MUL_MANY_TO_MANY);
	
	public String toString() {
		return String.valueOf(getId_Inmueble());
	}
	
}
