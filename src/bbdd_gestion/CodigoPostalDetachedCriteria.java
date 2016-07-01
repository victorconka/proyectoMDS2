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

public class CodigoPostalDetachedCriteria extends AbstractORMDetachedCriteria {
	public final IntegerExpression id_CodigoPostal;
	public final IntegerExpression municipioId;
	public final AssociationExpression municipio;
	public final StringExpression codigo_postal;
	public final CollectionExpression inmueble;
	public final IntegerExpression provinciaId;
	public final AssociationExpression provincia;
	
	public CodigoPostalDetachedCriteria() {
		super(bbdd_gestion.CodigoPostal.class, bbdd_gestion.CodigoPostalCriteria.class);
		id_CodigoPostal = new IntegerExpression("id_CodigoPostal", this.getDetachedCriteria());
		municipioId = new IntegerExpression("municipio.id_Municipio", this.getDetachedCriteria());
		municipio = new AssociationExpression("municipio", this.getDetachedCriteria());
		codigo_postal = new StringExpression("codigo_postal", this.getDetachedCriteria());
		inmueble = new CollectionExpression("ORM_Inmueble", this.getDetachedCriteria());
		provinciaId = new IntegerExpression("provincia.id_CodigoPostal", this.getDetachedCriteria());
		provincia = new AssociationExpression("provincia", this.getDetachedCriteria());
	}
	
	public CodigoPostalDetachedCriteria(DetachedCriteria aDetachedCriteria) {
		super(aDetachedCriteria, bbdd_gestion.CodigoPostalCriteria.class);
		id_CodigoPostal = new IntegerExpression("id_CodigoPostal", this.getDetachedCriteria());
		municipioId = new IntegerExpression("municipio.id_Municipio", this.getDetachedCriteria());
		municipio = new AssociationExpression("municipio", this.getDetachedCriteria());
		codigo_postal = new StringExpression("codigo_postal", this.getDetachedCriteria());
		inmueble = new CollectionExpression("ORM_Inmueble", this.getDetachedCriteria());
		provinciaId = new IntegerExpression("provincia.id_CodigoPostal", this.getDetachedCriteria());
		provincia = new AssociationExpression("provincia", this.getDetachedCriteria());
	}
	
	public MunicipioDetachedCriteria createMunicipioCriteria() {
		return new MunicipioDetachedCriteria(createCriteria("municipio"));
	}
	
	public InmuebleDetachedCriteria createInmuebleCriteria() {
		return new InmuebleDetachedCriteria(createCriteria("ORM_Inmueble"));
	}
	
	public ProvinciaDetachedCriteria createProvinciaCriteria() {
		return new ProvinciaDetachedCriteria(createCriteria("provincia"));
	}
	
	public CodigoPostal uniqueCodigoPostal(PersistentSession session) {
		return (CodigoPostal) super.createExecutableCriteria(session).uniqueResult();
	}
	
	public CodigoPostal[] listCodigoPostal(PersistentSession session) {
		List list = super.createExecutableCriteria(session).list();
		return (CodigoPostal[]) list.toArray(new CodigoPostal[list.size()]);
	}
}

