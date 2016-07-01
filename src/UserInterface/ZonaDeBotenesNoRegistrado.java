package UserInterface;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class ZonaDeBotenesNoRegistrado extends ZonaBotonesComun {
	
	private CitaNoRegistrado cnr = new CitaNoRegistrado();
	protected ContactarNoRegistrado contnr = new ContactarNoRegistrado();
	private FavoritoNoRegistrado fnr = new FavoritoNoRegistrado();
	
	public ZonaDeBotenesNoRegistrado() {
	}
	
	protected void accion(Entrar ent, ResultadosComun rc) {
		ent.setVisible(true);
		ent.setOpaque(false);
		rc.setVisible(false);
		JOptionPane.showMessageDialog(new JFrame(), "Debes estar registrado en el sistema antes");
	}
	
}