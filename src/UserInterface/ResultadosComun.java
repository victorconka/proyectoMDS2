package UserInterface;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class ResultadosComun extends JPanel {

	protected JButton volver;
	private Ordenar ord;
	protected ListaCasasComun lcc;
	
	public ResultadosComun() {		
		//UsuarioGenerico.getFrames()[0].setSize(Utils.wMedio+15, Utils.hMedio);
		
		setLayout(null);
		
		volver = new JButton("Volver");
		volver.setBounds(22, 335, 104, 23);
		add(volver);
		volver.setIcon(new ImageIcon("..\\ProyectoMDS2\\Iconos\\icono_volver.png"));
		
		ord = new Ordenar();
		add(ord);
		
		
		lcc = new ListaCasasComun();
		lcc.setOpaque(false);
		lcc.setLocation(0, 90);
		
		add(lcc);
						
	}
}