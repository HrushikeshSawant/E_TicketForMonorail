package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import bean.LoginBean;
import bean.WalletHistoryBean;
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
	
	public ArrayList<WalletHistoryBean> getWalletHistory(LoginBean loginBean)
	{
		ArrayList<WalletHistoryBean> walletHistory = new ArrayList<WalletHistoryBean>();
		try
		{
			String dateTime;
			String modeofTransaction;
			String amount;
			String transactionId;
			Connection con;
			PreparedStatement ps;
			ResultSet rs;
			
			con = DBConnection.DBCon();
			int size = 0 ;
			ps = con.prepareStatement("SELECT COUNT(*) FROM users u INNER JOIN wallet_transaction wt ON u.Email = wt.Email WHERE u.Email = ?");
			ps.setString(1, loginBean.getEmail());
			rs = ps.executeQuery();
			
			while(rs.next()){
				size = Integer.parseInt(rs.getString(1));
			}
			
			WalletHistoryBean walletHistoryBean1 = new WalletHistoryBean(size);
			walletHistory.add(0, walletHistoryBean1);
			
			ps = con.prepareStatement("SELECT wt.DateTime, wt.Mode_of_Transaction, wt.Amount, wt.Transaction_Id FROM users u INNER JOIN wallet_transaction wt ON u.Email = wt.Email WHERE u.Email = ?");
			ps.setString(1, loginBean.getEmail());
			rs = ps.executeQuery();
			
			while(rs.next())
			{
				dateTime = rs.getString("DateTime");
				modeofTransaction = rs.getString("Mode_of_Transaction");
				amount = rs.getString("Amount");
				transactionId = rs.getString("Transaction_Id");
				WalletHistoryBean walletHistoryBean = new WalletHistoryBean(dateTime, modeofTransaction, amount, transactionId);
				walletHistory.add(walletHistoryBean);
			}
			
			return walletHistory;
			
		}
		catch(Exception e)
		{
			e.getMessage();
		}
		
		log.trace("Something went wrong, Please try again..");
		return walletHistory;
	}
	
	public String updateWalletAmount(String email, double newAmount)
	{
		try
		{
			Connection con = DBConnection.DBCon();
			PreparedStatement ps = con.prepareStatement("UPDATE users SET Wallet = ? WHERE Email = ?");
			ps.setDouble(1, newAmount);
			ps.setString(2, email);
			int i = ps.executeUpdate();
			
			//TO ENSURE WHETHER DATA IS INSERTES. 1 = INSERTED, 0 = NOT INSERTED.
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
			
			return "No data found";
		}
		catch(Exception e)
		{
			e.getMessage();
		}
		
		log.trace("Something went wrong, Please try again..");
		return "Something went wrong, Please try again..";
	}
	
	public ArrayList<WalletHistoryBean> getHistoricUserWalletHistory(LoginBean loginBean)
	{
		ArrayList<WalletHistoryBean> walletHistory = new ArrayList<WalletHistoryBean>();
		try
		{
			String dateTime;
			String modeofTransaction;
			String amount;
			String transactionId;
			Connection con;
			PreparedStatement ps;
			ResultSet rs;
			
			con = DBConnection.DBCon();
			int size = 0 ;
			ps = con.prepareStatement("SELECT COUNT(*) FROM historic_users_data hud INNER JOIN historic_users_wallet_transaction_data huwtd ON hud.Email = huwtd.Email WHERE hud.Email = ?");
			ps.setString(1, loginBean.getEmail());
			rs = ps.executeQuery();
			
			while(rs.next()){
				size = Integer.parseInt(rs.getString(1));
			}
			
			WalletHistoryBean walletHistoryBean1 = new WalletHistoryBean(size);
			walletHistory.add(0, walletHistoryBean1);
			
			ps = con.prepareStatement("SELECT huwtd.DateTime, huwtd.Mode_of_Transaction, huwtd.Amount, huwtd.Transaction_Id FROM historic_users_data hud INNER JOIN historic_users_wallet_transaction_data huwtd ON hud.Email = huwtd.Email WHERE hud.Email = ?");
			ps.setString(1, loginBean.getEmail());
			rs = ps.executeQuery();
			
			while(rs.next())
			{
				dateTime = rs.getString("DateTime");
				modeofTransaction = rs.getString("Mode_of_Transaction");
				amount = rs.getString("Amount");
				transactionId = rs.getString("Transaction_Id");
				WalletHistoryBean walletHistoryBean = new WalletHistoryBean(dateTime, modeofTransaction, amount, transactionId);
				walletHistory.add(walletHistoryBean);
			}
			
			return walletHistory;
			
		}
		catch(Exception e)
		{
			e.getMessage();
		}
		
		log.trace("Something went wrong, Please try again..");
		return walletHistory;
	}

}
