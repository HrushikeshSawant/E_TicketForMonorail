package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.HashMap;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import bean.LoginBean;
import connection.DBConnection;

public class UserDetailsDao {

	private static Logger log = LogManager.getLogger(UserDetailsDao.class);
	HashMap<String, String> userDetails = new HashMap<String, String>();
	
	public HashMap<String, String> getUserDetails(LoginBean loginBean)
	{
		try
		{
			Connection con = DBConnection.DBCon();
			PreparedStatement ps = con.prepareStatement("SELECT Name, Email, Wallet, Status FROM users WHERE Email = ?");
			ps.setString(1, loginBean.getEmail());
			ResultSet rs = ps.executeQuery();
			
			while(rs.next())
			{
				userDetails.put("Name", rs.getString("Name"));
				userDetails.put("Email", rs.getString("Email"));
				userDetails.put("Wallet", rs.getString("Wallet"));
				userDetails.put("Status", rs.getString("Status"));
			}
			
			return userDetails;
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
		}
		return null;
	}
	
	public String getWalletAmount(String email)
	{
		try
		{
			Connection con = DBConnection.DBCon();
			PreparedStatement ps = con.prepareStatement("SELECT Wallet FROM users WHERE Email = ?");
			ps.setString(1, email);
			ResultSet rs = ps.executeQuery();
			
			while(rs.next())
			{
				return rs.getString("Wallet");
			}
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
		}
		return null;
	}
	
}
