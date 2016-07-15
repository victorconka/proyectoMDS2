/**
 * Licensee: University of Almeria
 * License Type: Academic
 */
package ormsamples;

import org.orm.*;
public class CreateProjectMDS2Data {
	public void createTestData() throws PersistentException {
		PersistentTransaction t = bbdd_gestion.ProjectMDS2PersistentManager.instance().getSession().beginTransaction();
		try {
			bbdd_gestion.Usuario lbbdd_gestionUsuario = bbdd_gestion.UsuarioDAO.createUsuario();
			// Initialize the properties of the persistent object here
			bbdd_gestion.UsuarioDAO.save(lbbdd_gestionUsuario);
			bbdd_gestion.Cliente lbbdd_gestionCliente = bbdd_gestion.ClienteDAO.createCliente();
			// TODO Initialize the properties of the persistent object here, the following properties must be initialized before saving : codigoPostal
			bbdd_gestion.ClienteDAO.save(lbbdd_gestionCliente);
			bbdd_gestion.UsuarioR lbbdd_gestionUsuarioR = bbdd_gestion.UsuarioRDAO.createUsuarioR();
			// TODO Initialize the properties of the persistent object here, the following properties must be initialized before saving : es_Favorita
			bbdd_gestion.UsuarioRDAO.save(lbbdd_gestionUsuarioR);
			bbdd_gestion.Provincia lbbdd_gestionProvincia = bbdd_gestion.ProvinciaDAO.createProvincia();
			// Initialize the properties of the persistent object here
			bbdd_gestion.ProvinciaDAO.save(lbbdd_gestionProvincia);
			bbdd_gestion.Municipio lbbdd_gestionMunicipio = bbdd_gestion.MunicipioDAO.createMunicipio();
			// Initialize the properties of the persistent object here
			bbdd_gestion.MunicipioDAO.save(lbbdd_gestionMunicipio);
			bbdd_gestion.Mapa lbbdd_gestionMapa = bbdd_gestion.MapaDAO.createMapa();
			// Initialize the properties of the persistent object here
			bbdd_gestion.MapaDAO.save(lbbdd_gestionMapa);
			bbdd_gestion.Inmueble lbbdd_gestionInmueble = bbdd_gestion.InmuebleDAO.createInmueble();
			// TODO Initialize the properties of the persistent object here, the following properties must be initialized before saving : extra
			bbdd_gestion.InmuebleDAO.save(lbbdd_gestionInmueble);
			bbdd_gestion.Foto lbbdd_gestionFoto = bbdd_gestion.FotoDAO.createFoto();
			// Initialize the properties of the persistent object here
			bbdd_gestion.FotoDAO.save(lbbdd_gestionFoto);
			bbdd_gestion.Extra lbbdd_gestionExtra = bbdd_gestion.ExtraDAO.createExtra();
			// TODO Initialize the properties of the persistent object here, the following properties must be initialized before saving : inmueble
			bbdd_gestion.ExtraDAO.save(lbbdd_gestionExtra);
			bbdd_gestion.Correo lbbdd_gestionCorreo = bbdd_gestion.CorreoDAO.createCorreo();
			// Initialize the properties of the persistent object here
			bbdd_gestion.CorreoDAO.save(lbbdd_gestionCorreo);
			bbdd_gestion.CodigoPostal lbbdd_gestionCodigoPostal = bbdd_gestion.CodigoPostalDAO.createCodigoPostal();
			// Initialize the properties of the persistent object here
			bbdd_gestion.CodigoPostalDAO.save(lbbdd_gestionCodigoPostal);
			bbdd_gestion.Casa lbbdd_gestionCasa = bbdd_gestion.CasaDAO.createCasa();
			// TODO Initialize the properties of the persistent object here, the following properties must be initialized before saving : favorita, numFavoritos, numVisitas, banios, habitaciones, precio, id_casa
			bbdd_gestion.CasaDAO.save(lbbdd_gestionCasa);
			bbdd_gestion.Administrador lbbdd_gestionAdministrador = bbdd_gestion.AdministradorDAO.createAdministrador();
			// Initialize the properties of the persistent object here
			bbdd_gestion.AdministradorDAO.save(lbbdd_gestionAdministrador);
			t.commit();
		}
		catch (Exception e) {
			t.rollback();
		}
		
	}
	
	public static void main(String[] args) {
		try {
			CreateProjectMDS2Data createProjectMDS2Data = new CreateProjectMDS2Data();
			try {
				createProjectMDS2Data.createTestData();
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
