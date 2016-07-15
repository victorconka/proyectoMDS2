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

import java.util.List;
import org.hibernate.criterion.DetachedCriteria;
import org.orm.PersistentSession;
import org.orm.criteria.*;

public class ClienteDetachedCriteria extends AbstractORMDetachedCriteria {
	public final IntegerExpression id_Usuario;
	public final StringExpression correo;
	public final StringExpression nombre;
	public final StringExpression contrasenia;
	public final CollectionExpression entrada;
	public final CollectionExpression salida;
	public final StringExpression direccion;
	public final StringExpression codigoPostal;
	public final CollectionExpression es_Vendida;
	
	public ClienteDetachedCriteria() {
		super(bbdd_gestion.Cliente.class, bbdd_gestion.ClienteCriteria.class);
		id_Usuario = new IntegerExpression("id_Usuario", this.getDetachedCriteria());
		correo = new StringExpression("correo", this.getDetachedCriteria());
		nombre = new StringExpression("nombre", this.getDetachedCriteria());
		contrasenia = new StringExpression("contrasenia", this.getDetachedCriteria());
		entrada = new CollectionExpression("ORM_Entrada", this.getDetachedCriteria());
		salida = new CollectionExpression("ORM_Salida", this.getDetachedCriteria());
		direccion = new StringExpression("direccion", this.getDetachedCriteria());
		codigoPostal = new StringExpression("codigoPostal", this.getDetachedCriteria());
		es_Vendida = new CollectionExpression("ORM_Es_Vendida", this.getDetachedCriteria());
	}
	
	public ClienteDetachedCriteria(DetachedCriteria aDetachedCriteria) {
		super(aDetachedCriteria, bbdd_gestion.ClienteCriteria.class);
		id_Usuario = new IntegerExpression("id_Usuario", this.getDetachedCriteria());
		correo = new StringExpression("correo", this.getDetachedCriteria());
		nombre = new StringExpression("nombre", this.getDetachedCriteria());
		contrasenia = new StringExpression("contrasenia", this.getDetachedCriteria());
		entrada = new CollectionExpression("ORM_Entrada", this.getDetachedCriteria());
		salida = new CollectionExpression("ORM_Salida", this.getDetachedCriteria());
		direccion = new StringExpression("direccion", this.getDetachedCriteria());
		codigoPostal = new StringExpression("codigoPostal", this.getDetachedCriteria());
		es_Vendida = new CollectionExpression("ORM_Es_Vendida", this.getDetachedCriteria());
	}
	
	public CasaDetachedCriteria createEs_VendidaCriteria() {
		return new CasaDetachedCriteria(createCriteria("ORM_Es_Vendida"));
	}
	
	public CorreoDetachedCriteria createEntradaCriteria() {
		return new CorreoDetachedCriteria(createCriteria("ORM_Entrada"));
	}
	
	public CorreoDetachedCriteria createSalidaCriteria() {
		return new CorreoDetachedCriteria(createCriteria("ORM_Salida"));
	}
	
	public Cliente uniqueCliente(PersistentSession session) {
		return (Cliente) super.createExecutableCriteria(session).uniqueResult();
	}
	
	public Cliente[] listCliente(PersistentSession session) {
		List list = super.createExecutableCriteria(session).list();
		return (Cliente[]) list.toArray(new Cliente[list.size()]);
	}
}

