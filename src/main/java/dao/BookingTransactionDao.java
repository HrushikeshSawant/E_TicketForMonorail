package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import connection.DBConnection;

public class BookingTransactionDao {
	
	private static Logger log = LogManager.getLogger(BookingTransactionDao.class);
	
	public String updateTicketTransaction(String email, String source, String destination, double passengersCount, double fare, String MOT, String txnid, String dateTime)
	{
		try
		{
			String walletUpdateStatus = null;
			Connection con = DBConnection.DBCon();
			PreparedStatement ps = con.prepareStatement("INSERT INTO ticket_transaction (Email, Source, Destination, Passengers_Count, Fare, Mode_of_Transaction, Transaction_Id, DateTime) VALUES (?, ?, ?, ?, ?, ?, ?, ?)");
			ps.setString(1, email);
			ps.setString(2, source);
			ps.setString(3, destination);
			ps.setDouble(4, passengersCount);
			ps.setDouble(5, fare);
			ps.setString(6, MOT);
			ps.setString(7, txnid);
			ps.setString(8, dateTime);
			
			int i = ps.executeUpdate();
			
			if(MOT.equalsIgnoreCase("WALLET"))
			{
				WalletDao walletDao = new WalletDao();
				double wallet = Double.parseDouble(walletDao.getWalletAmount(email));
				walletUpdateStatus = walletDao.updateWalletAmount(email, (Double)(wallet-fare));
			}
			
			
			if(MOT.equalsIgnoreCase("WALLET"))
			{
				//TO ENSURE WHETHER DATA IS INSERTES. 1 = INSERTED, 0 = NOT INSERTED.
				if(i != 0 && walletUpdateStatus.equalsIgnoreCase("Successful"))
					return "Successful";
			}
			else
			{
				if(i != 0)
					return "Successful";
			}
			
			return "Unsuccessful";
			
		}
		catch(Exception e)
		{
			e.getMessage();
		}
		
		log.trace("Something went wrong, Please try again..");
		return "Something went wrong, Please try again..";
	}
	
	public String updatePassTransaction(String email, String source, String destination, String validFrom, String validThrough, String passType, double fare, String MOT, String txnid, String dateTime)
	{
		try
		{
			Connection con = DBConnection.DBCon();
			PreparedStatement ps = con.prepareStatement("INSERT INTO pass_transaction (Email, Source, Destination, Valid_From, Valid_Through, Pass_Type, Fare, Mode_of_Transaction, Transaction_Id, DateTime) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)");
			ps.setString(1, email);
			ps.setString(2, source);
			ps.setString(3, destination);
			ps.setString(4, validFrom);
			ps.setString(5, validThrough);
			ps.setString(6, passType);
			ps.setDouble(7, fare);
			ps.setString(8, MOT);
			ps.setString(9, txnid);
			ps.setString(10, dateTime);
			
			int i = ps.executeUpdate();
			
			if(i != 0)
				return "Successful";
		
			return "Unsuccessful";
		
		}
		catch(Exception e)
		{
			e.getMessage();
		}
		log.trace("Something went wrong, Please try again..");
		return "Something went wrong, Please try again..";
	}

	public String updateAdminTicketTransaction(String adminEmail, String userEmail, String source, String destination, double passengersCount, double fare, String MOT, String txnid, String dateTime)
	{
		try
		{
			Connection con = DBConnection.DBCon();
			PreparedStatement ps = con.prepareStatement("INSERT INTO admin_ticket_transaction (Email, User_Email, Source, Destination, Passengers_Count, Fare, Mode_of_Transaction, Transaction_Id, DateTime) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)");
			ps.setString(1, adminEmail);
			ps.setString(2, userEmail);
			ps.setString(3, source);
			ps.setString(4, destination);
			ps.setDouble(5, passengersCount);
			ps.setDouble(6, fare);
			ps.setString(7, MOT);
			ps.setString(8, txnid);
			ps.setString(9, dateTime);
			
			int i = ps.executeUpdate();
			
			if(i != 0)
				return "Successful";
		
			return "Unsuccessful";
		
		}
		catch(Exception e)
		{
			e.getMessage();
		}
		log.trace("Something went wrong, Please try again..");
		return "Something went wrong, Please try again..";
	}
	
	public String updateAdminPassTransaction(String adminEmail, String userEmail, String source, String destination, String validFrom, String validThrough, String passType, double fare, String MOT, String txnid, String dateTime)
	{
		try
		{
			Connection con = DBConnection.DBCon();
			PreparedStatement ps = con.prepareStatement("INSERT INTO admin_pass_transaction (Email, User_Email, Source, Destination, Valid_From, Valid_Through, Pass_Type, Fare, Mode_of_Transaction, Transaction_Id, DateTime) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)");
			ps.setString(1, adminEmail);
			ps.setString(2, userEmail);
			ps.setString(3, source);
			ps.setString(4, destination);
			ps.setString(5, validFrom);
			ps.setString(6, validThrough);
			ps.setString(7, passType);
			ps.setDouble(8, fare);
			ps.setString(9, MOT);
			ps.setString(10, txnid);
			ps.setString(11, dateTime);
			
			int i = ps.executeUpdate();
			
			if(i != 0)
				return "Successful";
		
			return "Unsuccessful";
		
		}
		catch(Exception e)
		{
			e.getMessage();
		}
		log.trace("Something went wrong, Please try again..");
		return "Something went wrong, Please try again..";
	}
	
}
