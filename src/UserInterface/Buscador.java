package UserInterface;


import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Buscador extends JPanel{
	private ImageIcon foto;
	protected JTextField txtBuscarUsuario;
	
	public Buscador() {
		this.setLayout(null);
		this.setBounds(5,5,200,50);
		
		this.txtBuscarUsuario = new JTextField();
		this.txtBuscarUsuario.setBounds(30, 11, 160, 25);
		this.txtBuscarUsuario.setToolTipText("Buscar usuario\r\n");
		this.txtBuscarUsuario.setColumns(10);
		
		add(this.txtBuscarUsuario);	
		
	}
	
}