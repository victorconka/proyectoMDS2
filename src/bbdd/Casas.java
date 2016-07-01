package bbdd;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;

import org.orm.PersistentException;
import org.orm.PersistentTransaction;

import UserInterface.Utils;
import bbdd_gestion.Casa;
import bbdd_gestion.CasaCriteria;
import bbdd_gestion.CasaDAO;
import bbdd_gestion.CodigoPostal;
import bbdd_gestion.CodigoPostalDAO;
import bbdd_gestion.Extra;
import bbdd_gestion.ExtraDAO;
import bbdd_gestion.Mapa;
import bbdd_gestion.MapaDAO;
import bbdd_gestion.Municipio;
import bbdd_gestion.MunicipioDAO;
import bbdd_gestion.ProjectMDS2PersistentManager;
import bbdd_gestion.Provincia;
import bbdd_gestion.ProvinciaDAO;
import bbdd_gestion.UsuarioR;
import bbdd_gestion.UsuarioRCriteria;
import bbdd_gestion.UsuarioRDAO;

public class Casas {
	public BDPrincipal _bd_prin_casas;
	public Casa[] _conts_casa = new Casa[0];

	public boolean registrarVivienda(String aDireccion, String aMunicipio, String aProvincia, String aCp, String[] aFotos, String aPrecio, String aSuperficie, String aHabitaciones, String aBanios, String aTipo, String[] aExtras, String aEstado, String aAccion, String aMapa)   throws PersistentException{
		Casa c = null;
		Municipio m = null;
		Provincia p = null;
		CodigoPostal cp = null;
		Mapa ma = null;
		PersistentTransaction t = null;
		
		try {
			t = ProjectMDS2PersistentManager.instance().getSession().beginTransaction();
			
			
			//es importante asegurarse que los municipios/provincias... no existan de antelacion para
			//evitar inconsistencia y redundancia de datos
			p = ProvinciaDAO.createProvincia();
			p = bbdd_gestion.ProvinciaDAO.loadProvinciaByQuery("provincia LIKE '"+aProvincia+"'", null);
			if(p == null){
				System.out.println("provincia no encontrada");
				p = ProvinciaDAO.createProvincia();
				p.setProvincia(aProvincia);
				p.setCodigoPostal(cp);
				ProvinciaDAO.save(p);
			}
			
			cp = CodigoPostalDAO.createCodigoPostal();
			cp = bbdd_gestion.CodigoPostalDAO.loadCodigoPostalByQuery("codigo_postal LIKE '"+aCp+"'", null);
			//asignamos el valor del codigo postal solo en caso de no existir	
			if(cp == null){
				System.out.println("cp no encontrada");
				cp = CodigoPostalDAO.createCodigoPostal();
				cp.setCodigo_postal(aCp);
				cp.setMunicipio(m); //no es obligatorio
				cp.setProvincia(p);
				CodigoPostalDAO.save(cp);			
			}	
			
			m = MunicipioDAO.createMunicipio();
			m = bbdd_gestion.MunicipioDAO.loadMunicipioByQuery("municipio LIKE '"+aMunicipio+"'", null);
			if(m == null){
				//MUNICIPIO NO ENCONTRADO
				System.out.println("municipio no encontrado");
				m = MunicipioDAO.createMunicipio();
				m.setMunicipio(aMunicipio);
				m.setPertenece(p);
				MunicipioDAO.save(m);
			}
			
			ma = MapaDAO.createMapa();						
			
			c = CasaDAO.createCasa();
			c.setDireccion(aDireccion);
			c.setMunicipio(m);
			c.setProvincia(p);
			c.setCodigoPostal(cp);
			//c.setLinkFoto(aFotos[0]);
			c.setPrecio(Double.parseDouble(aPrecio));
			
			Double sup = null;
			if(aSuperficie != null && aSuperficie != ""){
				sup = Double.parseDouble(aSuperficie);
			}
			c.setSuperficie(sup);
			
			c.setHabitaciones(Integer.parseInt(aHabitaciones));
			c.setBanios(Integer.parseInt(aBanios));
			c.setTipo(aTipo);
			//c.setExtras;
			//-----------------------------------------------------------------------
			//--------EXTRAS
			if(aExtras != null && aExtras.length > 0){
				ArrayList<Extra> el = new ArrayList<Extra>();
				Extra e = null;
				for(String s : aExtras){
					e = ExtraDAO.createExtra();
					e = ExtraDAO.loadExtraByQuery("nombreextra LIKE '"+s+"'", null);
					if(e == null){					
						//crear en la bbdd y añadir
						e = ExtraDAO.createExtra();
						e.setNombreExtra(s);
						ExtraDAO.save(e);
					}
					//en cualquier caso añadimos extra
					//simplemente aniadir
					el.add(e);
				}
			}	
			//-----------------------------------------------------------------------			
			c.setEstado(aEstado);
			c.setAccion(aAccion);
			c.setMapa(ma);
			CasaDAO.save(c);		
			MapaDAO.save(ma);
			
			UsuarioR u = UsuarioRDAO.getUsuarioRByORMID(Utils.id);
			u.es_Vendida.add(c);
			UsuarioRDAO.save(u);
			
			t.commit();
			
			return true;
		}catch(Exception e) {
			e.printStackTrace();
			t.rollback();
		}
		return false;
	}

