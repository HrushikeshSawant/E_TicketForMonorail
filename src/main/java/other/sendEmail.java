package other;

import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class sendEmail {
	
	public static void main(String[] args) {
        
		String result1;
        String to = "hsawant2209@gmail.com";
		String subject = "Account Deleted!";				  
		String body = "Your User Account on E-Ticket for Monorail has been permanently deleted due to violation of some rules. \n\n\n For any Query mail us on: monorail.mmrda@gmail.com";
				
		final String from = "monorail.mmrda@gmail.com";
		final String pass = "jqysqgedjroidlqz";

		Properties prop = new Properties();
		prop.put("mail.smtp.host", "smtp.gmail.com");
		prop.put("mail.smtp.port", "465");
		prop.put("mail.smtp.ssl.enable", "true");
		prop.put("mail.smtp.auth", "true");
		
		Session session = Session.getInstance(prop, new Authenticator() {
			
			@Override
			protected PasswordAuthentication getPasswordAuthentication()
			{
				return new PasswordAuthentication(from, pass);
			}
			
		});
		
		session.setDebug(true);
		
		MimeMessage message = new MimeMessage(session);
		try 
		{
			message.setFrom(new InternetAddress(from));
			message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));
			message.setSubject(subject);
			message.setText(body);
			System.out.println("Sending...");
			Transport.send(message);
			System.out.println("Email Sent...");
			
		} 
		catch (MessagingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
    }
}
