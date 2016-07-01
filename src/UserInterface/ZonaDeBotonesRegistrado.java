package UserInterface;

import javax.swing.JButton;

public class ZonaDeBotonesRegistrado extends ZonaBotonesComun {
	
	protected JButton fav;
	protected CitaRegistrado cr = new CitaRegistrado();
	protected ContactarRegistrado contr = new ContactarRegistrado();
	
	public ZonaDeBotonesRegistrado() {
		iconoVisitas = null;
		add(contr).setVisible(false);
		add(cr).setVisible(false);
		
		for (int i = 0; i < getComponentCount(); i++) {
			getComponents()[i].setVisible(false);
		}
	}
	
	protected void accionContactar(ResultadosComun rc) {
		setVisible(true);
		rc.setVisible(false);
		contr.setVisible(true);
	}
	
	protected void accionCita(ResultadosComun rc) {
		setVisible(true);
		rc.setVisible(false);
		cr.setVisible(true);
	}
}