	public Casa[] Buscar(String aAccion, String aCp, String aProvincia, String aPrecio, Double aSuperficie, Integer aNHabitaciones, String aTipo, String aEstado, String[] aExtras)   throws PersistentException{
		
		Casa casas[] = null;
		CasaCriteria c = null;
		CodigoPostal cp = null;		

		try{
			//definimos el criterio de busqueda
			c = new CasaCriteria();
					
			//check accion
			if(aAccion != null && aAccion.length() > 1){
				if(String.valueOf(aAccion).toLowerCase().equals("comprar")){
					//System.out.println("accion comprar");
					aAccion = "Vender";
				}
				//System.out.println(aAccion);
				c.accion.like(aAccion);				
			}
			
			//check codigo postal
			//codigo postal funciona con null/empty/####
			
			if(aCp != null  && aCp.length() == 5){
				
				//-------------------------------LAS BUSQUEDAS DE RELACIONES NO FUNCIONAN CON CREAR OBJETO
				//-------------------------------ES NECESARIO CREAR SUBCONSULTA
				
				cp = CodigoPostalDAO.createCodigoPostal();
				cp = bbdd_gestion.CodigoPostalDAO.loadCodigoPostalByQuery("codigo_postal = '"+aCp+"'", null);			
				c.codigoPostalId.eq(cp.getORMID());			
			}
			
			//check provincia
			if(aProvincia != null && aProvincia.length() > 1){
				Provincia p = ProvinciaDAO.createProvincia();
				p = bbdd_gestion.ProvinciaDAO.loadProvinciaByQuery("provincia LIKE '"+aProvincia+"'", null);
				
				if(p!= null){//provincia existe					
					c.provinciaId.eq(p.getORMID());
				}
			}
			
			//check precio
			if(aPrecio != null && aPrecio.length() > 0){
				c.precio.le(Double.parseDouble(aPrecio));
			}
			//check superficie
			if(aSuperficie != null && aSuperficie > 0.0){
				c.superficie.le(aSuperficie);
	
			}
			//check nHabitaciones
			if(aNHabitaciones != null && aNHabitaciones > 0){
				c.habitaciones.between(0, aNHabitaciones.intValue());
			}
			//check tipo
			if(aTipo != null && aTipo.length() > 0){
				c.tipo.like(aTipo);
			}
			//check estado
			if(aEstado != null && aEstado != ""){
				c.estado.like(aEstado);
			}
			//los extras hay que comparar tras recuperar todas las casas
			if(aExtras != null && aExtras.length > 0){
				//recuperamos al menos aquellos elementos que son susceptibles
				//de cumplir el requisito
				//que no sea empty, al comparar sale error, no es capaz de realizar la comparacion 
				//por alguna razón...
				c.extra.isNotEmpty();
				
			}
			
			casas = bbdd_gestion.CasaDAO.listCasaByCriteria(c);	
			
			//ahora hay que eliminar aquellos que no cumplen el requisito
			if(aExtras != null && casas != null && casas.length > 0 && aExtras.length > 0){
				
				//creamos la lista de extras a comparar
				ArrayList<Extra> al = new ArrayList<Extra>();
				Extra ext =  null;
				//metemos extras en arraylist
				for(String s : aExtras){
					ext = bbdd_gestion.ExtraDAO.createExtra();
					ext = bbdd_gestion.ExtraDAO.loadExtraByQuery("nombreextra LIKE '"+s+"'", null);
					if(ext != null){//nos aseguramos de que el extra existe y de paso se hace un test
						//asi sabemos de donde viene el error
						al.add(ext);
					}else{
						System.out.println("este extra proviene del listado proporcionado por la interfaz y \n no debería de no estar en la bbdd");
					}
				}
				
				ArrayList<Casa> cs2 = new ArrayList<Casa>();
				for (Casa v : casas){
					//si numero de extras es suficiente
					if(v.extra.size() >= al.size()){
						boolean b = true;
						//comprobamos que todos los criterios extra estan presentes en la casa resultado
						for(Extra e : al){
							if(!v.extra.contains(e)){
								b = false;
								break;//no queremos dar vueltas sin sentido
							}
						}
						if(b == true){
							cs2.add(v);
						}
					}	
				}
				casas = cs2.toArray(new Casa[cs2.size()]);	
										
			}
			
				
			System.out.println("----------------------");
			System.out.println("recibo");
			System.out.println("acc>" + aAccion+"<");
			System.out.println("cp>" + aCp +"<");
			System.out.println("prov>" + aProvincia+"<");
			System.out.println("prec>"+aPrecio+"<");
			System.out.println("sup>"+aSuperficie+"<");
			System.out.println("nh>" + aNHabitaciones+"<");
			System.out.println("atipo>" + aTipo+"<");
			System.out.println("aestado>"+aEstado+"<");
			System.out.println("extra>" +aExtras+"<");
			System.out.println("----------------------");
			System.out.println(casas.length);
			
			return casas;
		}catch(Exception e) {
			e.printStackTrace();
		}
		return null;
		
	}

