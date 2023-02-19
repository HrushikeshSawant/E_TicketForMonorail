package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import connection.DBConnection;

public class WalletDao {
	
	private static Logger log = LogManager.getLogger(WalletDao.class);
	
	public String updatetransactionDetails(String email, double wallet, double amount, String MOT, String txnid, String dateTime)
	{
		try
		{
			double newWalletAmount = (Double)(wallet + amount);
			Connection con;
			PreparedStatement ps;
			
			con = DBConnection.DBCon();
			ps = con.prepareStatement("UPDATE users SET Wallet = ? WHERE Email = ?");
			ps.setDouble(1, newWalletAmount);
			ps.setString(2, email);
			int i = ps.executeUpdate();
			
			ps = con.prepareStatement("INSERT INTO wallet_transaction (Email, Amount, Mode_of_Transaction, Transaction_Id, DateTime) VALUES (?, ?, ?, ?, ?)");
			ps.setString(1, email);
			ps.setDouble(2, amount);
			ps.setString(3, MOT);
			ps.setString(4, txnid);
			ps.setString(5, dateTime);
			int j = ps.executeUpdate();
			
			if(i != 0 && j != 0)
			{
				log.trace("Payment Successful. Data updated in both tables");
				return "Payment Successful";
			}
			
			log.trace("Payment Successful. Data not updated");
			return "Payment Unsuccessful";
		}
		catch(Exception e)
		{
			e.getMessage();
		}
		
		log.trace("Something went wrong, Please try again..");
		return "Something went wrong, Please try again..";
	}

}
