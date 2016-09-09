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

public class CasaDetachedCriteria extends AbstractORMDetachedCriteria {
	public final IntegerExpression id_Inmueble;
	public final IntegerExpression codigoPostalId;
	public final AssociationExpression codigoPostal;
	public final IntegerExpression provinciaId;
	public final AssociationExpression provincia;
	public final IntegerExpression municipioId;
	public final AssociationExpression municipio;
	public final StringExpression direccion;
	public final CollectionExpression extra;
	public final IntegerExpression id_casa;
	public final DoubleExpression precio;
	public final DoubleExpression superficie;
	public final IntegerExpression habitaciones;
	public final IntegerExpression banios;
	public final StringExpression tipo;
	public final StringExpression estado;
	public final StringExpression accion;
	public final IntegerExpression numVisitas;
	public final IntegerExpression numFavoritos;
	public final StringExpression visible;
	public final StringExpression dCorta;
	public final StringExpression dLarga;
	public final DateExpression fecha;
	public final IntegerExpression vendeId;
	public final AssociationExpression vende;
	public final IntegerExpression mapaId;
	public final AssociationExpression mapa;
	public final CollectionExpression favorita;
	public final CollectionExpression correo;
	public final CollectionExpression fotos;
	public final IntegerExpression alquilaId;
	public final AssociationExpression alquila;
	
	public CasaDetachedCriteria() {
		super(bbdd_gestion.Casa.class, bbdd_gestion.CasaCriteria.class);
		id_Inmueble = new IntegerExpression("id_Inmueble", this.getDetachedCriteria());
		codigoPostalId = new IntegerExpression("codigoPostal.id_CodigoPostal", this.getDetachedCriteria());
		codigoPostal = new AssociationExpression("codigoPostal", this.getDetachedCriteria());
		provinciaId = new IntegerExpression("provincia.id_provincia", this.getDetachedCriteria());
		provincia = new AssociationExpression("provincia", this.getDetachedCriteria());
		municipioId = new IntegerExpression("municipio.id_Municipio", this.getDetachedCriteria());
		municipio = new AssociationExpression("municipio", this.getDetachedCriteria());
		direccion = new StringExpression("direccion", this.getDetachedCriteria());
		extra = new CollectionExpression("ORM_Extra", this.getDetachedCriteria());
		id_casa = new IntegerExpression("id_casa", this.getDetachedCriteria());
		precio = new DoubleExpression("precio", this.getDetachedCriteria());
		superficie = new DoubleExpression("superficie", this.getDetachedCriteria());
		habitaciones = new IntegerExpression("habitaciones", this.getDetachedCriteria());
		banios = new IntegerExpression("banios", this.getDetachedCriteria());
		tipo = new StringExpression("tipo", this.getDetachedCriteria());
		estado = new StringExpression("estado", this.getDetachedCriteria());
		accion = new StringExpression("accion", this.getDetachedCriteria());
		numVisitas = new IntegerExpression("numVisitas", this.getDetachedCriteria());
		numFavoritos = new IntegerExpression("numFavoritos", this.getDetachedCriteria());
		visible = new StringExpression("visible", this.getDetachedCriteria());
		dCorta = new StringExpression("dCorta", this.getDetachedCriteria());
		dLarga = new StringExpression("dLarga", this.getDetachedCriteria());
		fecha = new DateExpression("fecha", this.getDetachedCriteria());
		vendeId = new IntegerExpression("vende.", this.getDetachedCriteria());
		vende = new AssociationExpression("vende", this.getDetachedCriteria());
		mapaId = new IntegerExpression("mapa.id_mapa", this.getDetachedCriteria());
		mapa = new AssociationExpression("mapa", this.getDetachedCriteria());
		favorita = new CollectionExpression("ORM_Favorita", this.getDetachedCriteria());
		correo = new CollectionExpression("ORM_Correo", this.getDetachedCriteria());
		fotos = new CollectionExpression("ORM_Fotos", this.getDetachedCriteria());
		alquilaId = new IntegerExpression("alquila.", this.getDetachedCriteria());
		alquila = new AssociationExpression("alquila", this.getDetachedCriteria());
	}
	
