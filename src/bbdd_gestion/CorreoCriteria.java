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

public class CorreoCriteria extends AbstractORMCriteria {
	public final IntegerExpression id_Correo;
	public final IntegerExpression es_CausaMensajeId;
	public final AssociationExpression es_CausaMensaje;
	public final IntegerExpression enviaId;
	public final AssociationExpression envia;
	public final IntegerExpression recibeId;
	public final AssociationExpression recibe;
	public final StringExpression fuente;
	public final StringExpression destinatario;
	public final StringExpression asunto;
	public final StringExpression texto;
	
	public CorreoCriteria(Criteria criteria) {
		super(criteria);
		id_Correo = new IntegerExpression("id_Correo", this);
		es_CausaMensajeId = new IntegerExpression("es_CausaMensaje.", this);
		es_CausaMensaje = new AssociationExpression("es_CausaMensaje", this);
		enviaId = new IntegerExpression("envia.id_Usuario", this);
		envia = new AssociationExpression("envia", this);
		recibeId = new IntegerExpression("recibe.id_Usuario", this);
		recibe = new AssociationExpression("recibe", this);
		fuente = new StringExpression("fuente", this);
		destinatario = new StringExpression("destinatario", this);
		asunto = new StringExpression("asunto", this);
		texto = new StringExpression("texto", this);
	}
	
	public CorreoCriteria(PersistentSession session) {
		this(session.createCriteria(Correo.class));
	}
	
	public CorreoCriteria() throws PersistentException {
		this(bbdd_gestion.ProjectMDS2PersistentManager.instance().getSession());
	}
	
	public CasaCriteria createEs_CausaMensajeCriteria() {
		return new CasaCriteria(createCriteria("es_CausaMensaje"));
	}
	
	public UsuarioCriteria createEnviaCriteria() {
		return new UsuarioCriteria(createCriteria("envia"));
	}
	
	public UsuarioCriteria createRecibeCriteria() {
		return new UsuarioCriteria(createCriteria("recibe"));
	}
	
	public Correo uniqueCorreo() {
		return (Correo) super.uniqueResult();
	}
	
	public Correo[] listCorreo() {
		java.util.List list = super.list();
		return (Correo[]) list.toArray(new Correo[list.size()]);
	}
}

