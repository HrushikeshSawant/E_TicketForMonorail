package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import connection.DBConnection;

public class AdminRecoveryDao {
	
	private static Logger log = LogManager.getLogger(AdminRecoveryDao.class);

	public String checkAdminEmailExist(String email)
	{
		try
		{
			Connection con = DBConnection.DBCon();
			PreparedStatement ps = con.prepareStatement("SELECT Name FROM admins WHERE Email = ?");
			ps.setString(1, email);
			ResultSet rs = ps.executeQuery();
			
			if(rs.next())
			{
				//IF EMAIL EXISTS
				log.info("Email exists");
				return "Email exists"; 
				
			}
			else
			{
				//IF EMAIL DOES NOT EXISTS
				log.error("Email does not exists");
				return "Email does not exists"; 
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
