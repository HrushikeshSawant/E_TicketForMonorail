package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.Register;

import bean.User;
import connection.DBConnection;

public class RegisterDao {
	
	private static Logger log = LogManager.getLogger(RegisterDao.class);

	public String verifyAndInsetNewUser(User user) throws Throwable
	{
		try
		{
			double walletAmount = 0.0;
			log.info("Getting Connection con object");
			Connection con = DBConnection.DBCon();
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery("Select * from users where Email = '" + user.getEmail() + "'");
			
			if(!rs.next())
			{
				
			}
			else
			{
				System.out.println("Email already exists");
			}
		}
		catch(Exception e)
		{
			log.error("Exception occurred in RegisterDao");
			System.out.println(e.getMessage());
		}
		return "Something went wrong, Please try again..";
	}
	
}
