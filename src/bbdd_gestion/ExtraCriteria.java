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

public class ExtraCriteria extends AbstractORMCriteria {
	public final IntegerExpression id_Extra;
	public final StringExpression nombreExtra;
	public final StringExpression tipo;
	public final CollectionExpression inmueble;
	
	public ExtraCriteria(Criteria criteria) {
		super(criteria);
		id_Extra = new IntegerExpression("id_Extra", this);
		nombreExtra = new StringExpression("nombreExtra", this);
		tipo = new StringExpression("tipo", this);
		inmueble = new CollectionExpression("ORM_Inmueble", this);
	}
	
	public ExtraCriteria(PersistentSession session) {
		this(session.createCriteria(Extra.class));
	}
	
	public ExtraCriteria() throws PersistentException {
		this(bbdd_gestion.ProjectMDS2PersistentManager.instance().getSession());
	}
	
	public InmuebleCriteria createInmuebleCriteria() {
		return new InmuebleCriteria(createCriteria("ORM_Inmueble"));
	}
	
	public Extra uniqueExtra() {
		return (Extra) super.uniqueResult();
	}
	
	public Extra[] listExtra() {
		java.util.List list = super.list();
		return (Extra[]) list.toArray(new Extra[list.size()]);
	}
}

