package UserInterface;

import java.util.Properties;

import javax.mail.Message;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;


public class GCorreos implements GestorCorreos {

	@Override
	public void enviar(String de, String para, String asunto, String texto) {
		try {
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
		    mensaje.setSubject(asunto);
		    // Asignamos el mensaje como tal
		    mensaje.setText(texto);
		    // Enviamos el correo
		    Transport t = sesion.getTransport("smtp");
		    t.connect(de, bbdd_gestion.UsuarioDAO.getUsuarioByORMID(Utils.id).getContrasenia());
		    t.sendMessage(mensaje,mensaje.getAllRecipients());
		    t.close();
		    System.out.println("Mensaje enviado");
		} catch (Exception e1) {
			e1.printStackTrace();
		}
	}

}
