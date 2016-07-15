/**
 * Licensee: University of Almeria
 * License Type: Academic
 */
package ormsamples;

import org.orm.*;
public class ListProjectMDS2Data {
	private static final int ROW_COUNT = 100;
	
	public void listTestData() throws PersistentException {
		System.out.println("Listing Usuario...");
		bbdd_gestion.Usuario[] bbdd_gestionUsuarios = bbdd_gestion.UsuarioDAO.listUsuarioByQuery(null, null);
		int length = Math.min(bbdd_gestionUsuarios.length, ROW_COUNT);
		for (int i = 0; i < length; i++) {
			System.out.println(bbdd_gestionUsuarios[i]);
		}
		System.out.println(length + " record(s) retrieved.");
		
		System.out.println("Listing Cliente...");
		bbdd_gestion.Cliente[] bbdd_gestionClientes = bbdd_gestion.ClienteDAO.listClienteByQuery(null, null);
		length = Math.min(bbdd_gestionClientes.length, ROW_COUNT);
		for (int i = 0; i < length; i++) {
			System.out.println(bbdd_gestionClientes[i]);
		}
		System.out.println(length + " record(s) retrieved.");
		
		System.out.println("Listing UsuarioR...");
		bbdd_gestion.UsuarioR[] bbdd_gestionUsuarioRs = bbdd_gestion.UsuarioRDAO.listUsuarioRByQuery(null, null);
		length = Math.min(bbdd_gestionUsuarioRs.length, ROW_COUNT);
		for (int i = 0; i < length; i++) {
			System.out.println(bbdd_gestionUsuarioRs[i]);
		}
		System.out.println(length + " record(s) retrieved.");
		
		System.out.println("Listing Provincia...");
		bbdd_gestion.Provincia[] bbdd_gestionProvincias = bbdd_gestion.ProvinciaDAO.listProvinciaByQuery(null, null);
		length = Math.min(bbdd_gestionProvincias.length, ROW_COUNT);
		for (int i = 0; i < length; i++) {
			System.out.println(bbdd_gestionProvincias[i]);
		}
		System.out.println(length + " record(s) retrieved.");
		
		System.out.println("Listing Municipio...");
		bbdd_gestion.Municipio[] bbdd_gestionMunicipios = bbdd_gestion.MunicipioDAO.listMunicipioByQuery(null, null);
		length = Math.min(bbdd_gestionMunicipios.length, ROW_COUNT);
		for (int i = 0; i < length; i++) {
			System.out.println(bbdd_gestionMunicipios[i]);
		}
		System.out.println(length + " record(s) retrieved.");
		
		System.out.println("Listing Mapa...");
		bbdd_gestion.Mapa[] bbdd_gestionMapas = bbdd_gestion.MapaDAO.listMapaByQuery(null, null);
		length = Math.min(bbdd_gestionMapas.length, ROW_COUNT);
		for (int i = 0; i < length; i++) {
			System.out.println(bbdd_gestionMapas[i]);
		}
		System.out.println(length + " record(s) retrieved.");
		
		System.out.println("Listing Inmueble...");
		bbdd_gestion.Inmueble[] bbdd_gestionInmuebles = bbdd_gestion.InmuebleDAO.listInmuebleByQuery(null, null);
		length = Math.min(bbdd_gestionInmuebles.length, ROW_COUNT);
		for (int i = 0; i < length; i++) {
			System.out.println(bbdd_gestionInmuebles[i]);
		}
		System.out.println(length + " record(s) retrieved.");
		
		System.out.println("Listing Foto...");
		bbdd_gestion.Foto[] bbdd_gestionFotos = bbdd_gestion.FotoDAO.listFotoByQuery(null, null);
		length = Math.min(bbdd_gestionFotos.length, ROW_COUNT);
		for (int i = 0; i < length; i++) {
			System.out.println(bbdd_gestionFotos[i]);
		}
		System.out.println(length + " record(s) retrieved.");
		
		System.out.println("Listing Extra...");
		bbdd_gestion.Extra[] bbdd_gestionExtras = bbdd_gestion.ExtraDAO.listExtraByQuery(null, null);
		length = Math.min(bbdd_gestionExtras.length, ROW_COUNT);
		for (int i = 0; i < length; i++) {
			System.out.println(bbdd_gestionExtras[i]);
		}
		System.out.println(length + " record(s) retrieved.");
		
		System.out.println("Listing Correo...");
		bbdd_gestion.Correo[] bbdd_gestionCorreos = bbdd_gestion.CorreoDAO.listCorreoByQuery(null, null);
		length = Math.min(bbdd_gestionCorreos.length, ROW_COUNT);
		for (int i = 0; i < length; i++) {
			System.out.println(bbdd_gestionCorreos[i]);
		}
		System.out.println(length + " record(s) retrieved.");
		
		System.out.println("Listing CodigoPostal...");
		bbdd_gestion.CodigoPostal[] bbdd_gestionCodigoPostals = bbdd_gestion.CodigoPostalDAO.listCodigoPostalByQuery(null, null);
		length = Math.min(bbdd_gestionCodigoPostals.length, ROW_COUNT);
		for (int i = 0; i < length; i++) {
			System.out.println(bbdd_gestionCodigoPostals[i]);
		}
		System.out.println(length + " record(s) retrieved.");
		
		System.out.println("Listing Casa...");
		bbdd_gestion.Casa[] bbdd_gestionCasas = bbdd_gestion.CasaDAO.listCasaByQuery(null, null);
		length = Math.min(bbdd_gestionCasas.length, ROW_COUNT);
		for (int i = 0; i < length; i++) {
			System.out.println(bbdd_gestionCasas[i]);
		}
		System.out.println(length + " record(s) retrieved.");
		
		System.out.println("Listing Administrador...");
		bbdd_gestion.Administrador[] bbdd_gestionAdministradors = bbdd_gestion.AdministradorDAO.listAdministradorByQuery(null, null);
		length = Math.min(bbdd_gestionAdministradors.length, ROW_COUNT);
		for (int i = 0; i < length; i++) {
			System.out.println(bbdd_gestionAdministradors[i]);
		}
		System.out.println(length + " record(s) retrieved.");
		
	}
	
