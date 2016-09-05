package UserInterface;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

import bbdd.IUsuario;

public class Mensaje extends ZonaMensaje {

	protected JButton enviarB;
	protected JButton volverB;
	
	public Mensaje() {
		
		enviarB = new JButton("Enviar");
		enviarB.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Registry r = LocateRegistry.getRegistry(null);
					IUsuario iu = (IUsuario) r.lookup("Servidor2");
					if (iu.enviar(String.valueOf(Utils.id), String.valueOf(Utils.idCasa), paraTF.getText(), asuntoTF.getText(), textoTA.getText()))
						JOptionPane.showMessageDialog(new JFrame(), "Mensaje enviado");
					else
						JOptionPane.showMessageDialog(new JFrame(), "Mensaje no enviado");
					
					// La dirección de envío (to)
				    String para = paraTF.getText();
				    // La dirección de la cuenta de envío (from)
				    String de = bbdd_gestion.UsuarioDAO.getUsuarioByORMID(Utils.id).getCorreo();
				    // Obtenemos las propiedades del sistema
				    Properties props = new Properties();
				    props.put("mail.smtp.auth", "true");
			        props.put("mail.smtp.starttls.enable", "true");
			        
			        if (de.contains("hotmail"))
			        	props.put("mail.smtp.host", "smtp.live.com");
			        else
			        	props.put("mail.smtp.host", "smtp.gmail.com");
			        
			        props.put("mail.smtp.port", "587");
			        props.put("mail.smtp.user", de);

				    // Obtenemos la sesión por defecto
				    Session sesion = Session.getDefaultInstance(props);
				    //sesion.setDebug(true);

				    // Creamos un objeto mensaje tipo MimeMessage por defecto.
				    MimeMessage mensaje = new MimeMessage(sesion);
				    // Asignamos el “de o from” al header del correo.
				    mensaje.setFrom(new InternetAddress(de));
				    // Asignamos el “para o to” al header del correo.
				    mensaje.addRecipient(Message.RecipientType.TO, new InternetAddress(para));
				    // Asignamos el asunto
				    mensaje.setSubject(asuntoTF.getText());
				    // Asignamos el mensaje como tal
				    mensaje.setText(textoTA.getText());
				    // Enviamos el correo
				    Transport t = sesion.getTransport("smtp");
				    t.connect(de, bbdd_gestion.UsuarioDAO.getUsuarioByORMID(Utils.id).getContrasenia());
				    t.sendMessage(mensaje,mensaje.getAllRecipients());
				    t.close();
				    System.out.println("Mensaje enviado");
				    
				    paraTF.setText("");
					asuntoTF.setText("");
					textoTA.setText("");
				} catch (Exception e1) {
					e1.printStackTrace();
				}
			}
		});
		enviarB.setLocation(316, 332);
		enviarB.setSize(100, 24);
		add(enviarB);
		
		volverB = new JButton("Volver");
		volverB.setLocation(32, 332);
		volverB.setSize(100, 24);
		add(volverB);
	}
	
}