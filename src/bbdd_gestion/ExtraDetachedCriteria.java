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

public class ExtraDetachedCriteria extends AbstractORMDetachedCriteria {
	public final IntegerExpression id_Extra;
	public final StringExpression nombreExtra;
	public final StringExpression tipo;
	public final CollectionExpression inmueble;
	
	public ExtraDetachedCriteria() {
		super(bbdd_gestion.Extra.class, bbdd_gestion.ExtraCriteria.class);
		id_Extra = new IntegerExpression("id_Extra", this.getDetachedCriteria());
		nombreExtra = new StringExpression("nombreExtra", this.getDetachedCriteria());
		tipo = new StringExpression("tipo", this.getDetachedCriteria());
		inmueble = new CollectionExpression("ORM_Inmueble", this.getDetachedCriteria());
	}
	
	public ExtraDetachedCriteria(DetachedCriteria aDetachedCriteria) {
		super(aDetachedCriteria, bbdd_gestion.ExtraCriteria.class);
		id_Extra = new IntegerExpression("id_Extra", this.getDetachedCriteria());
		nombreExtra = new StringExpression("nombreExtra", this.getDetachedCriteria());
		tipo = new StringExpression("tipo", this.getDetachedCriteria());
		inmueble = new CollectionExpression("ORM_Inmueble", this.getDetachedCriteria());
	}
	
	public InmuebleDetachedCriteria createInmuebleCriteria() {
		return new InmuebleDetachedCriteria(createCriteria("ORM_Inmueble"));
	}
	
	public Extra uniqueExtra(PersistentSession session) {
		return (Extra) super.createExecutableCriteria(session).uniqueResult();
	}
	
	public Extra[] listExtra(PersistentSession session) {
		List list = super.createExecutableCriteria(session).list();
		return (Extra[]) list.toArray(new Extra[list.size()]);
	}
}

