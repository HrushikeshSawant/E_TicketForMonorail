package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import bean.GetUserDetailsBean;
import bean.UserBean;
import connection.DBConnection;

public class HistoricUserDetailsDao {
	
	private static Logger log = LogManager.getLogger(HistoricUserDetailsDao.class);
	
	public ArrayList<UserBean> getActiveUserDetails()
	{
		ArrayList<UserBean> historicUserDetails = new ArrayList<UserBean>();
		try
		{
			String name;
			String email;
			Connection con;
			PreparedStatement ps;
			ResultSet rs;
			
			con = DBConnection.DBCon();
			int size = 0 ;
			ps = con.prepareStatement("SELECT COUNT(*) FROM historic_users_data");
			rs = ps.executeQuery();
			
			while(rs.next()){
				size = Integer.parseInt(rs.getString(1));
			}
			
			UserBean userBean1 = new UserBean(size);
			historicUserDetails.add(0, userBean1);
			
			ps = con.prepareStatement("SELECT Name, Email FROM historic_users_data");
			rs = ps.executeQuery();
			
			while(rs.next())
			{
				name = rs.getString("Name");
				email = rs.getString("Email");
				UserBean userBean = new UserBean(name, email);
				historicUserDetails.add(userBean);
			}
			
			return historicUserDetails;
			
		}
		catch(Exception e)
		{
			e.getMessage();
		}
		
		log.trace("Something went wrong, Please try again..");
		return historicUserDetails;
	}
}
