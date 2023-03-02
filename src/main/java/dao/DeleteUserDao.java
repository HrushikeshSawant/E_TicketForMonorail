package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import connection.DBConnection;

public class DeleteUserDao {
	
	private static Logger log = LogManager.getLogger(DeleteUserDao.class);
	
	public String deleteUser(String email)
	{
		
		try
		{
			Connection con = DBConnection.DBCon();
			PreparedStatement ps = con.prepareStatement("UPDATE users SET Status = 'Deleted' WHERE Email = ?");
			ps.setString(1, email);
			int i = ps.executeUpdate();
			
			if(i != 0)
			{
				log.info("Account deleted");
				return "Account deleted";
			}
			else
			{
				log.error("Account not deleted");
				return "Account not deleted";
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
