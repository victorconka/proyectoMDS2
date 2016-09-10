package bbdd;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
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
import bbdd_gestion.ExtraCriteria;
import bbdd_gestion.ExtraDAO;
import bbdd_gestion.Foto;
import bbdd_gestion.FotoCriteria;
import bbdd_gestion.FotoDAO;
import bbdd_gestion.Mapa;
import bbdd_gestion.MapaCriteria;
import bbdd_gestion.MapaDAO;
import bbdd_gestion.Municipio;
import bbdd_gestion.MunicipioCriteria;
import bbdd_gestion.MunicipioDAO;
import bbdd_gestion.ProjectMDS2PersistentManager;
import bbdd_gestion.Provincia;
import bbdd_gestion.ProvinciaCriteria;
import bbdd_gestion.ProvinciaDAO;
import bbdd_gestion.UsuarioR;
import bbdd_gestion.UsuarioRCriteria;
import bbdd_gestion.UsuarioRDAO;

public class Casas {
	public BDPrincipal _bd_prin_casas;
	public Casa[] _conts_casa = new Casa[0];

	public boolean registrarVivienda(String aDireccion, String aMunicipio, String aProvincia, String aCp, String[] aFotos, 
			String aPrecio, String aSuperficie, String aHabitaciones, String aBanios, String aTipo, String[] aExtras, 
			String aEstado, String aAccion, String aMapa, String aDCorta, String aDLarga, String aVisible)   throws PersistentException{
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
			cp = CodigoPostalDAO.createCodigoPostal();
			cp = bbdd_gestion.CodigoPostalDAO.loadCodigoPostalByQuery("codigo_postal LIKE '"+aCp+"'", null);
			//asignamos el valor del codigo postal solo en caso de no existir	
			if(cp == null){
				System.out.println("cp no encontrada");
				cp = CodigoPostalDAO.createCodigoPostal();
				cp.setCodigo_postal(aCp);
				//cp.setMunicipio(m); //no es obligatorio
				//cp.setProvincia(p);
				CodigoPostalDAO.save(cp);			
			}	
			
			p = ProvinciaDAO.createProvincia();
			p = bbdd_gestion.ProvinciaDAO.loadProvinciaByQuery("provincia LIKE '"+aProvincia+"'", null);
			if(p == null){
				System.out.println("provincia no encontrada");
				p = ProvinciaDAO.createProvincia();
				p.setProvincia(aProvincia.toUpperCase());
				p.setCodigoPostal(cp);
				ProvinciaDAO.save(p);
			}	
			
			m = MunicipioDAO.createMunicipio();
			m = bbdd_gestion.MunicipioDAO.loadMunicipioByQuery("municipio LIKE '"+aMunicipio+"'", null);
			if(m == null){
				//MUNICIPIO NO ENCONTRADO
				System.out.println("municipio no encontrado");
				m = MunicipioDAO.createMunicipio();
				m.setMunicipio(aMunicipio.toUpperCase());
				m.setPertenece(p);
				MunicipioDAO.save(m);
			}
			
			
			
			c = CasaDAO.createCasa();
			c.setDireccion(aDireccion);
			c.setMunicipio(m);
			c.setProvincia(p);
			c.setCodigoPostal(cp);

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
				Extra e = null;
				for(String s : aExtras){
					e = ExtraDAO.createExtra();
					e = ExtraDAO.loadExtraByQuery("nombreextra LIKE '"+s+"'", null);
					//si extra no existe crearlo
					if(e == null){					
						//crear en la bbdd y añadir
						e = ExtraDAO.createExtra();
						e.setNombreExtra(s);
						//guardamos extra nuevo
						ExtraDAO.save(e);
						//hacemos commit
						t.commit();
						//reiniciar transaccion
						t = ProjectMDS2PersistentManager.instance().getSession().beginTransaction();
						//cargamos dicho extra en el array
						e = ExtraDAO.loadExtraByQuery("nombreextra LIKE '"+s+"'", null);
					}
					//en cualquier caso añadimos extra
					//simplemente aniadir
					c.extra.add(e);
				}
			}
			
			//-----------------------------------------------------------------------			
			
			c.setEstado(aEstado);
			c.setAccion(aAccion);
			c.setMapa(ma);
			//c.setVisible("Disponible");
			
			if(aDCorta != null){
				if(aDCorta.length() > 150){
					aDCorta = aDCorta.substring(0, 150);
				}
				c.setdCorta(aDCorta);
			}
			
			if(aDLarga != null){
				if(aDLarga.length()>1023){
					aDLarga = aDLarga.substring(0, 1023);
				}
				c.setdLarga(aDLarga);
			}
			
