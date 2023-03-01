package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import connection.DBConnection;

public class NewPasswordDao {
	
	private static Logger log = LogManager.getLogger(NewPasswordDao.class);
	
	public String updatePassword(String Email, String h_password)
	{
		
		try
		{
			Connection con = DBConnection.DBCon();
			PreparedStatement ps = con.prepareStatement("UPDATE users SET Password = ? WHERE Email = ?");
			ps.setString(1, h_password);
			ps.setString(2, Email);
			int i = ps.executeUpdate();
			
			if(i != 0)
			{
				log.info("Password updated");
				return "Password updated";
			}
			else
			{
				log.error("Password not updated");
				return "Password not updated";
			}
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
		}
		
		log.trace("Something went wrong, Please try again..");
		return "Something went wrong, Please try again..";
	}

}
