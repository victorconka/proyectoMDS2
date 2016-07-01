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
public class Casa extends bbdd_gestion.Inmueble implements Serializable {
	public Casa() {
	}
	
	private java.util.Set this_getSet (int key) {
		if (key == bbdd_gestion.ORMConstants.KEY_CASA_FAVORITA) {
			return ORM_favorita;
		}
		else if (key == bbdd_gestion.ORMConstants.KEY_CASA_CORREO) {
			return ORM_correo;
		}
		else if (key == bbdd_gestion.ORMConstants.KEY_CASA_FOTOS) {
			return ORM_fotos;
		}
		
		return null;
	}
	
	private void this_setOwner(Object owner, int key) {
		if (key == bbdd_gestion.ORMConstants.KEY_CASA_MAPA) {
			this.mapa = (bbdd_gestion.Mapa) owner;
		}
		
		else if (key == bbdd_gestion.ORMConstants.KEY_CASA_VENDE) {
			this.vende = (bbdd_gestion.Cliente) owner;
		}
		
		else if (key == bbdd_gestion.ORMConstants.KEY_CASA_ALQUILA) {
			this.alquila = (bbdd_gestion.UsuarioR) owner;
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
	
	private int id_casa;
	
	private double precio;
	
	private Double superficie;
	
	private int habitaciones;
	
	private int banios;
	
	private String tipo;
	
	private String linkMapa;
	
	private String estado;
	
	private String accion;
	
	private int numVisitas = 0;
	
	private int numFavoritos = 0;
	
	private String visible;
	
	private String dCorta;
	
	private String dLarga;
	
	private bbdd_gestion.Cliente vende;
	
	private bbdd_gestion.Mapa mapa;
	
	private java.util.Set ORM_favorita = new java.util.HashSet();
	
	private java.util.Set ORM_correo = new java.util.HashSet();
	
	private java.util.Set ORM_fotos = new java.util.HashSet();
	
	private bbdd_gestion.UsuarioR alquila;
	
	public void setId_casa(int value) {
		this.id_casa = value;
	}
	
	public int getId_casa() {
		return id_casa;
	}
	
	public void setPrecio(double value) {
		this.precio = value;
	}
	
	public double getPrecio() {
		return precio;
	}
	
	public void setSuperficie(double value) {
		setSuperficie(new Double(value));
	}
	
	public void setSuperficie(Double value) {
		this.superficie = value;
	}
	
	public Double getSuperficie() {
		return superficie;
	}
	
	public void setHabitaciones(int value) {
		this.habitaciones = value;
	}
	
	public int getHabitaciones() {
		return habitaciones;
	}
	
	public void setBanios(int value) {
		this.banios = value;
	}
	
	public int getBanios() {
		return banios;
	}
	
	public void setTipo(String value) {
		this.tipo = value;
	}
	
	public String getTipo() {
		return tipo;
	}
	
	public void setLinkMapa(String value) {
		this.linkMapa = value;
	}
	
	public String getLinkMapa() {
		return linkMapa;
	}
	
	public void setEstado(String value) {
		this.estado = value;
	}
	
	public String getEstado() {
		return estado;
	}
	
	public void setAccion(String value) {
		this.accion = value;
	}
	
	public String getAccion() {
		return accion;
	}
	
	public void setNumVisitas(int value) {
		this.numVisitas = value;
	}
	
	public int getNumVisitas() {
		return numVisitas;
	}
	
	public void setNumFavoritos(int value) {
		this.numFavoritos = value;
	}
	
	public int getNumFavoritos() {
		return numFavoritos;
	}
	
	public void setVisible(String value) {
		this.visible = value;
	}
	
	public String getVisible() {
		return visible;
	}
	
	public void setdCorta(String value) {
		this.dCorta = value;
	}
	
	public String getdCorta() {
		return dCorta;
	}
	
	public void setdLarga(String value) {
		this.dLarga = value;
	}
	
	public String getdLarga() {
		return dLarga;
	}
	
	public void setMapa(bbdd_gestion.Mapa value) {
		if (mapa != null) {
			mapa.casas.remove(this);
		}
		if (value != null) {
			value.casas.add(this);
		}
	}
	
	public bbdd_gestion.Mapa getMapa() {
		return mapa;
	}
	
	/**
	 * This method is for internal use only.
	 */
	public void setORM_Mapa(bbdd_gestion.Mapa value) {
		this.mapa = value;
	}
	
	private bbdd_gestion.Mapa getORM_Mapa() {
		return mapa;
	}
	
	private void setORM_Favorita(java.util.Set value) {
		this.ORM_favorita = value;
	}
	
	private java.util.Set getORM_Favorita() {
		return ORM_favorita;
	}
	
	public final bbdd_gestion.UsuarioRSetCollection favorita = new bbdd_gestion.UsuarioRSetCollection(this, _ormAdapter, bbdd_gestion.ORMConstants.KEY_CASA_FAVORITA, bbdd_gestion.ORMConstants.KEY_USUARIOR_ES_FAVORITA, bbdd_gestion.ORMConstants.KEY_MUL_MANY_TO_MANY);
	
	public void setVende(bbdd_gestion.Cliente value) {
		if (vende != null) {
			vende.es_Vendida.remove(this);
		}
		if (value != null) {
			value.es_Vendida.add(this);
		}
	}
	
	public bbdd_gestion.Cliente getVende() {
		return vende;
	}
	
	/**
	 * This method is for internal use only.
	 */
	public void setORM_Vende(bbdd_gestion.Cliente value) {
		this.vende = value;
	}
	
	private bbdd_gestion.Cliente getORM_Vende() {
		return vende;
	}
	
	private void setORM_Correo(java.util.Set value) {
		this.ORM_correo = value;
	}
	
	private java.util.Set getORM_Correo() {
		return ORM_correo;
	}
	
	public final bbdd_gestion.CorreoSetCollection correo = new bbdd_gestion.CorreoSetCollection(this, _ormAdapter, bbdd_gestion.ORMConstants.KEY_CASA_CORREO, bbdd_gestion.ORMConstants.KEY_CORREO_ES_CAUSAMENSAJE, bbdd_gestion.ORMConstants.KEY_MUL_ONE_TO_MANY);
	
	private void setORM_Fotos(java.util.Set value) {
		this.ORM_fotos = value;
	}
	
	private java.util.Set getORM_Fotos() {
		return ORM_fotos;
	}
	
	public final bbdd_gestion.FotoSetCollection fotos = new bbdd_gestion.FotoSetCollection(this, _ormAdapter, bbdd_gestion.ORMConstants.KEY_CASA_FOTOS, bbdd_gestion.ORMConstants.KEY_FOTO_CASA, bbdd_gestion.ORMConstants.KEY_MUL_ONE_TO_MANY);
	
	public void setAlquila(bbdd_gestion.UsuarioR value) {
		if (this.alquila != value) {
			bbdd_gestion.UsuarioR lalquila = this.alquila;
			this.alquila = value;
			if (value != null) {
				alquila.setEs_Alquilada(this);
			}
			if (lalquila != null && lalquila.getEs_Alquilada() == this) {
				lalquila.setEs_Alquilada(null);
			}
		}
	}
	
	public bbdd_gestion.UsuarioR getAlquila() {
		return alquila;
	}
	
	public String toString() {
		return super.toString();
	}
	
}
