package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.Register;

import bean.UserBean;
import connection.DBConnection;

public class RegisterDao {
	
	private static Logger log = LogManager.getLogger(RegisterDao.class);

	public String verifyAndInsetNewUser(UserBean user) throws Throwable
	{
		try
		{
			double walletAmount = 0.0;
			log.info("Getting Connection con object");
			Connection con = DBConnection.DBCon();
			Statement st = con.createStatement();
			ResultSet emailCheck = st.executeQuery("Select * from users where Email = '" + user.getEmail() + "'");
			
			if(!emailCheck.next())
			{
				ResultSet mobileCheck = st.executeQuery("Select * from users where Mobile_No = '" + user.getmobile_no() + "'");
				
				//IF EMAIL DOES NOT EXISTS
				if(!mobileCheck.next())
				{
					//IF MOBILE NO. DOES NOT EXISTS
					String sql = "INSERT INTO users (Name, Email, Mobile_No, Password, Wallet) VALUES (?, ?, ?, ?, ?)";
					
					PreparedStatement ps = con.prepareStatement(sql);
					ps.setString(1, user.getName());
					ps.setString(2, user.getEmail());
					ps.setString(3, user.getmobile_no());
					ps.setString(4, user.getH_password());
					ps.setDouble(5, walletAmount);
					
					int i = ps.executeUpdate();
					
					//TO ENSURE WHETHER DATA IS INSERTES. 1 = INSERTED, 0 = NOT INSERTED.
					if(i != 0)
						return "Successful";
					
				}
				else
				{
					return "Mobile No. already exists";
				}
			}
			else
			{
				return "Email already exists";
			}
			
			con.close();
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
		}
		
		log.info("Something went wrong, Please try again..");
		return "Something went wrong, Please try again..";
	}
	
}
