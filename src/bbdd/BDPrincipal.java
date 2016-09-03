package bbdd;

import bbdd_gestion.Casa;
import bbdd_gestion.Correo;
import bbdd_gestion.Usuario;
import bbdd_gestion.UsuarioR;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;
import org.orm.PersistentException;

public class BDPrincipal implements IUsuarioRegistrado, IAdministrador {

	public Server _unnamed_Server_;
	public Casas bd_casas = new Casas();
	public Usuarios bd_usuarios = new Usuarios();
	public Correos bd_correos = new Correos();
	public Administradores bd_administradores = new Administradores();
	public Mapas bd_mapas = new Mapas();
	public Fotos bd_fotos = new Fotos();
	public Municipios bd_municipios = new Municipios();
	public Extras bd_extras = new Extras();
	public Provincias bd_provincias = new Provincias();
	public CodigosPostales bd_cps = new CodigosPostales();
	
	public static void main(String[] args)
	{
		if (System.getSecurityManager() == null) {
            System.setSecurityManager(new SecurityManager());
        }
		try {
            String nombre1 = "Servidor1";
            String nombre2 = "Servidor2";
            String nombre3 = "Servidor3";
            
            LocateRegistry.createRegistry(1099);
            BDPrincipal servidor = new BDPrincipal();
            Remote servicio = UnicastRemoteObject.exportObject(servidor, 0);
            
            IAdministrador administrador = (IAdministrador) servicio;
            IUsuario usuario = (IUsuario) servicio;
            IUsuarioRegistrado usuarioR = (IUsuarioRegistrado) servicio;
            
            Registry registry = LocateRegistry.getRegistry();
            
            registry.rebind(nombre1, administrador);
            registry.rebind(nombre2, usuario);
            registry.rebind(nombre3, usuarioR);

            System.out.println("Servidor Arrancado");
            
            /*
            UsuarioRCriteria cr = new UsuarioRCriteria();
            cr.id_Usuario.eq(1);           
            UsuarioR aU = bbdd_gestion.UsuarioRDAO.loadUsuarioRByCriteria(cr);
            
            Casa c[] = servidor.obtenerFavoritas(aU);
            if(c == null){
            	System.out.println("CASA NULL");
            }else{
            	System.out.println(c.length + " <---- length");
            }
            */
        } catch (Exception e) {
            System.err.println("Problema con el servidor");
            e.printStackTrace();
        }
	};
	
	//implementado, sin probar
	//los datos se guardan tras su modificacion
	
	public Casa cargarDatosVivienda(String aId_vivienda) {
		try {
			return this.bd_casas.cargarDatosVivienda(aId_vivienda);
		} catch (PersistentException e) {
			e.printStackTrace();
		}
		//carga no fue exitosa
		return null;
	}
	

	public boolean registrarVivienda(String aDireccion, String aMunicipio, String aProvincia, String aCp, String[] aFotos, String aPrecio, String aSuperficie, String aHabitaciones, String aBanios, String aTipo, String[] aExtras, String aEstado, String aAccion, String aMapa, String aDCorta, String aDLarga, String aVisible) {
		try {
			return this.bd_casas.registrarVivienda(aDireccion, aMunicipio, aProvincia, aCp, aFotos, aPrecio, aSuperficie, aHabitaciones, aBanios, aTipo, aExtras, aEstado, aAccion, aMapa, aDCorta, aDLarga, aVisible);
		} catch (PersistentException e) {
			e.printStackTrace();
		}
		return false;
	}

	public boolean guardarDatos(String aNombre, String aApellidos, String aDireccion, String aMunicipio, String aProvincia, String aCp, String aEmail, String aPassword, String ORMidUsuario) {	
		UsuarioR u = null;
		try {
		
			u = bbdd_gestion.UsuarioRDAO.createUsuarioR();
			u.setNombre(aNombre);
			u.setApellidos(aApellidos);
			u.setCodigoPostal(aCp);
			u.setCorreo(aEmail);
			String direccion = aDireccion + "; " + aMunicipio + "; " + aProvincia;
			u.setDireccion(direccion);
			u.setContrasenia(aPassword);
			bbdd_gestion.UsuarioRDAO.save(u);
			
			return this.bd_usuarios.guardarDatos(u,ORMidUsuario);
		} catch (PersistentException e) {
			e.printStackTrace();
		}
		return false;
	}

