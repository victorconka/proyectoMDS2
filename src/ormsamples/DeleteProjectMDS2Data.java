/**
 * Licensee: University of Almeria
 * License Type: Academic
 */
package ormsamples;

import org.orm.*;
public class DeleteProjectMDS2Data {
	public void deleteTestData() throws PersistentException {
		PersistentTransaction t = bbdd_gestion.ProjectMDS2PersistentManager.instance().getSession().beginTransaction();
		try {
			bbdd_gestion.Usuario lbbdd_gestionUsuario = bbdd_gestion.UsuarioDAO.loadUsuarioByQuery(null, null);
			// Delete the persistent object
			bbdd_gestion.UsuarioDAO.delete(lbbdd_gestionUsuario);
			bbdd_gestion.Cliente lbbdd_gestionCliente = bbdd_gestion.ClienteDAO.loadClienteByQuery(null, null);
			// Delete the persistent object
			bbdd_gestion.ClienteDAO.delete(lbbdd_gestionCliente);
			bbdd_gestion.UsuarioR lbbdd_gestionUsuarioR = bbdd_gestion.UsuarioRDAO.loadUsuarioRByQuery(null, null);
			// Delete the persistent object
			bbdd_gestion.UsuarioRDAO.delete(lbbdd_gestionUsuarioR);
			bbdd_gestion.Provincia lbbdd_gestionProvincia = bbdd_gestion.ProvinciaDAO.loadProvinciaByQuery(null, null);
			// Delete the persistent object
			bbdd_gestion.ProvinciaDAO.delete(lbbdd_gestionProvincia);
			bbdd_gestion.Municipio lbbdd_gestionMunicipio = bbdd_gestion.MunicipioDAO.loadMunicipioByQuery(null, null);
			// Delete the persistent object
			bbdd_gestion.MunicipioDAO.delete(lbbdd_gestionMunicipio);
			bbdd_gestion.Mapa lbbdd_gestionMapa = bbdd_gestion.MapaDAO.loadMapaByQuery(null, null);
			// Delete the persistent object
			bbdd_gestion.MapaDAO.delete(lbbdd_gestionMapa);
			bbdd_gestion.Inmueble lbbdd_gestionInmueble = bbdd_gestion.InmuebleDAO.loadInmuebleByQuery(null, null);
			// Delete the persistent object
			bbdd_gestion.InmuebleDAO.delete(lbbdd_gestionInmueble);
			bbdd_gestion.Foto lbbdd_gestionFoto = bbdd_gestion.FotoDAO.loadFotoByQuery(null, null);
			// Delete the persistent object
			bbdd_gestion.FotoDAO.delete(lbbdd_gestionFoto);
			bbdd_gestion.Extra lbbdd_gestionExtra = bbdd_gestion.ExtraDAO.loadExtraByQuery(null, null);
			// Delete the persistent object
			bbdd_gestion.ExtraDAO.delete(lbbdd_gestionExtra);
			bbdd_gestion.Correo lbbdd_gestionCorreo = bbdd_gestion.CorreoDAO.loadCorreoByQuery(null, null);
			// Delete the persistent object
			bbdd_gestion.CorreoDAO.delete(lbbdd_gestionCorreo);
			bbdd_gestion.CodigoPostal lbbdd_gestionCodigoPostal = bbdd_gestion.CodigoPostalDAO.loadCodigoPostalByQuery(null, null);
			// Delete the persistent object
			bbdd_gestion.CodigoPostalDAO.delete(lbbdd_gestionCodigoPostal);
			bbdd_gestion.Casa lbbdd_gestionCasa = bbdd_gestion.CasaDAO.loadCasaByQuery(null, null);
			// Delete the persistent object
			bbdd_gestion.CasaDAO.delete(lbbdd_gestionCasa);
			bbdd_gestion.Administrador lbbdd_gestionAdministrador = bbdd_gestion.AdministradorDAO.loadAdministradorByQuery(null, null);
			// Delete the persistent object
			bbdd_gestion.AdministradorDAO.delete(lbbdd_gestionAdministrador);
			t.commit();
		}
		catch (Exception e) {
			t.rollback();
		}
		
	}
	
	public static void main(String[] args) {
		try {
			DeleteProjectMDS2Data deleteProjectMDS2Data = new DeleteProjectMDS2Data();
			try {
				deleteProjectMDS2Data.deleteTestData();
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
