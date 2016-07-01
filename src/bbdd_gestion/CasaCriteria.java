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

public class CasaCriteria extends AbstractORMCriteria {
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
	public final IntegerExpression id_casa;
	public final DoubleExpression precio;
	public final DoubleExpression superficie;
	public final IntegerExpression habitaciones;
	public final IntegerExpression banios;
	public final StringExpression tipo;
	public final StringExpression linkMapa;
	public final StringExpression estado;
	public final StringExpression accion;
	public final IntegerExpression numVisitas;
	public final IntegerExpression numFavoritos;
	public final StringExpression visible;
	public final StringExpression dCorta;
	public final StringExpression dLarga;
	public final IntegerExpression vendeId;
	public final AssociationExpression vende;
	public final IntegerExpression mapaId;
	public final AssociationExpression mapa;
	public final CollectionExpression favorita;
	public final CollectionExpression correo;
	public final CollectionExpression fotos;
	public final IntegerExpression alquilaId;
	public final AssociationExpression alquila;
	
	public CasaCriteria(Criteria criteria) {
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
		id_casa = new IntegerExpression("id_casa", this);
		precio = new DoubleExpression("precio", this);
		superficie = new DoubleExpression("superficie", this);
		habitaciones = new IntegerExpression("habitaciones", this);
		banios = new IntegerExpression("banios", this);
		tipo = new StringExpression("tipo", this);
		linkMapa = new StringExpression("linkMapa", this);
		estado = new StringExpression("estado", this);
		accion = new StringExpression("accion", this);
		numVisitas = new IntegerExpression("numVisitas", this);
		numFavoritos = new IntegerExpression("numFavoritos", this);
		visible = new StringExpression("visible", this);
		dCorta = new StringExpression("dCorta", this);
		dLarga = new StringExpression("dLarga", this);
		vendeId = new IntegerExpression("vende.", this);
		vende = new AssociationExpression("vende", this);
		mapaId = new IntegerExpression("mapa.id_mapa", this);
		mapa = new AssociationExpression("mapa", this);
		favorita = new CollectionExpression("ORM_Favorita", this);
		correo = new CollectionExpression("ORM_Correo", this);
		fotos = new CollectionExpression("ORM_Fotos", this);
		alquilaId = new IntegerExpression("alquila.", this);
		alquila = new AssociationExpression("alquila", this);
	}
	
	public CasaCriteria(PersistentSession session) {
		this(session.createCriteria(Casa.class));
	}
	
	public CasaCriteria() throws PersistentException {
		this(bbdd_gestion.ProjectMDS2PersistentManager.instance().getSession());
	}
	
	public ClienteCriteria createVendeCriteria() {
		return new ClienteCriteria(createCriteria("vende"));
	}
	
	public MapaCriteria createMapaCriteria() {
		return new MapaCriteria(createCriteria("mapa"));
	}
	
	public UsuarioRCriteria createFavoritaCriteria() {
		return new UsuarioRCriteria(createCriteria("ORM_Favorita"));
	}
	
	public CorreoCriteria createCorreoCriteria() {
		return new CorreoCriteria(createCriteria("ORM_Correo"));
	}
	
	public FotoCriteria createFotosCriteria() {
		return new FotoCriteria(createCriteria("ORM_Fotos"));
	}
	
	public UsuarioRCriteria createAlquilaCriteria() {
		return new UsuarioRCriteria(createCriteria("alquila"));
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
	
	public Casa uniqueCasa() {
		return (Casa) super.uniqueResult();
	}
	
	public Casa[] listCasa() {
		java.util.List list = super.list();
		return (Casa[]) list.toArray(new Casa[list.size()]);
	}
}

