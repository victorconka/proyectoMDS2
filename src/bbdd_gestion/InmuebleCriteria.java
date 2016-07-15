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

public class InmuebleCriteria extends AbstractORMCriteria {
	public final IntegerExpression id_Inmueble;
	public final IntegerExpression codigoPostalId;
	public final AssociationExpression codigoPostal;
	public final IntegerExpression provinciaId;
	public final AssociationExpression provincia;
	public final IntegerExpression municipioId;
	public final AssociationExpression municipio;
	public final StringExpression linkFoto;
	public final StringExpression direccion;
	public final CollectionExpression foto;
	public final CollectionExpression extra;
	
	public InmuebleCriteria(Criteria criteria) {
		super(criteria);
		id_Inmueble = new IntegerExpression("id_Inmueble", this);
		codigoPostalId = new IntegerExpression("codigoPostal.id_CodigoPostal", this);
		codigoPostal = new AssociationExpression("codigoPostal", this);
		provinciaId = new IntegerExpression("provincia.id_provincia", this);
		provincia = new AssociationExpression("provincia", this);
		municipioId = new IntegerExpression("municipio.id_Municipio", this);
		municipio = new AssociationExpression("municipio", this);
		linkFoto = new StringExpression("linkFoto", this);
		direccion = new StringExpression("direccion", this);
		foto = new CollectionExpression("ORM_Foto", this);
		extra = new CollectionExpression("ORM_Extra", this);
	}
	
	public InmuebleCriteria(PersistentSession session) {
		this(session.createCriteria(Inmueble.class));
	}
	
	public InmuebleCriteria() throws PersistentException {
		this(bbdd_gestion.ProjectMDS2PersistentManager.instance().getSession());
	}
	
	public CodigoPostalCriteria createCodigoPostalCriteria() {
		return new CodigoPostalCriteria(createCriteria("codigoPostal"));
	}
	
	public ProvinciaCriteria createProvinciaCriteria() {
		return new ProvinciaCriteria(createCriteria("provincia"));
	}
	
	public MunicipioCriteria createMunicipioCriteria() {
		return new MunicipioCriteria(createCriteria("municipio"));
	}
	
	public FotoCriteria createFotoCriteria() {
		return new FotoCriteria(createCriteria("ORM_Foto"));
	}
	
	public ExtraCriteria createExtraCriteria() {
		return new ExtraCriteria(createCriteria("ORM_Extra"));
	}
	
	public Inmueble uniqueInmueble() {
		return (Inmueble) super.uniqueResult();
	}
	
	public Inmueble[] listInmueble() {
		java.util.List list = super.list();
		return (Inmueble[]) list.toArray(new Inmueble[list.size()]);
	}
}