	public void listByCriteria() throws PersistentException {
		System.out.println("Listing Usuario by Criteria...");
		bbdd_gestion.UsuarioCriteria lbbdd_gestionUsuarioCriteria = new bbdd_gestion.UsuarioCriteria();
		// Please uncomment the follow line and fill in parameter(s) 
		//lbbdd_gestionUsuarioCriteria.id_Usuario.eq();
		lbbdd_gestionUsuarioCriteria.setMaxResults(ROW_COUNT);
		bbdd_gestion.Usuario[] bbdd_gestionUsuarios = lbbdd_gestionUsuarioCriteria.listUsuario();
		int length =bbdd_gestionUsuarios== null ? 0 : Math.min(bbdd_gestionUsuarios.length, ROW_COUNT); 
		for (int i = 0; i < length; i++) {
			 System.out.println(bbdd_gestionUsuarios[i]);
		}
		System.out.println(length + " Usuario record(s) retrieved."); 
		
		System.out.println("Listing Cliente by Criteria...");
		bbdd_gestion.ClienteCriteria lbbdd_gestionClienteCriteria = new bbdd_gestion.ClienteCriteria();
		// Please uncomment the follow line and fill in parameter(s) 
		//lbbdd_gestionClienteCriteria.id_Usuario.eq();
		lbbdd_gestionClienteCriteria.setMaxResults(ROW_COUNT);
		bbdd_gestion.Cliente[] bbdd_gestionClientes = lbbdd_gestionClienteCriteria.listCliente();
		length =bbdd_gestionClientes== null ? 0 : Math.min(bbdd_gestionClientes.length, ROW_COUNT); 
		for (int i = 0; i < length; i++) {
			 System.out.println(bbdd_gestionClientes[i]);
		}
		System.out.println(length + " Cliente record(s) retrieved."); 
		
		System.out.println("Listing UsuarioR by Criteria...");
		bbdd_gestion.UsuarioRCriteria lbbdd_gestionUsuarioRCriteria = new bbdd_gestion.UsuarioRCriteria();
		// Please uncomment the follow line and fill in parameter(s) 
		//lbbdd_gestionUsuarioRCriteria.id_Usuario.eq();
		lbbdd_gestionUsuarioRCriteria.setMaxResults(ROW_COUNT);
		bbdd_gestion.UsuarioR[] bbdd_gestionUsuarioRs = lbbdd_gestionUsuarioRCriteria.listUsuarioR();
		length =bbdd_gestionUsuarioRs== null ? 0 : Math.min(bbdd_gestionUsuarioRs.length, ROW_COUNT); 
		for (int i = 0; i < length; i++) {
			 System.out.println(bbdd_gestionUsuarioRs[i]);
		}
		System.out.println(length + " UsuarioR record(s) retrieved."); 
		
		System.out.println("Listing Provincia by Criteria...");
		bbdd_gestion.ProvinciaCriteria lbbdd_gestionProvinciaCriteria = new bbdd_gestion.ProvinciaCriteria();
		// Please uncomment the follow line and fill in parameter(s) 
		//lbbdd_gestionProvinciaCriteria.id_provincia.eq();
		lbbdd_gestionProvinciaCriteria.setMaxResults(ROW_COUNT);
		bbdd_gestion.Provincia[] bbdd_gestionProvincias = lbbdd_gestionProvinciaCriteria.listProvincia();
		length =bbdd_gestionProvincias== null ? 0 : Math.min(bbdd_gestionProvincias.length, ROW_COUNT); 
		for (int i = 0; i < length; i++) {
			 System.out.println(bbdd_gestionProvincias[i]);
		}
		System.out.println(length + " Provincia record(s) retrieved."); 
		
		System.out.println("Listing Municipio by Criteria...");
		bbdd_gestion.MunicipioCriteria lbbdd_gestionMunicipioCriteria = new bbdd_gestion.MunicipioCriteria();
		// Please uncomment the follow line and fill in parameter(s) 
		//lbbdd_gestionMunicipioCriteria.id_Municipio.eq();
		lbbdd_gestionMunicipioCriteria.setMaxResults(ROW_COUNT);
		bbdd_gestion.Municipio[] bbdd_gestionMunicipios = lbbdd_gestionMunicipioCriteria.listMunicipio();
		length =bbdd_gestionMunicipios== null ? 0 : Math.min(bbdd_gestionMunicipios.length, ROW_COUNT); 
		for (int i = 0; i < length; i++) {
			 System.out.println(bbdd_gestionMunicipios[i]);
		}
		System.out.println(length + " Municipio record(s) retrieved."); 
		
		System.out.println("Listing Mapa by Criteria...");
		bbdd_gestion.MapaCriteria lbbdd_gestionMapaCriteria = new bbdd_gestion.MapaCriteria();
		// Please uncomment the follow line and fill in parameter(s) 
		//lbbdd_gestionMapaCriteria.id_mapa.eq();
		lbbdd_gestionMapaCriteria.setMaxResults(ROW_COUNT);
		bbdd_gestion.Mapa[] bbdd_gestionMapas = lbbdd_gestionMapaCriteria.listMapa();
		length =bbdd_gestionMapas== null ? 0 : Math.min(bbdd_gestionMapas.length, ROW_COUNT); 
		for (int i = 0; i < length; i++) {
			 System.out.println(bbdd_gestionMapas[i]);
		}
		System.out.println(length + " Mapa record(s) retrieved."); 
		
		System.out.println("Listing Inmueble by Criteria...");
		bbdd_gestion.InmuebleCriteria lbbdd_gestionInmuebleCriteria = new bbdd_gestion.InmuebleCriteria();
		// Please uncomment the follow line and fill in parameter(s) 
		//lbbdd_gestionInmuebleCriteria.id_Inmueble.eq();
		lbbdd_gestionInmuebleCriteria.setMaxResults(ROW_COUNT);
		bbdd_gestion.Inmueble[] bbdd_gestionInmuebles = lbbdd_gestionInmuebleCriteria.listInmueble();
		length =bbdd_gestionInmuebles== null ? 0 : Math.min(bbdd_gestionInmuebles.length, ROW_COUNT); 
		for (int i = 0; i < length; i++) {
			 System.out.println(bbdd_gestionInmuebles[i]);
		}
		System.out.println(length + " Inmueble record(s) retrieved."); 
		
		System.out.println("Listing Foto by Criteria...");
		bbdd_gestion.FotoCriteria lbbdd_gestionFotoCriteria = new bbdd_gestion.FotoCriteria();
		// Please uncomment the follow line and fill in parameter(s) 
		//lbbdd_gestionFotoCriteria.id_foto.eq();
		lbbdd_gestionFotoCriteria.setMaxResults(ROW_COUNT);
		bbdd_gestion.Foto[] bbdd_gestionFotos = lbbdd_gestionFotoCriteria.listFoto();
		length =bbdd_gestionFotos== null ? 0 : Math.min(bbdd_gestionFotos.length, ROW_COUNT); 
		for (int i = 0; i < length; i++) {
			 System.out.println(bbdd_gestionFotos[i]);
		}
		System.out.println(length + " Foto record(s) retrieved."); 
		
		System.out.println("Listing Extra by Criteria...");
		bbdd_gestion.ExtraCriteria lbbdd_gestionExtraCriteria = new bbdd_gestion.ExtraCriteria();
		// Please uncomment the follow line and fill in parameter(s) 
		//lbbdd_gestionExtraCriteria.id_Extra.eq();
		lbbdd_gestionExtraCriteria.setMaxResults(ROW_COUNT);
		bbdd_gestion.Extra[] bbdd_gestionExtras = lbbdd_gestionExtraCriteria.listExtra();
		length =bbdd_gestionExtras== null ? 0 : Math.min(bbdd_gestionExtras.length, ROW_COUNT); 
		for (int i = 0; i < length; i++) {
			 System.out.println(bbdd_gestionExtras[i]);
		}
		System.out.println(length + " Extra record(s) retrieved."); 
		
		System.out.println("Listing Correo by Criteria...");
		bbdd_gestion.CorreoCriteria lbbdd_gestionCorreoCriteria = new bbdd_gestion.CorreoCriteria();
		// Please uncomment the follow line and fill in parameter(s) 
		//lbbdd_gestionCorreoCriteria.id_Correo.eq();
		lbbdd_gestionCorreoCriteria.setMaxResults(ROW_COUNT);
		bbdd_gestion.Correo[] bbdd_gestionCorreos = lbbdd_gestionCorreoCriteria.listCorreo();
		length =bbdd_gestionCorreos== null ? 0 : Math.min(bbdd_gestionCorreos.length, ROW_COUNT); 
		for (int i = 0; i < length; i++) {
			 System.out.println(bbdd_gestionCorreos[i]);
		}
		System.out.println(length + " Correo record(s) retrieved."); 
		
		System.out.println("Listing CodigoPostal by Criteria...");
		bbdd_gestion.CodigoPostalCriteria lbbdd_gestionCodigoPostalCriteria = new bbdd_gestion.CodigoPostalCriteria();
		// Please uncomment the follow line and fill in parameter(s) 
		//lbbdd_gestionCodigoPostalCriteria.id_CodigoPostal.eq();
		lbbdd_gestionCodigoPostalCriteria.setMaxResults(ROW_COUNT);
		bbdd_gestion.CodigoPostal[] bbdd_gestionCodigoPostals = lbbdd_gestionCodigoPostalCriteria.listCodigoPostal();
		length =bbdd_gestionCodigoPostals== null ? 0 : Math.min(bbdd_gestionCodigoPostals.length, ROW_COUNT); 
		for (int i = 0; i < length; i++) {
			 System.out.println(bbdd_gestionCodigoPostals[i]);
		}
		System.out.println(length + " CodigoPostal record(s) retrieved."); 
		
		System.out.println("Listing Casa by Criteria...");
		bbdd_gestion.CasaCriteria lbbdd_gestionCasaCriteria = new bbdd_gestion.CasaCriteria();
		// Please uncomment the follow line and fill in parameter(s) 
		//lbbdd_gestionCasaCriteria.id_Inmueble.eq();
		lbbdd_gestionCasaCriteria.setMaxResults(ROW_COUNT);
		bbdd_gestion.Casa[] bbdd_gestionCasas = lbbdd_gestionCasaCriteria.listCasa();
		length =bbdd_gestionCasas== null ? 0 : Math.min(bbdd_gestionCasas.length, ROW_COUNT); 
		for (int i = 0; i < length; i++) {
			 System.out.println(bbdd_gestionCasas[i]);
		}
		System.out.println(length + " Casa record(s) retrieved."); 
		
		System.out.println("Listing Administrador by Criteria...");
		bbdd_gestion.AdministradorCriteria lbbdd_gestionAdministradorCriteria = new bbdd_gestion.AdministradorCriteria();
		// Please uncomment the follow line and fill in parameter(s) 
		//lbbdd_gestionAdministradorCriteria.id_Usuario.eq();
		lbbdd_gestionAdministradorCriteria.setMaxResults(ROW_COUNT);
		bbdd_gestion.Administrador[] bbdd_gestionAdministradors = lbbdd_gestionAdministradorCriteria.listAdministrador();
		length =bbdd_gestionAdministradors== null ? 0 : Math.min(bbdd_gestionAdministradors.length, ROW_COUNT); 
		for (int i = 0; i < length; i++) {
			 System.out.println(bbdd_gestionAdministradors[i]);
		}
		System.out.println(length + " Administrador record(s) retrieved."); 
		
	}
	
	public static void main(String[] args) {
		try {
			ListProjectMDS2Data listProjectMDS2Data = new ListProjectMDS2Data();
			try {
				listProjectMDS2Data.listTestData();
				//listProjectMDS2Data.listByCriteria();
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
