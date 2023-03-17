package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import bean.GetUserDetailsBean;
import bean.LoginBean;
import bean.TicketHistoryBean;
import connection.DBConnection;

public class GetUserDetailsDao {
	
	private static Logger log = LogManager.getLogger(GetUserDetailsDao.class);
	
	public ArrayList<GetUserDetailsBean> getUserDetails()
	{
		ArrayList<GetUserDetailsBean> userDetails = new ArrayList<GetUserDetailsBean>();
		try
		{
			String name;
			String email;
			String accountStatus;
			Connection con;
			PreparedStatement ps;
			ResultSet rs;
			
			con = DBConnection.DBCon();
			int size = 0 ;
			ps = con.prepareStatement("SELECT COUNT(*) FROM users");
			rs = ps.executeQuery();
			
			while(rs.next()){
				size = Integer.parseInt(rs.getString(1));
			}
			
			GetUserDetailsBean getUserDetailsBean1 = new GetUserDetailsBean(size);
			userDetails.add(0, getUserDetailsBean1);
			
			ps = con.prepareStatement("SELECT Name, Email, Status FROM users");
			rs = ps.executeQuery();
			
			while(rs.next())
			{
				name = rs.getString("Name");
				email = rs.getString("Email");
				accountStatus = rs.getString("Status");
				GetUserDetailsBean getUserDetailsBean = new GetUserDetailsBean(name, email, accountStatus);
				userDetails.add(getUserDetailsBean);
			}
			
			return userDetails;
		}
		catch(Exception e)
		{
			e.getMessage();
		}
		
		log.trace("Something went wrong, Please try again..");
		return userDetails;
	}
	
	public ArrayList<GetUserDetailsBean> getActiveUserDetails()
	{
		ArrayList<GetUserDetailsBean> userDetails = new ArrayList<GetUserDetailsBean>();
		try
		{
			String name;
			String email;
			String accountStatus;
			Connection con;
			PreparedStatement ps;
			ResultSet rs;
			
			con = DBConnection.DBCon();
			int size = 0 ;
			ps = con.prepareStatement("SELECT COUNT(*) FROM users WHERE Status = 'Active'");
			rs = ps.executeQuery();
			
			while(rs.next()){
				size = Integer.parseInt(rs.getString(1));
			}
			
			GetUserDetailsBean getUserDetailsBean1 = new GetUserDetailsBean(size);
			userDetails.add(0, getUserDetailsBean1);
			
			ps = con.prepareStatement("SELECT Name, Email, Status FROM users WHERE Status = 'Active'");
			rs = ps.executeQuery();
			
			while(rs.next())
			{
				name = rs.getString("Name");
				email = rs.getString("Email");
				accountStatus = rs.getString("Status");
				GetUserDetailsBean getUserDetailsBean = new GetUserDetailsBean(name, email, accountStatus);
				userDetails.add(getUserDetailsBean);
			}
			
			return userDetails;
		}
		catch(Exception e)
		{
			e.getMessage();
		}
		
		log.trace("Something went wrong, Please try again..");
		return userDetails;
	}
}
