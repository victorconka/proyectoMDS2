package UserInterface;

import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollBar;
import javax.swing.AbstractListModel;

public class ListaUsuariosInteresados extends JPanel {

	private JLabel usuariosInteresados;
	protected JList<String> usuariosL;
	private JPanel usuariosSP;
	private JScrollBar barra;
	
	public ListaUsuariosInteresados() {
		setLayout(null);
		setSize(Utils.wMedio, Utils.hMedio);
		
		usuariosInteresados = new JLabel("Usuarios interesados");
		usuariosInteresados.setBounds(32, 172, 129, 27);
		add(usuariosInteresados);
		
		barra = new JScrollBar();
		barra.setLocation(150, 199);
		barra.setSize(17, 112);
		//add(barra);
		
		usuariosL = new JList<String>();
		usuariosL.setBounds(32, 199, 135, 112);
		add(usuariosL);
	}

}