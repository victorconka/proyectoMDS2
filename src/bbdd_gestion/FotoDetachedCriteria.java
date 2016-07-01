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

public class FotoDetachedCriteria extends AbstractORMDetachedCriteria {
	public final IntegerExpression id_foto;
	public final IntegerExpression casaId;
	public final AssociationExpression casa;
	public final IntegerExpression inmuebleId;
	public final AssociationExpression inmueble;
	public final StringExpression linkFoto;
	
	public FotoDetachedCriteria() {
		super(bbdd_gestion.Foto.class, bbdd_gestion.FotoCriteria.class);
		id_foto = new IntegerExpression("id_foto", this.getDetachedCriteria());
		casaId = new IntegerExpression("casa.", this.getDetachedCriteria());
		casa = new AssociationExpression("casa", this.getDetachedCriteria());
		inmuebleId = new IntegerExpression("inmueble.id_Inmueble", this.getDetachedCriteria());
		inmueble = new AssociationExpression("inmueble", this.getDetachedCriteria());
		linkFoto = new StringExpression("linkFoto", this.getDetachedCriteria());
	}
	
	public FotoDetachedCriteria(DetachedCriteria aDetachedCriteria) {
		super(aDetachedCriteria, bbdd_gestion.FotoCriteria.class);
		id_foto = new IntegerExpression("id_foto", this.getDetachedCriteria());
		casaId = new IntegerExpression("casa.", this.getDetachedCriteria());
		casa = new AssociationExpression("casa", this.getDetachedCriteria());
		inmuebleId = new IntegerExpression("inmueble.id_Inmueble", this.getDetachedCriteria());
		inmueble = new AssociationExpression("inmueble", this.getDetachedCriteria());
		linkFoto = new StringExpression("linkFoto", this.getDetachedCriteria());
	}
	
	public CasaDetachedCriteria createCasaCriteria() {
		return new CasaDetachedCriteria(createCriteria("casa"));
	}
	
	public InmuebleDetachedCriteria createInmuebleCriteria() {
		return new InmuebleDetachedCriteria(createCriteria("inmueble"));
	}
	
	public Foto uniqueFoto(PersistentSession session) {
		return (Foto) super.createExecutableCriteria(session).uniqueResult();
	}
	
	public Foto[] listFoto(PersistentSession session) {
		List list = super.createExecutableCriteria(session).list();
		return (Foto[]) list.toArray(new Foto[list.size()]);
	}
}

