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

public class MunicipioCriteria extends AbstractORMCriteria {
	public final IntegerExpression id_Municipio;
	public final IntegerExpression perteneceId;
	public final AssociationExpression pertenece;
	public final StringExpression municipio;
	public final CollectionExpression codigoPostals;
	public final CollectionExpression inmueble;
	
	public MunicipioCriteria(Criteria criteria) {
		super(criteria);
		id_Municipio = new IntegerExpression("id_Municipio", this);
		perteneceId = new IntegerExpression("pertenece.id_provincia", this);
		pertenece = new AssociationExpression("pertenece", this);
		municipio = new StringExpression("municipio", this);
		codigoPostals = new CollectionExpression("ORM_CodigoPostals", this);
		inmueble = new CollectionExpression("ORM_Inmueble", this);
	}
	
	public MunicipioCriteria(PersistentSession session) {
		this(session.createCriteria(Municipio.class));
	}
	
	public MunicipioCriteria() throws PersistentException {
		this(bbdd_gestion.ProjectMDS2PersistentManager.instance().getSession());
	}
	
	public ProvinciaCriteria createPerteneceCriteria() {
		return new ProvinciaCriteria(createCriteria("pertenece"));
	}
	
	public CodigoPostalCriteria createCodigoPostalsCriteria() {
		return new CodigoPostalCriteria(createCriteria("ORM_CodigoPostals"));
	}
	
	public InmuebleCriteria createInmuebleCriteria() {
		return new InmuebleCriteria(createCriteria("ORM_Inmueble"));
	}
	
	public Municipio uniqueMunicipio() {
		return (Municipio) super.uniqueResult();
	}
	
	public Municipio[] listMunicipio() {
		java.util.List list = super.list();
		return (Municipio[]) list.toArray(new Municipio[list.size()]);
	}
}

