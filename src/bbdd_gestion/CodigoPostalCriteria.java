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

public class CodigoPostalCriteria extends AbstractORMCriteria {
	public final IntegerExpression id_CodigoPostal;
	public final IntegerExpression municipioId;
	public final AssociationExpression municipio;
	public final StringExpression codigo_postal;
	public final CollectionExpression inmueble;
	public final IntegerExpression provinciaId;
	public final AssociationExpression provincia;
	
	public CodigoPostalCriteria(Criteria criteria) {
		super(criteria);
		id_CodigoPostal = new IntegerExpression("id_CodigoPostal", this);
		municipioId = new IntegerExpression("municipio.id_Municipio", this);
		municipio = new AssociationExpression("municipio", this);
		codigo_postal = new StringExpression("codigo_postal", this);
		inmueble = new CollectionExpression("ORM_Inmueble", this);
		provinciaId = new IntegerExpression("provincia.id_CodigoPostal", this);
		provincia = new AssociationExpression("provincia", this);
	}
	
	public CodigoPostalCriteria(PersistentSession session) {
		this(session.createCriteria(CodigoPostal.class));
	}
	
	public CodigoPostalCriteria() throws PersistentException {
		this(bbdd_gestion.ProjectMDS2PersistentManager.instance().getSession());
	}
	
	public MunicipioCriteria createMunicipioCriteria() {
		return new MunicipioCriteria(createCriteria("municipio"));
	}
	
	public InmuebleCriteria createInmuebleCriteria() {
		return new InmuebleCriteria(createCriteria("ORM_Inmueble"));
	}
	
	public ProvinciaCriteria createProvinciaCriteria() {
		return new ProvinciaCriteria(createCriteria("provincia"));
	}
	
	public CodigoPostal uniqueCodigoPostal() {
		return (CodigoPostal) super.uniqueResult();
	}
	
	public CodigoPostal[] listCodigoPostal() {
		java.util.List list = super.list();
		return (CodigoPostal[]) list.toArray(new CodigoPostal[list.size()]);
	}
}

