package bbdd;

import bbdd_gestion.Casa;
import bbdd_gestion.Correo;
import bbdd_gestion.UsuarioR;
import java.rmi.RemoteException;

public interface IUsuarioRegistrado extends IUsuario {

	public boolean Registrarse(String aNombre, String aApellidos, String aDireccion, String aMunicipio, String aProvincia, String aCp, String aEmail, String aContrasenia) throws RemoteException;

	public boolean registrarVivienda(String aDireccion, String aMunicipio, String aProvincia, String aCp, String[] aFotos, String aPrecio, String aSuperficie, String aHabitaciones, String aBanios, String aTipo, String[] aExtras, String aEstado, String aAccion, String aMapa, String aDCorta, String aDLarga, String aVisible) throws RemoteException;

	public Casa[] obtenerFavoritas(UsuarioR aUsuario) throws RemoteException;

	public boolean guardarDatos(String aNombre, String aApellidos, String aDireccion, String aMunicipio, String aProvincia, String aCp, String aEmail, String aPassword, String ORMidUsuario) throws RemoteException;

	public boolean favCasa(String aId_casa, String aId_usuario) throws RemoteException;

	public boolean eliminarVivienda(String aId_usuario, String aId_vivienda) throws RemoteException;

	public boolean modificarVivienda(String aDireccion, String aMunicipio, String aProvincia, String aCp, String[] aFotos, String aPrecio, String aSuperficie, String aHabitaciones, String aBanios, String aTipo, String[] aExtras, String aEstado, String aAccion, String aMapa, String aDCorta, String aDLarga, String aVisible) throws RemoteException;

	public boolean modificarEstadoVivienda(String aId_usuario, String aId_vivienda, String aEstado) throws RemoteException;

	public Correo[] cargarListadoCorreos(String aId_vivienda, String aId_usuario) throws RemoteException;

	public Correo cargarContenidoCorreo(String aId_usuario, String aId_correo) throws RemoteException;

	public String[] cargarUsuariosInteresados(String aId_usuario, String aId_vivienda) throws RemoteException;

	public UsuarioR cargarDatosUsuario(String aId_usuario) throws RemoteException;

	public Casa[] cargarViviendasPropias(String aId_usuario) throws RemoteException;
}