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

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class sendEmail {
	
	final static String from = "monorail.mmrda@gmail.com";
	final static String pass = "jqysqgedjroidlqz";
	private static Logger log = LogManager.getLogger(sendEmail.class);
	
	public static String sendEmailToUser(String email, String functionality, String data) {
        
		String subject = null;
		String body = null;
        String to = email;
        
        if(functionality.equalsIgnoreCase("otp"))
        {
        	subject = "MUMBAI MONORAIL: Request for Password Change";				  
    		body = "Your OTP for Password Change is : " + data;
        }
        else if(functionality.equalsIgnoreCase("User delete"))
        {
        	subject = "MUMBAI MONORAIL: Account Deleted!";				  
    		body = "Thank You for using E-TicketForMonorail. \nYour account has been deleted successfully!!";
        }
        else if(functionality.equalsIgnoreCase("Admin delete"))
        {
			subject = "MUMBAI MONORAIL: Account Deleted!";				  
			body = "Hello User, \n\nYour User Account on E-TicketForMonorail has been permanently deleted due to violation of some rules. \n\n For any Query mail us on: monorail.mmrda@gmail.com";
        }
        
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
		
//		session.setDebug(true);
		
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
			log.trace("Login Successful");
			return "Email Sent";
		} 
		catch (MessagingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		log.trace("Something went wrong, Please try again..");
		return "Something went wrong, Please try again..";
    }
	
	public static String sendTicketDetailsToUser(String name, String email, String source, String destination, double passengersCount, double fare, String txnid, String dateTime) {
        
        String to = email;
        String subject = "MUMBAI MONORAIL: Ticket Details";		      
		String body = "Name: "+name+"\n"+"Email: "+to+"\n"+"Source: "+source+"\n"+"Destination: "+destination+"\n"+
					  "No. of Passangers: "+passengersCount+"\n"+"Amount: "+fare+"\n"+
					  "Transaction Id: "+txnid+"\n"+"Issue Time: "+dateTime+"\n\n*Journey should be commence within 2 hours from Issue";
        
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
		
//		session.setDebug(true);
		
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
			log.trace("Login Successful");
			return "Email Sent";
		} 
		catch (MessagingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		log.trace("Something went wrong, Please try again..");
		return "Something went wrong, Please try again..";
    }
	
	public static String sendPassDetailsToUser(String name, String email, String source, String destination, String validFrom, String validThrough, String passType, double fare, String txnid, String dateTime) {
		
		String to = email;
		String subject = "MUMBAI MONORAIL: Pass Details";				  
		String body = "Name: "+name+"\n"+"Email: "+to+"\n"+"Source: "+source+"\n"+"Destination: "+destination+"\n"+
					  "Valid From: "+validFrom+"\n"+"Valid Though: "+validThrough+"\n"+
					  "Type: "+passType+"\n"+"Amount: "+fare+"\n"+
					  "Transaction Id: "+txnid+"\n"+"Date and Time: "+dateTime;
		
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
		
//		session.setDebug(true);
		
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
			log.trace("Login Successful");
			return "Email Sent";
		} 
		catch (MessagingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		log.trace("Something went wrong, Please try again..");
		return "Something went wrong, Please try again..";
	}
	
	public static String adminPasswordChangeRequest(String email) {
		
		String to = from;
		String subject = "MUMBAI MONORAIL: ADMIN PASSWORD RESET REQUEST";				  
		String body = "Hi Team, \n\nRequest to change admin password for '" + email + "' email address. \n\nThanks & Regards, \nAdmin.";
		
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
		
//		session.setDebug(true);
		
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
			log.trace("Login Successful");
			return "Email Sent";
		} 
		catch (MessagingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		log.trace("Something went wrong, Please try again..");
		return "Something went wrong, Please try again..";
	}
	
	public static String sendTicketFromAdminDetailsToUser(String email, String source, String destination, double passengersCount, double fare, String txnid, String dateTime) {
        
        String to = email;
        String subject = "MUMBAI MONORAIL: Ticket Details";		      
		String body = "Email: "+to+"\n"+"Source: "+source+"\n"+"Destination: "+destination+"\n"+
					  "No. of Passangers: "+passengersCount+"\n"+"Amount: "+fare+"\n"+
					  "Transaction Id: "+txnid+"\n"+"Issue Time: "+dateTime+"\n\n*Journey should be commence within 2 hours from Issue";
        
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
		
//		session.setDebug(true);
		
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
			log.trace("Login Successful");
			return "Email Sent";
		} 
		catch (MessagingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		log.trace("Something went wrong, Please try again..");
		return "Something went wrong, Please try again..";
    }
}