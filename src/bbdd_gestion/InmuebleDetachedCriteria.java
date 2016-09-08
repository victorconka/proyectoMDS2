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

public class InmuebleDetachedCriteria extends AbstractORMDetachedCriteria {
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
	
	public InmuebleDetachedCriteria() {
		super(bbdd_gestion.Inmueble.class, bbdd_gestion.InmuebleCriteria.class);
		id_Inmueble = new IntegerExpression("id_Inmueble", this.getDetachedCriteria());
		codigoPostalId = new IntegerExpression("codigoPostal.id_CodigoPostal", this.getDetachedCriteria());
		codigoPostal = new AssociationExpression("codigoPostal", this.getDetachedCriteria());
		provinciaId = new IntegerExpression("provincia.id_provincia", this.getDetachedCriteria());
		provincia = new AssociationExpression("provincia", this.getDetachedCriteria());
		municipioId = new IntegerExpression("municipio.id_Municipio", this.getDetachedCriteria());
		municipio = new AssociationExpression("municipio", this.getDetachedCriteria());
		linkFoto = new StringExpression("linkFoto", this.getDetachedCriteria());
		direccion = new StringExpression("direccion", this.getDetachedCriteria());
		foto = new CollectionExpression("ORM_Foto", this.getDetachedCriteria());
		extra = new CollectionExpression("ORM_Extra", this.getDetachedCriteria());
	}
	
	public InmuebleDetachedCriteria(DetachedCriteria aDetachedCriteria) {
		super(aDetachedCriteria, bbdd_gestion.InmuebleCriteria.class);
		id_Inmueble = new IntegerExpression("id_Inmueble", this.getDetachedCriteria());
		codigoPostalId = new IntegerExpression("codigoPostal.id_CodigoPostal", this.getDetachedCriteria());
		codigoPostal = new AssociationExpression("codigoPostal", this.getDetachedCriteria());
		provinciaId = new IntegerExpression("provincia.id_provincia", this.getDetachedCriteria());
		provincia = new AssociationExpression("provincia", this.getDetachedCriteria());
		municipioId = new IntegerExpression("municipio.id_Municipio", this.getDetachedCriteria());
		municipio = new AssociationExpression("municipio", this.getDetachedCriteria());
		linkFoto = new StringExpression("linkFoto", this.getDetachedCriteria());
		direccion = new StringExpression("direccion", this.getDetachedCriteria());
		foto = new CollectionExpression("ORM_Foto", this.getDetachedCriteria());
		extra = new CollectionExpression("ORM_Extra", this.getDetachedCriteria());
	}
	
	public CodigoPostalDetachedCriteria createCodigoPostalCriteria() {
		return new CodigoPostalDetachedCriteria(createCriteria("codigoPostal"));
	}
	
	public ProvinciaDetachedCriteria createProvinciaCriteria() {
		return new ProvinciaDetachedCriteria(createCriteria("provincia"));
	}
	
	public MunicipioDetachedCriteria createMunicipioCriteria() {
		return new MunicipioDetachedCriteria(createCriteria("municipio"));
	}
	
	public FotoDetachedCriteria createFotoCriteria() {
		return new FotoDetachedCriteria(createCriteria("ORM_Foto"));
	}
	
	public ExtraDetachedCriteria createExtraCriteria() {
		return new ExtraDetachedCriteria(createCriteria("ORM_Extra"));
	}
	
	public Inmueble uniqueInmueble(PersistentSession session) {
		return (Inmueble) super.createExecutableCriteria(session).uniqueResult();
	}
	
	public Inmueble[] listInmueble(PersistentSession session) {
		List list = super.createExecutableCriteria(session).list();
		return (Inmueble[]) list.toArray(new Inmueble[list.size()]);
	}
}