			c.setVisible(aVisible);
			CasaDAO.save(c);
			//guardamos las fotos
			/*
			if(aFotos != null && aFotos.length > 0){
				bbdd_gestion.Foto photo;
				for(String f : aFotos){
					photo = new bbdd_gestion.Foto();
					photo.setLinkFoto(f);
					photo.setCasa(c);
					FotoDAO.save(photo);
				}
			}
			*/
			//guardamos fotos de nuevo
			bbdd_gestion.Foto photo;
			FotoCriteria fc;
			HashSet<String> hs = new HashSet<String>(Arrays.asList(aFotos));
			for(String f : hs){
				fc = new FotoCriteria();
				fc.linkFoto.eq(f);
				if(f.trim().length() > 0){
					photo = new bbdd_gestion.FotoDAO().createFoto();
					photo.setLinkFoto(f);
					FotoDAO.save(photo);
					c.fotos.add(photo);
				}
			}
			/*
			MapaCriteria mac = new MapaCriteria();
			mac.url.eq(aMapa);
			ma=bbdd_gestion.MapaDAO.loadMapaByCriteria(mac);
			if(ma!=null){
				ma.casas.add(c);
			}else{
			*/
				ma = MapaDAO.createMapa();		
				ma.setUrl(aMapa);
				//calculamos la longitud y latitud
				//nos aseguramos que el mapa contiene long/lat
				if(aMapa.contains("@")){
					String[] splitURL = aMapa.split("/");
					String[] splitXYZ;

					for(String f : splitURL){
						if(f.contains("@")){
							f = f.replace("@", "");
							if(f.contains("z"))
								f = f.replace("z", "");
							splitXYZ = f.split(",");
							ma.setLongitud(splitXYZ[0]);
							ma.setLatitud(splitXYZ[1]);
							break;
						}
					}
				}	
				/*
			}
		*/
			ma.casas.add(c);
			MapaDAO.save(ma);
			UsuarioR u = UsuarioRDAO.getUsuarioRByORMID(Utils.id);
			u.es_Vendida.add(c);
			UsuarioRDAO.save(u);
			
