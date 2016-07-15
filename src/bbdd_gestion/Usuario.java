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
public class Usuario implements Serializable {
	public Usuario() {
	}
	
	private java.util.Set this_getSet (int key) {
		if (key == bbdd_gestion.ORMConstants.KEY_USUARIO_ENTRADA) {
			return ORM_entrada;
		}
		else if (key == bbdd_gestion.ORMConstants.KEY_USUARIO_SALIDA) {
			return ORM_salida;
		}
		
		return null;
	}
	
	org.orm.util.ORMAdapter _ormAdapter = new org.orm.util.AbstractORMAdapter() {
		public java.util.Set getSet(int key) {
			return this_getSet(key);
		}
		
	};
	
	private int id_Usuario;
	
	private String correo;
	
	private String nombre;
	
	private String contrasenia;
	
	private java.util.Set ORM_entrada = new java.util.HashSet();
	
	private java.util.Set ORM_salida = new java.util.HashSet();
	
	private void setId_Usuario(int value) {
		this.id_Usuario = value;
	}
	
	public int getId_Usuario() {
		return id_Usuario;
	}
	
	public int getORMID() {
		return getId_Usuario();
	}
	
	public void setCorreo(String value) {
		this.correo = value;
	}
	
	public String getCorreo() {
		return correo;
	}
	
	public void setNombre(String value) {
		this.nombre = value;
	}
	
	public String getNombre() {
		return nombre;
	}
	
	public void setContrasenia(String value) {
		this.contrasenia = value;
	}
	
	public String getContrasenia() {
		return contrasenia;
	}
	
	private void setORM_Entrada(java.util.Set value) {
		this.ORM_entrada = value;
	}
	
	private java.util.Set getORM_Entrada() {
		return ORM_entrada;
	}
	
	public final bbdd_gestion.CorreoSetCollection entrada = new bbdd_gestion.CorreoSetCollection(this, _ormAdapter, bbdd_gestion.ORMConstants.KEY_USUARIO_ENTRADA, bbdd_gestion.ORMConstants.KEY_CORREO_RECIBE, bbdd_gestion.ORMConstants.KEY_MUL_ONE_TO_MANY);
	
	private void setORM_Salida(java.util.Set value) {
		this.ORM_salida = value;
	}
	
	private java.util.Set getORM_Salida() {
		return ORM_salida;
	}
	
	public final bbdd_gestion.CorreoSetCollection salida = new bbdd_gestion.CorreoSetCollection(this, _ormAdapter, bbdd_gestion.ORMConstants.KEY_USUARIO_SALIDA, bbdd_gestion.ORMConstants.KEY_CORREO_ENVIA, bbdd_gestion.ORMConstants.KEY_MUL_ONE_TO_MANY);
	
	public String toString() {
		return String.valueOf(getId_Usuario());
	}
	
}
