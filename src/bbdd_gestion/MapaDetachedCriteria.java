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

public class MapaDetachedCriteria extends AbstractORMDetachedCriteria {
	public final IntegerExpression id_mapa;
	public final StringExpression longitud;
	public final StringExpression latitud;
	public final StringExpression codigoPostal;
	public final CollectionExpression casas;
	
	public MapaDetachedCriteria() {
		super(bbdd_gestion.Mapa.class, bbdd_gestion.MapaCriteria.class);
		id_mapa = new IntegerExpression("id_mapa", this.getDetachedCriteria());
		longitud = new StringExpression("longitud", this.getDetachedCriteria());
		latitud = new StringExpression("latitud", this.getDetachedCriteria());
		codigoPostal = new StringExpression("codigoPostal", this.getDetachedCriteria());
		casas = new CollectionExpression("ORM_Casas", this.getDetachedCriteria());
	}
	
	public MapaDetachedCriteria(DetachedCriteria aDetachedCriteria) {
		super(aDetachedCriteria, bbdd_gestion.MapaCriteria.class);
		id_mapa = new IntegerExpression("id_mapa", this.getDetachedCriteria());
		longitud = new StringExpression("longitud", this.getDetachedCriteria());
		latitud = new StringExpression("latitud", this.getDetachedCriteria());
		codigoPostal = new StringExpression("codigoPostal", this.getDetachedCriteria());
		casas = new CollectionExpression("ORM_Casas", this.getDetachedCriteria());
	}
	
	public CasaDetachedCriteria createCasasCriteria() {
		return new CasaDetachedCriteria(createCriteria("ORM_Casas"));
	}
	
	public Mapa uniqueMapa(PersistentSession session) {
		return (Mapa) super.createExecutableCriteria(session).uniqueResult();
	}
	
	public Mapa[] listMapa(PersistentSession session) {
		List list = super.createExecutableCriteria(session).list();
		return (Mapa[]) list.toArray(new Mapa[list.size()]);
	}
}

