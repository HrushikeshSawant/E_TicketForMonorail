package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import bean.LoginBean;
import bean.TicketHistoryBean;
import connection.DBConnection;

public class TicketHistoryDao {
	
	private static Logger log = LogManager.getLogger(TicketHistoryDao.class);
	
	public ArrayList<TicketHistoryBean> getTicketHistory(LoginBean loginBean)
	{
		ArrayList<TicketHistoryBean> ticketHistory = new ArrayList<TicketHistoryBean>();
		try
		{
			String source;
			String destination;
			double passengersCount;
			String modeofTransaction;
			double fare;
			String txnid;
			String dateTime;
			Connection con;
			PreparedStatement ps;
			ResultSet rs;
			
			con = DBConnection.DBCon();
			int size = 0 ;
			ps = con.prepareStatement("SELECT COUNT(*) FROM users u INNER JOIN ticket_transaction tt ON u.Email = tt.Email WHERE u.Email = ?");
			ps.setString(1, loginBean.getEmail());
			rs = ps.executeQuery();
			
			while(rs.next()){
				size = Integer.parseInt(rs.getString(1));
			}
			
			TicketHistoryBean ticketHistoryBean1 = new TicketHistoryBean(size);
			ticketHistory.add(0, ticketHistoryBean1);
			
			ps = con.prepareStatement("SELECT tt.Source, tt.Destination, tt.Passengers_Count, tt.Mode_of_Transaction, tt.Fare, tt.Transaction_Id, tt.DateTime FROM users u INNER JOIN ticket_transaction tt ON u.Email = tt.Email WHERE u.Email = ?");
			ps.setString(1, loginBean.getEmail());
			rs = ps.executeQuery();
			
			while(rs.next())
			{
				source = rs.getString("Source");
				destination = rs.getString("Destination");
				passengersCount = rs.getDouble("Passengers_Count");
				modeofTransaction = rs.getString("Mode_of_Transaction");
				fare = rs.getDouble("Fare");
				txnid = rs.getString("Transaction_Id");
				dateTime = rs.getString("DateTime");
				TicketHistoryBean ticketHistoryBean = new TicketHistoryBean(source, destination, passengersCount, modeofTransaction, fare, txnid, dateTime);
				ticketHistory.add(ticketHistoryBean);
			}
			
			return ticketHistory;
			
		}
		catch(Exception e)
		{
			e.getMessage();
		}
		
		log.trace("Something went wrong, Please try again..");
		return ticketHistory;
	}

}