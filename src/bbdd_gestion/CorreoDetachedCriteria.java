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

public class CorreoDetachedCriteria extends AbstractORMDetachedCriteria {
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
	
	public CorreoDetachedCriteria() {
		super(bbdd_gestion.Correo.class, bbdd_gestion.CorreoCriteria.class);
		id_Correo = new IntegerExpression("id_Correo", this.getDetachedCriteria());
		es_CausaMensajeId = new IntegerExpression("es_CausaMensaje.", this.getDetachedCriteria());
		es_CausaMensaje = new AssociationExpression("es_CausaMensaje", this.getDetachedCriteria());
		enviaId = new IntegerExpression("envia.id_Usuario", this.getDetachedCriteria());
		envia = new AssociationExpression("envia", this.getDetachedCriteria());
		recibeId = new IntegerExpression("recibe.id_Usuario", this.getDetachedCriteria());
		recibe = new AssociationExpression("recibe", this.getDetachedCriteria());
		fuente = new StringExpression("fuente", this.getDetachedCriteria());
		destinatario = new StringExpression("destinatario", this.getDetachedCriteria());
		asunto = new StringExpression("asunto", this.getDetachedCriteria());
		texto = new StringExpression("texto", this.getDetachedCriteria());
	}
	
	public CorreoDetachedCriteria(DetachedCriteria aDetachedCriteria) {
		super(aDetachedCriteria, bbdd_gestion.CorreoCriteria.class);
		id_Correo = new IntegerExpression("id_Correo", this.getDetachedCriteria());
		es_CausaMensajeId = new IntegerExpression("es_CausaMensaje.", this.getDetachedCriteria());
		es_CausaMensaje = new AssociationExpression("es_CausaMensaje", this.getDetachedCriteria());
		enviaId = new IntegerExpression("envia.id_Usuario", this.getDetachedCriteria());
		envia = new AssociationExpression("envia", this.getDetachedCriteria());
		recibeId = new IntegerExpression("recibe.id_Usuario", this.getDetachedCriteria());
		recibe = new AssociationExpression("recibe", this.getDetachedCriteria());
		fuente = new StringExpression("fuente", this.getDetachedCriteria());
		destinatario = new StringExpression("destinatario", this.getDetachedCriteria());
		asunto = new StringExpression("asunto", this.getDetachedCriteria());
		texto = new StringExpression("texto", this.getDetachedCriteria());
	}
	
	public CasaDetachedCriteria createEs_CausaMensajeCriteria() {
		return new CasaDetachedCriteria(createCriteria("es_CausaMensaje"));
	}
	
	public UsuarioDetachedCriteria createEnviaCriteria() {
		return new UsuarioDetachedCriteria(createCriteria("envia"));
	}
	
	public UsuarioDetachedCriteria createRecibeCriteria() {
		return new UsuarioDetachedCriteria(createCriteria("recibe"));
	}
	
	public Correo uniqueCorreo(PersistentSession session) {
		return (Correo) super.createExecutableCriteria(session).uniqueResult();
	}
	
	public Correo[] listCorreo(PersistentSession session) {
		List list = super.createExecutableCriteria(session).list();
		return (Correo[]) list.toArray(new Correo[list.size()]);
	}
}

