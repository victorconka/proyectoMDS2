package UserInterface;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.HashMap;

import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;
import javax.swing.GroupLayout.Alignment;
import javax.swing.border.LineBorder;

import bbdd.IUsuarioRegistrado;
import bbdd_gestion.Casa;

public class ListaViviendasEnPropiedad extends InformaciónListaCasas {

	private JScrollBar viviendasSB;
	private JButton volverB;
	protected Vivienda v;
	private Casa[] casas = null;
	private int i;
	private HashMap<JButton, Casa> map;
	//panel que contendrá los resultados de busqueda
	JPanel panel = new JPanel ();
	JScrollPane scroll = new JScrollPane ( panel );
	
	public ListaViviendasEnPropiedad() {
		
		v = new Vivienda();
		add(v).setVisible(false);		
		verCabecera();
		map = new HashMap<JButton, Casa>();
		

		v.eliminarVivienda.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Registry r = LocateRegistry.getRegistry(1099);
					IUsuarioRegistrado iu = (IUsuarioRegistrado) r.lookup("Servidor3");
					iu.eliminarVivienda(String.valueOf(Utils.id), String.valueOf(Utils.idCasa));
				} catch (Exception e1) {
					e1.printStackTrace();
				}
			}
		});
	}
	
	protected void cagarDatos() {
		JButton[] botones = null;
		
		try {
			Registry r = LocateRegistry.getRegistry(1099);
			IUsuarioRegistrado iu = (IUsuarioRegistrado) r.lookup("Servidor3");
			casas = iu.cargarViviendasPropias(String.valueOf(Utils.id));
			botones = new JButton[casas.length];
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		//tamaño del panel scrollPane
		this.setBounds(0,0,Utils.wMedio,  Utils.hMedio);
		//los layout es aconsejable ponerlos de acuerdo a como
		//estan puestos aqui
		setLayout(null);

		//----------------------------------------------------------------	

		panel.removeAll();
        panel.revalidate();
        panel.repaint();
        
        scroll.revalidate();
        scroll.repaint();
		
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
				.addGap(0, (Utils.hDR*casas.length), Short.MAX_VALUE)//tamaño del panel trasero
				);
		//se aplica el grid
		panel.setLayout(gl_panel);
		
		//Ahora toca agregar nuestros resultados de busqueda al panel
		for(i = 0; i < casas.length; i++)
		{
			InformaciónListaCasas dr1 = new InformaciónListaCasas();
			dr1.infoEstadoL.setText(casas[i].getEstado());
			dr1.infoInteresadosL.setText(String.valueOf(casas[i].getNumFavoritos()));
			dr1.infoVisitasL.setText(String.valueOf(casas[i].getNumVisitas()));
			dr1.verDatos();
			dr1.setBorder(new LineBorder(new Color(i*25, 0, 0), 2, true));
			dr1.setLocation(0,i*Utils.hDR);
			botones[i] = new JButton();
			botones[i].setContentAreaFilled(false);
			botones[i].setBounds(0,i*Utils.hDR, Utils.wMedio, Utils.hDR);
			botones[i].addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					for(Component c: getParent().getComponents())
						c.setVisible(false);
					esconder();
					panel.setOpaque(true);
					setVisible(true);
					v.setVisible(true);
					Utils.idCasa = map.get(e.getSource()).getORMID();
					v.cargarDatos();
				}
			});
			map.put(botones[i], casas[i]);
			dr1.verDatos();
			panel.add(dr1).setVisible(true);
			panel.add(botones[i]).setVisible(true);
		}  
		//-------------------------------------------------------------------

		//este panel de desplazamiento es la ventana a traves de la cual 
		//vamos a interactuar con los resultados de busqueda.
		scroll.setOpaque(true);
		scroll.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		scroll.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scroll.setBounds(0,97,450,  260); //tamaño de la ventana (scrollPane)
		scroll.setSize(Utils.wMedio, (Utils.hDR*3));
		scroll.setVisible(true);
		//finalmente añadimos el panel construido al componente del panel this.
		add(scroll, BorderLayout.CENTER);
	}
}