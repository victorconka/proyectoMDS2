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

public class MapaCriteria extends AbstractORMCriteria {
	public final IntegerExpression id_mapa;
	public final StringExpression longitud;
	public final StringExpression latitud;
	public final StringExpression codigoPostal;
	public final CollectionExpression casas;
	
	public MapaCriteria(Criteria criteria) {
		super(criteria);
		id_mapa = new IntegerExpression("id_mapa", this);
		longitud = new StringExpression("longitud", this);
		latitud = new StringExpression("latitud", this);
		codigoPostal = new StringExpression("codigoPostal", this);
		casas = new CollectionExpression("ORM_Casas", this);
	}
	
	public MapaCriteria(PersistentSession session) {
		this(session.createCriteria(Mapa.class));
	}
	
	public MapaCriteria() throws PersistentException {
		this(bbdd_gestion.ProjectMDS2PersistentManager.instance().getSession());
	}
	
	public CasaCriteria createCasasCriteria() {
		return new CasaCriteria(createCriteria("ORM_Casas"));
	}
	
	public Mapa uniqueMapa() {
		return (Mapa) super.uniqueResult();
	}
	
	public Mapa[] listMapa() {
		java.util.List list = super.list();
		return (Mapa[]) list.toArray(new Mapa[list.size()]);
	}
}