			t.commit();
			ProjectMDS2PersistentManager.instance().disposePersistentManager();
			return true;
		}catch(Exception e) {
			e.printStackTrace();
			t.rollback();
		}
		ProjectMDS2PersistentManager.instance().disposePersistentManager();
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
				//no es posible verificar				
				//c.extra.isNotEmpty();				
			}
			
			//esto es para encontrar casas con atributo visible puesto a si.
			c.visible.like("si");
			
			//se realiza la consulta y se obtiene el listado de casas que cumplan los criterios "criteria".
			casas = bbdd_gestion.CasaDAO.listCasaByCriteria(c);			
		
			//ahora hay que eliminar aquellos que no cumplen el requisito
			if(aExtras != null && casas != null && casas.length > 0 && aExtras.length > 0){		
				//creamos la lista de extras a comparar
				ArrayList<String> extrasCasa;
				//lista de casas resultante
				ArrayList<Casa> cs2 = new ArrayList<Casa>();
				ArrayList<String> aExtrasList = new ArrayList<String>(Arrays.asList(aExtras));
				Iterator<Extra> it;
				Extra ex = bbdd_gestion.ExtraDAO.createExtra();
				for (Casa v : casas){
					it = v.extra.getIterator();				
					extrasCasa = new ArrayList<String>();
					while(it.hasNext()){
						ex = it.next();
						extrasCasa.add(ex.getNombreExtra().toLowerCase());
					}
					if(extrasCasa.containsAll(aExtrasList)){
						cs2.add(v);
					}

				}
				casas = cs2.toArray(new Casa[cs2.size()]);									
			}
			
			
			/*	
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
			System.out.println("casas.length>" + casas.length);
			System.out.println("----------------------");
			*/
			return casas;
		}catch(Exception e) {
			e.printStackTrace();
		}
		return null;
		
	}

	public boolean eliminarVivienda(String aId_usuario, String aId_casa)   throws PersistentException{
		Casa c = CasaDAO.loadCasaByQuery("inmuebleid_inmueble = '"+aId_casa+"'", null);
		UsuarioR u = UsuarioRDAO.loadUsuarioRByORMID(Integer.parseInt(aId_usuario));
		Iterator i = u.es_Vendida.getIterator();
		
		while (i.hasNext())
			if (i.next().equals(c))
				u.es_Vendida.remove(c);
		
		UsuarioR[] urs = c.favorita.toArray();
		
		for (int j = 0; j < urs.length; j++) {
			if (urs[j].es_Favorita.contains(c))
				urs[j].es_Favorita.remove(c);
		}
		boolean b = true;
		if (c != null) b = CasaDAO.delete(c);
		//st.commit();
		return b;
	}

	public boolean modificarVivienda(String aIdCasa, String aDireccion, String aMunicipio, String aProvincia, String aCp, 
			String[] aFotos, String aPrecio, String aSuperficie, String aHabitaciones, String aBanios, String aTipo, 
			String[] aExtras, String aEstado, String aAccion, String aMapa, String aDCorta, String aDLarga, String aVisible)   throws PersistentException {
		/*
		System.out.println("idCasa>" + aIdCasa + "<");
		System.out.println("direccion>" + aDireccion + "<");
		System.out.println("municipio>" + aMunicipio + "<");
		System.out.println("provincia>" + aProvincia + "<");
		System.out.println("cp>" + aCp + "<");
		System.out.println("fotos>" + Arrays.toString(aFotos) + "<");
		System.out.println("precio>" + aPrecio + "<");
		System.out.println("sup>" + aSuperficie + "<");
		System.out.println("hab>" + aHabitaciones + "<");
		System.out.println("ban>" + aBanios + "<");
		System.out.println("tipo>" + aTipo + "<");
		System.out.println("extras>" + Arrays.toString(aExtras) + "<");
		System.out.println("estado>" + aEstado + "<");
		System.out.println("accion>" + aAccion + "<");
		System.out.println("mapa>" + aMapa + "<");
		System.out.println("corta>" + aDCorta + "<");
		System.out.println("larga>" + aDLarga + "<");
		System.out.println("vsible>" + aVisible + "<");
		*/
		boolean modificado = false;
		PersistentTransaction t = null;
		
		try {
			t = ProjectMDS2PersistentManager.instance().getSession().beginTransaction();			
			Casa c = bbdd_gestion.CasaDAO.getCasaByORMID(Integer.valueOf(aIdCasa));
			
			if(aDireccion != null && aDireccion.trim().length() > 0){
				c.setDireccion(aDireccion);
				modificado = true;
			}
			
			if(aCp != null && aCp.trim().length() > 0){
				bbdd_gestion.CodigoPostal cp = bbdd_gestion.CodigoPostalDAO.getCodigoPostalByORMID(Integer.valueOf(aCp));
				if(cp!=null){
					c.setCodigoPostal(cp);
				}else{
					cp = bbdd_gestion.CodigoPostalDAO.createCodigoPostal();
					cp.setCodigo_postal(aCp);
					bbdd_gestion.CodigoPostalDAO.save(cp);
				}
				c.setCodigoPostal(cp);
				modificado = true;
			}
			
			if(aProvincia != null && aProvincia.trim().length() > 0){
				ProvinciaCriteria pc = new ProvinciaCriteria();
				pc.provincia.eq(aProvincia);
				bbdd_gestion.Provincia p = bbdd_gestion.ProvinciaDAO.loadProvinciaByCriteria(pc);
				if(p!=null){
					c.setProvincia(p);
				}else{
					p = bbdd_gestion.ProvinciaDAO.createProvincia();
					p.setProvincia(aProvincia);
					bbdd_gestion.ProvinciaDAO.save(p);
				}
				c.setProvincia(p);
				modificado = true;
			}
	
			if(aMunicipio != null && aMunicipio.trim().length() > 0){
				MunicipioCriteria mc = new MunicipioCriteria();
				mc.municipio.eq(aMunicipio);
				bbdd_gestion.Municipio m = bbdd_gestion.MunicipioDAO.loadMunicipioByCriteria(mc);
				if(m!=null){
					c.setMunicipio(m);
				}else{
					m = bbdd_gestion.MunicipioDAO.createMunicipio();
					m.setMunicipio(aMunicipio);
					bbdd_gestion.MunicipioDAO.save(m);
				}
				m.setPertenece(c.getProvincia());
				c.setMunicipio(m);
				modificado = true;
			}
			
			if(aFotos != null){
				//borramos todas las fotos			
				if(c.fotos.size() > 0){
					Foto[] fotos = c.fotos.toArray();
					for(Foto f : fotos){
						FotoDAO.deleteAndDissociate(f);
					}
				}
				//guardamos fotos de nuevo
				bbdd_gestion.Foto photo;
				FotoCriteria fc;
				HashSet<String> hs = new HashSet<String>(Arrays.asList(aFotos));
				for(String f : hs){
					fc = new FotoCriteria();
					fc.linkFoto.eq(f);
					if(/*FotoDAO.listFotoByCriteria(fc).length == 0 &&*/ f.trim().length() > 0){
						photo = new bbdd_gestion.FotoDAO().createFoto();
						photo.setLinkFoto(f);
						FotoDAO.save(photo);
						c.fotos.add(photo);
					}
				}
				modificado = true;
				
			}
	
			if(aPrecio != null && aPrecio.trim().length() > 0){
				c.setPrecio(Double.valueOf(aPrecio));
				modificado = true;
			}
	
			if(aSuperficie != null && aSuperficie.trim().length() > 0){
				c.setSuperficie(Double.valueOf(aSuperficie));
				modificado = true;
			}
	
			if(aHabitaciones != null && aHabitaciones.trim().length() > 0){
				c.setHabitaciones(Integer.valueOf(aHabitaciones));
				modificado = true;
			}
	
			if(aBanios != null && aBanios.trim().length() > 0){
				c.setBanios(Integer.valueOf(aBanios));
				modificado = true;
			}
	
			if(aTipo != null && aTipo.trim().length() > 0){
				c.setTipo(aTipo);
				modificado = true;
			}
	
			if(aExtras != null){
				//borramos todos los extras
				ExtraCriteria ec = new ExtraCriteria();
				ec.inmueble.equals(c);
				Extra[] el = ExtraDAO.listExtraByCriteria(ec);
				
				for(Extra ex : el){
					c.extra.remove(ex);
				}
				
				
				//los insertamos de nuevo
				Extra e = null;
				for(String s : aExtras){
					e = ExtraDAO.createExtra();
					e = ExtraDAO.loadExtraByQuery("nombreextra LIKE '"+s+"'", null);
					//si extra no existe crearlo
					if(e == null){					
						//crear en la bbdd y añadir
						e = ExtraDAO.createExtra();
						e.setNombreExtra(s);
						//guardamos extra nuevo
						ExtraDAO.save(e);
						//hacemos commit
						//t.commit();
						//reiniciar transaccion
						//t = ProjectMDS2PersistentManager.instance().getSession().beginTransaction();
						//cargamos dicho extra en el array
						e = ExtraDAO.loadExtraByQuery("nombreextra LIKE '"+s+"'", null);
					}
					//en cualquier caso añadimos extra
					//simplemente aniadir
					c.extra.add(e);
				}
				
				modificado = true;
			}
	
			if(aEstado != null && aEstado.trim().length() > 0){
				c.setEstado(aEstado);
				modificado = true;
			}
	
			if(aAccion != null && aAccion.trim().length() > 0){
				c.setAccion(aAccion);
				modificado = true;
			}
			
			if(aMapa != null){
				Mapa m = MapaDAO.createMapa();
				m.setUrl(aMapa);
				//calculamos la longitud y latitud
				//nos aseguramos que el mapa contiene long/lat
				if(aMapa.contains("@")){
					String[] splitURL = aMapa.split("/");
					String[] splitXYZ;

					for(String f : splitURL){
						if(f.contains("@")){
							f = f.replace("@", "");
							if(f.contains("z"))
								f = f.replace("z", "");
							splitXYZ = f.split(",");
							m.setLongitud(splitXYZ[0]);
							m.setLatitud(splitXYZ[1]);
							break;
						}
					}
				}	
				Mapa delM = c.getMapa();			
				MapaDAO.save(m);
				c.setMapa(m);
				if(delM != null)
					MapaDAO.deleteAndDissociate(delM);
				modificado = true;
			}
			
			if(aDCorta != null){
				if(aDCorta.length() > 150){
					aDCorta = aDCorta.substring(0, 150);
				}
				c.setdCorta(aDCorta);
				modificado = true;
			}
			
			if(aDLarga != null){
				if(aDLarga.length()>1023){
					aDLarga = aDLarga.substring(0, 1023);
				}
				c.setdLarga(aDLarga);
				modificado = true;
			}
			
			if(aVisible != null){
				c.setVisible(aVisible);
				modificado = true;
			}
			
			if(modificado){
				bbdd_gestion.CasaDAO.save(c);
			}
		t.commit();
		ProjectMDS2PersistentManager.instance().disposePersistentManager();
		return true;
		}catch(Exception e) {
			e.printStackTrace();
			t.rollback();
		}
		ProjectMDS2PersistentManager.instance().disposePersistentManager();
	
		/*
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
			cp = CodigoPostalDAO.createCodigoPostal();
			cp = bbdd_gestion.CodigoPostalDAO.loadCodigoPostalByQuery("codigo_postal LIKE '"+aCp+"'", null);
			//asignamos el valor del codigo postal solo en caso de no existir	
			if(cp == null){
				System.out.println("cp no encontrada");
				cp = CodigoPostalDAO.createCodigoPostal();
				cp.setCodigo_postal(aCp);
				//cp.setMunicipio(m); //no es obligatorio
				//cp.setProvincia(p);
				CodigoPostalDAO.save(cp);			
			}	
			
			p = ProvinciaDAO.createProvincia();
			p = bbdd_gestion.ProvinciaDAO.loadProvinciaByQuery("provincia LIKE '"+aProvincia+"'", null);
			if(p == null){
				System.out.println("provincia no encontrada");
				p = ProvinciaDAO.createProvincia();
				p.setProvincia(aProvincia.toUpperCase());
				p.setCodigoPostal(cp);
				ProvinciaDAO.save(p);
			}	
			
			m = MunicipioDAO.createMunicipio();
			m = bbdd_gestion.MunicipioDAO.loadMunicipioByQuery("municipio LIKE '"+aMunicipio+"'", null);
			if(m == null){
				//MUNICIPIO NO ENCONTRADO
				System.out.println("municipio no encontrado");
				m = MunicipioDAO.createMunicipio();
				m.setMunicipio(aMunicipio.toUpperCase());
				m.setPertenece(p);
				MunicipioDAO.save(m);
			}

			ma = MapaDAO.createMapa();						
			/*
			 * asignar mapa, extraer coordenadas de google maps
			*/
			/*
			c = CasaDAO.createCasa();
			c.setDireccion(aDireccion);
			c.setMunicipio(m);
			c.setProvincia(p);
			c.setCodigoPostal(cp);
			//c.setLinkFoto(aFotos[0]);
			//System.out.println(">"+aPrecio+"<");
			c.setPrecio(Double.parseDouble(aPrecio));

			Double sup = null;
			if(aSuperficie != null && aSuperficie != ""){
				//sup = Double.parseDouble(aSuperficie);
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
			c.setdCorta(aDCorta);
			c.setdLarga(aDLarga);
			c.setVisible(aVisible);
			CasaDAO.save(c);		
			MapaDAO.save(ma);

			t.commit();
			ProjectMDS2PersistentManager.instance().disposePersistentManager();
			return true;
		}catch(Exception e) {
			e.printStackTrace();
			t.rollback();
		}
		ProjectMDS2PersistentManager.instance().disposePersistentManager();
		*/
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
				ProjectMDS2PersistentManager.instance().disposePersistentManager();
			}else{
				System.out.println("Casa para fav no existe ?!?!");
			}
			}catch(Exception e) {
				e.printStackTrace();
				t.rollback();
		}
		return false;
	}
