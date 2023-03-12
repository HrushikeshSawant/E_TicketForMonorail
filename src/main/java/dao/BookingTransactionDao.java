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

}
