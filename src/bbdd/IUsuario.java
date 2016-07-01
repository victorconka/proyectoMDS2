package bbdd;

import bbdd_gestion.Casa;
import bbdd_gestion.Usuario;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface IUsuario extends Remote {
	
	public boolean eliminarUsuario(String aEmail) throws RemoteException;
	
	public boolean enviar(String aId_usuario_origen, String aDestinatario, String aAsunto, String aContenido) throws RemoteException;

	public Usuario acceder(String aEmail, String aContrasenia) throws RemoteException;

	public Casa[] Buscar(String aAccion, String aCp, String aProvincia, Double aPrecio, Double aSuperficie, Integer aNHabitaciones, String aTipo, String aEstado, String[] aExtras) throws RemoteException;

	public Casa cargarDatosVivienda(String aId_vivienda) throws RemoteException;
}