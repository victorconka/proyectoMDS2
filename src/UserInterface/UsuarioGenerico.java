package UserInterface;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

import javax.swing.JFrame;

import bbdd.IAdministrador;
import bbdd.IUsuarioRegistrado;

public class UsuarioGenerico extends JFrame {
	
	protected PrimerFiltroComun pfc = new PrimerFiltroComun();
	protected SegundoFiltroComun sfc = new SegundoFiltroComun();
	protected ResultadosComun rc = new ResultadosComun();
	protected static UsuarioNoRegistrado window = new UsuarioNoRegistrado();
	private static UsuarioRegistrado window2 = new UsuarioRegistrado();
	private static Administrador window3 = new Administrador();
	
	public UsuarioGenerico() {
		setResizable(false); 

		
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.getContentPane().setSize(Utils.wMedio, Utils.hMedio);
		
		getContentPane().setLayout(null);
		
		pfc.setOpaque(false);
		this.setSize(Utils.wMedio+15, Utils.hMedio);
		pfc.setBounds(0, 0, Utils.wMedio+15, Utils.hMedio);
		getContentPane().add(pfc);
		
		pfc.buscar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				pfc.setVisible(false);
				sfc.setVisible(true);
			}
		});
		
		sfc.setOpaque(false);
		getContentPane().add(sfc).setVisible(false);
		sfc.setBounds(0, 0, Utils.wMedio, Utils.hMedio);
		
		sfc.buscar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				sfc.setVisible(false);
				rc.setVisible(true);
//---------------------------------------------------------------------------------------------------------- 
////////////////OBTENEMOS DATOS Y LLAMAMOS LA BUSQUEDA
//---------------------------------------------------------------------------------------------------------- 
				//Primer filtro
				String accion = pfc.getAccion();
				String cp = pfc.getCP();
				String prov = pfc.getProvincia();
				//Segundo filtro
				String pre = sfc.getPrecioTF();
				String sup = sfc.getSuperficieTF();
				String nHab = sfc.getHabitacionesTF();
				String banios = sfc.getBañosTF();
				String tipo = sfc.getTipoCB();
				String estado = sfc.getEstadoCB();
				//segundo filtro extras
				String extras[] = sfc.getExtras();
//---------------------------------------------------------------------------------------------------------- 
////////////////LLAMAMOS EL METODO
//----------------------------------------------------------------------------------------------------------
				Double precio = null;
				if(pre!= null && pre != ""){
					precio = Double.valueOf(pre);
				}
				Double superficie = null;
				if(sup!= null && sup != ""){
					superficie = Double.valueOf(sup);
				}	
				int n = 0;
				if(nHab != null && nHab!= "")
					n = Integer.valueOf(nHab);
				
				rc.lcc.cargarCasas(accion, cp, prov, precio, superficie, n, tipo, estado, extras);
			}
		});
		
		sfc.volver.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				pfc.setVisible(true);
				sfc.setVisible(false);
			}
		});
		
		rc.setOpaque(false);
		getContentPane().add(rc).setVisible(false);
		rc.setBounds(0, 0, Utils.wMedio, Utils.hMedio);
		
		
		
		rc.volver.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				rc.setVisible(false);
				sfc.setVisible(true);
			}
		});
		
	}
	
	protected void cambiarUsuario(boolean unr, boolean ur) {
		if (unr){
			boolean e = false;
			for(int n = 0;n <UsuarioGenerico.getFrames().length; n++){
				if(UsuarioGenerico.getFrames()[n].toString().contains("UsuarioNoRegistrado")){
					e = true;
				}
			}
			if(!e)
				window = new UsuarioNoRegistrado();
		}
		window.setVisible(unr);
		window2.setVisible(ur);
		if (ur){
			window2.pur.lvp.cargarViviendasPropias();
		}
	}
	
	public void cambiarAdmin(boolean unr, boolean admin) {
		if (unr){
			boolean e = false;
			for(int n = 0;n <UsuarioGenerico.getFrames().length; n++){
				if(UsuarioGenerico.getFrames()[n].toString().contains("UsuarioNoRegistrado")){
					e = true;
				}
			}
			if(!e)
				window = new UsuarioNoRegistrado();
		}
		window.setVisible(unr);
		window3.setVisible(admin);
	}
	
	private static void setAdmin() {
		IAdministrador ia = null;
		try {
			Registry registry = LocateRegistry.getRegistry(1099);
			ia = (IAdministrador) registry.lookup("Servidor1");
			ia.registrarAdmin("admin", "jbf441@inlumine.ual.es", "z43j7mn7");
			IUsuarioRegistrado u = (IUsuarioRegistrado) registry.lookup("Servidor3");
			//u.Registrarse("nombre", "apellido", "direccion", "municipio", "provincia", "cp", "email@hotmail.com", "pass");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		/* El metodo setAdmin solo debe llamarse una vez cuando la bd esta 
		recien creada, ya que solo tendremos un administrador en la aplicacion */
		
		//setAdmin();
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					window.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
}