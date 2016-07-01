package bbdd;

import java.rmi.RemoteException;

public interface IAdministrador extends IUsuario {
	
	public void registrarAdmin(String aNombre, String aEmail, String aContrasenia) throws RemoteException;

}