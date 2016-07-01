/**
 * Licensee: University of Almeria
 * License Type: Academic
 */
package ormsamples;

import org.orm.*;
public class RetrieveAndUpdateProjectMDS2Data {
	public void retrieveAndUpdateTestData() throws PersistentException {
		PersistentTransaction t = bbdd_gestion.ProjectMDS2PersistentManager.instance().getSession().beginTransaction();
		try {
			bbdd_gestion.Usuario lbbdd_gestionUsuario = bbdd_gestion.UsuarioDAO.loadUsuarioByQuery(null, null);
			// Update the properties of the persistent object
			bbdd_gestion.UsuarioDAO.save(lbbdd_gestionUsuario);
			bbdd_gestion.Cliente lbbdd_gestionCliente = bbdd_gestion.ClienteDAO.loadClienteByQuery(null, null);
			// Update the properties of the persistent object
			bbdd_gestion.ClienteDAO.save(lbbdd_gestionCliente);
			bbdd_gestion.UsuarioR lbbdd_gestionUsuarioR = bbdd_gestion.UsuarioRDAO.loadUsuarioRByQuery(null, null);
			// Update the properties of the persistent object
			bbdd_gestion.UsuarioRDAO.save(lbbdd_gestionUsuarioR);
			bbdd_gestion.Provincia lbbdd_gestionProvincia = bbdd_gestion.ProvinciaDAO.loadProvinciaByQuery(null, null);
			// Update the properties of the persistent object
			bbdd_gestion.ProvinciaDAO.save(lbbdd_gestionProvincia);
			bbdd_gestion.Municipio lbbdd_gestionMunicipio = bbdd_gestion.MunicipioDAO.loadMunicipioByQuery(null, null);
			// Update the properties of the persistent object
			bbdd_gestion.MunicipioDAO.save(lbbdd_gestionMunicipio);
			bbdd_gestion.Mapa lbbdd_gestionMapa = bbdd_gestion.MapaDAO.loadMapaByQuery(null, null);
			// Update the properties of the persistent object
			bbdd_gestion.MapaDAO.save(lbbdd_gestionMapa);
			bbdd_gestion.Inmueble lbbdd_gestionInmueble = bbdd_gestion.InmuebleDAO.loadInmuebleByQuery(null, null);
			// Update the properties of the persistent object
			bbdd_gestion.InmuebleDAO.save(lbbdd_gestionInmueble);
			bbdd_gestion.Foto lbbdd_gestionFoto = bbdd_gestion.FotoDAO.loadFotoByQuery(null, null);
			// Update the properties of the persistent object
			bbdd_gestion.FotoDAO.save(lbbdd_gestionFoto);
			bbdd_gestion.Extra lbbdd_gestionExtra = bbdd_gestion.ExtraDAO.loadExtraByQuery(null, null);
			// Update the properties of the persistent object
			bbdd_gestion.ExtraDAO.save(lbbdd_gestionExtra);
			bbdd_gestion.Correo lbbdd_gestionCorreo = bbdd_gestion.CorreoDAO.loadCorreoByQuery(null, null);
			// Update the properties of the persistent object
			bbdd_gestion.CorreoDAO.save(lbbdd_gestionCorreo);
			bbdd_gestion.CodigoPostal lbbdd_gestionCodigoPostal = bbdd_gestion.CodigoPostalDAO.loadCodigoPostalByQuery(null, null);
			// Update the properties of the persistent object
			bbdd_gestion.CodigoPostalDAO.save(lbbdd_gestionCodigoPostal);
			bbdd_gestion.Casa lbbdd_gestionCasa = bbdd_gestion.CasaDAO.loadCasaByQuery(null, null);
			// Update the properties of the persistent object
			bbdd_gestion.CasaDAO.save(lbbdd_gestionCasa);
			bbdd_gestion.Administrador lbbdd_gestionAdministrador = bbdd_gestion.AdministradorDAO.loadAdministradorByQuery(null, null);
			// Update the properties of the persistent object
			bbdd_gestion.AdministradorDAO.save(lbbdd_gestionAdministrador);
			t.commit();
		}
		catch (Exception e) {
			t.rollback();
		}
		
	}
	