	public boolean eliminarVivienda(String aId_usuario, String aId_casa)   throws PersistentException{
		//PersistentTransaction t = bbdd_gestion.ProjectMDS2PersistentManager.instance().getSession().beginTransaction();
		Casa c = CasaDAO.loadCasaByQuery("inmuebleid_inmueble = '"+aId_casa+"'", null);
		if (c != null) System.out.println("No soy nulo " +c.getORMID());
		UsuarioR u = UsuarioRDAO.loadUsuarioRByORMID(Integer.parseInt(aId_usuario));
		Iterator i = u.es_Vendida.getIterator();
		while (i.hasNext())
			if (i.next().equals(c))
				u.es_Vendida.remove(c);
		boolean b = CasaDAO.delete(c);
		//st.commit();
		return b;
	}

	public boolean modificarVivienda(String aDireccion, String aMunicipio, String aProvincia, String aCp, String[] aFotos, String aPrecio, String aSuperficie, String aHabitaciones, String aBanios, String aTipo, String[] aExtras, String aEstado, String aAccion, String aMapa)   throws PersistentException {
		Casa c = null;
		Municipio m = null;
		Provincia p = null;
		CodigoPostal cp = null;
		Mapa ma = null;
		PersistentTransaction t = null;

		try {
			t = ProjectMDS2PersistentManager.instance().getSession().beginTransaction();


			//es importante asegurarse que los municipios/provincias... no existan de antelacion para
			//evitar inconsistencia y redundancia de datos
			p = ProvinciaDAO.createProvincia();
			p = bbdd_gestion.ProvinciaDAO.loadProvinciaByQuery("provincia LIKE '"+aProvincia+"'", null);
			if(p == null){
				System.out.println("provincia no encontrada");
				p = ProvinciaDAO.createProvincia();
				p.setProvincia(aProvincia);
				p.setCodigoPostal(cp);
				ProvinciaDAO.save(p);
			}

			cp = CodigoPostalDAO.createCodigoPostal();
			cp = bbdd_gestion.CodigoPostalDAO.loadCodigoPostalByQuery("codigo_postal LIKE '"+aCp+"'", null);
			//asignamos el valor del codigo postal solo en caso de no existir	
			if(cp == null){
				System.out.println("cp no encontrada");
				cp = CodigoPostalDAO.createCodigoPostal();
				cp.setCodigo_postal(aCp);
				cp.setMunicipio(m); //no es obligatorio
				cp.setProvincia(p);
				CodigoPostalDAO.save(cp);			
			}	

			m = MunicipioDAO.createMunicipio();
			m = bbdd_gestion.MunicipioDAO.loadMunicipioByQuery("municipio LIKE '"+aMunicipio+"'", null);
			if(m == null){
				//MUNICIPIO NO ENCONTRADO
				System.out.println("municipio no encontrado");
				m = MunicipioDAO.createMunicipio();
				m.setMunicipio(aMunicipio);
				m.setPertenece(p);
				MunicipioDAO.save(m);
			}

			ma = MapaDAO.createMapa();						

			c = CasaDAO.createCasa();
			c.setDireccion(aDireccion);
			c.setMunicipio(m);
			c.setProvincia(p);
			c.setCodigoPostal(cp);
			//c.setLinkFoto(aFotos[0]);
			c.setPrecio(Double.parseDouble(aPrecio));

			Double sup = null;
			if(aSuperficie != null && aSuperficie != ""){
				sup = Double.parseDouble(aSuperficie);
			}
			c.setSuperficie(sup);

			c.setHabitaciones(Integer.parseInt(aHabitaciones));
			c.setBanios(Integer.parseInt(aBanios));
			c.setTipo(aTipo);
			//c.setExtras;
			//-----------------------------------------------------------------------
			//--------EXTRAS
			if(aExtras != null && aExtras.length > 0){
				ArrayList<Extra> el = new ArrayList<Extra>();
				Extra e = null;
				for(String s : aExtras){
					e = ExtraDAO.createExtra();
					e = ExtraDAO.loadExtraByQuery("nombreextra LIKE '"+s+"'", null);
					if(e == null){					
						//crear en la bbdd y añadir
						e = ExtraDAO.createExtra();
						e.setNombreExtra(s);
						ExtraDAO.save(e);
					}
					//en cualquier caso añadimos extra
					//simplemente aniadir
					el.add(e);
				}
			}	
			//-----------------------------------------------------------------------			
			c.setEstado(aEstado);
			c.setAccion(aAccion);
			c.setMapa(ma);
			CasaDAO.save(c);		
			MapaDAO.save(ma);

			t.commit();

			return true;
		}catch(Exception e) {
			e.printStackTrace();
			t.rollback();
		}
		return false;
	}

