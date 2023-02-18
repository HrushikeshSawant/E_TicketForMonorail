package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import bean.LoginBean;
import connection.DBConnection;

public class LoginDao {

	private static Logger log = LogManager.getLogger(LoginDao.class);
	
	public String verifyUserLogin(LoginBean loginBean)
	{
		try
		{
			Connection con = DBConnection.DBCon();
			PreparedStatement ps;
			ResultSet rs;
			ps = con.prepareStatement("SELECT Name FROM users WHERE Email = ?");
			ps.setString(1, loginBean.getEmail());
			rs = ps.executeQuery();
			
			//USER VERIFICATION
			if(rs.next())
			{
				ps = con.prepareStatement("SELECT Name FROM users WHERE Email = ? AND Password = ?");
				ps.setString(1, loginBean.getEmail());
				ps.setString(2, loginBean.geth_password());
				rs = ps.executeQuery();
				
				if(rs.next())
				{
					log.trace("Login Successful");
					return "Login Successful";
				}
				else
				{
					//IF INCORRECT PASSWORD
					log.error("Incorrect Password");
					return "Incorrect Password";
				}
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
