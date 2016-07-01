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

public class ProvinciaDetachedCriteria extends AbstractORMDetachedCriteria {
	public final IntegerExpression id_provincia;
	public final IntegerExpression codigoPostalId;
	public final AssociationExpression codigoPostal;
	public final StringExpression provincia;
	public final CollectionExpression contiene;
	public final CollectionExpression inmueble;
	
	public ProvinciaDetachedCriteria() {
		super(bbdd_gestion.Provincia.class, bbdd_gestion.ProvinciaCriteria.class);
		id_provincia = new IntegerExpression("id_provincia", this.getDetachedCriteria());
		codigoPostalId = new IntegerExpression("codigoPostal.id_CodigoPostal", this.getDetachedCriteria());
		codigoPostal = new AssociationExpression("codigoPostal", this.getDetachedCriteria());
		provincia = new StringExpression("provincia", this.getDetachedCriteria());
		contiene = new CollectionExpression("ORM_Contiene", this.getDetachedCriteria());
		inmueble = new CollectionExpression("ORM_Inmueble", this.getDetachedCriteria());
	}
	
	public ProvinciaDetachedCriteria(DetachedCriteria aDetachedCriteria) {
		super(aDetachedCriteria, bbdd_gestion.ProvinciaCriteria.class);
		id_provincia = new IntegerExpression("id_provincia", this.getDetachedCriteria());
		codigoPostalId = new IntegerExpression("codigoPostal.id_CodigoPostal", this.getDetachedCriteria());
		codigoPostal = new AssociationExpression("codigoPostal", this.getDetachedCriteria());
		provincia = new StringExpression("provincia", this.getDetachedCriteria());
		contiene = new CollectionExpression("ORM_Contiene", this.getDetachedCriteria());
		inmueble = new CollectionExpression("ORM_Inmueble", this.getDetachedCriteria());
	}
	
	public CodigoPostalDetachedCriteria createCodigoPostalCriteria() {
		return new CodigoPostalDetachedCriteria(createCriteria("codigoPostal"));
	}
	
	public MunicipioDetachedCriteria createContieneCriteria() {
		return new MunicipioDetachedCriteria(createCriteria("ORM_Contiene"));
	}
	
	public InmuebleDetachedCriteria createInmuebleCriteria() {
		return new InmuebleDetachedCriteria(createCriteria("ORM_Inmueble"));
	}
	
	public Provincia uniqueProvincia(PersistentSession session) {
		return (Provincia) super.createExecutableCriteria(session).uniqueResult();
	}
	
	public Provincia[] listProvincia(PersistentSession session) {
		List list = super.createExecutableCriteria(session).list();
		return (Provincia[]) list.toArray(new Provincia[list.size()]);
	}
}

