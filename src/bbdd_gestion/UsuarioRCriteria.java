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

public class UsuarioRCriteria extends AbstractORMCriteria {
	public final IntegerExpression id_Usuario;
	public final StringExpression correo;
	public final StringExpression nombre;
	public final StringExpression contrasenia;
	public final CollectionExpression entrada;
	public final CollectionExpression salida;
	public final StringExpression direccion;
	public final StringExpression codigoPostal;
	public final CollectionExpression es_Vendida;
	public final StringExpression apellidos;
	public final IntegerExpression es_AlquiladaId;
	public final AssociationExpression es_Alquilada;
	public final CollectionExpression es_Favorita;
	
	public UsuarioRCriteria(Criteria criteria) {
		super(criteria);
		id_Usuario = new IntegerExpression("id_Usuario", this);
		correo = new StringExpression("correo", this);
		nombre = new StringExpression("nombre", this);
		contrasenia = new StringExpression("contrasenia", this);
		entrada = new CollectionExpression("ORM_Entrada", this);
		salida = new CollectionExpression("ORM_Salida", this);
		direccion = new StringExpression("direccion", this);
		codigoPostal = new StringExpression("codigoPostal", this);
		es_Vendida = new CollectionExpression("ORM_Es_Vendida", this);
		apellidos = new StringExpression("apellidos", this);
		es_AlquiladaId = new IntegerExpression("es_Alquilada.", this);
		es_Alquilada = new AssociationExpression("es_Alquilada", this);
		es_Favorita = new CollectionExpression("ORM_Es_Favorita", this);
	}
	
	public UsuarioRCriteria(PersistentSession session) {
		this(session.createCriteria(UsuarioR.class));
	}
	
	public UsuarioRCriteria() throws PersistentException {
		this(bbdd_gestion.ProjectMDS2PersistentManager.instance().getSession());
	}
	
	public CasaCriteria createEs_AlquiladaCriteria() {
		return new CasaCriteria(createCriteria("es_Alquilada"));
	}
	
	public CasaCriteria createEs_FavoritaCriteria() {
		return new CasaCriteria(createCriteria("ORM_Es_Favorita"));
	}
	
	public CasaCriteria createEs_VendidaCriteria() {
		return new CasaCriteria(createCriteria("ORM_Es_Vendida"));
	}
	
	public CorreoCriteria createEntradaCriteria() {
		return new CorreoCriteria(createCriteria("ORM_Entrada"));
	}
	
	public CorreoCriteria createSalidaCriteria() {
		return new CorreoCriteria(createCriteria("ORM_Salida"));
	}
	
	public UsuarioR uniqueUsuarioR() {
		return (UsuarioR) super.uniqueResult();
	}
	
	public UsuarioR[] listUsuarioR() {
		java.util.List list = super.list();
		return (UsuarioR[]) list.toArray(new UsuarioR[list.size()]);
	}
}

