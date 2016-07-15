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
public class Correo implements Serializable {
	public Correo() {
	}
	
	private void this_setOwner(Object owner, int key) {
		if (key == bbdd_gestion.ORMConstants.KEY_CORREO_RECIBE) {
			this.recibe = (bbdd_gestion.Usuario) owner;
		}
		
		else if (key == bbdd_gestion.ORMConstants.KEY_CORREO_ES_CAUSAMENSAJE) {
			this.es_CausaMensaje = (bbdd_gestion.Casa) owner;
		}
		
		else if (key == bbdd_gestion.ORMConstants.KEY_CORREO_ENVIA) {
			this.envia = (bbdd_gestion.Usuario) owner;
		}
	}
	
	org.orm.util.ORMAdapter _ormAdapter = new org.orm.util.AbstractORMAdapter() {
		public void setOwner(Object owner, int key) {
			this_setOwner(owner, key);
		}
		
	};
	
	private int id_Correo;
	
	private bbdd_gestion.Casa es_CausaMensaje;
	
	private bbdd_gestion.Usuario envia;
	
	private bbdd_gestion.Usuario recibe;
	
	private String fuente;
	
	private String destinatario;
	
	private String asunto;
	
	private String texto;
	
	private void setId_Correo(int value) {
		this.id_Correo = value;
	}
	
	public int getId_Correo() {
		return id_Correo;
	}
	
	public int getORMID() {
		return getId_Correo();
	}
	
	public void setFuente(String value) {
		this.fuente = value;
	}
	
	public String getFuente() {
		return fuente;
	}
	
	public void setDestinatario(String value) {
		this.destinatario = value;
	}
	
	public String getDestinatario() {
		return destinatario;
	}
	
	public void setAsunto(String value) {
		this.asunto = value;
	}
	
	public String getAsunto() {
		return asunto;
	}
	
	public void setTexto(String value) {
		this.texto = value;
	}
	
	public String getTexto() {
		return texto;
	}
	
	public void setRecibe(bbdd_gestion.Usuario value) {
		if (recibe != null) {
			recibe.entrada.remove(this);
		}
		if (value != null) {
			value.entrada.add(this);
		}
	}
	
	public bbdd_gestion.Usuario getRecibe() {
		return recibe;
	}
	
	/**
	 * This method is for internal use only.
	 */
	public void setORM_Recibe(bbdd_gestion.Usuario value) {
		this.recibe = value;
	}
	
	private bbdd_gestion.Usuario getORM_Recibe() {
		return recibe;
	}
	
	public void setEs_CausaMensaje(bbdd_gestion.Casa value) {
		if (es_CausaMensaje != null) {
			es_CausaMensaje.correo.remove(this);
		}
		if (value != null) {
			value.correo.add(this);
		}
	}
	
	public bbdd_gestion.Casa getEs_CausaMensaje() {
		return es_CausaMensaje;
	}
	
	/**
	 * This method is for internal use only.
	 */
	public void setORM_Es_CausaMensaje(bbdd_gestion.Casa value) {
		this.es_CausaMensaje = value;
	}
	
	private bbdd_gestion.Casa getORM_Es_CausaMensaje() {
		return es_CausaMensaje;
	}
	
	public void setEnvia(bbdd_gestion.Usuario value) {
		if (envia != null) {
			envia.salida.remove(this);
		}
		if (value != null) {
			value.salida.add(this);
		}
	}
	
	public bbdd_gestion.Usuario getEnvia() {
		return envia;
	}
	
	/**
	 * This method is for internal use only.
	 */
	public void setORM_Envia(bbdd_gestion.Usuario value) {
		this.envia = value;
	}
	
	private bbdd_gestion.Usuario getORM_Envia() {
		return envia;
	}
	
	public String toString() {
		return String.valueOf(getId_Correo());
	}
	
}
