package bbdd;

import org.orm.PersistentException;
import org.orm.PersistentTransaction;

import bbdd_gestion.Administrador;
import bbdd_gestion.AdministradorDAO;
import bbdd_gestion.ProjectMDS2PersistentManager;

public class Administradores {
	public BDPrincipal _bd_prin_administradores;
	public Administrador[] _conts_administrador = new Administrador[0];
	
	public void registrarAdmin(String aNombre, String aEmail, String aContrasenia) throws PersistentException {
		Administrador a = null;
		PersistentTransaction t = bbdd_gestion.ProjectMDS2PersistentManager.instance().getSession().beginTransaction();
		boolean existe = false;
		String condicion = "correo = '";
		try {	
		
			a = AdministradorDAO.createAdministrador();
			a.setNombre(aNombre);
			a.setCorreo(aEmail);
			a.setContrasenia(aContrasenia);
			
			condicion += a.getCorreo()+"' and contrasenia = '"+a.getContrasenia()+"'";
			
			Administrador u = AdministradorDAO.loadAdministradorByQuery(condicion, null);
			if (u != null) 
				existe = true;
						
			if (!existe) {
				AdministradorDAO.save(a);
				t.commit();
			}
			ProjectMDS2PersistentManager.instance().disposePersistentManager();
		}
		catch (Exception e) {
			e.printStackTrace();
			t.rollback();
		}
		bbdd_gestion.ProjectMDS2PersistentManager.instance().disposePersistentManager();
	}
}