	public boolean favCasa(String aId_casa, String aId_usuario) {
		try {
			return bd_casas.favCasa(aId_casa, aId_usuario);
		} catch (PersistentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}

	public boolean eliminarVivienda(String aId_usuario, String aId_vivienda) {
		try {
			return this.bd_casas.eliminarVivienda(aId_usuario, aId_vivienda);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}
	public boolean modificarVivienda(String aDireccion, String aMunicipio, String aProvincia, String aCp,
			String[] aFotos, String aPrecio, String aSuperficie, String aHabitaciones, String aBanios, String aTipo,
			String[] aExtras, String aEstado, String aAccion, String aMapa, String aDCorta, String aDLarga, String aVisible) {
		try {
			return this.bd_casas.modificarVivienda(aDireccion, aMunicipio, aProvincia, aCp, aFotos, aPrecio, aSuperficie, 
					aHabitaciones, aBanios, aTipo, aExtras, aEstado, aAccion, aMapa, aDCorta, aDLarga, aVisible);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	public boolean modificarEstadoVivienda(String aId_usuario, String aId_vivienda, String aEstado) {
		try {
			return this.bd_casas.modificarEstadoVivienda(aId_usuario, aId_vivienda, aEstado);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	//implementado - sin probar
	//modificada la devolucion porque String[] no tiene sentido ...
	//al no ser que se manden cadenas concatenadas de "fuente + ; + adunto + ; + texto(cortado a cierta longitud)"
	public Correo[] cargarListadoCorreos(String aId_vivienda, String aId_usuario) {
		try{
			return this.bd_correos.cargarListadoCorreos(aId_vivienda, aId_usuario);
		} catch (PersistentException e) {
			e.printStackTrace();
		}
		return null;
	}

	//metodo implementado sin probar
	public Correo cargarContenidoCorreo(String aId_usuario, String aId_correo) {
		try {
			return this.bd_correos.cargarContenidoCorreo(aId_usuario, aId_correo);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
//implementado, sin testear.	
	public String[] cargarUsuariosInteresados(String aId_usuario, String aId_vivienda) {
		try {
			return bd_usuarios.cargarUsuariosInteresados(aId_usuario, aId_vivienda);
		} catch (PersistentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	//implmenentado, sin probar
	public UsuarioR cargarDatosUsuario(String aId_usuario) {
		try {
			return this.bd_usuarios.cargarDatosUsuario(aId_usuario);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public Casa[] cargarViviendasPropias(String aId_usuario) {
		try {
			return this.bd_casas.cargarViviendasPropias(aId_usuario);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	//0 -> encontrado usuario, no tiene favoritos
	public Casa[] obtenerFavoritas(UsuarioR aU) {
		try {
			return this.bd_usuarios.obtenerFavoritas(aU);
		} catch (PersistentException e) {
			e.printStackTrace();
		}
		return null;
	}
	/* ************************************************************************ */
	/* ************************************************************************ */
	/* ************************************************************************ */
	// METODOS IMPLEMENTADOS Y TESTEADOS
	

	public Casa[] Buscar(String aAccion, String aCp, String aProvincia, Double aPrecio, Double aSuperficie, Integer aNHabitaciones, String aTipo, String aEstado, String[] aExtras) {
		try {
			String price;
			if(aPrecio == null || aPrecio == 0.0){
				price = null;
			}else{
				price = aPrecio.toString();
			}
			return this.bd_casas.Buscar(aAccion, aCp, aProvincia, price, aSuperficie, aNHabitaciones, aTipo, aEstado, aExtras);
		} catch (PersistentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//consulta sin éxito
		return null;
	}
	
	public void registrarAdmin(String aNombre, String aEmail, String aContrasenia) {
		try {
			this.bd_administradores.registrarAdmin(aNombre, aEmail, aContrasenia);
		} catch (PersistentException e) {
			e.printStackTrace();
		}
	}
	
	public Usuario acceder(String aEmail, String aContrasenia) {

		try {
			return this.bd_usuarios.acceder(aEmail, aContrasenia);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	/**
	 * metodo implementado
	 * registra un usuario
	 */
	public boolean Registrarse(String aNombre, String aApellidos, String aDireccion, String aMunicipio, String aProvincia, String aCp, String aEmail, String aContrasenia) { 
		try {
			return this.bd_usuarios.Registrarse(aNombre, aApellidos, aDireccion, aMunicipio, aProvincia, aCp, aEmail, aContrasenia);
		} catch (PersistentException e) {
			e.printStackTrace();
		}
		return false;
	}
	
	public boolean eliminarUsuario(String aEmail) {
		try {
			return this.bd_usuarios.eliminarUsuario(aEmail);
		} catch (PersistentException e) {
			e.printStackTrace();
		}
		return false;
	}
	
	public boolean enviar(String aId_usuario_origen, String aId_casa, String aDestinatario, String aAsunto, String aContenido) {
		//throw new UnsupportedOperationException();
		try {
			return this.bd_correos.enviar(aId_usuario_origen, aId_casa, aDestinatario, aAsunto, aContenido);
		} catch (PersistentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}



}