	public void retrieveByCriteria() throws PersistentException {
		System.out.println("Retrieving Usuario by UsuarioCriteria");
		bbdd_gestion.UsuarioCriteria lbbdd_gestionUsuarioCriteria = new bbdd_gestion.UsuarioCriteria();
		// Please uncomment the follow line and fill in parameter(s)
		//lbbdd_gestionUsuarioCriteria.id_Usuario.eq();
		System.out.println(lbbdd_gestionUsuarioCriteria.uniqueUsuario());
		
		System.out.println("Retrieving Cliente by ClienteCriteria");
		bbdd_gestion.ClienteCriteria lbbdd_gestionClienteCriteria = new bbdd_gestion.ClienteCriteria();
		// Please uncomment the follow line and fill in parameter(s)
		//lbbdd_gestionClienteCriteria.id_Usuario.eq();
		System.out.println(lbbdd_gestionClienteCriteria.uniqueCliente());
		
		System.out.println("Retrieving UsuarioR by UsuarioRCriteria");
		bbdd_gestion.UsuarioRCriteria lbbdd_gestionUsuarioRCriteria = new bbdd_gestion.UsuarioRCriteria();
		// Please uncomment the follow line and fill in parameter(s)
		//lbbdd_gestionUsuarioRCriteria.id_Usuario.eq();
		System.out.println(lbbdd_gestionUsuarioRCriteria.uniqueUsuarioR());
		
		System.out.println("Retrieving Provincia by ProvinciaCriteria");
		bbdd_gestion.ProvinciaCriteria lbbdd_gestionProvinciaCriteria = new bbdd_gestion.ProvinciaCriteria();
		// Please uncomment the follow line and fill in parameter(s)
		//lbbdd_gestionProvinciaCriteria.id_provincia.eq();
		System.out.println(lbbdd_gestionProvinciaCriteria.uniqueProvincia());
		
		System.out.println("Retrieving Municipio by MunicipioCriteria");
		bbdd_gestion.MunicipioCriteria lbbdd_gestionMunicipioCriteria = new bbdd_gestion.MunicipioCriteria();
		// Please uncomment the follow line and fill in parameter(s)
		//lbbdd_gestionMunicipioCriteria.id_Municipio.eq();
		System.out.println(lbbdd_gestionMunicipioCriteria.uniqueMunicipio());
		
		System.out.println("Retrieving Mapa by MapaCriteria");
		bbdd_gestion.MapaCriteria lbbdd_gestionMapaCriteria = new bbdd_gestion.MapaCriteria();
		// Please uncomment the follow line and fill in parameter(s)
		//lbbdd_gestionMapaCriteria.id_mapa.eq();
		System.out.println(lbbdd_gestionMapaCriteria.uniqueMapa());
		
		System.out.println("Retrieving Inmueble by InmuebleCriteria");
		bbdd_gestion.InmuebleCriteria lbbdd_gestionInmuebleCriteria = new bbdd_gestion.InmuebleCriteria();
		// Please uncomment the follow line and fill in parameter(s)
		//lbbdd_gestionInmuebleCriteria.id_Inmueble.eq();
		System.out.println(lbbdd_gestionInmuebleCriteria.uniqueInmueble());
		
		System.out.println("Retrieving Foto by FotoCriteria");
		bbdd_gestion.FotoCriteria lbbdd_gestionFotoCriteria = new bbdd_gestion.FotoCriteria();
		// Please uncomment the follow line and fill in parameter(s)
		//lbbdd_gestionFotoCriteria.id_foto.eq();
		System.out.println(lbbdd_gestionFotoCriteria.uniqueFoto());
		
		System.out.println("Retrieving Extra by ExtraCriteria");
		bbdd_gestion.ExtraCriteria lbbdd_gestionExtraCriteria = new bbdd_gestion.ExtraCriteria();
		// Please uncomment the follow line and fill in parameter(s)
		//lbbdd_gestionExtraCriteria.id_Extra.eq();
		System.out.println(lbbdd_gestionExtraCriteria.uniqueExtra());
		
		System.out.println("Retrieving Correo by CorreoCriteria");
		bbdd_gestion.CorreoCriteria lbbdd_gestionCorreoCriteria = new bbdd_gestion.CorreoCriteria();
		// Please uncomment the follow line and fill in parameter(s)
		//lbbdd_gestionCorreoCriteria.id_Correo.eq();
		System.out.println(lbbdd_gestionCorreoCriteria.uniqueCorreo());
		
		System.out.println("Retrieving CodigoPostal by CodigoPostalCriteria");
		bbdd_gestion.CodigoPostalCriteria lbbdd_gestionCodigoPostalCriteria = new bbdd_gestion.CodigoPostalCriteria();
		// Please uncomment the follow line and fill in parameter(s)
		//lbbdd_gestionCodigoPostalCriteria.id_CodigoPostal.eq();
		System.out.println(lbbdd_gestionCodigoPostalCriteria.uniqueCodigoPostal());
		
		System.out.println("Retrieving Casa by CasaCriteria");
		bbdd_gestion.CasaCriteria lbbdd_gestionCasaCriteria = new bbdd_gestion.CasaCriteria();
		// Please uncomment the follow line and fill in parameter(s)
		//lbbdd_gestionCasaCriteria.id_Inmueble.eq();
		System.out.println(lbbdd_gestionCasaCriteria.uniqueCasa());
		
		System.out.println("Retrieving Administrador by AdministradorCriteria");
		bbdd_gestion.AdministradorCriteria lbbdd_gestionAdministradorCriteria = new bbdd_gestion.AdministradorCriteria();
		// Please uncomment the follow line and fill in parameter(s)
		//lbbdd_gestionAdministradorCriteria.id_Usuario.eq();
		System.out.println(lbbdd_gestionAdministradorCriteria.uniqueAdministrador());
		
	}
	
	
	public static void main(String[] args) {
		try {
			RetrieveAndUpdateProjectMDS2Data retrieveAndUpdateProjectMDS2Data = new RetrieveAndUpdateProjectMDS2Data();
			try {
				retrieveAndUpdateProjectMDS2Data.retrieveAndUpdateTestData();
				//retrieveAndUpdateProjectMDS2Data.retrieveByCriteria();
			}
			finally {
				bbdd_gestion.ProjectMDS2PersistentManager.instance().disposePersistentManager();
			}
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}
}
