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

public class MunicipioDetachedCriteria extends AbstractORMDetachedCriteria {
	public final IntegerExpression id_Municipio;
	public final IntegerExpression perteneceId;
	public final AssociationExpression pertenece;
	public final StringExpression municipio;
	public final CollectionExpression codigoPostals;
	public final CollectionExpression inmueble;
	
	public MunicipioDetachedCriteria() {
		super(bbdd_gestion.Municipio.class, bbdd_gestion.MunicipioCriteria.class);
		id_Municipio = new IntegerExpression("id_Municipio", this.getDetachedCriteria());
		perteneceId = new IntegerExpression("pertenece.id_provincia", this.getDetachedCriteria());
		pertenece = new AssociationExpression("pertenece", this.getDetachedCriteria());
		municipio = new StringExpression("municipio", this.getDetachedCriteria());
		codigoPostals = new CollectionExpression("ORM_CodigoPostals", this.getDetachedCriteria());
		inmueble = new CollectionExpression("ORM_Inmueble", this.getDetachedCriteria());
	}
	
	public MunicipioDetachedCriteria(DetachedCriteria aDetachedCriteria) {
		super(aDetachedCriteria, bbdd_gestion.MunicipioCriteria.class);
		id_Municipio = new IntegerExpression("id_Municipio", this.getDetachedCriteria());
		perteneceId = new IntegerExpression("pertenece.id_provincia", this.getDetachedCriteria());
		pertenece = new AssociationExpression("pertenece", this.getDetachedCriteria());
		municipio = new StringExpression("municipio", this.getDetachedCriteria());
		codigoPostals = new CollectionExpression("ORM_CodigoPostals", this.getDetachedCriteria());
		inmueble = new CollectionExpression("ORM_Inmueble", this.getDetachedCriteria());
	}
	
	public ProvinciaDetachedCriteria createPerteneceCriteria() {
		return new ProvinciaDetachedCriteria(createCriteria("pertenece"));
	}
	
	public CodigoPostalDetachedCriteria createCodigoPostalsCriteria() {
		return new CodigoPostalDetachedCriteria(createCriteria("ORM_CodigoPostals"));
	}
	
	public InmuebleDetachedCriteria createInmuebleCriteria() {
		return new InmuebleDetachedCriteria(createCriteria("ORM_Inmueble"));
	}
	
	public Municipio uniqueMunicipio(PersistentSession session) {
		return (Municipio) super.createExecutableCriteria(session).uniqueResult();
	}
	
	public Municipio[] listMunicipio(PersistentSession session) {
		List list = super.createExecutableCriteria(session).list();
		return (Municipio[]) list.toArray(new Municipio[list.size()]);
	}
}

