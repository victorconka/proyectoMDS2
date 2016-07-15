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

import org.hibernate.Criteria;
import org.orm.PersistentException;
import org.orm.PersistentSession;
import org.orm.criteria.*;

public class AdministradorCriteria extends AbstractORMCriteria {
	public final IntegerExpression id_Usuario;
	public final StringExpression correo;
	public final StringExpression nombre;
	public final StringExpression contrasenia;
	public final CollectionExpression entrada;
	public final CollectionExpression salida;
	
	public AdministradorCriteria(Criteria criteria) {
		super(criteria);
		id_Usuario = new IntegerExpression("id_Usuario", this);
		correo = new StringExpression("correo", this);
		nombre = new StringExpression("nombre", this);
		contrasenia = new StringExpression("contrasenia", this);
		entrada = new CollectionExpression("ORM_Entrada", this);
		salida = new CollectionExpression("ORM_Salida", this);
	}
	
	public AdministradorCriteria(PersistentSession session) {
		this(session.createCriteria(Administrador.class));
	}
	
	public AdministradorCriteria() throws PersistentException {
		this(bbdd_gestion.ProjectMDS2PersistentManager.instance().getSession());
	}
	
	public CorreoCriteria createEntradaCriteria() {
		return new CorreoCriteria(createCriteria("ORM_Entrada"));
	}
	
	public CorreoCriteria createSalidaCriteria() {
		return new CorreoCriteria(createCriteria("ORM_Salida"));
	}
	
	public Administrador uniqueAdministrador() {
		return (Administrador) super.uniqueResult();
	}
	
	public Administrador[] listAdministrador() {
		java.util.List list = super.list();
		return (Administrador[]) list.toArray(new Administrador[list.size()]);
	}
}