/* version previa
	public boolean modificarEstadoVivienda(String aId_usuario, String aId_vivienda, String aEstado)   throws PersistentException{
		CasaCriteria cr = new CasaCriteria();
		cr.id_casa.eq(Integer.valueOf(aId_vivienda));
		Casa c = CasaDAO.createCasa();
		c = CasaDAO.loadCasaByORMID(Integer.parseInt(aId_vivienda));
		c.setVisible(aEstado);
		boolean b = CasaDAO.save(c);
		PersistentTransaction t = ProjectMDS2PersistentManager.instance().getSession().beginTransaction();
		t.commit();
		ProjectMDS2PersistentManager.instance().disposePersistentManager();
		return b;
	}
*/
	/*
	 * Se modifica la visibilidad de la casa
	 */
	public boolean modificarEstadoVivienda(String aId_usuario, String aId_vivienda, String aEstado)   throws PersistentException{
		boolean b = false;
		PersistentTransaction t =  null;
		try{
			ProjectMDS2PersistentManager.instance().getSession().close();
			t = ProjectMDS2PersistentManager.instance().getSession().beginTransaction();
			
			CasaCriteria cr = new CasaCriteria();		
			cr.id_casa.eq(Integer.valueOf(aId_vivienda));
						Casa c = CasaDAO.createCasa();
			c = CasaDAO.loadCasaByORMID(Integer.parseInt(aId_vivienda));
			Casa c2 = CasaDAO.createCasa();
			c2 = CasaDAO.loadCasaByQuery("id_inmueble like " + aId_vivienda, null);
			t.commit();
			ProjectMDS2PersistentManager.instance().getSession().close();
			
			t = ProjectMDS2PersistentManager.instance().getSession().beginTransaction();			
			c.setVisible(aEstado);		
			b = CasaDAO.save(c);
			t.commit();
			ProjectMDS2PersistentManager.instance().disposePersistentManager();

		}catch(Exception e) {
			e.printStackTrace();
			t.rollback();
		}
		ProjectMDS2PersistentManager.instance().disposePersistentManager();
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