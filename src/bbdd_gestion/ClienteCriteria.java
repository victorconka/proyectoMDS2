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

public class ClienteCriteria extends AbstractORMCriteria {
	public final IntegerExpression id_Usuario;
	public final StringExpression correo;
	public final StringExpression nombre;
	public final StringExpression contrasenia;
	public final CollectionExpression entrada;
	public final CollectionExpression salida;
	public final StringExpression direccion;
	public final StringExpression codigoPostal;
	public final CollectionExpression es_Vendida;
	
	public ClienteCriteria(Criteria criteria) {
		super(criteria);
		id_Usuario = new IntegerExpression("id_Usuario", this);
		correo = new StringExpression("correo", this);
		nombre = new StringExpression("nombre", this);
		contrasenia = new StringExpression("contrasenia", this);
		entrada = new CollectionExpression("ORM_Entrada", this);
		salida = new CollectionExpression("ORM_Salida", this);
		direccion = new StringExpression("direccion", this);
		codigoPostal = new StringExpression("codigoPostal", this);
		es_Vendida = new CollectionExpression("ORM_Es_Vendida", this);
	}
	
	public ClienteCriteria(PersistentSession session) {
		this(session.createCriteria(Cliente.class));
	}
	
	public ClienteCriteria() throws PersistentException {
		this(bbdd_gestion.ProjectMDS2PersistentManager.instance().getSession());
	}
	
	public CasaCriteria createEs_VendidaCriteria() {
		return new CasaCriteria(createCriteria("ORM_Es_Vendida"));
	}
	
	public CorreoCriteria createEntradaCriteria() {
		return new CorreoCriteria(createCriteria("ORM_Entrada"));
	}
	
	public CorreoCriteria createSalidaCriteria() {
		return new CorreoCriteria(createCriteria("ORM_Salida"));
	}
	
	public Cliente uniqueCliente() {
		return (Cliente) super.uniqueResult();
	}
	
	public Cliente[] listCliente() {
		java.util.List list = super.list();
		return (Cliente[]) list.toArray(new Cliente[list.size()]);
	}
}

