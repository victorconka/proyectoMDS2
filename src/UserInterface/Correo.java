package UserInterface;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.ScrollPaneConstants;

public class Correo extends ZonaMensaje {
	
	protected JButton responder;
	protected JButton volver;
	private JTextArea textArea;
	private JScrollPane pane;
	private JLabel respuesta;
	
	public Correo() {
		separator_3.setLocation(415, 45);
		separator_2.setLocation(32, 45);
		separator_1.setLocation(32, 45);
		asuntoTF.setLocation(180, 113);
		asuntoTF.setEditable(true);
		separator_2.setSize(14, 470);
		separator_3.setSize(14, 470);
		separator.setLocation(32, 513);
		this.setSize(Utils.wMedio, Utils.hGrande);
		
		textArea = new JTextArea();
		textArea.setBounds(78, 339, 307, 113);
		pane = new JScrollPane(textArea);
		pane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		pane.setBounds(78, 339, 307, 113);
		add(pane);
		
		respuesta = new JLabel("Respuesta");
		respuesta.setBounds(78, 314, 89, 14);
		add(respuesta);
		
		volver = new JButton("Volver");
		volver.setBounds(78, 479, 89, 23);
		add(volver);
		
		responder = new JButton("Responder");
		responder.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				// La direcci�n de env�o (to)
			    String para = "s_vicuk@hotmail.com";

			    // La direcci�n de la cuenta de env�o (from)
			    String de = "xtremebos@gmail.com";

			    // El servidor (host). En este caso usamos localhost
			    String host = "localhost";

			    // Obtenemos las propiedades del sistema
			    Properties propiedades = System.getProperties();
			    Properties props = new Properties();
			    props.put("mail.smtp.auth", "true");
		        props.put("mail.smtp.starttls.enable", "true");
		        props.put("mail.smtp.host", "smtp.gmail.com");
		       // props.put("mail.smtp.host", "smtp.live.com");
		        props.put("mail.smtp.port", "587");
		       // props.put("mail.smtp.user", de);
		        
//		        propiedades.put("mail.smtp.auth", "false");
//		        propiedades.put("mail.smtp.starttls.enable", "true");
//		        propiedades.put("mail.smtp.host", "smtp.gmail.com");
//		        propiedades.put("mail.smtp.port", "587");

			    // Configuramos el servidor de correo
			    propiedades.setProperty("mail.smtp.host", host);

			    // Obtenemos la sesi�n por defecto
			    Session sesion = Session.getDefaultInstance(props);
			    sesion.setDebug(true);

			    try{
			      // Creamos un objeto mensaje tipo MimeMessage por defecto.
			      MimeMessage mensaje = new MimeMessage(sesion);

			      // Asignamos el �de o from� al header del correo.
			      mensaje.setFrom(new InternetAddress(de));

			      // Asignamos el �para o to� al header del correo.
			      mensaje.addRecipient(Message.RecipientType.TO, new InternetAddress(para));

			      // Asignamos el asunto
			      mensaje.setSubject("Primer correo sencillo");

			      // Asignamos el mensaje como tal
			      mensaje.setText("Probando correo con JavaMail");

			      // Enviamos el correo
			      Transport t = sesion.getTransport("smtp");
			      //t.connect("juanlu_bf@hotmail.com", "JL_02_06_1995");
			      t.connect("Xtremebos@gmail.com", "lacontraseniadegogle123");
			      t.sendMessage(mensaje,mensaje.getAllRecipients());
			      t.close();
			      System.out.println("Mensaje enviado");
			    } catch (MessagingException e) {
			      e.printStackTrace();
			    }
			}
		});
		responder.setBounds(254, 479, 131, 23);
		add(responder);
	}
}