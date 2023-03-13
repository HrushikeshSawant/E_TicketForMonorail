package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import bean.LoginBean;
import bean.PassHistoryBean;
import connection.DBConnection;

public class PassHistoryDao {

private static Logger log = LogManager.getLogger(TicketHistoryDao.class);
	
	public ArrayList<PassHistoryBean> getPassHistory(LoginBean loginBean)
	{
		ArrayList<PassHistoryBean> passHistory = new ArrayList<PassHistoryBean>();
		try
		{
			String source;
			String destination;
			String validFrom;
			String validThrough;
			String passType;
			String modeofTransaction;
			double fare;
			String txnid;
			String dateTime;
			Connection con;
			PreparedStatement ps;
			ResultSet rs;
			
			con = DBConnection.DBCon();
			int size = 0 ;
			ps = con.prepareStatement("SELECT COUNT(*) FROM users u INNER JOIN pass_transaction pt ON u.Email = pt.Email WHERE u.Email = ?");
			ps.setString(1, loginBean.getEmail());
			rs = ps.executeQuery();
			
			while(rs.next()){
				size = Integer.parseInt(rs.getString(1));
			}
			
			PassHistoryBean passHistoryBean1 = new PassHistoryBean(size);
			passHistory.add(0, passHistoryBean1);
			
			ps = con.prepareStatement("SELECT pt.Source, pt.Destination, pt.Valid_From, pt.Valid_Through, pt.Pass_Type, pt.Mode_of_Transaction, pt.Fare, pt.Transaction_Id, pt.DateTime FROM users u INNER JOIN pass_transaction pt ON u.Email = pt.Email WHERE u.Email = ?");
			ps.setString(1, loginBean.getEmail());
			rs = ps.executeQuery();
			
			while(rs.next())
			{
				source = rs.getString("Source");
				destination = rs.getString("Destination");
				validFrom = rs.getString("Valid_From");
				validThrough = rs.getString("Valid_Through");
				passType = rs.getString("Pass_Type");
				modeofTransaction = rs.getString("Mode_of_Transaction");
				fare = rs.getDouble("Fare");
				txnid = rs.getString("Transaction_Id");
				dateTime = rs.getString("DateTime");
				PassHistoryBean passHistoryBean = new PassHistoryBean(source, destination, validFrom, validThrough, passType, modeofTransaction, fare, txnid, dateTime);
				passHistory.add(passHistoryBean);
			}
			
			return passHistory;
			
		}
		catch(Exception e)
		{
			e.getMessage();
		}
		
		log.trace("Something went wrong, Please try again..");
		return passHistory;
	}
	
}
