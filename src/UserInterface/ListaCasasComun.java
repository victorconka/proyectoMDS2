package UserInterface;

import java.awt.BorderLayout;
import java.awt.Color;
import javax.swing.JScrollPane;
import java.awt.EventQueue;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.Arrays;
import java.util.Comparator;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;

import bbdd.IUsuario;
import bbdd_gestion.Casa;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.ScrollPaneConstants;


public class ListaCasasComun extends JPanel {
	//este mumero es aleatorio, para la implementación real 
	//este dato se obtiene de forma dinamica
	private int nResults = 0; //7
	protected JPanel panel = null;
	protected JScrollPane scroll = null;
	private Casa[] casas;


	public void cargarCasas(String aAccion, String aCp, String aProvincia, Double aPrecio, Double aSuperficie, Integer aNHabitaciones, String aTipo, String aEstado, String[] aExtras){

		//---------------------------------------------------------------------------------------------------------- 
		casas = null;
		try {
			Registry r = LocateRegistry.getRegistry(1099);
			IUsuario iu = (IUsuario) r.lookup("Servidor2");
			casas = iu.Buscar(aAccion, aCp, aProvincia, aPrecio, aSuperficie, aNHabitaciones, aTipo, aEstado, aExtras);

			//-------------------------------------------------------------------
			if(casas != null)
				nResults = casas.length;   

			cargarPanel();

			Casa c = null;
			//Ahora toca agregar nuestros resultados de busqueda al panel
			for(int i = 0;i < nResults; i++)
			{
				c = casas[i];
				DatosReducidos dr1 = new DatosReducidos();
				dr1.setBorder(new LineBorder(new Color(i*25, 0, 0), 2, true));
				dr1.setLocation(0,i*Utils.hDR);
				dr1.setCasa(c);
				panel.add(dr1);

			}  
			//-------------------------------------------------------------------
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
	/*
	 * valores entrada [0,7]
	 * */
	public void ordenar(int n){
		Comparator<bbdd_gestion.Casa> comp = null;
		
		switch(n){
		case 0: 
			comp = new OrdenarLccFechaG();
			break;
		case 1: 
			comp = new OrdenarLccFechaL();
			break;
        case 2: 
        	comp = new OrdenarLccPrecioG();
        	break;
        case 3: 
        	comp = new OrdenarLccPrecioL();
        	break;
        case 4: 
        	comp = new OrdenarLccHabG();
        	break;
        case 5: 
        	comp = new OrdenarLccHabL();
        	break;
        case 6: 
        	comp = new OrdenarLccSupG();
        	break;
        case 7: 
        	comp = new OrdenarLccSupL();
        	break;
		}
		
		Arrays.sort(this.casas, comp);
		System.out.println(Arrays.toString(this.casas));	
		cargarPanel();
		Casa c = null;
		//Ahora toca agregar nuestros resultados de busqueda al panel
		for(int i = 0;i < this.casas.length; i++)
		{
			c = this.casas[i];
			DatosReducidos dr1 = new DatosReducidos();
			dr1.setBorder(new LineBorder(new Color(i*25, 0, 0), 2, true));
			dr1.setLocation(0,i*Utils.hDR);
			dr1.setCasa(c);
			panel.add(dr1);

		} 
	}
	private void cargarPanel() {
		panel.removeAll();
		panel.revalidate();
		panel.repaint();

		scroll.revalidate();
		scroll.repaint();

		//------------------------------------------------------------------------------------------------------            
		//cargar citas
		//esta agrupación es SUPER IMPRESCINDIBLE
		//no se como, pero es la responsable de que todo funcione
		GroupLayout gl_panel = new GroupLayout(panel);
		//configuraciones del agrupamiento
		gl_panel.setHorizontalGroup(
				gl_panel.createParallelGroup(Alignment.LEADING)
				//wMedio w-width
				.addGap(0, Utils.wMedio, Short.MAX_VALUE)
				);
		gl_panel.setVerticalGroup(
				gl_panel.createParallelGroup(Alignment.LEADING)
				//hDR, h-height datos reducidos
				.addGap(0, (Utils.hDR*nResults), Short.MAX_VALUE)//tamaño del panel trasero
				);
		//se aplica el grid
		panel.setLayout(gl_panel);
		//------------------------------------------------------------------------------------------------------ 
		scroll.setOpaque(true);
		scroll.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		scroll.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scroll.setBounds(0,0,Utils.wMedio+20,  (Utils.hDR*3)); //tamaño de la ventana (scrollPane)
		scroll.setSize(Utils.wMedio, (Utils.hDR*3));
		//finalmente añadimos el panel construido al componente del panel this.
		add ( scroll, BorderLayout.CENTER );
	}

	public ListaCasasComun() {

		//tamaño del panel scrollPane
		this.setBounds(0,0,Utils.wMedio+30,  (Utils.hDR*3));
		//los layout es aconsejable ponerlos de acuerdo a como
		//estan puestos aqui
		setLayout(null);


		//----------------------------------------------------------------
		//panel que contendrá los resultados de busqueda
		panel = new JPanel ();

		//este panel de desplazamiento es la ventana a traves de la cual 
		//vamos a interactuar con los resultados de busqueda.

		scroll = new JScrollPane ( panel ); 


	}
	/**
	 * un pequeño lanzador
	 */
	/*
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JFrame f = new JFrame();
					f.getContentPane().setLayout(null);
					f.setSize(Utils.wMedio+40, 280);
					f.setVisible(true);	

					ListaCasasComun listaC = new ListaCasasComun();
					listaC.setVisible(true);
					f.getContentPane().add(listaC);

				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	*/
}