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

public class FotoCriteria extends AbstractORMCriteria {
	public final IntegerExpression id_foto;
	public final IntegerExpression casaId;
	public final AssociationExpression casa;
	public final IntegerExpression inmuebleId;
	public final AssociationExpression inmueble;
	public final StringExpression linkFoto;
	
	public FotoCriteria(Criteria criteria) {
		super(criteria);
		id_foto = new IntegerExpression("id_foto", this);
		casaId = new IntegerExpression("casa.", this);
		casa = new AssociationExpression("casa", this);
		inmuebleId = new IntegerExpression("inmueble.id_Inmueble", this);
		inmueble = new AssociationExpression("inmueble", this);
		linkFoto = new StringExpression("linkFoto", this);
	}
	
	public FotoCriteria(PersistentSession session) {
		this(session.createCriteria(Foto.class));
	}
	
	public FotoCriteria() throws PersistentException {
		this(bbdd_gestion.ProjectMDS2PersistentManager.instance().getSession());
	}
	
	public CasaCriteria createCasaCriteria() {
		return new CasaCriteria(createCriteria("casa"));
	}
	
	public InmuebleCriteria createInmuebleCriteria() {
		return new InmuebleCriteria(createCriteria("inmueble"));
	}
	
	public Foto uniqueFoto() {
		return (Foto) super.uniqueResult();
	}
	
	public Foto[] listFoto() {
		java.util.List list = super.list();
		return (Foto[]) list.toArray(new Foto[list.size()]);
	}
}