	public boolean favCasa(String aId_casa, String aId_usuario)   throws PersistentException {
		PersistentTransaction t = null;
		try{
			t = ProjectMDS2PersistentManager.instance().getSession().beginTransaction();
			CasaCriteria c = new CasaCriteria();
			c.id_casa.eq(Integer.valueOf(aId_casa));
			Casa casa = CasaDAO.createCasa();
			casa = CasaDAO.loadCasaByCriteria(c);
			
			if(casa != null){
				UsuarioRCriteria c1 = new UsuarioRCriteria();
				c1.id_Usuario.eq(Integer.valueOf(aId_usuario));
				UsuarioR u = UsuarioRDAO.createUsuarioR();
				u = UsuarioRDAO.loadUsuarioRByCriteria(c1);
				
				u.es_Favorita.add(casa);
				
				UsuarioRDAO.save(u);
				t.commit();
			}else{
				System.out.println("Casa para fav no existe ?!?!");
			}
			}catch(Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	public boolean modificarEstadoVivienda(String aId_usuario, String aId_vivienda, String aEstado)   throws PersistentException{
		CasaCriteria cr = new CasaCriteria();
		cr.id_casa.eq(Integer.valueOf(aId_vivienda));
		Casa c = CasaDAO.createCasa();
		c = CasaDAO.loadCasaByORMID(Integer.parseInt(aId_vivienda));
		System.out.println(aEstado);
		System.out.println(c.getORMID());
		c.setVisible(aEstado);
		boolean b = CasaDAO.save(c);
		PersistentTransaction t = ProjectMDS2PersistentManager.instance().getSession().beginTransaction();
		t.commit();
		return b;
	}

	public Casa cargarDatosVivienda(String aId_vivienda)   throws PersistentException{
		return CasaDAO.getCasaByORMID(Integer.parseInt(aId_vivienda));
	}

	public Casa[] cargarViviendasPropias(String aId_usuario)  throws PersistentException {
		UsuarioRCriteria c1 = new UsuarioRCriteria();
		c1.id_Usuario.eq(Integer.valueOf(aId_usuario));
		UsuarioR u = UsuarioRDAO.createUsuarioR();
		u = UsuarioRDAO.loadUsuarioRByCriteria(c1);
		return u.es_Vendida.toArray();
	}
}