	public CasaDetachedCriteria(DetachedCriteria aDetachedCriteria) {
		super(aDetachedCriteria, bbdd_gestion.CasaCriteria.class);
		id_Inmueble = new IntegerExpression("id_Inmueble", this.getDetachedCriteria());
		codigoPostalId = new IntegerExpression("codigoPostal.id_CodigoPostal", this.getDetachedCriteria());
		codigoPostal = new AssociationExpression("codigoPostal", this.getDetachedCriteria());
		provinciaId = new IntegerExpression("provincia.id_provincia", this.getDetachedCriteria());
		provincia = new AssociationExpression("provincia", this.getDetachedCriteria());
		municipioId = new IntegerExpression("municipio.id_Municipio", this.getDetachedCriteria());
		municipio = new AssociationExpression("municipio", this.getDetachedCriteria());
		direccion = new StringExpression("direccion", this.getDetachedCriteria());
		extra = new CollectionExpression("ORM_Extra", this.getDetachedCriteria());
		id_casa = new IntegerExpression("id_casa", this.getDetachedCriteria());
		precio = new DoubleExpression("precio", this.getDetachedCriteria());
		superficie = new DoubleExpression("superficie", this.getDetachedCriteria());
		habitaciones = new IntegerExpression("habitaciones", this.getDetachedCriteria());
		banios = new IntegerExpression("banios", this.getDetachedCriteria());
		tipo = new StringExpression("tipo", this.getDetachedCriteria());
		estado = new StringExpression("estado", this.getDetachedCriteria());
		accion = new StringExpression("accion", this.getDetachedCriteria());
		numVisitas = new IntegerExpression("numVisitas", this.getDetachedCriteria());
		numFavoritos = new IntegerExpression("numFavoritos", this.getDetachedCriteria());
		visible = new StringExpression("visible", this.getDetachedCriteria());
		dCorta = new StringExpression("dCorta", this.getDetachedCriteria());
		dLarga = new StringExpression("dLarga", this.getDetachedCriteria());
		fecha = new DateExpression("fecha", this.getDetachedCriteria());
		vendeId = new IntegerExpression("vende.", this.getDetachedCriteria());
		vende = new AssociationExpression("vende", this.getDetachedCriteria());
		mapaId = new IntegerExpression("mapa.id_mapa", this.getDetachedCriteria());
		mapa = new AssociationExpression("mapa", this.getDetachedCriteria());
		favorita = new CollectionExpression("ORM_Favorita", this.getDetachedCriteria());
		correo = new CollectionExpression("ORM_Correo", this.getDetachedCriteria());
		fotos = new CollectionExpression("ORM_Fotos", this.getDetachedCriteria());
		alquilaId = new IntegerExpression("alquila.", this.getDetachedCriteria());
		alquila = new AssociationExpression("alquila", this.getDetachedCriteria());
	}
	
	public ClienteDetachedCriteria createVendeCriteria() {
		return new ClienteDetachedCriteria(createCriteria("vende"));
	}
	
	public MapaDetachedCriteria createMapaCriteria() {
		return new MapaDetachedCriteria(createCriteria("mapa"));
	}
	
	public UsuarioRDetachedCriteria createFavoritaCriteria() {
		return new UsuarioRDetachedCriteria(createCriteria("ORM_Favorita"));
	}
	
	public CorreoDetachedCriteria createCorreoCriteria() {
		return new CorreoDetachedCriteria(createCriteria("ORM_Correo"));
	}
	
	public FotoDetachedCriteria createFotosCriteria() {
		return new FotoDetachedCriteria(createCriteria("ORM_Fotos"));
	}
	
	public UsuarioRDetachedCriteria createAlquilaCriteria() {
		return new UsuarioRDetachedCriteria(createCriteria("alquila"));
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
	
	public ExtraDetachedCriteria createExtraCriteria() {
		return new ExtraDetachedCriteria(createCriteria("ORM_Extra"));
	}
	
	public Casa uniqueCasa(PersistentSession session) {
		return (Casa) super.createExecutableCriteria(session).uniqueResult();
	}
	
	public Casa[] listCasa(PersistentSession session) {
		List list = super.createExecutableCriteria(session).list();
		return (Casa[]) list.toArray(new Casa[list.size()]);
	}
}

