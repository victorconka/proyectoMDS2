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

public class ProvinciaCriteria extends AbstractORMCriteria {
	public final IntegerExpression id_provincia;
	public final IntegerExpression codigoPostalId;
	public final AssociationExpression codigoPostal;
	public final StringExpression provincia;
	public final CollectionExpression contiene;
	public final CollectionExpression inmueble;
	
	public ProvinciaCriteria(Criteria criteria) {
		super(criteria);
		id_provincia = new IntegerExpression("id_provincia", this);
		codigoPostalId = new IntegerExpression("codigoPostal.id_CodigoPostal", this);
		codigoPostal = new AssociationExpression("codigoPostal", this);
		provincia = new StringExpression("provincia", this);
		contiene = new CollectionExpression("ORM_Contiene", this);
		inmueble = new CollectionExpression("ORM_Inmueble", this);
	}
	
	public ProvinciaCriteria(PersistentSession session) {
		this(session.createCriteria(Provincia.class));
	}
	
	public ProvinciaCriteria() throws PersistentException {
		this(bbdd_gestion.ProjectMDS2PersistentManager.instance().getSession());
	}
	
	public CodigoPostalCriteria createCodigoPostalCriteria() {
		return new CodigoPostalCriteria(createCriteria("codigoPostal"));
	}
	
	public MunicipioCriteria createContieneCriteria() {
		return new MunicipioCriteria(createCriteria("ORM_Contiene"));
	}
	
	public InmuebleCriteria createInmuebleCriteria() {
		return new InmuebleCriteria(createCriteria("ORM_Inmueble"));
	}
	
	public Provincia uniqueProvincia() {
		return (Provincia) super.uniqueResult();
	}
	
	public Provincia[] listProvincia() {
		java.util.List list = super.list();
		return (Provincia[]) list.toArray(new Provincia[list.size()]);
	}
}

